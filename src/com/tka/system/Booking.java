package com.tka.system;

import java.util.Date;

public class Booking {
	private int id;
	private int customerId;
	private int roomId;
	private Date checkinDate;
	private Date checkoutDate;

	public Booking() {
	}

	public Booking(int id, int customerId, int roomId, Date checkinDate, Date checkoutDate) {
		this.id = id;
		this.customerId = customerId;
		this.roomId = roomId;
		this.checkinDate = checkinDate;
		this.checkoutDate = checkoutDate;
	}

	// Getters and Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public Date getCheckinDate() {
		return checkinDate;
	}

	public void setCheckinDate(Date checkinDate) {
		this.checkinDate = checkinDate;
	}

	public Date getCheckoutDate() {
		return checkoutDate;
	}

	public void setCheckoutDate(Date checkoutDate) {
		this.checkoutDate = checkoutDate;
	}

	public void display() {
	    System.out.println("Booking ID   : " + id);
	    System.out.println("Customer ID  : " + customerId);
	    System.out.println("Room ID      : " + roomId);
	    System.out.println("Check-in     : " + checkinDate);
	    System.out.println("Check-out    : " + checkoutDate);
	    System.out.println("--------------------------------------");
	}

}
