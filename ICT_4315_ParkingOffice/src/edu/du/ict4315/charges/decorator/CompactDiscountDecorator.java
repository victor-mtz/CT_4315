package edu.du.ict4315.charges.decorator;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;

import edu.du.ict4315.parking.ParkingPermit;
import ude.du.ict4315.currency.Money;

public class CompactDiscountDecorator extends ParkingChargeCalculatorDecorator {
	public CompactDiscountDecorator(ParkingChargeCalculator element) {
		super(element);
	}

	private static final BigDecimal discount = new BigDecimal("0.80");
	
	
	@Override
	public Money getParkingCharge(Money baseRate, LocalDateTime entryTime, LocalDateTime exitTime, ParkingPermit permit) {
		long daysDuration = Math.max(1,
				Duration.between(entryTime, exitTime).toDays());
		
		return baseRate.multiply(BigDecimal.valueOf(daysDuration)).multiply(discount);
	}
}
