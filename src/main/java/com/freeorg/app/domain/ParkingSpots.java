package com.freeorg.app.domain;

import java.util.HashSet;
import java.util.Set;

public class ParkingSpots {
	
	private static ParkingSpots parkingSpots = new ParkingSpots();
	
	private Set<ParkingSpot> parkingSpotsSet = new HashSet<ParkingSpot>();
	
	private ParkingSpots() {
	}
	
	public Set<ParkingSpot> getAvailable() {
		final HashSet<ParkingSpot> availableSpots = new HashSet<ParkingSpot>();
		parkingSpotsSet.stream()
		.filter(p -> p.isAvailable())
		.forEach(availableSpots::add);;
		return availableSpots;
	}

	public static ParkingSpots getInstance() {
		return parkingSpots ;
	}

	public void add(ParkingSpot parkingSpot) {
		parkingSpotsSet.add(parkingSpot);
	}

	public ParkingSpot get(String availableParkingSpotId) {
		return parkingSpotsSet.stream()
				.filter(ps -> ps.getId().equals(availableParkingSpotId))
				.findFirst().get();
	}

	public void unreserveAll() {
		for(ParkingSpot p : parkingSpotsSet) {
			p.setAvailable(true);
		}
	}	
}
