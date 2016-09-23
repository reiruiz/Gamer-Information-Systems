/**
 * Project: A00971562Lab5
 * File: Validator.java
 * Date: Jun 10, 2016
 * Time: 8:48:48 PM
 */
package a00971562.gis.util;

import java.util.regex.Pattern;

/**
 * @author Rei Ruiz, A00971562
 *
 */
public class Validator {

	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	private static Pattern pattern = Pattern.compile(EMAIL_PATTERN);

	private Validator() {
	}

	/**
	 * Validate an email string.
	 * 
	 * @param email
	 *            the email string.
	 * @return true if the email address is valid, false otherwise.
	 */
	public static boolean validateEmail(final String email) {
		return pattern.matcher(email).matches();
	}

}
