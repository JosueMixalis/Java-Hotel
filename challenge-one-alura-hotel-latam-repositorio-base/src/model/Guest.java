package model;

import java.sql.Date;

public class Guest {
	
	private Long id, bookingId;
	private String firstName, lastName,
	nationality, phoneNumber;
	private Date birthDate;
	
	public Guest( String firstName, String lastName, String nationality, String phoneNumber, Date birthDate, Long bookingId) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.nationality = nationality;
		this.phoneNumber = phoneNumber;
		this.birthDate = birthDate;
		this.bookingId = bookingId;
	}
	
	public Guest(Long id, String firstName, String lastName, String nationality, String phoneNumber, Date birthDate, Long bookingId) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.nationality = nationality;
		this.phoneNumber = phoneNumber;
		this.birthDate = birthDate;
		this.bookingId = bookingId;
	}

	public Long getId() {
		return id;
	}

	public Long getBookingId() {
		return bookingId;
	}

	public void setBookingId(Long bookingId) {
		this.bookingId = bookingId;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getNationality() {
		return nationality;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
	
	
}
