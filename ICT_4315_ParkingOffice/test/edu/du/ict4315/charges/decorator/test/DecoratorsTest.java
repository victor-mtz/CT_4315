package edu.du.ict4315.charges.decorator.test;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import edu.du.ict4315.charges.decorator.CompactDiscountDecorator;
import edu.du.ict4315.charges.decorator.DayOfWeekDiscountDecorator;
import edu.du.ict4315.charges.decorator.FlatRateCalculator;
import edu.du.ict4315.charges.decorator.ParkingChargeCalculator;
import edu.du.ict4315.parking.Car;
import edu.du.ict4315.parking.CarType;
import edu.du.ict4315.parking.ParkingPermit;
import ude.du.ict4315.currency.Money;

class DecoratorsTest {

	@Test
	void flatRateTest() {
		ParkingChargeCalculator calculator = new FlatRateCalculator();
		
		Money baseRate = new Money(new BigDecimal("20.00"));
		
		Car newCar = new Car();
		
		newCar.setCarType(CarType.SUV);
		
		ParkingPermit permit = new ParkingPermit(newCar);
		
        LocalDateTime entry =
                LocalDateTime.of(2026, 4, 1, 9, 0);
        LocalDateTime exit =
                LocalDateTime.of(2026, 4, 4, 9, 0);
        
        Money charge = calculator.getParkingCharge(baseRate, entry, exit, permit);
        
        assertEquals("$60.00", charge.toString());
	}
	
	@Test
	void compactCarDiscount() {
		ParkingChargeCalculator calculator = new CompactDiscountDecorator(new FlatRateCalculator());
		
		Money baseRate = new Money(new BigDecimal("20.00"));
		
		Car newCar = new Car();
		
		newCar.setCarType(CarType.COMPACT);
		
		ParkingPermit permit = new ParkingPermit(newCar);
		
        LocalDateTime entry =
                LocalDateTime.of(2026, 4, 1, 9, 0);
        LocalDateTime exit =
                LocalDateTime.of(2026, 4, 2, 9, 0);
        
        Money charge = calculator.getParkingCharge(baseRate, entry, exit, permit);
        
        assertEquals("$16.00", charge.toString());
	}
	
	@Test
	void weekendCarDiscount() {
		ParkingChargeCalculator calculator = new DayOfWeekDiscountDecorator(new FlatRateCalculator());
		
		Money baseRate = new Money(new BigDecimal("20.00"));
		
		Car newCar = new Car();
		
		newCar.setCarType(CarType.COMPACT);
		
		ParkingPermit permit = new ParkingPermit(newCar);
		

        // Friday -> Sunday
        LocalDateTime entry =
                LocalDateTime.of(2026, 4, 17, 8, 0); // Friday
        LocalDateTime exit =
                LocalDateTime.of(2026, 4, 19, 8, 0); // Sunday

        Money charge = calculator.getParkingCharge(baseRate, entry, exit, permit);

        assertEquals("$56.00", charge.toString());
	}

}
