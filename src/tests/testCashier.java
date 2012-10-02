package tests;

import junit.Cashier;
import junit.Envelope;
import junit.NegativeBalanceException;
import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

public class testCashier {
	
	private Envelope testEnvelope;

	@Before
	public void initTest() {
		//Test Envelope has 2 dollars and 82 cents
		//Total cents = 282
		testEnvelope = new Envelope(2,2,2,2,2);
	}
	
	@Test
	public void testMakeChange()
	{
		try
		{
			Cashier testCashier = new Cashier();
	
			int expected = new Envelope(0,2,1,0,0).getTotalCents();
			int actual = testCashier.makeChange(testEnvelope, 2, 22).getTotalCents();
			Assert.assertEquals(expected, actual);	
		}
		catch (NegativeBalanceException ex)
		{
			System.out.println(ex);
		}
	}
	
	@Test
	public void testMakeChange2()
	{
		try
		{
			Cashier testCashier = new Cashier();
			int expected = new Envelope(1,2,2,2,2).getTotalCents();
			int actual = testCashier.makeChange(testEnvelope, 1, 0).getTotalCents();
			Assert.assertEquals(expected, actual);
		}
		catch (NegativeBalanceException ex)
		{
			System.out.println(ex);
		}
	}
	
	@Test
	public void testMakeChange3()
	{
		try
		{
			Cashier testCashier = new Cashier();
			
			int expected = new Envelope(0,0,0,0,0).getTotalCents();
			int actual = testCashier.makeChange(testEnvelope, 2, 82).getTotalCents();
			Assert.assertEquals(expected, actual);
		}
		catch (NegativeBalanceException ex)
		{
			System.out.println(ex);
		}
	}
		
	@Test
	public void testMakeChange4()
	{
		try
		{
			Cashier testCashier = new Cashier();
			
			int expected = new Envelope(2,2,2,2,2).getTotalCents();
			int actual = testCashier.makeChange(testEnvelope, 0, 0).getTotalCents();
			Assert.assertEquals(expected, actual);
		}
		catch (NegativeBalanceException ex)
		{
			System.out.println(ex);
		}
	}

	@Test 
	public void testMakeChange5()
	{
		try 
		{
			Cashier testCashier = new Cashier();
			
			int expected = new Envelope(1,1,1,1,1).getTotalCents();
			int actual = testCashier.makeChange(testEnvelope, 1, 41).getTotalCents();
			Assert.assertEquals(expected, actual);
		}
		catch (NegativeBalanceException ex)
		{
			System.out.println(ex);
		}
	}
	
	@Test
	public void testMakeChange6() {
		try {
			Cashier cashier = new Cashier();
			Envelope e = new Envelope(10, 0, 0, 0, 0);
			Envelope expected = new Envelope(0, 0, 0, 0, 1);
			Envelope actual = cashier.makeChange(e, 9, 99);
			Assert.assertEquals(expected.getTotalCents(), actual.getTotalCents());
		} catch (NegativeBalanceException ex) {
			System.out.println(ex);
		}
	}
	
	@Test (expected = NegativeBalanceException.class)
	public void testMakeChangeNegative() throws NegativeBalanceException
	{
		Cashier testCashier = new Cashier();
	
		testCashier.makeChange(testEnvelope, 3, 0);
	}
}