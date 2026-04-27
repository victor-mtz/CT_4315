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

}
