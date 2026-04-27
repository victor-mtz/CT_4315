package edu.du.ict4315.parking;

import java.util.ArrayList;
import java.util.List;

public class TransactionManager {
	  private List<ParkingTransaction> transactions = new ArrayList<ParkingTransaction>();
	  private ParkingOffice parkingOffice;
	  
	  public TransactionManager(ParkingOffice parkingOffice) {
		  this.parkingOffice = parkingOffice;
	  }
	  
	  public void getParkingCharges(ParkingPermit permit) {
		  // TODO: implement get parking charges by permit
	  }
	  
	  public void getParkingCharges(Customer customer) {
		  // TODO: implement get parking charges by customer
	  }
}
