package com.csc.lap.features.datetime;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateTimeExamplesJava7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//get current date
		System.out.println("Get current date");
		Date date = Calendar.getInstance().getTime();
		System.out.println(date);
		
		//get current day, month, year
		System.out.println("Get current day, month, year");
		Calendar cal = Calendar.getInstance();
		System.out.println("Day: " + cal.get(Calendar.DATE)
				+ " Month: " + (cal.get(Calendar.MONTH)+1)
				+ " Year: " + cal.get(Calendar.YEAR));
		
		//get a particular date
		System.out.println("Get a particular date");
		Calendar cal1 = new GregorianCalendar(2015, 5, 18);
		System.out.println(cal1.getTime());
		
		//compare 2 dates
		System.out.println("Compare 2 dates");
		Calendar cal2 = new GregorianCalendar(2015, 5, 18);
		Calendar cal3 = new GregorianCalendar(2015, 5, 18);
		System.out.println("By compareTo() :" + cal2.getTime().compareTo(cal3.getTime()));
		System.out.println("By equals() :" +cal2.getTime().equals(cal3.getTime()));
		
		//Another way to compare 2 Calendar objects
//		Calendar cal3 = Calendar.getInstance();
//		Calendar cal4 = Calendar.getInstance();
//		cal4.set(2015, 5, 18);
//		cal3.set(2015, 5, 18);
//		System.out.println(cal4.equals(cal3));
		
		//get current time
		System.out.println("Get current time");
		Calendar cal4 = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
		System.out.println(sdf.format(cal4.getTime()));
	}

}
