// File: Address
// Author: Victor Martinez
// Class: ICT 4315
package edu.du.ict4315.parking;

public class Address {
  protected String streetAddress1 = "S Gaylord St";
  protected String streetAddress2 = "";
  protected String city = "Denver";
  protected String state = "Colorado";
  protected String zipCode = "80210";
  
  public Address() {
	  
  }

  public Address(String streetAddress1, String streetAddress2, String city, String state, String zipCode) {
 	this.streetAddress1 = streetAddress1;
	this.streetAddress2 = streetAddress2;
	this.city = city;
	this.state = state;
	this.zipCode = zipCode;
  }
	
  public Address(String streetAddress1, String city, String state, String zipCode) {
	this.streetAddress1 = streetAddress1;
	this.city = city;
	this.state = state;
	this.zipCode = zipCode;
  }
	
  public String getAddressInfo() {
	return this.streetAddress1 + " " + this.streetAddress2 + " " + this.city + " " + this.state + " " + this.zipCode;
  }
}
