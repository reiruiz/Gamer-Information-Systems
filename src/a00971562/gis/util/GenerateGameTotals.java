/**
 * Project: A00971562Gis
 * File: GenerateGameTotals.java
 * Date: Jun 18, 2016
 * Time: 10:07:38 PM
 */
package a00971562.gis.util;

import java.util.List;

import a00971562.gis.data.Game;
import a00971562.gis.data.Score;

/**
 * @author Rei Ruiz, A00971562
 *
 */
public class GenerateGameTotals {

	/**
	 * Private constructor to prevent instantiation.
	 */
	private GenerateGameTotals() {

	}

	/**
	 * Generates game totals by identifying identical games played by the same persona and adding their win/loss totals.
	 * 
	 * @param scores
	 *            the list of scores containing players, personas, games, and scores
	 * @return a list with the total game win/loss count for each unique persona and game
	 */
	public static List<Score> generate(List<Score> scores) {
		for (int i = 0; i < scores.size(); i++) {
			for (int j = i + 1; j < scores.size(); j++) {
				if (scores.get(i).getPersonaId() == scores.get(j).getPersonaId() && scores.get(i).getGameId().equalsIgnoreCase(scores.get(j).getGameId())) {
					if (scores.get(i).getWinTotal() != 0 && scores.get(j).getWinTotal() != 0) {
						scores.get(i).setWinTotal(scores.get(i).getWinTotal() + scores.get(j).getWinTotal());
						scores.get(j).setWinTotal(scores.get(i).getWinTotal());
					}
					if (scores.get(i).getLostTotal() != 0 && scores.get(j).getLostTotal() != 0) {
						scores.get(i).setLostTotal(scores.get(i).getLostTotal() + scores.get(j).getLostTotal());
						scores.get(j).setLostTotal(scores.get(i).getLostTotal());
					}
					if (scores.get(i).getWinTotal() == scores.get(j).getWinTotal() && scores.get(i).getLostTotal() == scores.get(j).getLostTotal()) {
						scores.remove(j);
					}
				}
			}
		}
		return scores;
	}

	/**
	 * Consolidates a list with game win/loss totals by combining wins and losses and removing identical games and personas.
	 * 
	 * @param scores
	 *            the list with game win/loss totals
	 * @return a list with consolidated win/loss totals and no duplicates
	 */
	public static List<Score> consolidate(List<Score> scores) {
		for (int i = 0; i < scores.size(); i++) {
			for (int j = i + 1; j < scores.size(); j++) {
				if (scores.get(i).getPersonaId() == scores.get(j).getPersonaId() && scores.get(i).getGameId().equalsIgnoreCase(scores.get(j).getGameId())) {
					if (scores.get(i).getWinTotal() != 0)
						scores.get(j).setWinTotal(scores.get(i).getWinTotal());
					if (scores.get(i).getLostTotal() != 0)
						scores.get(j).setLostTotal(scores.get(i).getLostTotal());
					if (scores.get(j).getWinTotal() != 0)
						scores.get(i).setWinTotal(scores.get(j).getWinTotal());
					if (scores.get(j).getLostTotal() != 0)
						scores.get(i).setLostTotal(scores.get(j).getLostTotal());
					scores.remove(j);
				}
			}
		}
		return scores;
	}

	/**
	 * Counts and sets the number of games played for that game.
	 * 
	 * @param gameList
	 *            a list of games
	 * @param scoreList
	 *            a list of scores
	 */
	public static void count(List<Game> gameList, List<Score> scoreList) {
		for (int i = 0; i < gameList.size(); i++) {
			int played = 0;
			for (int j = 0; j < scoreList.size(); j++) {
				if (gameList.get(i).getId().compareTo(scoreList.get(j).getGameId()) == 0) {
					played += scoreList.get(j).getWinTotal() + scoreList.get(j).getLostTotal();
				}
			}
			gameList.get(i).setPlayed(played);
		}
	}
}