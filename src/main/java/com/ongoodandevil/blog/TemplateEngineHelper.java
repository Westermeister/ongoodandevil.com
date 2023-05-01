package com.ongoodandevil.blog;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.Locale;

/**
 * Singleton class that provides utility functions for Thymeleaf.
 */
public class TemplateEngineHelper {
	private static TemplateEngineHelper instance;

	private TemplateEngineHelper() {}

	/**
	 * Return the singleton instance.
	 */
	public static synchronized TemplateEngineHelper getInstance() {
		if (instance == null) {
			instance = new TemplateEngineHelper();
		}
		return instance;
	}

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
