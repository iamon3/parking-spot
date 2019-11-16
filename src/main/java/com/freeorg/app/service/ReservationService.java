package com.freeorg.app.service;

import java.util.Collections;
import java.util.Set;

import com.freeorg.app.domain.ParkingSpot;
import com.freeorg.app.domain.ParkingSpots;
import com.freeorg.app.domain.User;

public class ReservationService {
	private static ReservationService reservationService = new ReservationService(ParkingSpots.getInstance());
	private ParkingSpots parkingSpots;
	
	private ReservationService(ParkingSpots parkingSpots) {
		this.parkingSpots = parkingSpots;
	}
	
	public static ReservationService getInstance() {
		return reservationService;
	}

	public Set<ParkingSpot> getAvailable() {
		return Collections.unmodifiableSet(parkingSpots.getAvailable());
	}

	public Set<ParkingSpot> getAvailable(String latitude, String longitude, int radiusMeters) {
		// Some logic which will find all parking slots in the given radius and in available parking spots
		return Collections.unmodifiableSet(parkingSpots.getAvailable());
	}

	public void reserve(User user, String availableParkingSpotId) {
		parkingSpots.get(availableParkingSpotId).setAvailable(false);
	}
}
