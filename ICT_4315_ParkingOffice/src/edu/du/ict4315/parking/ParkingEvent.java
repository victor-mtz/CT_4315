package edu.du.ict4315.parking;

import java.time.LocalDateTime;

public class ParkingEvent {
	private ParkingEventType eventType;
	private ParkingLot parkingLot;
	private LocalDateTime entry;
	private LocalDateTime exit;
	private ParkingPermit permit;
	
	public ParkingEvent(ParkingLot lot, ParkingEventType type, LocalDateTime permitScan, ParkingPermit permit) {
		if (type.equals(ParkingEventType.ENTRY)) {
			this.entry = permitScan;
		} else {
			this.exit = permitScan;
		}
		this.parkingLot = lot;
		this.eventType = type;
		this.permit = permit;
	}

	public ParkingPermit getPermit() {
		return this.permit;
	}
	
	public LocalDateTime getEntry() {
		return this.entry;
	}
	
	public LocalDateTime getExit() {
		return this.exit;
	}
	
	public ParkingLot getParkingLog() {
		return this.parkingLot;
	}
	
}
