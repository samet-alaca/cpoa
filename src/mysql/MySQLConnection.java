package mysql;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class MySQLConnection {
	
	private static Connection connection;
	
	public static Connection getInstance() {
		if(connection == null) {
			Properties database = new Properties();
			File config = new File("config/database.dtd");
			try {
				FileInputStream source = new FileInputStream(config);
				database.loadFromXML(source);
				connection = DriverManager.getConnection(
					"jdbc:mysql://" +
					database.getProperty("host") + 
					":" +
					database.getProperty("port") +
					"/" +
					database.getProperty("database"),
					database.getProperty("username"),
					database.getProperty("password")
				);
			} catch(Exception error) {
				error.printStackTrace();
			}
		}
		return connection;
	}
	
}
