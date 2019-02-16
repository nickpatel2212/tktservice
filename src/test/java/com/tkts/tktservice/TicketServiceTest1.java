/**
 * 
 */
package com.tkts.tktservice;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tkts.tktservice.daos.SeatDao;
import com.tkts.tktservice.daos.SeatHoldDao;
import com.tkts.tktservice.services.TicketService;

/**
 * @author nikul
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TicketServiceTest1 {
	
	@Autowired
	private TicketService ticketService;

	@MockBean
	private SeatHoldDao seatHoldDao;

	@MockBean
	private SeatDao seatDao;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		Integer i = 10;
		Mockito.when(seatDao.getNumSeatsAvailable()).thenReturn(i);
	}

	/**
	 * Test method for
	 * {@link com.tkts.tktservice.services.TicketServiceImpl#numSeatsAvailable()}.
	 */
	@Test
	public void testNumSeatsAvailable() {
		int count = ticketService.numSeatsAvailable();
		assertThat(count != 0);
		assertThat(count == 10);
	}
}
