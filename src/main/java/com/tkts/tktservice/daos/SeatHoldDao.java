package com.tkts.tktservice.daos;

import java.util.Random;

import org.springframework.stereotype.Component;

import com.tkts.tktservice.domains.SeatHold;

@Component
public class SeatHoldDao {

	public SeatHold createSeatHold() {
		// TODO Auto-generated method stub
		return new SeatHold(new Random().nextInt()*1000);
	}

	public SeatHold getSeatHoldById(int seatHoldId) {
		// TODO Auto-generated method stub
		// not implemented. stubbed in tests
		return null;
	}

}
