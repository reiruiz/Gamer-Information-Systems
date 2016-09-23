/**
 * Project: A00971562GisA2
 * File: ScoreDao.java
 * Date: Jul 18, 2016
 * Time: 2:28:58 PM
 */
package a00971562.gis.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import a00971562.gis.data.Database;
import a00971562.gis.data.Score;
import a00971562.gis.util.GenerateGameTotals;

/**
 * @author Rei Ruiz, A00971562
 *
 */
public class ScoreDao extends Dao {

	private static final Logger LOG = LogManager.getLogger(ScoreDao.class);
	public static final String TABLE_NAME = "Scores";

	public ScoreDao(Database database) {
		super(database, TABLE_NAME);
	}

	@Override
	public void create() throws SQLException, ClassNotFoundException {
		LOG.info("Database " + TABLE_NAME + " created");
		super.create(String.format(
				"CREATE TABLE %s(%s INTEGER, %s VARCHAR(4), %s VARCHAR(4), %s INTEGER, %s INTEGER, %s VARCHAR(20), %s VARCHAR(20), %s VARCHAR(40), %s VARCHAR(40), %s INTEGER, %s VARCHAR(40), %s VARCHAR(4), %s VARCHAR(4), %s VARCHAR(40), %s VARCHAR(40))",
				TABLE_NAME, "personaId", "gameId", "win", "winTotal", "lostTotal", "firstName", "lastName", "emailAddress", "birthDate", "playerId", "gamerTag", "platform", "id",
				"name", "producer"));
	}

	public static void add(Score score) throws SQLException, ClassNotFoundException {
		Statement statement = null;
		try {
			Connection connection = Database.getConnection();
			statement = connection.createStatement();
			String sqlString = String.format("INSERT INTO %s VALUES(%d, '%s', '%s', %d, %d, '%s', '%s', '%s', '%s', %d, '%s', '%s', '%s', '%s', '%s')", TABLE_NAME,
					score.getPersonaId(), score.getGameId(), score.getWin(), score.getWinTotal(), score.getLostTotal(), score.getFirstName(), score.getLastName(),
					score.getEmailAddress(), score.getBirthDate(), score.getPlayerId(), score.getGamerTag(), score.getPlatform(), score.getId(), score.getName(),
					score.getProducer());
			LOG.info(sqlString);
			statement.executeUpdate(sqlString);
		} finally {
			close(statement);
		}
	}

	public static void update(Score score) throws SQLException, ClassNotFoundException {
		Connection connection;
		Statement statement = null;
		try {
			connection = Database.getConnection();
			statement = connection.createStatement();
			String sqlString = String.format(
					"UPDATE %s SET %d=%d, %s='%s', %s='%s', %d=%d, %d=%d, %s='%s', %s='%s', %s='%s', %s='%s', %d='%d', %s='%s', %s='%s', %s='%s', %s='%s', %s='%s', WHERE %s=%d",
					TABLE_NAME, "personaId", score.getPersonaId(), "gameId", score.getGameId(), "win", score.getWin(), "winTotal", score.getWinTotal(), "lostTotal",
					score.getLostTotal(), "firstName", score.getFirstName(), "lastName", score.getLastName(), "emailAddress", score.getEmailAddress(), "birthDate",
					score.getBirthDate(), "playerId", score.getPlayerId(), "gamerTag", score.getGamerTag(), "platform", score.getPlatform(), "id", score.getId(), "name",
					score.getName(), "producer", score.getProducer(), "personaId", score.getPersonaId());
			LOG.info("Query: " + sqlString);
			statement.executeUpdate(sqlString);
		} finally {
			close(statement);
		}
	}

	public static void delete(Score score) throws SQLException, ClassNotFoundException {
		Connection connection;
		Statement statement = null;
		try {
			connection = Database.getConnection();
			statement = connection.createStatement();
			String sqlString = String.format("DELETE FROM %s WHERE %s='%d'", TABLE_NAME, "personaId", score.getPersonaId());
			LOG.info("Query: " + sqlString);
			statement.executeUpdate(sqlString);
		} finally {
			close(statement);
		}
	}

