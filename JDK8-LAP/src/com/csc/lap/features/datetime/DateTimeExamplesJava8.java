package com.csc.lap.features.datetime;

import java.time.Clock;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.Date;


public class DateTimeExamplesJava8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//get current date, note that the new date is already in a nicer format comparing to Java 7
		System.out.println("Get current date"); 
		LocalDate today = LocalDate.now();
		System.out.println(today);
		
		//get current day, month, year
		System.out.println("Get current day, month, year");
		LocalDate today1 = LocalDate.now();
		System.out.println("Day: " + today1.getDayOfMonth()
				+ " Month: " + today1.getMonthValue()
				+ " Year: " + today1.getYear());
		
		//get a particular date
		System.out.println("Get a particular date");
		LocalDate date = LocalDate.of(2015, 6, 18); //note that the java 8 now has month from 1 -> 12
		System.out.println(date);
		
		//compare 2 dates
		System.out.println("Compare 2 dates");
		LocalDate date1 = LocalDate.of(2015, 6, 18);
		LocalDate date2 = LocalDate.of(2015, 6, 18);
		System.out.println("Compare by compareTo(): " + date1.compareTo(date2));
		System.out.println("Compare by equals(): " + date1.equals(date2));
		
		//get current time
		System.out.println("Get current time");
		LocalTime time = LocalTime.now();
		System.out.println(time);
		
		//clock
		Clock clock1 = Clock.system(ZoneId.of("America/Guadeloupe"));
		Clock clock2 = Clock.system(ZoneId.of("Etc/GMT+7"));
		System.out.println("Clock 1 GMT+7: " + clock1.instant());
		System.out.println("Clock 2 America: " + clock2.instant());
		//System.out.println(ZoneId.getAvailableZoneIds());
		
		//temporal adjusters
		System.out.println("Temporal Adjuster");
		LocalDate localDate = LocalDate.now();
		System.out.println("Today: " + localDate);
		System.out.print("First day of next day from today: " + localDate.with(TemporalAdjusters.firstDayOfNextMonth()));
		LocalDate nextTuesday = LocalDate.now().with(TemporalAdjusters.next(DayOfWeek.TUESDAY));
		System.out.println("Next Tuesday from today: " + nextTuesday);
		
		//ZonedDateTime
		System.out.println("Zoned Date Time");
		ZonedDateTime local = ZonedDateTime.now();
		System.out.println("Default zoned date time: " + local);
		Clock clockUSA = Clock.system(ZoneId.of("America/Montreal"));
		Clock clockIndia = Clock.system(ZoneId.of("Indian/Kerguelen"));
		
		System.out.println("Zoned date time from USA: " + ZonedDateTime.now(clockUSA));
		System.out.println("Zoned date time from India: " +ZonedDateTime.now(clockIndia));
		//System.out.println(ZoneId.getAvailableZoneIds());
		
		//Period
		System.out.println("Period");
		Period period = Period.of(1, 2, 60);
		System.out.println("Period of 1 year, 2 months and 60 days: " + period);
		
		//Duration
		System.out.println("Duration");
		Duration duration = Duration.ofMinutes(60);
		System.out.println("Duration of 60 minutes: " + duration);
		
		//Backward compatibility
		System.out.println("Backward compatible");
		Calendar cal = Calendar.getInstance();
		Date date3 = cal.getTime();
		LocalDateTime localDateTime = LocalDateTime.ofInstant(date3.toInstant(), ZoneId.systemDefault());
		LocalTime localTime = localDateTime.toLocalTime();
		System.out.println("Old date type: \t\t\t" + date 
				+ "\nConverted date type: \t\t" + localDateTime
				+ "\nConverted to local time: \t" + localTime);
	}

}
