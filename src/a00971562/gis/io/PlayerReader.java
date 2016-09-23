/**
 * Project: A00971562Gis
 * File: PlayerReader.java
 * Date: Jun 17, 2016
 * Time: 8:54:31 PM
 */
package a00971562.gis.io;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import a00971562.gis.ApplicationException;
import a00971562.gis.data.Player;
import a00971562.gis.util.Validator;

/**
 * @author Rei Ruiz, A00971562
 *
 */
public class PlayerReader {

	/**
	 * Private constructor to prevent instantiation.
	 */
	private PlayerReader() {

	}

	/**
	 * Read the player input data.
	 * 
	 * @param playerData
	 *            the input data
	 * @return a list of players
	 * @throws ApplicationException
	 * @throws IOException
	 */
	public static List<Player> read(File playerData) throws ApplicationException, IOException {
		Scanner scan = new Scanner(playerData);
		List<Player> players = new ArrayList<Player>();
		try {
			if (scan.hasNext())
				scan.nextLine();
			while (scan.hasNext()) {
				String row = scan.nextLine();
				List<String> elements = Arrays.asList(row.split("\\|"));
				if (elements.size() != 5)
					throw new ApplicationException("Missing element. Expected 5 elements from 'players.dat' but got " + elements.size());
				Player player = new Player();
				int index = 0;
				player.setId(Integer.parseInt(elements.get(index++)));
				player.setFirstName(elements.get(index++));
				player.setLastName(elements.get(index++));
				String email = elements.get(index++);
				player.setEmailAddress(email);
				if (!Validator.validateEmail(email))
					throw new ApplicationException("'" + email + "' is an invalid email address.");
				String birthDate = elements.get(index++);
				player.setBirthDate(birthDate);
				players.add(player);
			}
		} finally {
			scan.close();
		}
		return players;
	}
}