	/**
	 * Retrieves all the data from the 'Scores' table.
	 * 
	 * @return a list of scores
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public static List<Score> getScoresData() throws SQLException, ClassNotFoundException {
		List<Score> scoresData = new ArrayList<Score>();
		Connection connection;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			connection = Database.getConnection();
			statement = connection.createStatement();
			String sqlString = String.format("SELECT * FROM %s", TABLE_NAME);
			LOG.info("Query: " + sqlString);
			resultSet = statement.executeQuery(sqlString);
			while (resultSet.next()) {
				Score score = new Score();
				score.setPersonaId(resultSet.getInt("personaId"));
				score.setGameId(resultSet.getString("gameId"));
				score.setWin(resultSet.getString("win"));
				score.setWinTotal(resultSet.getInt("winTotal"));
				score.setLostTotal(resultSet.getInt("lostTotal"));
				score.setFirstName(resultSet.getString("firstName"));
				score.setLastName(resultSet.getString("lastName"));
				score.setEmailAddress(resultSet.getString("emailAddress"));
				score.setBirthDate(resultSet.getString("birthDate"));
				score.setPlayerId(resultSet.getInt("playerId"));
				score.setGamerTag(resultSet.getString("gamerTag"));
				score.setPlatform(resultSet.getString("platform"));
				score.setId(resultSet.getString("id"));
				score.setName(resultSet.getString("name"));
				score.setProducer(resultSet.getString("producer"));
				scoresData.add(score);
			}
		} finally {
			close(statement);
		}
		GenerateGameTotals.consolidate(GenerateGameTotals.generate(scoresData));
		return scoresData;
	}

	/**
	 * Retrieves all the personas from the 'Scores' table.
	 * 
	 * @return a list of Strings containing personas
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public static List<String> getScoresPersonas() throws SQLException, ClassNotFoundException {
		List<String> scoresData = new ArrayList<String>();
		Connection connection;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			connection = Database.getConnection();
			statement = connection.createStatement();
			String sqlString = String.format("SELECT * FROM %s", TABLE_NAME);
			LOG.info("Query: " + sqlString);
			resultSet = statement.executeQuery(sqlString);
			while (resultSet.next()) {
				scoresData.add("(" + resultSet.getString("personaId") + ") " + resultSet.getString("gamerTag"));
			}
		} finally {
			close(statement);
		}
		return scoresData;
	}

	/**
	 * Retrieves all the games from the 'Scores' table.
	 * 
	 * @return a list of Strings containing game names
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public static List<String> getScoresGameNames() throws SQLException, ClassNotFoundException {
		List<String> scoresData = new ArrayList<String>();
		Connection connection;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			connection = Database.getConnection();
			statement = connection.createStatement();
			String sqlString = String.format("SELECT * FROM %s", TABLE_NAME);
			LOG.info("Query: " + sqlString);
			resultSet = statement.executeQuery(sqlString);
			while (resultSet.next()) {
				scoresData.add(resultSet.getString("name"));
			}
		} finally {
			close(statement);
		}
		return scoresData;
	}

	/**
	 * Retrieves the win/loss totals from the 'Scores' table.
	 * 
	 * @return a list of Strings containing the win/loss totals
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public static List<String> getScoresWinLose() throws SQLException, ClassNotFoundException {
		List<String> scoresData = new ArrayList<String>();
		Connection connection;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			connection = Database.getConnection();
			statement = connection.createStatement();
			String sqlString = String.format("SELECT * FROM %s", TABLE_NAME);
			LOG.info("Query: " + sqlString);
			resultSet = statement.executeQuery(sqlString);
			while (resultSet.next()) {
				scoresData.add(resultSet.getString("win"));
			}
		} finally {
			close(statement);
		}
		return scoresData;
	}

	/**
	 * Determines if a gamer tag exists in the database table 'Scores'.
	 * 
	 * @param gamerTag
	 *            the gamer tag to check
	 * @return a boolean
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public static boolean checkGamerTag(String gamerTag) throws SQLException, ClassNotFoundException {
		boolean exists;
		Connection connection;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			connection = Database.getConnection();
			statement = connection.createStatement();
			String sqlString = String.format("SELECT * FROM %s WHERE %s='%s'", TABLE_NAME, "gamerTag", gamerTag);
			LOG.info("Query: " + sqlString);
			resultSet = statement.executeQuery(sqlString);
			if (resultSet.next()) {
				exists = true;
			} else {
				exists = false;
			}
		} finally {
			close(statement);
		}

		return exists;
	}

}
