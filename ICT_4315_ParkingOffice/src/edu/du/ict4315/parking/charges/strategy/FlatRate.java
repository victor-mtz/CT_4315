package edu.du.ict4315.parking.charges.strategy;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;

import edu.du.ict4315.parking.ParkingPermit;
import ude.du.ict4315.currency.Money;

public class FlatRate implements ParkingChargeStrategy {
	
	@Override
	public Money calculateParkingCharge(
			Money baseRate, 
			LocalDateTime entryTime, 
			LocalDateTime exitTime, 
			ParkingPermit permit) {
		
		long daysDuration = Math.max(1,
				Duration.between(entryTime, exitTime).toDays());
		
		return baseRate.multiply(BigDecimal.valueOf(daysDuration));
	}
}
