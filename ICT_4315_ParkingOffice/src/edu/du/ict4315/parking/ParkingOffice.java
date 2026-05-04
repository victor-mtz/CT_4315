// File: ParkingOffice
// Author: Victor Martinez
// Class: ICT 4315
package edu.du.ict4315.parking;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ude.du.ict4315.currency.Money;

public class ParkingOffice {
  private String parkingOfficeName = "Name not set";
  private List<Customer> listOfCustomers = new ArrayList<>();
  private List<ParkingLot> listOfParkingLots = new ArrayList<>();
  private Address parkingOfficeAddress = new Address();
  
  public ParkingOffice() {
	  
  }
  
  public String getParkingOfficeName() {
    return this.parkingOfficeName;
  }
  
  public ParkingTransaction park(Date d, ParkingPermit parkingPermit, ParkingLot parkingLot) {
	// TODO: return a real parking transaction once the ParkingTransaction class is fully implemented
	return new ParkingTransaction();
  }
  
  public Money getParkingCharges(ParkingPermit permit) {
	// TODO: return real value
	return new Money();
  }
  
  public Money getParkingCharges(Customer customer) {
	// TODO: return real value  
	return new Money();
  }
  
  public String register(Customer customer) {
	  this.listOfCustomers.add(customer);
	  int newCustomerIndex = this.listOfCustomers.indexOf(customer);
	  // ensures that the return value is from the ParkingOffice's own list of customers
	  return this.listOfCustomers.get(newCustomerIndex).getId();
  }
  
  public String register(Car car) {
	  return new ParkingPermit(car).getPermitId();
  }
  
  public List<ParkingLot> getParkingLots() {
	  return this.listOfParkingLots;
  }
  
  public void addParkingLot(ParkingLot lot) {
	  this.listOfParkingLots.add(lot);
  }
}
