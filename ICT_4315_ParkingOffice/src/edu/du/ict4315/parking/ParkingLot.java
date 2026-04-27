// File: ParkingLot
// Author: Victor Martinez
// Class: ICT 4315
package edu.du.ict4315.parking;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import edu.du.ict4315.parking.charges.factory.ParkingChargeStrategyFactory;
import edu.du.ict4315.parking.charges.factory.ParkingChargeStrategyType;
import edu.du.ict4315.parking.charges.strategy.ParkingChargeStrategy;
import ude.du.ict4315.currency.Money;

public class ParkingLot {
    private String id = "None set";
    private String name = "No name";
    private Address address = new Address();
    private int capacity = 25;
    private double hourlyRate = 5;
    private double dailyRate = 15;
    private ParkingChargeStrategy chargeStrategy;
    
    public ParkingLot() {
    	
    }
    
    public ParkingLot(String id, String name, Address address, int capacity) {
    	this.id = id;
    	this.name = name;
    	this.address = address;
    	this.capacity = capacity;
    }
    
    public Money getDailyRate() {
    	return new Money(new BigDecimal(this.dailyRate));
    }
    
    public ParkingChargeStrategy getStrategy() {
    	return this.chargeStrategy;
    }
    
    public void setStrategy(ParkingChargeStrategyType strategyType) {
    	ParkingChargeStrategyFactory strategyFactory = new ParkingChargeStrategyFactory();
    	this.chargeStrategy = strategyFactory.makeStrategy(strategyType);
    }
    
    public Money calculateCharge(
    		LocalDateTime entryTime,
    		LocalDateTime exitTime,
    		ParkingPermit permit,
    		boolean useDiscount) {
    	Money dailyRate = this.getDailyRate();
    	if (this.chargeStrategy != null) {
    		return this.chargeStrategy.calculateParkingCharge(dailyRate, entryTime, exitTime, permit);
    	} else {
    		throw new IllegalArgumentException("Charge strategy not set for Parking Lot.");
    	}
    	
    }
}
