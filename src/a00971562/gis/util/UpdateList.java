/**
 * Project: A00971562Gis
 * File: UpdateScoreList.java
 * Date: Jun 18, 2016
 * Time: 2:27:39 AM
 */
package a00971562.gis.util;

import java.util.List;

import a00971562.gis.data.Game;
import a00971562.gis.data.Persona;
import a00971562.gis.data.Player;
import a00971562.gis.data.Score;

/**
 * @author Rei Ruiz, A00971562
 *
 */
public class UpdateList {

	/**
	 * Private constructor to prevent instantiation.
	 */
	private UpdateList() {

	}

	/**
	 * Updates a score list of scores by combining identical players, personas, and games.
	 * 
	 * @param player
	 *            list of players
	 * @param persona
	 *            list of personas
	 * @param game
	 *            list of games
	 * @param score
	 *            list of scores
	 */
	public static void updateScoreList(List<Player> player, List<Persona> persona, List<Game> game, List<Score> score) {
		ComparePlayerWithPersona.assignField(player, persona);
		CompareGameWithScore.assignField(game, score);
		ComparePersonaWithScore.assignField(persona, score);
	}

	/**
	 * Updates a player list by assigning identical fields.
	 * 
	 * @param player
	 *            a list of players
	 * @param score
	 *            a list of scores
	 */
	public static void updatePlayerList(List<Player> player, List<Score> score) {
		ComparePlayerWithScore.assignField(player, score);
	}

	/**
	 * Updates the incoming list by a given filter (i.e. gamer tag).
	 * 
	 * @param list
	 *            the incoming list of scores
	 * @param gamerTag
	 *            the gamer tag to filter
	 * @return
	 */
	public static List<Score> filterGamerTag(List<Score> list, String gamerTag) {
		for (int index = 0; index < list.size(); index++) {
			if (!list.get(index).getGamerTag().equalsIgnoreCase(gamerTag)) {
				list.remove(index);
				index--;
			}
		}
		return list;
	}

}
