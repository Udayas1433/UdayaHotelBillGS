package com.wipro.hotel.main;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.wipro.hotel.service.HotelBillService;

public class MainClass
{
	public static void main(String[] args) throws Exception
	{
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		HotelBillService h =new HotelBillService();
		Date bookingDate=formatter.parse("11/07/2017");
		Date departureDate=formatter.parse("13/07/2017");
		System.out.println(h.calculateBill("CC112233", bookingDate,departureDate ,"AC"));
	}
}
