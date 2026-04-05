// File: ParkingLot
// Author: Victor Martinez
// Class: ICT 4315
package edu.du.ict4315.parking;

import ude.du.ict4315.currency.Money;

public class ParkingLot {
    private String id = "None set";
    private String name = "No name";
    private Address address = new Address();
    private int capacity = 25;
    private double hourlyRate = 5;
    private double dailyRate = 15;
    
    public ParkingLot() {
    	
    }
    
    public ParkingLot(String id, String name, Address address, int capacity) {
    	this.id = id;
    	this.name = name;
    	this.address = address;
    	this.capacity = capacity;
    }
    
    public Money getDailyRate(CarType type) {
    	// TODO: calculate daily rate based on car type
    	return new Money();
    }
}
