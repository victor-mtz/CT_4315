package edu.du.ict4315.parking.charges.strategy.test;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import edu.du.ict4315.parking.Car;
import edu.du.ict4315.parking.CarType;
import edu.du.ict4315.parking.ParkingPermit;
import edu.du.ict4315.parking.charges.strategy.CompactDiscountRate;
import edu.du.ict4315.parking.charges.strategy.ParkingChargeStrategy;
import ude.du.ict4315.currency.Money;

class CompactDiscountRateTest {

	@Test
	void compactCarDiscount() {
		ParkingChargeStrategy strategy = new CompactDiscountRate();
		
		Money baseRate = new Money(new BigDecimal("20.00"));
		
		Car newCar = new Car();
		
		newCar.setCarType(CarType.COMPACT);
		
		ParkingPermit permit = new ParkingPermit(newCar);

        LocalDateTime entry =
                LocalDateTime.of(2026, 4, 10, 8, 0);
        LocalDateTime exit =
                LocalDateTime.of(2026, 4, 11, 8, 0);

        Money result = strategy.calculateParkingCharge(
                baseRate, entry, exit, permit);

        assertEquals("$16.00", result.toString());

	}

}
