package edu.du.ict4315.parking.server;

import com.google.gson.Gson;

import java.util.Properties;

public class ParkingRequest {

    private String command;
    private Properties properties;

    public ParkingRequest(String command, Properties properties) {
        this.command = command;
        this.properties = properties;
    }

    public String getCommand() {
        return command;
    }

    public Properties getProperties() {
        return properties;
    }

    public String toJson() {
        return new Gson().toJson(this);
    }

    public static ParkingRequest fromJson(String json) {
        return new Gson().fromJson(json, ParkingRequest.class);
    }

    @Override
    public String toString() {
        return "ParkingRequest{" +
                "command='" + command + '\'' +
                ", properties=" + properties +
                '}';
    }
}