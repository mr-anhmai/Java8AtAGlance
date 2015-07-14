package com.csc.lap.migration;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

public class NewDateTimeAPI {
public static void main(String[] args) {
	//Backward compatibility
			System.out.println("Backward compatible");
			Calendar cal = Calendar.getInstance();
			Date date3 = cal.getTime();
			LocalDateTime localDateTime = LocalDateTime.ofInstant(date3.toInstant(), ZoneId.systemDefault());
			LocalTime localTime = localDateTime.toLocalTime();
			System.out.println("Old date type: \t\t\t" + date3 
					+ "\nConverted date type: \t\t" + localDateTime
					+ "\nConverted to local time: \t" + localTime);
}
}
