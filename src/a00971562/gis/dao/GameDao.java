/**
 * Project: A00971562GisA2
 * File: GameDao.java
 * Date: Jul 18, 2016
 * Time: 2:28:50 PM
 */
package a00971562.gis.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import a00971562.gis.data.Database;
import a00971562.gis.data.Game;

/**
 * @author Rei Ruiz, A00971562
 *
 */
public class GameDao extends Dao {

	private static final Logger LOG = LogManager.getLogger(GameDao.class);
	public static final String TABLE_NAME = "Games";

	public GameDao(Database database) {
		super(database, TABLE_NAME);
	}

	@Override
	public void create() throws SQLException, ClassNotFoundException {
		LOG.info("Database " + TABLE_NAME + " created");
		super.create(String.format("CREATE TABLE %s(%s VARCHAR(4), %s VARCHAR(40), %s VARCHAR(40), %s INTEGER, PRIMARY KEY (%s))", TABLE_NAME, "id", "name", "producer", "played",
				"id"));
	}

	public static void add(Game game) throws SQLException, ClassNotFoundException {
		Statement statement = null;
		try {
			Connection connection = Database.getConnection();
			statement = connection.createStatement();
			String sqlString = String.format("INSERT INTO %s VALUES('%s', '%s', '%s', %d)", TABLE_NAME, game.getId(), game.getName(), game.getProducer(), game.getPlayed());
			LOG.info(sqlString);
			statement.executeUpdate(sqlString);
		} finally {
			close(statement);
		}
	}

	public static void update(Game game) throws SQLException, ClassNotFoundException {
		Connection connection;
		Statement statement = null;
		try {
			connection = Database.getConnection();
			statement = connection.createStatement();
			String sqlString = String.format("UPDATE %s SET %s='%s', %s='%s', %s='%s', %s=d, WHERE %s=%d", TABLE_NAME, "name", game.getName(), "producer", game.getProducer(),
					"played", game.getPlayed(), "id", game.getId());
			LOG.info("Query: " + sqlString);
			statement.executeUpdate(sqlString);
		} finally {
			close(statement);
		}
	}

	public static void delete(Game game) throws SQLException, ClassNotFoundException {
		Connection connection;
		Statement statement = null;
		try {
			connection = Database.getConnection();
			statement = connection.createStatement();
			String sqlString = String.format("DELETE FROM %s WHERE %s='%s'", TABLE_NAME, "id", game.getId());
			LOG.info("Query: " + sqlString);
			statement.executeUpdate(sqlString);
		} finally {
			close(statement);
		}
	}

}
