package com.freeorg.app.service;

public class GeocodingService {
	
	private static GeocodingService geocodingService = new GeocodingService(); 
	
	private GeocodingService() {
	}
	
	public static GeocodingService getInstance() {
		return geocodingService;
	}

	public String[] ToLatLong(String address) {
		// Some logic to reverse geo code
		return new String[2];
	}
}
