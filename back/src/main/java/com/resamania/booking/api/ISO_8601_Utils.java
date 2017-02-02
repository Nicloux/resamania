package com.resamania.booking.api;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class ISO_8601_Utils {
	
	public static Calendar toCalendar(final String iso_8601_TimeZone) throws ParseException {
	        Calendar calendar = GregorianCalendar.getInstance();
	        String timeStamp = iso_8601_TimeZone.replace("Z", "+00:00");

	        Date date = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ").parse(timeStamp);
	        calendar.setTime(date);
	        
	        return calendar;
    }
	
	/* Format a date to dd-MM-yyyy */
	public static String toFrenchFormat(final String iso_8601_TimeZone) {
        String timeStamp = iso_8601_TimeZone.replace("Z", "+0000");

        Date date = null;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ").parse(timeStamp);
		} catch (ParseException e) {
			e.printStackTrace();
		}
        
		SimpleDateFormat frenchFormat = new SimpleDateFormat("dd-MM-yyyy");
		String formatedDate = frenchFormat.format(date);
		
		return formatedDate;
	}
	
	public static String getTime(String iso_8601_TimeZone) {
        
		DateTimeFormatter zonedDateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
		ZonedDateTime zonedDate = ZonedDateTime.parse(iso_8601_TimeZone, zonedDateFormatter);
		
		String time = zonedDate.getHour() + ":" + zonedDate.getMinute();
		
		return time;
	}
	
	public static String durationBetween(String beginDate, String endDate) {
        
		DateTimeFormatter zonedDateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
		ZonedDateTime beginDateTime = ZonedDateTime.parse(beginDate, zonedDateFormatter);
		ZonedDateTime endDateTime = ZonedDateTime.parse(endDate, zonedDateFormatter);
		
		Duration duration = Duration.between(beginDateTime.toLocalTime(), endDateTime.toLocalTime());
        
        long durationInSecond = duration.getSeconds();
        
        long hour = durationInSecond / 3600;
        long minute = durationInSecond / 3600 / 60;
        
        String durationString;
        if(minute == 0) {
        	durationString = hour + "h";
        } else {
        	durationString = hour + "h" + minute;
        }
        		
		return durationString;
	}
}
