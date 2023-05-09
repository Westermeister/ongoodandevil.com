package com.ongoodandevil.blog;

import java.time.format.TextStyle;
import java.time.LocalDate;
import java.time.Month;
import java.util.Locale;

import org.springframework.stereotype.Component;

/**
 * Provides helpful utility functions.
 */
@Component
public class BlogHelper {
	/**
	 * Converts numerical date to human-readable format.
	 *
	 * @param isoDate  a date in ISO-8601 format (YYYY-MM-DD) e.g. "1970-01-01"
	 * @return         all caps month and day number, then comma, space, and year e.g. "JANUARY 1, 1970"
	 */
	public String processIsoDate(String isoDate) {
		LocalDate date = LocalDate.parse(isoDate);
		Month month = date.getMonth();
		String monthName = month.getDisplayName(TextStyle.FULL, Locale.ENGLISH).toUpperCase();
		return String.format("%s %d, %d", monthName, date.getDayOfMonth(), date.getYear());
	}
}
