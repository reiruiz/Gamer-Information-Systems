/**
 * Project: A00971562Gis
 * File: ComparePlayerWithScore.java
 * Date: Jun 19, 2016
 * Time: 11:19:10 AM
 */
package a00971562.gis.util;

import java.util.List;

import a00971562.gis.data.Player;
import a00971562.gis.data.Score;

/**
 * @author Rei Ruiz, A00971562
 *
 */
public class ComparePlayerWithScore {

	/**
	 * Private constructor to prevent instantiation.
	 */
	private ComparePlayerWithScore() {

	}

	/**
	 * Compars a player's id with a score's player's id.
	 * 
	 * @param player
	 *            a player object
	 * @param score
	 *            a score object
	 * @return and integer
	 */
	private static int compareId(Player player, Score score) {
		return player.getId() - score.getPlayerId();
	}

	/**
	 * Unused method.
	 * 
	 * @param player
	 *            a player object
	 * @param score
	 *            a score object
	 */
	@SuppressWarnings("unused")
	private static void assign(Player player, Score score) {

	}

	/**
	 * Scans through a list of players and scores to consolidate win and loss totals to determine games played.
	 * 
	 * @param playerList
	 *            a list of players
	 * @param scoreList
	 *            a list of scores
	 */
	public static void assignField(List<Player> playerList, List<Score> scoreList) {
		for (int i = 0; i < playerList.size(); i++) {
			int gamesPlayed = 0;
			int gamesWon = 0;
			for (int j = 0; j < scoreList.size(); j++) {
				if (compareId(playerList.get(i), scoreList.get(j)) == 0) {
					gamesPlayed += scoreList.get(j).getWinTotal() + scoreList.get(j).getLostTotal();
					gamesWon += scoreList.get(j).getWinTotal();
				}
			}
			playerList.get(i).setGamesPlayed(gamesPlayed);
			playerList.get(i).setGamesWon(gamesWon);
		}
	}

}
