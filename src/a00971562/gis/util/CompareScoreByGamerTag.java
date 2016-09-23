/**
 * Project: A00971562Gis
 * File: CompareScoreByGamertag.java
 * Date: Jun 18, 2016
 * Time: 9:14:54 PM
 */
package a00971562.gis.util;

import java.util.Comparator;

import a00971562.gis.data.Score;

/**
 * @author Rei Ruiz, A00971562
 *
 */
public class CompareScoreByGamerTag implements Comparator<Score> {

	/**
	 * Compares two score's gamer tags and sorts them according to gamer tag and game name length.
	 */
	@Override
	public int compare(Score score1, Score score2) {
		int scoreComp = score1.getGamerTag().compareTo(score2.getGamerTag());
		if (scoreComp != 0)
			return scoreComp;
		else
			return score2.getName().length() - score1.getName().length();
	}

}
