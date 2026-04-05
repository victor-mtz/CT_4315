// File: ParkingTransaction
// Author: Victor Martinez
// Class: ICT 4315
package edu.du.ict4315.parking;

import java.time.Instant;
import java.util.Date;

import ude.du.ict4315.currency.Money;

public class ParkingTransaction {
	private Date date = Date.from(Instant.now());
	private ParkingPermit permit = new ParkingPermit(new Car());
	private ParkingLot parkingLot = new ParkingLot();
	private Money chargedAmount = new Money();
	
	public Money getChargedAmount() {
		// TODO: get the actual charged amount
		return this.chargedAmount;
	}
	
	public ParkingPermit getPermit() {
		return this.permit;
	}
}
