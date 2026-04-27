// File: Address
// Author: Victor Martinez
// Class: ICT 4315
package edu.du.ict4315.parking;

public class Address {
	private String streetAddress1;
	private String streetAddress2;
	private String city;
	private String state;
	private String zipCode;
	
	public static class AddressBuilder {
		private String streetAddress1;
		private String city;
		private String streetAddress2;
		private String state;
		private String zipCode;
		
		public AddressBuilder() {
		}
		
		public AddressBuilder streetAddress1(String streetAddress1) {
			this.streetAddress1 = streetAddress1;
			return this;
		}
		
		public AddressBuilder streetAddress2(String streetAddress2) {
			this.streetAddress2 = streetAddress2;
			return this;
		}
		
		public AddressBuilder city(String city) {
			this.city = city;
			return this;
		}
		
		public AddressBuilder state(String state) {
			this.state = state;
			return this;
		}
		
		public AddressBuilder zipCode(String zipCode) {
			this.zipCode = zipCode;
			return this;
		}
		
		public Address buildAddress() {
			Address address = new Address();
			address.streetAddress1 = this.streetAddress1;
			address.streetAddress2 = this.streetAddress2;
			address.city = this.city;
			address.state = this.state;
			address.zipCode = this.zipCode;
			
			return address;
		}
	}
	
	  public String getAddressInfo() {
			return this.streetAddress1 + " " + this.streetAddress2 + " " + this.city + " " + this.state + " " + this.zipCode;
	  }
}
