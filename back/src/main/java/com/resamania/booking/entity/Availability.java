package com.resamania.booking.entity;

public class Availability {
	
	private int id;	
	private String activityName;	
	private String roomName;	
	private String coachName;
    private String beginDate; 
    private String beginHour;    
    private String duration;    
    private int nbPlace;   
    private int nbPlaceAvailable; 
    
    public Availability() {}
    
    public Availability(Booking booking) {
    	this.id = booking.getId();
    	this.activityName = booking.getActivityList().get(0).getName();
    	this.roomName = booking.getRoomList().get(0).getName();
    	this.coachName = booking.getCoachList().get(0).getSurname();
    	this.beginDate = booking.getBeginDate();
    	this.beginHour = booking.getBeginHour();
    	this.duration = booking.getDuration();
    	this.nbPlace = booking.getNbPlace();
    	this.nbPlaceAvailable = booking.getNbPlace() - booking.getNbPlaceInUsed();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getActivityName() {
		return activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public String getCoachName() {
		return coachName;
	}

	public void setCoachName(String coachName) {
		this.coachName = coachName;
	}

	public String getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}

	public String getBeginHour() {
		return beginHour;
	}

	public void setBeginHour(String beginHour) {
		this.beginHour = beginHour;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public int getNbPlace() {
		return nbPlace;
	}

	public void setNbPlace(int nbPlace) {
		this.nbPlace = nbPlace;
	}

	public int getNbPlaceAvailable() {
		return nbPlaceAvailable;
	}

	public void setNbPlaceAvailable(int nbPlaceAvailable) {
		this.nbPlaceAvailable = nbPlaceAvailable;
	}
}
