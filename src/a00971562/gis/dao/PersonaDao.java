/**
 * Project: A00971562GisA2
 * File: PersonaDao.java
 * Date: Jul 18, 2016
 * Time: 2:28:38 PM
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
import a00971562.gis.data.Persona;

/**
 * @author Rei Ruiz, A00971562
 *
 */
public class PersonaDao extends Dao {

	private static final Logger LOG = LogManager.getLogger(PersonaDao.class);
	public static final String TABLE_NAME = "Personas";

	public PersonaDao(Database database) {
		super(database, TABLE_NAME);
	}

	@Override
	public void create() throws SQLException, ClassNotFoundException {
		LOG.info("Database " + TABLE_NAME + " created");
		super.create(String.format(
				"CREATE TABLE %s(%s INTEGER, %s INTEGER, %s VARCHAR(40), %s VARCHAR(2), %s VARCHAR(20), %s VARCHAR(20), %s VARCHAR(40), %s VARCHAR(40), PRIMARY KEY (%s))",
				TABLE_NAME, "id", "playerId", "gamerTag", "platform", "firstName", "lastName", "emailAddress", "birthDate", "id"));
	}

	public static void add(Persona persona) throws SQLException, ClassNotFoundException {
		Statement statement = null;
		try {
			Connection connection = Database.getConnection();
			statement = connection.createStatement();
			String sqlString = String.format("INSERT INTO %s VALUES(%d, %d, '%s', '%s', '%s', '%s', '%s', '%s')", TABLE_NAME, persona.getId(), persona.getPlayerId(),
					persona.getGamerTag(), persona.getPlatform(), persona.getFirstName(), persona.getLastName(), persona.getEmailAddress(), persona.getBirthDate());
			LOG.info(sqlString);
			statement.executeUpdate(sqlString);
		} finally {
			close(statement);
		}
	}

	public static void update(Persona persona) throws SQLException, ClassNotFoundException {
		Connection connection;
		Statement statement = null;
		try {
			connection = Database.getConnection();
			statement = connection.createStatement();
			String sqlString = String.format("UPDATE %s SET %s=%d, %s='%s', %s='%s', %s='%s', %s='%s', %s='%s', %s='%s' WHERE %s=%d", TABLE_NAME, "playerId", persona.getPlayerId(),
					"gamerTag", persona.getGamerTag(), "platform", persona.getPlatform(), "firstName", persona.getFirstName(), "lastName", persona.getLastName(), "emailAddress",
					persona.getEmailAddress(), "birthDate", persona.getBirthDate(), "id", persona.getId());
			LOG.info("Query: " + sqlString);
			statement.executeUpdate(sqlString);
		} finally {
			close(statement);
		}
	}

	public static void delete(Persona persona) throws SQLException, ClassNotFoundException {
		Connection connection;
		Statement statement = null;
		try {
			connection = Database.getConnection();
			statement = connection.createStatement();
			String sqlString = String.format("DELETE FROM %s WHERE %s='%s'", TABLE_NAME, "id", persona.getId());
			LOG.info("Query: " + sqlString);
			statement.executeUpdate(sqlString);
		} finally {
			close(statement);
		}
	}

	/**
	 * Retrieves the gamer tags from the 'Personas' table.
	 * 
	 * @return a list of Strings containing gamer tags
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public static List<String> getGamertags() throws SQLException, ClassNotFoundException {
		List<String> gamerTags = new ArrayList<String>();
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
				gamerTags.add(resultSet.getString("gamerTag"));
			}
		} finally {
			close(statement);
		}
		return gamerTags;
	}

	/**
	 * Retreives the personas from the 'Personas' table.
	 * 
	 * @param gamerTag
	 *            a gamer tag to match with a persona
	 * @return a persona
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public static Persona getPersonas(String gamerTag) throws SQLException, ClassNotFoundException {
		Persona persona = new Persona();
		Connection connection;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			connection = Database.getConnection();
			statement = connection.createStatement();
			String sqlString = String.format("SELECT * FROM %s WHERE %s = '%s'", TABLE_NAME, "gamerTag", gamerTag);
			LOG.info("Query: " + sqlString);
			resultSet = statement.executeQuery(sqlString);
			while (resultSet.next()) {
				persona.setId(resultSet.getInt("id"));
				persona.setFirstName(resultSet.getString("firstName"));
				persona.setLastName(resultSet.getString("lastName"));
				persona.setEmailAddress(resultSet.getString("emailAddress"));
				persona.setGamerTag(resultSet.getString("gamerTag"));
				persona.setBirthDate(resultSet.getString("birthDate"));
				persona.setPlatform(resultSet.getString("platform"));
			}
		} finally {
			close(statement);
		}
		return persona;
	}

}
