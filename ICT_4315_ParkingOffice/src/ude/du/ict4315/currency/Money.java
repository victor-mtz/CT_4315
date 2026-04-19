package ude.du.ict4315.currency;

import java.math.BigDecimal;

public class Money {
	private final BigDecimal amount;
	
	public Money() {
		this.amount = BigDecimal.ZERO;
	}
	
	public Money(BigDecimal amount) {
		this.amount = amount.setScale(2);
	}
	
	public BigDecimal getAmount() {
		return this.amount;
	}
	
    public Money add(Money other) {
        return new Money(this.amount.add(other.amount));
    }
	
	public Money multiply(BigDecimal days) {
		return new Money(this.amount.multiply(days));
	}
	
	@Override
	public String toString() {
		return "$" + this.amount;
	}
}
