package edu.du.ict4315.parking;

import java.util.ArrayList;
import java.util.List;

public class ParkingObserver implements ParkingAction {
	private TransactionManager transactionManager;
	private ParkingOffice office;
	private List<ParkingLot> lots = new ArrayList<>();
	
	public ParkingObserver(ParkingOffice office, TransactionManager manager) {
		this.office = office;
		this.transactionManager = manager;
		this.getParkingLots();
		this.subscribe();
	}
	
	@Override
	public void update(ParkingEvent event) {
		this.transactionManager.park(event);
	}
	
	private void getParkingLots() {
		lots = this.office.getParkingLots();
	}
	
	private void subscribe() {
		for (ParkingLot lot : this.lots) {
			lot.addObserver(this);
		}
	}

}
