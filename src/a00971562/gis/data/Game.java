/**
 * Project: A00971562Gis
 * File: Game.java
 * Date: Jun 17, 2016
 * Time: 8:24:55 PM
 */
package a00971562.gis.data;

/**
 * @author Rei Ruiz, A00971562
 *
 */
public class Game {

	private String id;
	private String name;
	private String producer;
	private int played;

	/**
	 * Empty constructor.
	 */
	public Game() {

	}

	/**
	 * Generates a game with an id, name, and producer.
	 * 
	 * @param id
	 *            id
	 * @param name
	 *            name
	 * @param producer
	 *            producer
	 */
	public Game(String id, String name, String producer) {
		this.id = id;
		this.name = name;
		this.producer = producer;
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

	/**
	 * Returns the number of games played.
	 * 
	 * @return the number of games played
	 */
	public int getPlayed() {
		return played;
	}

	/**
	 * Sets the number of games played.
	 * 
	 * @param played
	 *            the number of games played
	 */
	public void setPlayed(int played) {
		this.played = played;
	}

	@Override
	public String toString() {
		return "Game [id=" + id + ", name=" + name + ", producer=" + producer + ", played=" + played + "]";
	}

}
