package javaUtility;

import java.time.LocalDate;
import java.util.Random;

public class JavaUtil {
	public static int generateRandomNumber(int limit)
	{
		Random r = new Random();
		return r.nextInt(limit);
	}
	public static String getCurrentDate()
	{
//		LocalDateTime now = LocalDateTime.now();
//		return now.toString().substring(0, 10);
		LocalDate date = LocalDate.now();
		return date.toString();
	}
	
	public static String getDesiredDate()
	{
		LocalDate today = LocalDate.now();
		LocalDate nextDate = today.plusDays(15);
		return nextDate.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(getCurrentDate());
		System.out.println(getDesiredDate());
	}
}
