/**
 * Project: A00971562GisA2
 * File: PlayerDao.java
 * Date: Jul 18, 2016
 * Time: 2:28:26 PM
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

import a00971562.gis.dao.PlayerDao;
import a00971562.gis.data.Database;
import a00971562.gis.data.Player;

/**
 * @author Rei Ruiz, A00971562
 *
 */
public class PlayerDao extends Dao {

	private static final Logger LOG = LogManager.getLogger(PlayerDao.class);
	public static final String TABLE_NAME = "Players";

	public PlayerDao(Database database) {
		super(database, TABLE_NAME);
	}

	@Override
	public void create() throws SQLException, ClassNotFoundException {
		LOG.info("Database " + TABLE_NAME + " created");
		super.create(String.format("CREATE TABLE %s(%s INTEGER, %s VARCHAR(20), %s VARCHAR(20), %s VARCHAR(40), %s VARCHAR(40), %s INTEGER, %s INTEGER, PRIMARY KEY (%s))",
				TABLE_NAME, "id", "firstName", "lastName", "emailAddress", "birthDate", "gamesPlayed", "gamesWon", "id"));
	}

	public static void add(Player player) throws SQLException, ClassNotFoundException {
		Statement statement = null;
		try {
			Connection connection = Database.getConnection();
			statement = connection.createStatement();
			String sqlString = String.format("INSERT INTO %s VALUES(%d, '%s', '%s', '%s', '%s', %d, %d)", TABLE_NAME, player.getId(), player.getFirstName(), player.getLastName(),
					player.getEmailAddress(), player.getBirthDate(), player.getGamesPlayed(), player.getGamesWon());
			LOG.info(sqlString);
			statement.executeUpdate(sqlString);
		} finally {
			close(statement);
		}
	}

	public static void update(Player player) throws SQLException, ClassNotFoundException {
		Connection connection;
		Statement statement = null;
		try {
			connection = Database.getConnection();
			statement = connection.createStatement();
			String sqlString = String.format("UPDATE %s SET %s='%s', %s='%s', %s='%s', %s='s', %s=%d, %s=%d, WHERE %s=%d", TABLE_NAME, "firstName", player.getFirstName(),
					"lastName", player.getLastName(), "emailAddress", player.getEmailAddress(), "birthDate", player.getBirthDate(), "gamesPlayed", player.getGamesPlayed(),
					"gamesWon", player.getGamesWon(), "id", player.getId());
			LOG.info("Query: " + sqlString);
			statement.executeUpdate(sqlString);
		} finally {
			close(statement);
		}
	}

	public static void delete(Player player) throws SQLException, ClassNotFoundException {
		Connection connection;
		Statement statement = null;
		try {
			connection = Database.getConnection();
			statement = connection.createStatement();
			String sqlString = String.format("DELETE FROM %s WHERE %s='%s'", TABLE_NAME, "id", player.getId());
			LOG.info("Query: " + sqlString);
			statement.executeUpdate(sqlString);
		} finally {
			close(statement);
		}
	}

	/**
	 * Retrieves the full names from the 'Players' table.
	 * 
	 * @return a list of Strings containing full names
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public static List<String> getFullNames() throws SQLException, ClassNotFoundException {
		List<String> fullNames = new ArrayList<String>();
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
				fullNames.add(resultSet.getString("firstName") + " " + resultSet.getString("lastName"));
			}
		} finally {
			close(statement);
		}
		return fullNames;
	}

}
