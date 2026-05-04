// File: ParkingTransaction
// Author: Victor Martinez
// Class: ICT 4315
package edu.du.ict4315.parking;

import java.time.Instant;
import java.util.Date;

import ude.du.ict4315.currency.Money;

public class ParkingTransaction {
	private Date date;
	private ParkingPermit permit;
	private ParkingLot parkingLot;
	private Money chargedAmount;
	
	public static class ParkingTransactionBuilder {
		private Date date;
		private ParkingPermit permit;
		private ParkingLot parkingLot;
		private Money chargedAmount;
		
		public ParkingTransactionBuilder date(Date date) {
			this.date = date;
			return this;
		}
		
		public ParkingTransactionBuilder permit(ParkingPermit permit) {
			this.permit = permit;
			return this;
		}
		
		public ParkingTransactionBuilder parkingLot(ParkingLot parkingLot) {
			this.parkingLot = parkingLot;
			return this;
		}
		
		public ParkingTransactionBuilder chargedAmount(Money chargedAmount) {
			this.chargedAmount = chargedAmount;
			return this;
		}
		
		public ParkingTransaction buildParkingTransaction() {
			ParkingTransaction parkingTransaction = new ParkingTransaction();
			parkingTransaction.date = this.date;
			parkingTransaction.permit = this.permit;
			parkingTransaction.parkingLot = this.parkingLot;
			parkingTransaction.chargedAmount = this.chargedAmount;
			
			return parkingTransaction;
		}
	}
	
	public Money getChargedAmount() {
		// TODO: get the actual charged amount
		return this.chargedAmount;
	}
	
	public ParkingPermit getPermit() {
		return this.permit;
	}
}
