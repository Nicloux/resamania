package com.resamania.booking.api;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.resamania.booking.entity.Activity;
import com.resamania.booking.entity.Availability;
import com.resamania.booking.entity.Booking;
import com.resamania.booking.entity.Coach;
import com.resamania.booking.entity.Room;
import com.resamania.booking.entity.Supplier;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

@Component
public class ResamaniaApiRequester {
	
	private final static Logger logger = LoggerFactory.getLogger(ResamaniaApiRequester.class);
	
	private final String resamaniaApiUrl = "http://api.intprod01.resamania.fr/rest/resamania/v1/";
	private Map<String, String> headers;
	private URL apiUrl;
	private List<Activity> activities = new ArrayList<Activity>();
	private List<Room> rooms = new ArrayList<Room>();
	private List<Coach> coachs = new ArrayList<Coach>();
	
	public ResamaniaApiRequester() {
		headers = new HashMap<String, String>();
		headers.put("mail", "test-api@intprod01.resamania.fr");
		headers.put("password", "anthony");	
	}
	
	public List<Supplier> getSuppliers() {		
		try {
			apiUrl = new URL(resamaniaApiUrl + ResamaniaApiTarget.SUPPLIER.getTarget());
		} catch (MalformedURLException e) {
			logger.error("The resamania api url is malformed: " + apiUrl.toString());
		}
		
		Map<String, String> requestParam = new HashMap<String, String>();
		requestParam.put("offset", "0");
		requestParam.put("size", "10");
		
		Response response = RestAssured.given()
			.accept(ContentType.JSON)
			.headers(headers)
			.queryParams(requestParam)
			.get(apiUrl);
		
		List<Supplier> suppliers = response.body().jsonPath().getList("resultList", Supplier.class);
		
		return suppliers;
	}
	
	public List<Activity> getActivities(int supplierId) {
		try {
			apiUrl = new URL(resamaniaApiUrl + ResamaniaApiTarget.ACTIVITY.getTarget());
		} catch (MalformedURLException e) {
			logger.error("The resamania api url is malformed: " + apiUrl.toString());
		}
		
		Map<String, String> requestParam = new HashMap<String, String>();
		requestParam.put("supplierId", String.valueOf(supplierId));
		requestParam.put("offset", "0");
		requestParam.put("size", "100");
		
		Response response = RestAssured.given()
			.accept(ContentType.JSON)
			.headers(headers)
			.queryParams(requestParam)
			.get(apiUrl);
		
		activities = response.body().jsonPath().getList("resultList", Activity.class);
		
		return activities;
	}

	public String getActivityNameById(int activityId) {
		
		if(activities.isEmpty()) {
			getActivities(23);
		}
		
		for (Activity activity : activities) {
			if(activity.getId() == activityId) {
				return activity.getName();
			}
		}
		
		return "Unknown activity";
	}
	
	public List<Room> getRooms(int supplierId) {
		try {
			apiUrl = new URL(resamaniaApiUrl + ResamaniaApiTarget.ROOM.getTarget());
		} catch (MalformedURLException e) {
			logger.error("The resamania api url is malformed: " + apiUrl.toString());
		}
		
		Map<String, String> requestParam = new HashMap<String, String>();
		requestParam.put("supplierId", String.valueOf(supplierId));
		requestParam.put("offset", "0");
		requestParam.put("size", "100");
		
		Response response = RestAssured.given()
			.accept(ContentType.JSON)
			.headers(headers)
			.queryParams(requestParam)
			.get(apiUrl);
		
		rooms = response.body().jsonPath().getList("resultList", Room.class);
		
		return rooms;
	}
	
	public String getRoomNameById(int roomId) {
		
		if(rooms.isEmpty()) {
			getRooms(23);
		}
		
		for (Room room : rooms) {
			if(room.getId() == roomId) {
				return room.getName();
			}
		}
		
		return "Unknown room";
	}
	
	public List<Coach> getCoachs(int supplierId) {
		try {
			apiUrl = new URL(resamaniaApiUrl + ResamaniaApiTarget.COACH.getTarget());
		} catch (MalformedURLException e) {
			logger.error("The resamania api url is malformed: " + apiUrl.toString());
		}
		
		Map<String, String> requestParam = new HashMap<String, String>();
		requestParam.put("supplierId", String.valueOf(supplierId));
		requestParam.put("offset", "0");
		requestParam.put("size", "100");
		
		Response response = RestAssured.given()
			.accept(ContentType.JSON)
			.headers(headers)
			.queryParams(requestParam)
			.get(apiUrl);
		
		coachs = response.body().jsonPath().getList("resultList", Coach.class);
		
		return coachs;
	}
	
