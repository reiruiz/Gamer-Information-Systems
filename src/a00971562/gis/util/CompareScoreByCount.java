/**
 * Project: A00971562Gis
 * File: CompareScoreByCount.java
 * Date: Jun 19, 2016
 * Time: 5:36:36 PM
 */
package a00971562.gis.util;

import java.util.Comparator;

import a00971562.gis.data.Score;

/**
 * @author Rei Ruiz, A00971562
 *
 */
public class CompareScoreByCount implements Comparator<Score> {

	/**
	 * Compares two score's game totals and sorts them according to game total and win total.
	 */
	@Override
	public int compare(Score score1, Score score2) {
		int scoreComp = (score1.getWinTotal() + score1.getLostTotal()) - (score2.getWinTotal() + score2.getLostTotal());
		if (scoreComp != 0)
			return scoreComp;
		else
			return score1.getWinTotal() - score2.getWinTotal();
	}

}
