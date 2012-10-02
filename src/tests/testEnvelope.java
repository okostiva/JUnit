package tests;

import junit.Envelope;
import junit.framework.Assert;

import org.junit.Test;

public class testEnvelope {

	@Test
	public void testGetTotalCents() {
		int expected = 25;
		int actual = new Envelope(0,1,0,0,0).getTotalCents();
		Assert.assertEquals(expected, actual);
		
		expected = 141;
		actual = new Envelope(1,1,1,1,1).getTotalCents();
		Assert.assertEquals(expected, actual);
		
		expected = 0;
		actual = new Envelope(0,0,0,0,0).getTotalCents();
		Assert.assertEquals(expected, actual);
		
		expected = 111;
		actual = new Envelope(1,0,1,0,1).getTotalCents();
		Assert.assertEquals(expected, actual);
		
		expected = 200;
		actual = new Envelope(2,0,0,0,0).getTotalCents();
		Assert.assertEquals(expected, actual);
		
		expected = 1000;
		actual = new Envelope(8,6,4,2,0).getTotalCents();
		Assert.assertEquals(expected, actual);
		
		expected = 128;
		actual = new Envelope(0,2,4,6,8).getTotalCents();
		Assert.assertEquals(expected, actual);
		
		Envelope e = new Envelope(0, 2, 0, 0, 0);
		expected = 50;
		actual = e.getTotalCents();
		Assert.assertEquals(expected, actual);

		Envelope b = new Envelope(3, 1, 1, 1, 1);
		expected = 341;
		actual = b.getTotalCents();
		Assert.assertEquals(expected, actual);
		
		Envelope c = new Envelope(1, 2, 3, 4, 5);
		expected = 205;
		actual = c.getTotalCents();
		Assert.assertEquals(expected, actual);
		
	}

}
