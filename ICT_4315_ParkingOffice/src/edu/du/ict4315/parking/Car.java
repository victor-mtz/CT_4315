// File: Car
// Author: Victor Martinez
// Class: ICT 4315
package edu.du.ict4315.parking;

public class Car {
  private CarType type;
  private String licensePlate = "None";
  private Customer owner;
  
  public Car() {
	type = CarType.COMPACT;
	owner = new Customer();
  }
  
  public Car(CarType type, String licensePlate, Customer owner) {
	this.type = type;
	this.licensePlate = licensePlate;
	this.owner = owner;
  }
  
  public CarType getType() {
	return this.type;
  }
  
  public String getLicensePlate() {
	return this.licensePlate;
  }
  
  public Customer getOwner() {
	return this.owner;
  }
}