	public String getCoachNameById(int coachId) {
		
		if(coachs.isEmpty()) {
			getCoachs(23);
		}
		
		for (Coach coach : coachs) {
			if(coach.getId() == coachId) {
				return coach.getSurname();
			}
		}
		
		return "Unknown coach";
	}
	
	/* The parameter supplierId is required and at least 1 of the parameters roomId, activityId, coachId
	 * have to be filled.
	 */
	public List<Availability> getBookingAvailabilies(int supplierId, int roomId, int activityId, int coachId, String startDate) {
		try {
			apiUrl = new URL(resamaniaApiUrl + ResamaniaApiTarget.BOOKING.getTarget());
		} catch (MalformedURLException e) {
			logger.error("The resamania api url is malformed: " + apiUrl.toString());
		}
		
		LocalDate startLocalDate = LocalDate.parse(startDate);
		LocalDate endLocalDate = startLocalDate.plusDays(1);
		
		Map<String, String> requestParam = new HashMap<String, String>();
		requestParam.put("supplierId", String.valueOf(supplierId));
		requestParam.put("begin", startLocalDate.toString());
		requestParam.put("end", endLocalDate.toString());
		requestParam.put("offset", "0");
		requestParam.put("size", "10");
		
		if(roomId > 0) {
			requestParam.put("roomId", String.valueOf(roomId));
		}
		
		if(activityId > 0) {
			requestParam.put("activityId", String.valueOf(activityId));
		}
		
		if(coachId > 0) {
			requestParam.put("coachId", String.valueOf(coachId));
		}
		
		if(roomId == 0 && activityId == 0 && coachId == 0) {
			logger.error("To check booking info, at least 1 of the parameters roomId, activityId, coachId have to be filled.");
			return new ArrayList<Availability>();
		}
		
		Response response = RestAssured.given()
			.accept(ContentType.JSON)
			.headers(headers)
			.queryParams(requestParam)
			.get(apiUrl);
		
		logger.warn(response.asString());
		
		ObjectMapper mapper = new ObjectMapper();
		List<Booking> bookingList = null;
		try {
			bookingList = mapper.readValue(response.asString(), new TypeReference<List<Booking>>(){});
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<Availability> availabilities = new ArrayList<Availability>();
		if(!bookingList.isEmpty()) {		
			
			for (Booking booking : bookingList) {				
				
				List<Integer> activityIdList = booking.getActivityIdList();				
				if(!activityIdList.isEmpty()) {
					
					List<Activity> activityList = new ArrayList<Activity>();
					for (Integer activityID : activityIdList) {
						Activity activity = new Activity();
						activity.setId(activityID);
						String activityName = getActivityNameById(activityID);
						activity.setName(activityName);
						
						activityList.add(activity);
					}
					booking.setActivityList(activityList);
				}
				
				List<Integer> coachIdList = booking.getCoachIdList();
				if(!coachIdList.isEmpty()) {
					List<Coach> coachList = new ArrayList<Coach>();
					for (Integer coachID : coachIdList) {
						Coach coach = new Coach();
						coach.setId(coachID);
						String coachName = getCoachNameById(coachID);
						coach.setSurname(coachName);
						
						coachList.add(coach);
					}
					booking.setCoachList(coachList);
				}
				
				List<Integer> roomIdList = booking.getRoomIdList();
				if(!roomIdList.isEmpty()) {
					List<Room> roomList = new ArrayList<Room>();
					for (Integer roomID : roomIdList) {
						Room room = new Room();
						room.setId(roomID);
						String roomName = getRoomNameById(roomID);
						room.setName(roomName);
						
						roomList.add(room);
					}
					booking.setRoomList(roomList);
				}
	
				
				String beginDate = booking.getBeginDate();
				String endDate = booking.getEndDate();
				logger.warn("beginDate: " + beginDate);
				
				String formatedBeginDate = ISO_8601_Utils.toFrenchFormat(beginDate);
				booking.setBeginDate(formatedBeginDate);
				
				String formatedEndDate = ISO_8601_Utils.toFrenchFormat(endDate);
				booking.setEndDate(formatedEndDate);
				
				String beginHour = ISO_8601_Utils.getTime(beginDate);
				booking.setBeginHour(beginHour);
				
				String duration = ISO_8601_Utils.durationBetween(beginDate, endDate);
				booking.setDuration(duration);
				
				Availability availability = new Availability(booking);
				availabilities.add(availability);
			}
		}
			
		return availabilities;
	}

}
