/**
 * Project: A00971562Gis
 * File: Score.java
 * Date: Jun 17, 2016
 * Time: 8:25:05 PM
 */
package a00971562.gis.data;

/**
 * @author Rei Ruiz, A00971562
 *
 */
public class Score {

	private int personaId;
	private String gameId;
	private String win;
	private int winTotal;
	private int lostTotal;
	private String firstName;
	private String lastName;
	private String emailAddress;
	private String birthDate;
	private int playerId;
	private String gamerTag;
	private String platform;
	private String id;
	private String name;
	private String producer;

	/**
	 * Empty constructor.
	 */
	public Score() {

	}

	/**
	 * Generates a score with a persona id, game id, and win.
	 * 
	 * @param personaId
	 *            persona id
	 * @param gameId
	 *            game id
	 * @param win
	 *            win
	 */
	public Score(int personaId, String gameId, String win) {
		this.personaId = personaId;
		this.gameId = gameId;
		this.win = win;
	}

	/**
	 * Returns the score's persona id.
	 * 
	 * @return the score's persona id
	 */
	public int getPersonaId() {
		return personaId;
	}

	/**
	 * Sets the score's persona id.
	 * 
	 * @param personaId
	 *            the score's persona id
	 */
	public void setPersonaId(int personaId) {
		this.personaId = personaId;
	}

	/**
	 * Returns the score's game id.
	 * 
	 * @return the score's game id
	 */
	public String getGameId() {
		return gameId;
	}

	/**
	 * Sets the score's game id.
	 * 
	 * @param gameId
	 *            the score's game id
	 */
	public void setGameId(String gameId) {
		this.gameId = gameId;
	}

	/**
	 * Returns the score's win.
	 * 
	 * @return the score's win
	 */
	public String getWin() {
		return win;
	}

	/**
	 * Sets the score's win.
	 * 
	 * @param win
	 *            the score's win
	 */
	public void setWin(String win) {
		this.win = win;
	}

	/**
	 * Returns the win totals.
	 * 
	 * @return win totals
	 */
	public int getWinTotal() {
		return winTotal;
	}

	/**
	 * Sets the win totals.
	 * 
	 * @param winTotal
	 *            win totals
	 */
	public void setWinTotal(int winTotal) {
		this.winTotal = winTotal;
	}

	/**
	 * Returns the lost totals.
	 * 
	 * @return the lost totals
	 */
	public int getLostTotal() {
		return lostTotal;
	}

	/**
	 * Sets the lost totals.
	 * 
	 * @param lostTotal
	 *            the lost totals
	 */
	public void setLostTotal(int lostTotal) {
		this.lostTotal = lostTotal;
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
	 * Returns the player's id.
	 * 
	 * @return player's id
	 */
	public int getPlayerId() {
		return playerId;
	}

	/**
	 * Sets the player's id.
	 * 
	 * @param id
	 *            player's id
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
	 * Returns the game's id.
	 * 
	 * @return the game's id
	 */
	public String getId() {
		return id;
	}

	/**
	 * Set's the game's id.
	 * 
	 * @param id
	 *            the game's id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Returns the game's name.
	 * 
	 * @return the game's name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the game's name.
	 * 
	 * @param name
	 *            the game's name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Returns the game's producer.
	 * 
	 * @return the game's producer
	 */
	public String getProducer() {
		return producer;
	}

	/**
	 * Sets the game's producer.
	 * 
	 * @param producer
	 *            the game's producer
	 */
	public void setProducer(String producer) {
		this.producer = producer;
	}

	@Override
	public String toString() {
		return "Score [personaId=" + personaId + ", gameId=" + gameId + ", win=" + win + ", winTotal=" + winTotal + ", lostTotal=" + lostTotal + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", emailAddress=" + emailAddress + ", birthDate=" + birthDate + ", playerId=" + playerId + ", gamerTag=" + gamerTag + ", platform="
				+ platform + ", id=" + id + ", name=" + name + ", producer=" + producer + "]";
	}

}
