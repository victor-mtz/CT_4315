// File: ParkingPermit
// Author: Victor Martinez
// Class: ICT 4315
package edu.du.ict4315.parking;

import java.util.Date;
import java.util.UUID;

public class ParkingPermit {
    private String id = String.valueOf(UUID.randomUUID());
    private Car car;
    private Date expiration = new Date();
    
    public ParkingPermit(Car car) {
    	this.car = car;
    }
    
    public Car getCar() {
    	return this.car;
    }
    
    public String getPermitId() {
    	return this.id;
    }
}
