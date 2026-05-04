package edu.du.ict4315.parking;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
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
	  
	  public void park(ParkingEvent event) {
		  LocalDateTime eventTime = event.getEntry();
		  Date toDate = Date.from(eventTime.atZone(ZoneId.systemDefault()).toInstant());
		  ParkingTransaction pt = new ParkingTransaction.ParkingTransactionBuilder()
				  .date(toDate)
				  .permit(event.getPermit())
				  .parkingLot(event.getParkingLog())
				  .chargedAmount(this.parkingOffice.getParkingCharges(event.getPermit()))
				  .buildParkingTransaction();
		  transactions.add(pt);
	  }
	  
	  public List<ParkingTransaction> getTransactions() {
		  return this.transactions;
	  }
}
