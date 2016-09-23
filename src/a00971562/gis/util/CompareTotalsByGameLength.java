/**
 * Project: A00971562Gis
 * File: CompareTotalsByGameName.java
 * Date: Jun 19, 2016
 * Time: 3:16:30 PM
 */
package a00971562.gis.util;

import java.util.Comparator;

import a00971562.gis.data.Game;

/**
 * @author Rei Ruiz, A00971562
 *
 */
public class CompareTotalsByGameLength implements Comparator<Game> {

	/**
	 * Compares two score's game name length and sorts them accordingly.
	 */
	@Override
	public int compare(Game game1, Game game2) {
		return game2.getName().length() - game1.getName().length();
	}

}
