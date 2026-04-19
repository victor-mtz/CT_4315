package edu.du.ict4315.parking.charges.strategy.test;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import edu.du.ict4315.parking.Car;
import edu.du.ict4315.parking.CarType;
import edu.du.ict4315.parking.ParkingPermit;
import edu.du.ict4315.parking.charges.strategy.DayOfWeekRate;
import edu.du.ict4315.parking.charges.strategy.ParkingChargeStrategy;
import ude.du.ict4315.currency.Money;

class DayOfWeekRateTest {

	@Test
	void weekendDaysDiscount() {
		ParkingChargeStrategy strategy = new DayOfWeekRate();
		
		Money baseRate = new Money(new BigDecimal("20.00"));
		
		Car newCar = new Car();
		
		newCar.setCarType(CarType.COMPACT);
		
		ParkingPermit permit = new ParkingPermit(newCar);
		

        // Friday -> Sunday
        LocalDateTime entry =
                LocalDateTime.of(2026, 4, 17, 8, 0); // Friday
        LocalDateTime exit =
                LocalDateTime.of(2026, 4, 19, 8, 0); // Sunday

        Money result = strategy.calculateParkingCharge(
                baseRate, entry, exit, permit);

        assertEquals("$56.00", result.toString());
	}
	
	@Test
	void weekdayCharge() {
		ParkingChargeStrategy strategy = new DayOfWeekRate();
		
		Money baseRate = new Money(new BigDecimal("20.00"));
		
		Car newCar = new Car();
		
		newCar.setCarType(CarType.COMPACT);
		
		ParkingPermit permit = new ParkingPermit(newCar);
		
        LocalDateTime entry =
                LocalDateTime.of(2026, 4, 13, 8, 0); // Monday
        LocalDateTime exit =
                LocalDateTime.of(2026, 4, 14, 8, 0); // Tuesday


        Money result = strategy.calculateParkingCharge(
                baseRate, entry, exit, permit);

        assertEquals("$40.00", result.toString());
	}

}
