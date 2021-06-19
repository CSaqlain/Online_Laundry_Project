package com.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.bean.Booking;
import com.dao.IBookingRepository;
import com.service.IBookingService;



@SpringBootTest
public class BookingServiceTest {
	@Autowired
	IBookingService ibookingservice;
	
	@MockBean
	IBookingRepository brepo;
	
	@Test
	void testaddBooking() 
	{
		Booking b1=new Booking();
		b1.setServiceType("DryCleaning");
		b1.setBookingId(1000L);
		b1.setBookingDate(LocalDate.now());
		b1.setBookingTime(LocalTime.now());
		//b1.setCustomerDetails(null);
		Mockito.when(brepo.save(b1)).thenReturn(b1);
		Booking response=ibookingservice.addBooking(b1);
		assertThat(response.getServiceType().equals("Hair Cut"));
		//assertThat(response.getBookingId().equals(null));
		assertThat(response.getBookingId()).isEqualTo(1000L);
		assertThat(response.getBookingDate().equals(LocalDate.now()));
		assertThat(response.getBookingTime().equals(LocalTime.now()));
	//	assertThat(response.getCustomerDetails().equals(null));
	}

	@Test
	void testgetAllBookings()
	{
		Booking b1=new Booking();
		b1.setServiceType("DryCleaning");
		b1.setBookingId(1000L);
		b1.setBookingDate(LocalDate.now());
		b1.setBookingTime(LocalTime.now());
		Booking b2=new Booking();
		b2.setServiceType("Dry");
		b2.setBookingId(1002L);
		b2.setBookingDate(LocalDate.now());
		b2.setBookingTime(LocalTime.now());
		List<Booking> ls=new ArrayList<>();
		ls.add(b1);
		ls.add(b2);
		Mockito.when(brepo.findAll()).thenReturn(ls);
		assertThat(ibookingservice.getAllBookings()).isEqualTo(ls);
		
	}
	
	@Test
	void testremoveBooking()
	{
		Booking b1=new Booking();
		b1.setServiceType("DryCleaning");
		b1.setBookingId(1000L);
		b1.setBookingDate(LocalDate.now());
		b1.setBookingTime(LocalTime.now());
		Optional<Booking> b2=Optional.of(b1);
		
		Mockito.when(brepo.findById(1000L)).thenReturn(b2);
		Mockito.when(brepo.existsById(b1.getBookingId())).thenReturn(false);
		assertFalse(brepo.existsById(b1.getBookingId()));
		
	}
	
	@Test
	void testupdateBooking()
	{
		Booking b1=new Booking();
		b1.setServiceType("DryCleaning");
		b1.setBookingId(1000L);
		b1.setBookingDate(LocalDate.now());
		b1.setBookingTime(LocalTime.now());
		Optional<Booking> b2=Optional.of(b1);
		Mockito.when(brepo.findById(1000L)).thenReturn(b2);
		b1.setServiceType("DryWashing");
		Mockito.when(brepo.save(b1)).thenReturn(b1);
		assertThat(ibookingservice.updateBooking(b1)).isEqualTo(b1);
	}
	
	
	@Test 
	void testgetBookingsByDate()
	{ 
	    Booking b1 = new Booking();
	    b1.setServiceType("DryCleaning"); b1.setBookingDate(LocalDate.now());
	    b1.setBookingId(1000L); b1.setBookingTime(LocalTime.now()); Optional<Booking>
	    b2=Optional.of(b1); Mockito.when(brepo.findById(1000L)).thenReturn(b2);
	    //b1.setServiceType("DryCleaning"); Mockito.when(brepo.save())
	}
	 
	
	@Test
	void testgetBookingsByCustomer()
	{
		Booking b1 = new Booking();
		b1.setBookingDate(LocalDate.now());
		b1.setBookingId(1000L);
		b1.setServiceType("DryCleaning");
	}	
}

