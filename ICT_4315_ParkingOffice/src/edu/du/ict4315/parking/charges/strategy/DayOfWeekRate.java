package edu.du.ict4315.parking.charges.strategy;

import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;

import edu.du.ict4315.parking.CarType;
import edu.du.ict4315.parking.ParkingPermit;
import ude.du.ict4315.currency.Money;

public class DayOfWeekRate implements ParkingChargeStrategy {
	private final BigDecimal dayOfWeekDiscount = new BigDecimal("0.90");
	private final BigDecimal dayAndCarTypeDiscount = new BigDecimal("0.70");
	
	@Override
	public Money calculateParkingCharge(
			Money baseRate, 
			LocalDateTime entryTime, 
			LocalDateTime exitTime, 
			ParkingPermit permit) {
		
		Money total = new Money(BigDecimal.ZERO); // base rate that will get added to
		
		LocalDate currentDate = entryTime.toLocalDate();
		LocalDate endDate = exitTime.toLocalDate();
		
		if (currentDate.isAfter(endDate)) {
			endDate = currentDate;
		}
		
		while (!currentDate.isAfter(endDate)) {
			
			Money dailyRate = baseRate;
			
			DayOfWeek dayOfWeek = currentDate.getDayOfWeek();
			System.out.println("day of week:" + dayOfWeek);
			if (dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY) {
				// TODO: implement combined carType and weekend discount
				dailyRate = dailyRate.multiply(dayOfWeekDiscount);
			}
			
			total = total.add(dailyRate);
			currentDate = currentDate.plusDays(1);
		}
		
		return total;
	}
}
