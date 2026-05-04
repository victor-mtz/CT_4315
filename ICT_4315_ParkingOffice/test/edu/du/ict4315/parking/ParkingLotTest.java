package edu.du.ict4315.parking;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.du.ict4315.parking.charges.factory.ParkingChargeStrategyType;
import edu.du.ict4315.parking.charges.strategy.CompactDiscountRate;
import edu.du.ict4315.parking.charges.strategy.DayOfWeekRate;
import edu.du.ict4315.parking.charges.strategy.FlatRate;
import edu.du.ict4315.parking.charges.strategy.ParkingChargeStrategy;

class ParkingLotTest {
	ParkingLot parkingLot;
	
	@BeforeEach
	void setUp() {
		parkingLot = new ParkingLot();
	}

	@Test
	void testMakeFlatRateParkingCharge() {
		parkingLot.setStrategy(ParkingChargeStrategyType.FLAT_RATE);
		ParkingChargeStrategy lotStrategy = parkingLot.getStrategy();
		assertTrue(lotStrategy instanceof FlatRate);
	}
	
	@Test
	void testMakeCompactDiscountParkingCharge() {
		parkingLot.setStrategy(ParkingChargeStrategyType.COMPACT_DISCOUNT);
		ParkingChargeStrategy lotStrategy = parkingLot.getStrategy();
		assertTrue(lotStrategy instanceof CompactDiscountRate);
	}
	
	@Test
	void testMakeDayOfWeekParkingCharge() {
		parkingLot.setStrategy(ParkingChargeStrategyType.WEEKEND_DISCOUNT);
		ParkingChargeStrategy lotStrategy = parkingLot.getStrategy();
		assertTrue(lotStrategy instanceof DayOfWeekRate);
	}
	
	@Test
	void observerEnterEvent() {
		ParkingOffice office = new ParkingOffice();
		office.addParkingLot(parkingLot);
		
		TransactionManager manager = new TransactionManager(office);
		ParkingObserver observer = new ParkingObserver(office, manager);
		
		Car car = new Car();
		ParkingPermit permit = new ParkingPermit(car);
		
		parkingLot.enter(permit);
		
		assertEquals(1, manager.getTransactions().size());
	}
	
	@Test
	void multipleObservers() {
		ParkingOffice office = new ParkingOffice();
		office.addParkingLot(parkingLot);
		
		TransactionManager manager1 = new TransactionManager(office);
		ParkingObserver observer = new ParkingObserver(office, manager1);
		
		TransactionManager manager2 = new TransactionManager(office);
		ParkingObserver observer2 = new ParkingObserver(office, manager2);
		
		Car car = new Car();
		ParkingPermit permit = new ParkingPermit(car);
		
		parkingLot.enter(permit);
		
		assertEquals(1, manager1.getTransactions().size());
		assertEquals(1, manager2.getTransactions().size());
	}

}
