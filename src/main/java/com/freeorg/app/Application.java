package com.freeorg.app;

import java.util.Set;

import com.freeorg.app.domain.ParkingSpot;
import com.freeorg.app.domain.User;
import com.freeorg.app.service.GeocodingService;
import com.freeorg.app.service.ReservationService;
import com.freeorg.app.service.UserService;

/**
 * It's Facade for Reservation, Geocoding etc
 *
 */
public class Application 
{
	private static Application application = new Application(ReservationService.getInstance(), GeocodingService.getInstance(), UserService.getInstance());
	
	private ReservationService reservationService;
	private GeocodingService geocodingService;
	private UserService userService;
	
	private Application(ReservationService reservationService, GeocodingService geocodingService, UserService userService) {
		this.reservationService = reservationService;
		this.geocodingService = geocodingService;
		this.userService = userService;
	}
	
	public static Application getInstance() {
		return application;
	}
	
	public Set<ParkingSpot> getAvailable() {
		return reservationService.getAvailable();
	}

	public Set<ParkingSpot> searhNear(String address, int radiusMeters) {
		String[] latLonStringArr = geocodingService.ToLatLong(address);
		return reservationService.getAvailable(latLonStringArr[0], latLonStringArr[1], radiusMeters);
	}
	
	public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }

	public void reserve(String userId, String availableParkingSpotId) {
		reservationService.reserve(userService.get(userId), availableParkingSpotId);
	}
}
