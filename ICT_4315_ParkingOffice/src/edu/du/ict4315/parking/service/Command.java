package edu.du.ict4315.parking.service;

public interface Command {
	String getCommandName();
	String getDisplayName();
	String execute(String[] params);
}
