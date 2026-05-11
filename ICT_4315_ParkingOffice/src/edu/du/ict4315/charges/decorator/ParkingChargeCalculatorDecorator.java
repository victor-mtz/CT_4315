package edu.du.ict4315.charges.decorator;

import java.time.LocalDateTime;

import edu.du.ict4315.parking.ParkingPermit;
import ude.du.ict4315.currency.Money;

public abstract class ParkingChargeCalculatorDecorator extends ParkingChargeCalculator {
	protected ParkingChargeCalculator element;
	
	public ParkingChargeCalculatorDecorator(ParkingChargeCalculator element) {
		this.element = element;
	}
	
	@Override
	public Money getParkingCharge(Money baseRate, LocalDateTime entryTime, LocalDateTime exitTime, ParkingPermit permit) {
		return element.getParkingCharge(baseRate, entryTime, exitTime, permit);
	}
}
