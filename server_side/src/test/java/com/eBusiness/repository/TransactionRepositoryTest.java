package com.eBusiness.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.eBusiness.Application;
import com.eBusiness.persist.entity.transaction.Transaction;
import com.eBusiness.persist.repo.transaction.TransactionRepository;

//@RunWith(SpringRunner.class)
//@SpringBootTest

//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(classes = Application.class) //Depreciated since spring boot test 1.5

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public class TransactionRepositoryTest {

	private static final Long TEST_ID = new Long(-1);
	
	@Autowired private TransactionRepository transactionRepo;
	
	@Before
	public void setup() {
		
	}
	
	@After
	public void tearDown() {
		
	}
	
	@Test
	public void findAllByAccountId() {
		List<Transaction> transactions = null;
		try{
			transactions = transactionRepo.findAllByAccount(TEST_ID);
		}
		catch(Exception e) {
			fail(e.getMessage());
		}
		assertEquals(4, transactions.size());
	}
}
