/**
 * Project: A00971562GisA2
 * File: CompareScoreByPersonaId.java
 * Date: Jul 18, 2016
 * Time: 11:26:23 PM
 */
package a00971562.gis.util;

import java.util.Comparator;

import a00971562.gis.data.Score;

/**
 * @author Rei Ruiz, A00971562
 *
 */
public class CompareScoreByPersonaId implements Comparator<Score> {

	/**
	 * Compares two score's persona ids and sorts them.
	 */
	@Override
	public int compare(Score score1, Score score2) {
		return score1.getPersonaId() - score2.getPersonaId();
	}

}
