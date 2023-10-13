package model;

import java.sql.Date;

public class Booking {
	private Long id;
	private Date entryDate, departureDate;
	private Double price;
	private String paymentMethod;
	
	public Booking (Date entryDate, Date departureDate, double price, String  paymentMethod) {
		this.entryDate = entryDate;
		this.departureDate = departureDate;
		this.price = price;
		this.paymentMethod = paymentMethod;
	}
	
	public Booking (Long id, Date entryDate, Date departureDate, double price, String  paymentMethod) {
		this.id = id;
		this.entryDate = entryDate;
		this.departureDate = departureDate;
		this.price = price;
		this.paymentMethod = paymentMethod;
	}

	public Long getId() {
		return id;
	}

	public Date getEntryDate() {
		return entryDate;
	}

	public Date getDepartureDate() {
		return departureDate;
	}

	public Double getPrice() {
		return price;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	

}

