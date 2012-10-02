package junit;


public class Cashier {

	public Cashier() {
		
		// TODO Auto-generated constructor stub
	}
	
	public Envelope makeChange(Envelope env, int dollars, int cents) throws NegativeBalanceException
	{
		int totalChange = env.getTotalCents();
		int totalPrice = (100*dollars) + cents;
		int change = totalChange - totalPrice;
		
		if (change < 0)
		{
			throw new NegativeBalanceException("The price exceeds the envelope contents by " + Math.abs(change) + " cent(s)!");
		}
		else
		{
			int changeDollars = change/100;
			change = change%100;
			int changeQuarters = change/25;
			change = change%25;
			int changeDimes = change/10;
			change = change%10;
			int changeNickels = change/5;
			change = change%5;
			int changePennies = change;
			
			return new Envelope(changeDollars, changeQuarters, changeDimes, changeNickels, changePennies);
		}
	}

}
