package com.freeorg.app;

import org.junit.BeforeClass;

import com.freeorg.app.domain.ParkingSpot;
import com.freeorg.app.domain.ParkingSpots;
import com.freeorg.app.service.ReservationService;

public class TestsBase {

	public static ReservationService reservationService;
	public static ParkingSpots parkingSpots;
	
	@BeforeClass
	public static void setup() { 
		parkingSpots = ParkingSpots.getInstance();
		parkingSpots.add(new ParkingSpot("1","1",true));
		parkingSpots.add(new ParkingSpot("2","2",true));
		parkingSpots.add(new ParkingSpot("3","3",true));
		parkingSpots.add(new ParkingSpot("4","4",true));
		
		reservationService = ReservationService.getInstance();
		
	}
}
