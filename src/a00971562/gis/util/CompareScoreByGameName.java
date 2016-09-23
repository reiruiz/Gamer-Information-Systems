/**
 * Project: A00971562Gis
 * File: SortByArgument.java
 * Date: Jun 19, 2016
 * Time: 5:04:51 PM
 */
package a00971562.gis.util;

import java.util.Comparator;

import a00971562.gis.data.Score;

/**
 * @author Rei Ruiz, A00971562
 *
 */
public class CompareScoreByGameName implements Comparator<Score> {

	/**
	 * Compares two score's game name and sorts them according to game name and gamer tag.
	 */
	@Override
	public int compare(Score score1, Score score2) {
		int nameComp = score1.getName().compareTo(score2.getName());
		if (nameComp != 0)
			return nameComp;
		else
			return score1.getGamerTag().compareTo(score2.getGamerTag());
	}

}
