package com.wipro.hotel.entity;

import java.util.Date;

public class Customer
{
	String customerId;
	Date bookingDate;
	Date departureDate;
	String roomType;
	double billAmount;
	public Customer(String customerId, Date bookingDate, Date departureDate, String roomType)
	{
		this.customerId = customerId;
		this.bookingDate = bookingDate;
		this.departureDate = departureDate;
		this.roomType = roomType;
	}
	public double getTariffPerDay()
	{
		if(roomType.equals("AC"))
		{
			billAmount=3725;
		}
		else if(roomType.equals("Non-AC"))
		{
			billAmount=2250;
		}
		return billAmount;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public Date getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}
	public Date getDepartureDate() {
		return departureDate;
	}
	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	public double getBillAmount() {
		return billAmount;
	}
	public void setBillAmount(double billAmount) {
		this.billAmount = billAmount;
	}
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId +", billAmount=" + billAmount + "]";
	}
	
	
}
