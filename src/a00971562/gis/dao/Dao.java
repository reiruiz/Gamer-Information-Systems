/**
 * Project: A00971562Lab7
 * File: Dao.java
 * Date: Jun 25, 2016
 * Time: 2:36:43 PM
 */
package a00971562.gis.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import a00971562.gis.data.Database;

/**
 * @author Rei Ruiz, A00971562
 *
 */

public abstract class Dao {

	private static Logger LOG = LogManager.getLogger(Dao.class);
	protected final Database database;
	protected final String tableName;

	/**
	 * Constructor.
	 * 
	 * @param database
	 * @param tableName
	 */
	protected Dao(Database database, String tableName) {
		this.database = database;
		this.tableName = tableName;
	}

	/**
	 * Abstract method.
	 * 
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public abstract void create() throws SQLException, ClassNotFoundException;

	/**
	 * Create query.
	 * 
	 * @param createStatement
	 *            create statement
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	protected void create(String createStatement) throws SQLException, ClassNotFoundException {
		LOG.info("Query: " + createStatement);
		Statement statement = null;
		try {
			Connection connection = Database.getConnection();
			statement = connection.createStatement();
			statement.executeUpdate(createStatement);
		} finally {
			close(statement);
		}
	}

	/**
	 * Add query.
	 * 
	 * @param updateStatement
	 *            update statement
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	protected void add(String updateStatement) throws SQLException, ClassNotFoundException {
		LOG.info("Query: " + updateStatement);
		Statement statement = null;
		try {
			Connection connection = Database.getConnection();
			statement = connection.createStatement();
			statement.executeUpdate(updateStatement);
		} finally {
			close(statement);
		}
	}

	/**
	 * Drop query.
	 * 
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public void drop() throws SQLException, ClassNotFoundException {
		Statement statement = null;
		try {
			Connection connection = Database.getConnection();
			statement = connection.createStatement();
			if (Database.tableExists(tableName)) {
				statement.executeUpdate("DROP TABLE " + tableName);
			}
		} finally {
			close(statement);
		}
	}

	/**
	 * Closes the query.
	 * 
	 * @param statement
	 *            statement
	 */
	protected static void close(Statement statement) throws SQLException {
		if (statement != null) {
			statement.close();
		}
	}

	/**
	 * Shuts down the database.
	 * 
	 * @throws SQLException
	 */
	public void shutdown() throws SQLException {
		Database.shutdown();
	}

}
