package edu.du.ict4315.parking.service;

import edu.du.ict4315.parking.Customer;
import edu.du.ict4315.parking.ParkingOffice;

public class RegisterCustomerCommand implements Command {
	private ParkingOffice office;
	private String commandName = "registerCustomer";
	private String displayName = "Register Customer";
	
	public RegisterCustomerCommand(ParkingOffice office) {
		this.office = office;
	}

	@Override
	public String getCommandName() {
		return this.commandName;
	}

	@Override
	public String getDisplayName() {
		return this.displayName;
	}

	@Override
	public String execute(String[] params) {
		// TODO: Use arguments passed down to the function to build out the objects
		// The expected list of parameters to build the Customer object is as follows:
		// [id, firstName, lastName, phoneNumber, address]
		Customer customerToRegister = new Customer();
		return this.office.register(customerToRegister);
	}

}
