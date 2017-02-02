package com.resamania.booking.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

public class Booking {
	
	@JsonProperty
	private int id;
	
	@JsonProperty
    private String beginDate;
    
	@JsonProperty
    private String endDate;
    
	@JsonProperty(access = Access.READ_ONLY)
    private String beginHour;
    
	@JsonProperty(access = Access.READ_ONLY)
    private String duration;
    
    @JsonProperty
    private int nbPlace;
    
    @JsonProperty
    private int nbPlaceInUsed; 
    
    @JsonProperty(access = Access.WRITE_ONLY)
    private List<Integer> roomIdList;
    
    @JsonProperty(access = Access.READ_ONLY)
    private List<Room> roomList;
    
    @JsonProperty(access = Access.WRITE_ONLY)
    private List<Integer> activityIdList;
    
    @JsonProperty(access = Access.READ_ONLY)
    private List<Activity> activityList;
    
    @JsonProperty(access = Access.WRITE_ONLY)
    private List<Integer> coachIdList;
    
    @JsonProperty(access = Access.READ_ONLY)
    private List<Coach> coachList;
    
    @JsonProperty(access = Access.WRITE_ONLY)
    private String commentary;
    
    @JsonProperty(access = Access.WRITE_ONLY)
    private String lastModificationDate;
    
    @JsonProperty(access = Access.WRITE_ONLY)
    private String suppressionDate;
    
    @JsonProperty(access = Access.WRITE_ONLY)
    private boolean isFromScheduledBooking = false;
    
    @JsonProperty(access = Access.WRITE_ONLY)
    private String level;
    
    @JsonProperty(access = Access.WRITE_ONLY)
    private String intensity;
    
    @JsonProperty(access = Access.WRITE_ONLY)
    private String calories;
    
    @JsonIgnore
    private int sessionId;
    
    public Booking() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
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

	public int getNbPlaceInUsed() {
		return nbPlaceInUsed;
	}

	public void setNbPlaceInUsed(int nbPlaceInUsed) {
		this.nbPlaceInUsed = nbPlaceInUsed;
	}

	public List<Integer> getRoomIdList() {
		return roomIdList;
	}

	public void setRoomIdList(List<Integer> roomIdList) {
		this.roomIdList = roomIdList;
	}

	public List<Room> getRoomList() {
		return roomList;
	}

	public void setRoomList(List<Room> roomList) {
		this.roomList = roomList;
	}

	public List<Integer> getActivityIdList() {
		return activityIdList;
	}

	public void setActivityIdList(List<Integer> activityIdList) {
		this.activityIdList = activityIdList;
	}

	public List<Activity> getActivityList() {
		return activityList;
	}

	public void setActivityList(List<Activity> activityList) {
		this.activityList = activityList;
	}

	public List<Integer> getCoachIdList() {
		return coachIdList;
	}

	public void setCoachIdList(List<Integer> coachIdList) {
		this.coachIdList = coachIdList;
	}

	public List<Coach> getCoachList() {
		return coachList;
	}

	public void setCoachList(List<Coach> coachList) {
		this.coachList = coachList;
	}

	public String getCommentary() {
		return commentary;
	}

	public void setCommentary(String commentary) {
		this.commentary = commentary;
	}

	public String getLastModificationDate() {
		return lastModificationDate;
	}

	public void setLastModificationDate(String lastModificationDate) {
		this.lastModificationDate = lastModificationDate;
	}

	public String getSuppressionDate() {
		return suppressionDate;
	}

	public void setSuppressionDate(String suppressionDate) {
		this.suppressionDate = suppressionDate;
	}
	
	@JsonIgnore
	public boolean isFromScheduledBooking() {
		return isFromScheduledBooking;
	}
	
	public void setIsFromScheduledBooking(boolean isFromScheduledBooking) {
		this.isFromScheduledBooking = isFromScheduledBooking;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getIntensity() {
		return intensity;
	}

	public void setIntensity(String intensity) {
		this.intensity = intensity;
	}

	public String getCalories() {
		return calories;
	}

	public void setCalories(String calories) {
		this.calories = calories;
	}

	public int getSessionId() {
		return sessionId;
	}

	public void setSessionId(int sessionId) {
		this.sessionId = sessionId;
	}
}
