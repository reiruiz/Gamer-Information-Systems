/**
 * Project: A00971562Gis
 * File: ScoreReader.java
 * Date: Jun 17, 2016
 * Time: 8:54:58 PM
 */
package a00971562.gis.io;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import a00971562.gis.ApplicationException;
import a00971562.gis.data.Score;

/**
 * @author Rei Ruiz, A00971562
 *
 */
public class ScoreReader {

	/**
	 * Private constructor to prevent instantiation.
	 */
	private ScoreReader() {

	}

	/**
	 * Reads the scores input data.
	 * 
	 * @param scoreData
	 *            the input data
	 * @return a list of scores
	 * @throws ApplicationException
	 * @throws IOException
	 */
	public static List<Score> read(File scoreData) throws ApplicationException, IOException {
		Scanner scan = new Scanner(scoreData);
		List<Score> scores = new ArrayList<Score>();
		try {
			if (scan.hasNext())
				scan.nextLine();
			while (scan.hasNext()) {
				String row = scan.nextLine();
				List<String> elements = Arrays.asList(row.split("\\|"));
				if (elements.size() != 3)
					throw new ApplicationException("Missing element. Expected 3 elements from 'scores.dat' but got " + elements.size());
				Score score = new Score();
				int index = 0;
				score.setPersonaId(Integer.parseInt(elements.get(index++)));
				score.setGameId(elements.get(index++));
				String win = elements.get(index++);
				score.setWin(win);
				int winTotal = 0;
				int lostTotal = 0;
				if (win.equalsIgnoreCase("win"))
					score.setWinTotal(++winTotal);
				else
					score.setLostTotal(++lostTotal);
				scores.add(score);
			}
		} finally {
			scan.close();
		}
		return scores;
	}
}
