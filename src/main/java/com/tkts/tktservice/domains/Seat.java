package com.tkts.tktservice.domains;

public class Seat {
	private int seatNumber;
	private boolean isReserved;
	private boolean isOnHold;
	
	public Seat(int seatNumber) {
		super();
		this.seatNumber = seatNumber;
		this.isReserved = false;
		this.isOnHold = false;
	}
	
	public Seat() {
	}
	
	
	public int getSeatNumber() {
		return seatNumber;
	}
	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}
	public boolean isReserved() {
		return isReserved;
	}
	public void setReserved(boolean isReserved) {
		this.isReserved = isReserved;
	}
	public boolean isOnHold() {
		return isOnHold;
	}
	public void setOnHold(boolean isOnHold) {
		this.isOnHold = isOnHold;
	}
	
}