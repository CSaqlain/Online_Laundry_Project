package com.service;



import java.time.LocalDate;
import java.util.List;

import com.bean.Booking;



public interface IBookingService {

	Booking addBooking(Booking booking);

	Booking removeBooking(long bookingId);

	Booking updateBooking(Booking booking);

	Booking getBooking(long bookingId);

	List<Booking> getAllBookings();

	List<Booking> getBookingsByDate(LocalDate localDate);

	List<Booking> getBookingsByCustomer(String customerId);
}