/**
 * Project: A00971562Gis
 * File: Persona.java
 * Date: Jun 17, 2016
 * Time: 8:24:21 PM
 */
package a00971562.gis.data;

/**
 * @author Rei Ruiz, A00971562
 *
 */
public class Persona {

	private int id;
	private int playerId;
	private String gamerTag;
	private String platform;
	private String firstName;
	private String lastName;
	private String emailAddress;
	private String birthDate;

	/**
	 * Empty constructor.
	 */
	public Persona() {

	}

	/**
	 * Generates a persona with an id, player id, gamer tag, and platform.
	 * 
	 * @param id
	 *            id
	 * @param playerId
	 *            player id
	 * @param gamerTag
	 *            gamer tag
	 * @param platform
	 *            platform
	 */
	public Persona(int id, int playerId, String gamerTag, String platform) {
		this.id = id;
		this.playerId = playerId;
		this.gamerTag = gamerTag;
		this.platform = platform;
	}

	/**
	 * Returns the persona's id.
	 * 
	 * @return persona's id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Sets the persona's id
	 * 
	 * @param id
	 *            the persona's id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Returns the persona's player's id.
	 * 
	 * @return the persona's player id
	 */
	public int getPlayerId() {
		return playerId;
	}

	/**
	 * Sets the persona's player's id.
	 * 
	 * @param playerId
	 *            the persona's player's id
	 */
	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}

	/**
	 * Returns the persona's gamer tag.
	 * 
	 * @return the persona's gamer tag
	 */
	public String getGamerTag() {
		return gamerTag;
	}

	/**
	 * Sets the persona's gamer tag.
	 * 
	 * @param gamerTag
	 *            the persona's gamer tag
	 */
	public void setGamerTag(String gamerTag) {
		this.gamerTag = gamerTag;
	}

	/**
	 * Returns the persona's platform.
	 * 
	 * @return the persona's platform
	 */
	public String getPlatform() {
		return platform;
	}

	/**
	 * Sets the persona's platform.
	 * 
	 * @param platform
	 *            the persona's platform
	 */
	public void setPlatform(String platform) {
		this.platform = platform;
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

	@Override
	public String toString() {
		return "Persona [id=" + id + ", playerId=" + playerId + ", gamerTag=" + gamerTag + ", platform=" + platform + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", emailAddress=" + emailAddress + ", birthDate=" + birthDate + "]";
	}

}
