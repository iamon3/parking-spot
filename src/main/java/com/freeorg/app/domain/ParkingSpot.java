package com.freeorg.app.domain;

public class ParkingSpot {
	private String id;
	private String latitude;
	private String longitude;
	private boolean isAvailable;

	public ParkingSpot(String lat, String lon, boolean isAvailable) {
		this.latitude = lat;
		this.longitude = lon;
		this.isAvailable = isAvailable;
	}

	public ParkingSpot(String id, String lat, String lon, boolean isAvailable) {
		this.id = id;
		this.latitude = lat;
		this.longitude = lon;
		this.isAvailable = isAvailable;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	@Override
	public int hashCode() {
		return (latitude + "_" + longitude).hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof ParkingSpot) {
			ParkingSpot ps = (ParkingSpot) obj;
			return this.latitude.equals(ps.latitude) && this.longitude.equals(ps.longitude);
		}
		return false;
	}

	public String getId() {
		return id;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
}
