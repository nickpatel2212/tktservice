package com.tkts.tktservice.services;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tkts.tktservice.daos.SeatDao;
import com.tkts.tktservice.daos.SeatHoldDao;
import com.tkts.tktservice.domains.Seat;
import com.tkts.tktservice.domains.SeatHold;

@Component
public class TicketServiceImpl implements TicketService {
	

	@Autowired
	SeatDao seatDao;
	
	@Autowired
	SeatHoldDao seatHoldDao;

	@Override
	public int numSeatsAvailable() {
		// TODO Auto-generated method stub
		return seatDao.getNumSeatsAvailable();
	}

	@Override
	public SeatHold findAndHoldSeats(int numSeats, String customerEmail) {
		// TODO Auto-generated method stub
		SeatHold seatHold = seatHoldDao.createSeatHold();
		seatHold.setCustomerEmail(customerEmail);
		for(int i=0; i<numSeats; i++) {
			Seat seat = seatDao.getAvailableSeats();
			seatHold.getReservedSeats().add(seat);
		}
		return seatHold;
	}

	@Override
	public String reserveSeats(int seatHoldId, String customerEmail) {
		String response = "Reservation Successful";
		SeatHold seatHold = seatHoldDao.getSeatHoldById(seatHoldId);
		if(seatHold.getCustomerEmail().equalsIgnoreCase(customerEmail)) {
			try {
				if(seatHold.getTxnTime().plusSeconds(300).isBefore(LocalDateTime.now())) {
					seatHold.getReservedSeats().forEach(seat -> {
						seat.setReserved(true);
					});
				} else {
					response = "Reservation fails: seatHold time exceeded";
				}
			}catch(Exception e) {
				response = "Reservation fails: unknown error while reserving seats";
			}
		}
		return response;
	}
	
	

}
