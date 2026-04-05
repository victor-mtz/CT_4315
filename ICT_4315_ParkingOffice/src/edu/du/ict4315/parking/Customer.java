// File: Customer
// Author: Victor Martinez
// Class: ICT 4315
package edu.du.ict4315.parking;

import java.util.UUID;

public class Customer {
	private String id;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private Address address;
	
	public Customer() {
		id = String.valueOf(UUID.randomUUID());
		firstName = "Customer";
		lastName = "One";
		phoneNumber = "111-222-3456";
		address = new Address();
	}
	
	public Customer(String id, String firstName, String lastName, String phoneNumber, Address address) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}
	
	public String getCustomerName() {
		return this.firstName + " " + this.lastName;
	}
	
	public String getId() {
		return this.id;
	}
}
