/**
 * Project: A00971562Gis
 * File: Gis.java
 * Date: Jul 18, 2016
 * Time: 1:48:06 PM
 */
package a00971562.gis;

import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.time.Duration;
import java.time.Instant;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import a00971562.gis.ApplicationException;
import a00971562.gis.dao.GameDao;
import a00971562.gis.dao.PersonaDao;
import a00971562.gis.dao.PlayerDao;
import a00971562.gis.dao.ScoreDao;
import a00971562.gis.data.Database;
import a00971562.gis.data.Game;
import a00971562.gis.data.Persona;
import a00971562.gis.data.Player;
import a00971562.gis.data.Score;
import a00971562.gis.ui.ErrorDialog;
import a00971562.gis.ui.MainFrame;
import a00971562.gis.util.CompareScoreByPersonaId;
import a00971562.gis.util.UpdateList;
import a00971562.gis.io.GameReader;
import a00971562.gis.io.PersonaReader;
import a00971562.gis.io.PlayerReader;
import a00971562.gis.io.ScoreReader;

/**
 * @author Rei Ruiz, A00971562
 *
 */
public class Gis {

	public static String dialogException;
	private File playerData;
	private File personaData;
	private File gameData;
	private File scoreData;
	public static List<Player> players;
	public static List<Persona> personas;
	public static List<Game> games;
	public static List<Score> scores;
	private Properties properties;
	private Database database;
	private PlayerDao playerDao;
	private PersonaDao personaDao;
	private GameDao gameDao;
	private ScoreDao scoreDao;
	private static final Logger LOG = LogManager.getLogger(Gis.class);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		System.out.println("starting...");
		Instant start = Instant.now();
		LOG.info(start);
		File playersData = new File("players.dat");
		LOG.info("Reading from " + playersData.getAbsolutePath());
		File personasData = new File("personas.dat");
		LOG.info("Reading from " + personasData.getAbsolutePath());
		File gamesData = new File("games.dat");
		LOG.info("Reading from " + gamesData.getAbsolutePath());
		File scoresData = new File("scores.dat");
		LOG.info("Reading from " + scoresData.getAbsolutePath());
		try {
			new Gis(playersData, personasData, gamesData, scoresData).run();
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						MainFrame frame = new MainFrame();
						frame.setVisible(true);
					} catch (Exception exception) {
						throw exception;
					}
				}
			});
		} catch (Exception exception) {
			LOG.error(exception);
			dialogException = ErrorDialog.getStackTrace(exception);
			ErrorDialog.produceErrorDialog();
		} finally {
			Instant end = Instant.now();
			LOG.info(end);
			Duration timeElapsed = Duration.between(start, end);
			LOG.info("Duration: " + timeElapsed.toMillis() + " ms\n");
			try {
				Database.shutdown();
			} catch (SQLException exception) {
				LOG.error(exception);
				dialogException = ErrorDialog.getStackTrace(exception);
				ErrorDialog.produceErrorDialog();
			}
		}
	}

	/**
	 * Gis constructor.
	 * 
	 * @param playerData
	 *            player input data
	 * @param personaData
	 *            persona input data
	 * @param gameData
	 *            game input data
	 * @param scoreData
	 *            score input data
	 */
	public Gis(File playerData, File personaData, File gameData, File scoreData) {
		this.playerData = playerData;
		this.personaData = personaData;
		this.gameData = gameData;
		this.scoreData = scoreData;
	}

	/**
	 * Populates the list of players, personas, games, and scores.
	 * 
	 * @throws ApplicationException
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	private void run() throws ApplicationException, IOException, SQLException, ClassNotFoundException {
		players = PlayerReader.read(playerData);
		personas = PersonaReader.read(personaData);
		games = GameReader.read(gameData);
		scores = ScoreReader.read(scoreData);
		UpdateList.updateScoreList(players, personas, games, scores);
		UpdateList.updatePlayerList(players, scores);
		Collections.sort(scores, new CompareScoreByPersonaId());
		load();
	}

	/**
	 * Loads the configuration files and creates the table.
	 * 
	 * @throws ApplicationException
	 * @throws IOException
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	private void load() throws ApplicationException, IOException, SQLException, ClassNotFoundException {
		properties = new Properties();
		properties.load(new BufferedReader(new FileReader("db.properties")));
		database = new Database(properties);
		playerDao = new PlayerDao(database);
		personaDao = new PersonaDao(database);
		gameDao = new GameDao(database);
		scoreDao = new ScoreDao(database);
		if (!Database.tableExists(PlayerDao.TABLE_NAME)) {
			playerDao.create();
			for (Player player : players)
				PlayerDao.add(player);
		}
		if (!Database.tableExists(PersonaDao.TABLE_NAME)) {
			personaDao.create();
			for (Persona persona : personas)
				PersonaDao.add(persona);
		}
		if (!Database.tableExists(GameDao.TABLE_NAME)) {
			gameDao.create();
			for (Game game : games)
				GameDao.add(game);
		}
		if (!Database.tableExists(ScoreDao.TABLE_NAME)) {
			scoreDao.create();
			for (Score score : scores)
				ScoreDao.add(score);
		}
	}

}
