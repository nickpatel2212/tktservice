package com.tkts.tktservice.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

import com.tkts.tktservice.TicketServiceTest1;
import com.tkts.tktservice.TicketServiceTest2;
import com.tkts.tktservice.TicketServiceTest3;
import com.tkts.tktservice.services.TicketService;
import com.tkts.tktservice.services.TicketServiceImpl;

@RunWith(Suite.class)
@SuiteClasses({ TicketServiceTest1.class, TicketServiceTest2.class, TicketServiceTest3.class })
public class TicketServiceTests {
	
	
	 

}
