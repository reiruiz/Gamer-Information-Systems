/**
 * Project: A00971562Gis
 * File: CompareGameWithScore.java
 * Date: Jun 18, 2016
 * Time: 12:05:01 AM
 */
package a00971562.gis.util;

import java.util.List;

import a00971562.gis.data.Game;
import a00971562.gis.data.Score;

/**
 * @author Rei Ruiz, A00971562
 *
 */
public class CompareGameWithScore {

	/**
	 * Private constructor to prevent instantiation.
	 */
	private CompareGameWithScore() {

	}

	/**
	 * Compares a game's id with the score's game id.
	 * 
	 * @param game
	 *            a game object
	 * @param score
	 *            a score object
	 * @return an integer
	 */
	private static int compareId(Game game, Score score) {
		return game.getId().compareTo(score.getGameId());
	}

	/**
	 * Assigns the fields of a game to a score.
	 * 
	 * @param game
	 *            a game object
	 * @param score
	 *            a score object
	 */
	private static void assign(Game game, Score score) {
		score.setId(game.getId());
		score.setName(game.getName());
		score.setProducer(game.getProducer());
	}

	/**
	 * Scans through a list of games and scores to identify identical games and scores.
	 * 
	 * @param gameList
	 *            a list of games
	 * @param scoreList
	 *            a list of scores
	 */
	public static void assignField(List<Game> gameList, List<Score> scoreList) {
		for (int i = 0; i < gameList.size(); i++) {
			for (int j = 0; j < scoreList.size(); j++) {
				if (compareId(gameList.get(i), scoreList.get(j)) == 0)
					assign(gameList.get(i), scoreList.get(j));
			}
		}
	}
}
