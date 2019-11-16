package com.freeorg.app;

import static org.junit.Assert.assertTrue;

import java.util.Set;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

import com.freeorg.app.domain.ParkingSpot;
import com.freeorg.app.domain.ParkingSpots;
import com.freeorg.app.service.ReservationService;
import com.freeorg.app.service.UserService;

/**
 * Unit test for simple App.
 */
public class ApplicationTest // extends TestsBase
{
	public static ParkingSpots parkingSpots;
	public static UserService userService;
	public static ReservationService reservationService;
	private static Application application;

	@BeforeClass
	public static void setup() {

		parkingSpots = ParkingSpots.getInstance();
		parkingSpots.add(new ParkingSpot("123e4567-e89b-12d3-a456-426655440000", "1", "1", true));
		parkingSpots.add(new ParkingSpot("2", "2", true));
		parkingSpots.add(new ParkingSpot("3", "3", true));
		parkingSpots.add(new ParkingSpot("4", "4", true));

		userService = UserService.getInstance();
		userService.add("253w4567-e89b-12d3-a456-426655445937", "9876543210");

		application = Application.getInstance();
	}

	/*
	 * @After void tearDown() { // parkingSpots.unreserveAll(); }
	 */

	@Test
	public void getAvailableSlots() {
		// Given
		// When
		Set<ParkingSpot> spots = application.getAvailable();

		// Then
		assertTrue(4 == spots.size());
	}

	@Test
	public void searchNear() {
		// Given
		String address = "Parihar Chowk Pune";
		int radiusMeters = 100;

		// When
		Set<ParkingSpot> spots = application.searhNear(address, radiusMeters);

		// Then
		assertTrue(4 == spots.size());
	}

	@Test
	public void reserve() {

		assertTrue(4 == application.getAvailable().size());

		// Given
		String userId = "253w4567-e89b-12d3-a456-426655445937";
		String availableParkingSpotId = "123e4567-e89b-12d3-a456-426655440000";

		// When
		application.reserve(userId, availableParkingSpotId);

		// Then
		assertTrue(3 == application.getAvailable().size());
	}
}
