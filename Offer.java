package com.wipro.hotel.entity;

public class Offer
{
	public double getOffer(String roomType,double billAmount)
	{
		if(roomType.equals("AC"))
		{
			if(billAmount<=5000)
			{
				billAmount=billAmount;
			}
			else if(billAmount>5000&&billAmount<=10000)
			{
				billAmount=(billAmount*(12/100f));
			}
			else if(billAmount>10000)
			{
				billAmount=(billAmount*(18/100f));
			}
		}	
		else if(roomType.equals("Non-AC"))
		{
			if(billAmount<=10000);
			{
				billAmount=billAmount;
			}
			if(roomType.equals("Non-AC")&&billAmount>10000)
			{
				billAmount=(billAmount*(3/100));
			}
		}		
		return billAmount;
	}
}
