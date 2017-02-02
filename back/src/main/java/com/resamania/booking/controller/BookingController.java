package com.resamania.booking.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.resamania.booking.api.ResamaniaApiRequester;
import com.resamania.booking.entity.Activity;
import com.resamania.booking.entity.Availability;
import com.resamania.booking.entity.Coach;
import com.resamania.booking.entity.Room;
import com.resamania.booking.entity.Supplier;

@RestController
@RequestMapping("/resamania")
public class BookingController {
	
	@Inject ResamaniaApiRequester requester;
	
	@GetMapping("/suppliers")
	public List<Supplier> getSuppliers() {
		List<Supplier> suppliers = requester.getSuppliers();
		return suppliers;
	}
	
	@GetMapping("/activities")
	public List<Activity> getActivities(@RequestParam("supplierId") int supplierId) {
		List<Activity> activities = requester.getActivities(supplierId);
		return activities;
	}
	
	@GetMapping("/activity")
	public String getActivityNameById(@RequestParam("activityId") int activityId) {
		String activityName = requester.getActivityNameById(activityId);
		return activityName;
	}
	
	@GetMapping("/rooms")
	public List<Room> getRooms(@RequestParam("supplierId") int supplierId) {
		List<Room> rooms = requester.getRooms(supplierId);
		return rooms;
	}
	
	@GetMapping("/coachs")
	public List<Coach> getCoachs(@RequestParam("supplierId") int supplierId) {
		List<Coach> coachs = requester.getCoachs(supplierId);
		return coachs;
	}
	
	@GetMapping("/booking")
	public List<Availability> getBookingAvailabilies(@RequestParam("supplierId") int supplierId,
														@RequestParam("roomId") int roomId,
														@RequestParam("activityId") int activityId,
														@RequestParam("coachId") int coachId,
														@RequestParam("startDate") String startDate
		) {
		
		List<Availability> availabilities = requester.getBookingAvailabilies(supplierId, roomId, activityId, coachId, startDate);
		return availabilities;
	}
}
