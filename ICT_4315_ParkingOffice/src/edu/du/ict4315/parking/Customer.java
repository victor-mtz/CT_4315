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
	
	public class CustomerBuilder {
		private final String id = String.valueOf(UUID.randomUUID());
		private String firstName;
		private String lastName;
		private String phoneNumber;
		private Address address;
		
		public CustomerBuilder() {
		}
		
		public CustomerBuilder firstName(String firstName) {
			this.firstName = firstName;
			return this;
		}
		
		public CustomerBuilder lastName(String lastName) {
			this.lastName = lastName;
			return this;
		}
		
		public CustomerBuilder phoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
			return this;
		}
		
		public CustomerBuilder Address(Address address) {
			this.address = address;
			return this;
		}
		
		public Customer buildCustomer() {
			Customer customer = new Customer();
			customer.firstName = this.firstName;
			customer.lastName = this.lastName;
			customer.phoneNumber = this.phoneNumber;
			customer.address = this.address;
			
			return customer;
		}
	}
	
	public String getCustomerName() {
		return this.firstName + " " + this.lastName;
	}
	
	public String getId() {
		return this.id;
	}
}

