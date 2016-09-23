/**
 * Project: A00971562Gis
 * File: DateProcessor.java
 * Date: Jun 17, 2016
 * Time: 9:10:23 PM
 */
package a00971562.gis.util;

import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author Rei Ruiz, A00971562
 *
 */
public class DateProcessor {

	/**
	 * Private constructor to prevent instantiation.
	 */
	private DateProcessor() {

	}

	/**
	 * Parses the LocalDate from a basic ISO date formatted String.
	 * 
	 * @param input
	 *            the basic ISO date formatted string
	 * @return the LocalDate
	 */
	public static LocalDate parseDate(String input) {
		LocalDate basicIsoDate = LocalDate.parse(input, DateTimeFormatter.BASIC_ISO_DATE);
		return basicIsoDate;
	}

	/**
	 * Formats a given LocalDate object into the "EEE MMM dd yyyy" format.
	 * 
	 * @param input
	 *            the given LocalDate
	 * @return the formatted date
	 */
	public static String formatDate(LocalDate input) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEE MMM dd yyyy");
		String formattedDateTime = input.format(formatter);
		return formattedDateTime;

	}

	/**
	 * Gets the current age given a birth date.
	 * 
	 * @param input
	 *            a birth date
	 * @return the current age
	 */
	public static int getAge(String input) {
		Instant currentTime = Instant.now();
		return Integer.parseInt(currentTime.toString().substring(0, 4)) - Integer.parseInt(input.substring(0, 4));
	}

}
