package com.tkts.tktservice;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThat;

import java.time.LocalDateTime;

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
import com.tkts.tktservice.domains.SeatHold;
import com.tkts.tktservice.services.TicketService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TicketServiceTest3 {
	
	@Autowired
	private TicketService ticketService;

	@MockBean
	private SeatHoldDao seatHoldDao;

	@MockBean
	private SeatDao seatDao;

	@Before
	public void setUp() throws Exception {
		int seatHoldId = 10;
		SeatHold seatHold = new SeatHold(seatHoldId);
		seatHold.setCustomerEmail("email");
		Mockito.when(seatHoldDao.getSeatHoldById(seatHoldId)).thenReturn(seatHold);
	}

	@Test
	public void testReserveSeats() {
		String ans = ticketService.reserveSeats(10, "email");
		System.out.println(ans);
		assertThat(ans != null);
		
		
	}
	
	@Before
	public void setUpPositiveTest() {
		int seatHoldId = 10;
		SeatHold seatHold = new SeatHold(seatHoldId);
		seatHold.setCustomerEmail("email");
		Mockito.when(seatHoldDao.getSeatHoldById(seatHoldId)).thenReturn(seatHold);
		
		
	}
	@Test
	public void testReserveSeatsPostive() {
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String ans = ticketService.reserveSeats(10, "email");
		System.out.println(ans);
		assertThat(ans != null);
		
	}

}
