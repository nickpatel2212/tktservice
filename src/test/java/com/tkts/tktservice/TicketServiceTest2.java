package com.tkts.tktservice;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tkts.tktservice.daos.SeatDao;
import com.tkts.tktservice.daos.SeatHoldDao;
import com.tkts.tktservice.domains.Seat;
import com.tkts.tktservice.domains.SeatHold;
import com.tkts.tktservice.services.TicketService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TicketServiceTest2 {
	
	@Autowired
	private TicketService ticketService;

	@MockBean
	private SeatHoldDao seatHoldDao;

	@MockBean
	private SeatDao seatDao;

	@Before
	public void setUp() throws Exception {
		int seatHoldId = new Random().nextInt(100);
		SeatHold seatHold = new SeatHold(seatHoldId);
		Mockito.when(seatHoldDao.createSeatHold()).thenReturn(seatHold);
		
		Seat seat = new Seat();
		Mockito.when(seatDao.getAvailableSeats()).thenReturn(seat);
		
		List<Seat> seatList = new ArrayList<>();
		Seat seatToReserve = new Seat(new Random().nextInt(10));
		seatList.add(seatToReserve);
		
		//Mockito.when(seatHold.getReservedSeats()).thenReturn(seatList);
	}

	@Test
	public void testFindAndHoldSeats() {
		SeatHold seatHold = ticketService.findAndHoldSeats(5, "email");
		assertThat(seatHold != null);
		assertThat(seatHold.getCustomerEmail() != null);
		assertThat(seatHold.getCustomerEmail().equalsIgnoreCase("email"));
	}

}
