/**
 * Project: A00971562Gis
 * File: GameReader.java
 * Date: Jun 17, 2016
 * Time: 8:54:50 PM
 */
package a00971562.gis.io;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import a00971562.gis.ApplicationException;
import a00971562.gis.data.Game;

/**
 * @author Rei Ruiz, A00971562
 *
 */
public class GameReader {

	/**
	 * Private constructor to prevent instantiation.
	 */
	private GameReader() {

	}

	/**
	 * Reads the game's input data.
	 * 
	 * @param gameData
	 *            the input data
	 * @return a list of games
	 * @throws ApplicationException
	 * @throws IOException
	 */
	public static List<Game> read(File gameData) throws ApplicationException, IOException {
		Scanner scan = new Scanner(gameData);
		List<Game> games = new ArrayList<Game>();
		try {
			if (scan.hasNext())
				scan.nextLine();
			while (scan.hasNext()) {
				String row = scan.nextLine();
				List<String> elements = Arrays.asList(row.split("\\|"));
				if (elements.size() != 3)
					throw new ApplicationException("Missing element. Expected 3 elements from 'games.dat' but got " + elements.size());
				Game game = new Game();
				int index = 0;
				game.setId(elements.get(index++));
				game.setName(elements.get(index++));
				game.setProducer(elements.get(index++));
				games.add(game);
			}
		} finally {
			scan.close();
		}
		return games;
	}
}
