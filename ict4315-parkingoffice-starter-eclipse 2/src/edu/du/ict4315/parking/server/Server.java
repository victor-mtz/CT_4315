//////////////////////////
// File: Server.java
// Author: R Judd, modified by M I Schwartz
// This file implements a String message-oriented server to allow clients to send
// commands to the Parking Office server.
// Note: Assignment 8 examines alternate ways of exchanging messages.
// Note: Assignment 9 examines ways of supporting paralellism.
//////////////////////////
package edu.du.ict4315.parking.server;

import edu.du.ict4315.parking.service.ParkingService;
import edu.du.ict4315.parking.Address;
import edu.du.ict4315.parking.RealParkingOffice;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import com.google.inject.Inject

public class Server {

    static {
        System.setProperty(
                "java.util.logging.SimpleFormatter.format",
                "%1$tc %4$-7s (%2$s) %5$s %6$s%n");
    }

    private static final Logger logger = Logger.getLogger(Server.class.getName());
    // Set logging level

    static {
        logger.setLevel(Level.FINE);
    }
    // Pick a TCP/IP Port
    private final int PORT = 7777;

    private final ParkingService service;
    
    private volatile boolean running = false;
    
    private ServerSocket serverSocket;
    
    private final ExecutorService threadPool = Executors.newFixedThreadPool(5);

    @Inject
    public Server(ParkingService service) {
        this.service = service;
    }
    
    public void startServer() throws IOException {
    	running = true;
    	
        logger.info("Starting server: " + InetAddress.getLocalHost().getHostAddress());
        
        serverSocket = new ServerSocket(PORT);
        serverSocket.setReuseAddress(true);
        
        try {
        	while (running) {
        		try {
        			Socket client = serverSocket.accept();
        			client.setSoTimeout(10000); // sets a 10 second timeout
        			threadPool.execute(() -> handleClient(client));
        		} catch (IOException e) {
        			if (running) {
        				logger.log(Level.WARNING, "Error accepting client", e);
        			}
        		}
        	}
        } finally {
        	stopServer();
        }
    }
    

    public void stopServer() {
        running = false;

        logger.info("Stopping server...");

        try {
            if (serverSocket != null && !serverSocket.isClosed()) {
                serverSocket.close();
            }
        } catch (IOException e) {
            logger.log(Level.WARNING, "Error closing server socket", e);
        }
        
        threadPool.shutdown();
    }
    
    private void handleClient(Socket client) {
        try (
            var inputStream = client.getInputStream();
            PrintWriter pw = new PrintWriter(client.getOutputStream())
        ) {

            String jsonInput = new String(inputStream.readAllBytes()).trim();

            ParkingResponse response;

            try {
                ParkingRequest request = ParkingRequest.fromJson(jsonInput);

                if ("shutdown".equalsIgnoreCase(request.getCommand())) {
                    response = new ParkingResponse(200, "Server shutting down...");

                    pw.println(response.toJson());
                    pw.flush();

                    new Thread(this::stopServer).start();
                    return;
                }

                String input = request.getCommand();
                for (String name : request.getProperties().stringPropertyNames()) {
                    input += "\n" + name + "=" + request.getProperties().getProperty(name);
                }

                String result = service.handleInput(
                        new java.io.ByteArrayInputStream(input.getBytes())
                );

                response = new ParkingResponse(200, result);

            } catch (Exception ex) {
                ex.printStackTrace();
                response = new ParkingResponse(500, ex.getMessage());
            }

            pw.println(response.toJson());
            pw.flush();

        } catch (java.net.SocketTimeoutException e) {
        	logger.warning("Client connection exceeded the 10 second limit. Connection timed out.");
        
    	} catch (IOException e) {
            logger.log(Level.WARNING, "Failed to read from client.", e);
        } finally {
            try {
                client.close();
            } catch (IOException e) {
                logger.log(Level.WARNING, "Failed to close client socket.", e);
            }
        }
    }

    /**
     * Run this as: $ java ict4315.server.Server
     */
    public static void main(String[] args) throws Exception {
        RealParkingOffice parkingOffice = new RealParkingOffice();
        // Set an address and name
        parkingOffice.setParkingOfficeName("DU Parking Office -- Test");
        Address address;
        address = new Address.Builder().withStreetAddress1("2130 S. High St.")
                .withCity("Denver")
                .withState("CO")
                .withZip("80210")
                .build();
        parkingOffice.setParkingOfficeAddress(address);

        ParkingService service = new ParkingService(parkingOffice);

        Server server = new Server(service);
        
        Thread serverThread = new Thread(() -> {
        	try {
        		server.startServer();
        	} catch (IOException e) {
        		e.printStackTrace();
        	}
        });
        
        serverThread.start();
    }
}
