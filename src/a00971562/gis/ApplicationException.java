/**
 * Project: A00971562Gis
 * File: ApplicationException.java
 * Date: Jul 18, 2016
 * Time: 2:08:35 PM
 */
package a00971562.gis;

/**
 * @author Rei Ruiz, A00971562
 *
 */
@SuppressWarnings("serial")
public class ApplicationException extends Exception {

	/**
	 * Empty constructor.
	 */
	public ApplicationException() {

	}

	/**
	 * Constructs an ApplicationException with a message.
	 * 
	 * @param message
	 *            the message
	 */
	public ApplicationException(String message) {
		super(message);
	}

	/**
	 * Constructs an ApplicationException with a throwable.
	 * 
	 * @param cause
	 *            the throwable
	 */
	public ApplicationException(Throwable cause) {
		super(cause);
	}

	/**
	 * Constructs an ApplicationException with a message and a throwable.
	 * 
	 * @param message
	 *            the message
	 * @param cause
	 *            the throwable
	 */
	public ApplicationException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Constructs an ApplicationException with a message, a throwable, suppression, and a stack trace.
	 * 
	 * @param message
	 *            the message
	 * @param cause
	 *            the throwable
	 * @param enableSuppression
	 *            the suppression
	 * @param writableStackTrace
	 *            the stack trace
	 */
	public ApplicationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
