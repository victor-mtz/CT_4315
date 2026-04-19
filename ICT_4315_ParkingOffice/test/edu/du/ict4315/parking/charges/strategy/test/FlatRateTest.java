package edu.du.ict4315.parking.charges.strategy.test;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import edu.du.ict4315.parking.Car;
import edu.du.ict4315.parking.CarType;
import edu.du.ict4315.parking.ParkingPermit;
import edu.du.ict4315.parking.charges.strategy.FlatRate;
import edu.du.ict4315.parking.charges.strategy.ParkingChargeStrategy;
import ude.du.ict4315.currency.Money;

class FlatRateTest {

	@Test
	void flatRateTest() {
		ParkingChargeStrategy strategy = new FlatRate();
		
		Money baseRate = new Money(new BigDecimal("20.00"));
		
		Car newCar = new Car();
		
		newCar.setCarType(CarType.SUV);
		
		ParkingPermit permit = new ParkingPermit(newCar);
		
        LocalDateTime entry =
                LocalDateTime.of(2026, 4, 1, 9, 0);
        LocalDateTime exit =
                LocalDateTime.of(2026, 4, 4, 9, 0);
        
        Money result = strategy.calculateParkingCharge(
                baseRate, entry, exit, permit);

        assertEquals("$60.00", result.toString());
	}

}
