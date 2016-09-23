/**
 * Project: examples8
 * File: Database.java
 * Date: 2012-10-28
 * Time: 12:26:04 PM
 */

package a00971562.gis.data;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author scirka
 * 
 */
public class Database {

	public static final String DB_DRIVER_KEY = "db.driver";
	public static final String DB_URL_KEY = "db.url";
	public static final String DB_USER_KEY = "db.user";
	public static final String DB_PASSWORD_KEY = "db.password";

	private static Logger LOG = LogManager.getLogger(Database.class);

	private static Connection connection;
	private static Properties properties;

	public Database(Properties properties) throws FileNotFoundException, IOException {
		LOG.debug("Loading database properties from db.properties");
		Database.properties = properties;
	}

	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		if (connection != null) {
			return connection;
		}
		connect();
		return connection;
	}

	private static void connect() throws ClassNotFoundException, SQLException {
		Class.forName(properties.getProperty(DB_DRIVER_KEY));
		LOG.info("Driver loaded");
		connection = DriverManager.getConnection(properties.getProperty(DB_URL_KEY), properties.getProperty(DB_USER_KEY), properties.getProperty(DB_PASSWORD_KEY));
		LOG.info("Database connected");
	}

	public static void shutdown() throws SQLException {
		if (connection != null) {
			connection.close();
			connection = null;
		}
	}

	public static boolean tableExists(String tableName) throws SQLException, ClassNotFoundException {
		DatabaseMetaData databaseMetaData = getConnection().getMetaData();
		ResultSet resultSet = null;
		String rsTableName = null;

		try {
			resultSet = databaseMetaData.getTables(connection.getCatalog(), "%", "%", null);
			while (resultSet.next()) {
				rsTableName = resultSet.getString("TABLE_NAME");
				if (rsTableName.equalsIgnoreCase(tableName)) {
					return true;
				}
			}
		} finally {
			resultSet.close();
		}

		return false;
	}

}
