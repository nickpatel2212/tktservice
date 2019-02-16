package com.tkts.tktservice.domains;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class SeatHold {
	private int seatHoldId;
	private List<Seat> reservedSeats;
	private String customerEmail;
	private LocalDateTime txnTime;
	
	
	
	
	public SeatHold(int seatHoldId) {
		super();
		this.seatHoldId = seatHoldId;
		this.reservedSeats = new ArrayList<>();
		this.txnTime = LocalDateTime.now();
	}
	
	public List<Seat> getReservedSeats() {
		return reservedSeats;
	}
	public void setReservedSeats(List<Seat> reservedSeats) {
		this.reservedSeats = reservedSeats;
	}
	public int getSeatHoldId() {
		return seatHoldId;
	}
	public void setSeatHoldId(int seatHoldId) {
		this.seatHoldId = seatHoldId;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public LocalDateTime getTxnTime() {
		return txnTime;
	}
	
	
	
	
}
