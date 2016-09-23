/**
 * Project: A00971562Gis
 * File: Player.java
 * Date: Jun 17, 2016
 * Time: 8:24:03 PM
 */
package a00971562.gis.data;

/**
 * @author Rei Ruiz, A00971562
 *
 */
public class Player {

	private int id;
	private String firstName;
	private String lastName;
	private String emailAddress;
	private String birthDate;
	private int gamesPlayed;
	private int gamesWon;

	/**
	 * Empty constructor
	 */
	public Player() {

	}

	/**
	 * Generates a player with an id, first name, last name, email address, and birth date.
	 * 
	 * @param id
	 *            id
	 * @param firstName
	 *            first name
	 * @param lastName
	 *            last name
	 * @param emailAddress
	 *            email address
	 * @param birthDate
	 *            birth date
	 */
	public Player(int id, String firstName, String lastName, String emailAddress, String birthDate) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAddress = emailAddress;
		this.birthDate = birthDate;
	}

	/**
	 * Returns the player's id.
	 * 
	 * @return player's id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Sets the player's id.
	 * 
	 * @param id
	 *            player's id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Returns the player's first name.
	 * 
	 * @return player's first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets the player's first name.
	 * 
	 * @param firstName
	 *            player's first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Returns the player's last name.
	 * 
	 * @return player's last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets the player's last name.
	 * 
	 * @param lastName
	 *            player's last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Returns the player's email address.
	 * 
	 * @return player's email address
	 */
	public String getEmailAddress() {
		return emailAddress;
	}

	/**
	 * Sets the player's email address.
	 * 
	 * @param emailAddress
	 *            player's email address
	 */
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	/**
	 * Returns the player's birth date.
	 * 
	 * @return player's birth date
	 */
	public String getBirthDate() {
		return birthDate;
	}

	/**
	 * Sets the player's birth date.
	 * 
	 * @param birthDate
	 *            player's birth date
	 */
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	/**
	 * Returns the amount of games played.
	 * 
	 * @return the amount of games played
	 */
	public int getGamesPlayed() {
		return gamesPlayed;
	}

	/**
	 * Sets the amount of games played.
	 * 
	 * @param gamesPlayed
	 *            the new amount of games played
	 */
	public void setGamesPlayed(int gamesPlayed) {
		this.gamesPlayed = gamesPlayed;
	}

	/**
	 * Returns the amount of games won.
	 * 
	 * @return the amount of games won
	 */
	public int getGamesWon() {
		return gamesWon;
	}

	/**
	 * Sets the amount of games won.
	 * 
	 * @param gamesWon
	 *            the new amount of games won.
	 */
	public void setGamesWon(int gamesWon) {
		this.gamesWon = gamesWon;
	}

	@Override
	public String toString() {
		return "Player [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", emailAddress=" + emailAddress + ", birthDate=" + birthDate + ", gamesPlayed="
				+ gamesPlayed + ", gamesWon=" + gamesWon + "]";
	}

}
