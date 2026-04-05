package edu.du.ict4315.parking.service;

import java.util.HashMap;
import java.util.Map;

import edu.du.ict4315.parking.ParkingOffice;

public class ParkingService {
    private ParkingOffice office;
    private Map<String,Command> commands = new HashMap<>();
    
    private void register(String commandName) {
    	Command commandToInsert = commandName.contains("Car") ? new RegisterCarCommand(this.office) : new RegisterCustomerCommand(this.office);
    	this.commands.putIfAbsent(commandName, commandToInsert);
    }
    
    public String performCommand(String commandToPerform, String[] commandParameters) {
    	Command command = this.commands.get(commandToPerform);
    	return command.execute(commandParameters);
    }
    
    public ParkingService(ParkingOffice office) {
    	this.office = office;
    	this.register("registerCar");
    	this.register("registerCustomer");
    }
    
    public Map<String,Command> getRegisteredCommands() {
    	return this.commands;
    }
}
