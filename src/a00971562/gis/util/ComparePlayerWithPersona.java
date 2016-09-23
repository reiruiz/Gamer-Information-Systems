/**
 * Project: A00971562Gis
 * File: ComparePlayerWithPersona.java
 * Date: Jun 18, 2016
 * Time: 12:04:37 AM
 */
package a00971562.gis.util;

import java.util.List;

import a00971562.gis.data.Persona;
import a00971562.gis.data.Player;

/**
 * @author Rei Ruiz, A00971562
 *
 */
public class ComparePlayerWithPersona {

	/**
	 * Private constructor to prevent instantiation.
	 */
	private ComparePlayerWithPersona() {

	}

	/**
	 * Compares a player's id with a persona's player id.
	 * 
	 * @param player
	 *            a player object
	 * @param persona
	 *            a persona object
	 * @return an integer
	 */
	private static int compareId(Player player, Persona persona) {
		return player.getId() - persona.getPlayerId();
	}

	/**
	 * Assigns the fields of a player to a persona.
	 * 
	 * @param player
	 *            a player object
	 * @param persona
	 *            a persona object
	 */
	private static void assign(Player player, Persona persona) {
		persona.setFirstName(player.getFirstName());
		persona.setLastName(player.getLastName());
		persona.setEmailAddress(player.getEmailAddress());
		persona.setBirthDate(player.getBirthDate());
	}

	/**
	 * Scans through a list of players and personas to identify identical players and personas.
	 * 
	 * @param playerList
	 *            a list of players
	 * @param personaList
	 *            a list of personas
	 */
	public static void assignField(List<Player> playerList, List<Persona> personaList) {
		for (int i = 0; i < playerList.size(); i++) {
			for (int j = 0; j < personaList.size(); j++) {
				if (compareId(playerList.get(i), personaList.get(j)) == 0)
					assign(playerList.get(i), personaList.get(j));
			}
		}
	}

}
