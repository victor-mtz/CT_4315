package edu.du.ict4315.parking.charges.factory;

import edu.du.ict4315.parking.charges.strategy.ParkingChargeStrategy;

public interface IParkingChargeStrategyFactory {
//	ParkingChargeStrategy getStrategy();
	ParkingChargeStrategy makeStrategy(ParkingChargeStrategyType type);
}
