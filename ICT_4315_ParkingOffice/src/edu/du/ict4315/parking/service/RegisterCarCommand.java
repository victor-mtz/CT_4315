package edu.du.ict4315.parking.service;

import edu.du.ict4315.parking.Car;
import edu.du.ict4315.parking.CarType;
import edu.du.ict4315.parking.Customer;
import edu.du.ict4315.parking.ParkingOffice;

public class RegisterCarCommand implements Command {
	private ParkingOffice office;
	private String commandName = "registerCar";
	private String displayName = "Register Car";
	
	public RegisterCarCommand(ParkingOffice office) {
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
		// The expected list of parameters to build the Car object is as follows:
		// [CarType, licensePlate, owner]
		Customer carOwner = new Customer();
		Car carToRegister = new Car(CarType.COMPACT, "Small_Car", carOwner);
		return this.office.register(carToRegister);
	}

}
