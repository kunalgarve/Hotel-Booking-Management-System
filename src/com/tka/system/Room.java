package com.tka.system;

public class Room {
	private int id;
	private String roomNumber;
	private String type;
	private double price;
	private boolean available;

	public Room() {
	}

	public Room(int id, String roomNumber, String type, double price, boolean available) {
		this.id = id;
		this.roomNumber = roomNumber;
		this.type = type;
		this.price = price;
		this.available = available;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public void display() {
	    System.out.println("Room ID      : " + id);
	    System.out.println("Room Number  : " + roomNumber);
	    System.out.println("Type         : " + type);
	    System.out.println("Price        : " + price);
	    System.out.println("Available    : " + available);
	    System.out.println("------------------------------------");
	}

}
