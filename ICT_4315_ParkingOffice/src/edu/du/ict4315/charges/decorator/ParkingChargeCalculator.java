package edu.du.ict4315.charges.decorator;

import java.time.LocalDateTime;

import edu.du.ict4315.parking.ParkingPermit;
import ude.du.ict4315.currency.Money;

public abstract class ParkingChargeCalculator {
	public abstract Money getParkingCharge(Money baseRate, LocalDateTime entryTime, LocalDateTime exitTime, ParkingPermit permit);
}
