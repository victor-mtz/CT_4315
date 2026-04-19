package edu.du.ict4315.parking.charges.strategy;

import java.time.LocalDateTime;

import edu.du.ict4315.parking.ParkingPermit;
import ude.du.ict4315.currency.Money;

public interface ParkingChargeStrategy {
	Money calculateParkingCharge(
			Money baseRate, 
			LocalDateTime entryTime, 
			LocalDateTime exitTime, 
			ParkingPermit permit);
}
