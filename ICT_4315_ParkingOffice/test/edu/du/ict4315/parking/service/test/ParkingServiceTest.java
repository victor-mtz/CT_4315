package edu.du.ict4315.parking.service.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;

import org.junit.jupiter.api.Test;

import edu.du.ict4315.parking.ParkingOffice;
import edu.du.ict4315.parking.service.Command;
import edu.du.ict4315.parking.service.ParkingService;

class ParkingServiceTest {
	private ParkingOffice newParkingOffice = new ParkingOffice();
	private ParkingService newParkingService = new ParkingService(newParkingOffice);

	@Test
	void testRegisterCar() {
		// [CarType, licensePlate, owner]
		String[] carArgs = {"SUV", "None", "New Owner"};
		assertNotNull(newParkingService.performCommand("registerCar", carArgs));
	}
	
	@Test
	void testRegisterCustomer() {
		// [id, firstName, lastName, phoneNumber, address]
		String[] customerArgs = {"random_id", "John", "Doe", "111-222-3456", "Denver, CO"};
		assertNotNull(newParkingService.performCommand("registerCustomer", customerArgs));
	}

	@Test
	void testGetRegisteredCommands() {
		Map<String,Command> commands = newParkingService.getRegisteredCommands();
		assertNotNull(commands);
	}

}
