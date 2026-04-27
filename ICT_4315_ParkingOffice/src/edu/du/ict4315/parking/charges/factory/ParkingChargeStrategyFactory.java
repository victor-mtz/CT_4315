package edu.du.ict4315.parking.charges.factory;

import edu.du.ict4315.parking.charges.strategy.CompactDiscountRate;
import edu.du.ict4315.parking.charges.strategy.DayOfWeekRate;
import edu.du.ict4315.parking.charges.strategy.FlatRate;
import edu.du.ict4315.parking.charges.strategy.ParkingChargeStrategy;

public class ParkingChargeStrategyFactory implements IParkingChargeStrategyFactory {

	@Override
	public ParkingChargeStrategy makeStrategy(ParkingChargeStrategyType type) {
		switch(type) {
		case FLAT_RATE:
			return new FlatRate();
			
		case COMPACT_DISCOUNT:
			return new CompactDiscountRate();
			
		case WEEKEND_DISCOUNT:
			return new DayOfWeekRate();
			
		default:
			throw new IllegalArgumentException("Invalid strategy type: " + type);
		}
	}
}
