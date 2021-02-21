package com.wipro.hotel.service;
import java.util.Date;
import com.wipro.hotel.entity.Customer;
import com.wipro.hotel.entity.Offer;
import com.wipro.hotel.exception.InvalidDataException;
import com.wipro.hotel.exception.InvalidRoomTypeException;

public class HotelBillService
{
	 int nod;
	double tarrif,ba,tax,finalbill;
	public String validateData(String customerId, Date bookingDate,Date departureDate, String roomType)
	{
		if(customerId.length()==8&&customerId!=null)
		{
			if(bookingDate.after(departureDate))
			{		
					return "Valid";
			}
		
			if(roomType.equals("AC")||roomType.equals("Non-AC"))
			{
				return "Valid";
			}
			else
			{
				try
				{
					throw new InvalidRoomTypeException();
				}
				catch (Exception e)
				{
					System.out.println(e);
				}
			}
		}
		else
		{
			try
			{
				 throw new InvalidDataException();
			}
			catch (Exception e)
			{
				System.out.println(e);
			}
		}
		return roomType;
	}
	public int getDaysStayed(Date bookingDate, Date departureDate)
	{
		return Math.abs((int)((bookingDate.getTime()-departureDate.getTime())/86400000));
	}
	public String calculateBill(String customerId,Date bookingDate,Date	departureDate, String roomType) 
	{
		HotelBillService hb=new HotelBillService();
		
		String valid=hb.validateData(customerId, bookingDate, departureDate, roomType);
		if(valid.equals("Valid"))
		{
			Customer c=new Customer(customerId,bookingDate, departureDate, roomType);
			nod=hb.getDaysStayed(bookingDate, departureDate);
			tarrif=c.getTariffPerDay();
			ba=(nod*tarrif);
			if(ba<=5000)
			{
				ba+=ba*0.05;
			}
			else if(ba>5000&&ba<=10000)
			{
				ba+=ba*0.1;
			}
			else if(ba>5000&&ba<=10000)
			{
				ba+=ba*0.2;
			}
			Offer of=new Offer();
			finalbill=ba-of.getOffer(roomType, ba);			
			System.out.println("Customer id:"+c.getCustomerId());
			System.out.println("Bill Amount:Rs."+String.format("%.1f", finalbill));
		}
		return valid;
	}
}
