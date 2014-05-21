package de.conet.techtalk.simplewebapp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.h2.jdbcx.JdbcConnectionPool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.conet.techtalk.simplewebapp.model.Stunden;
import de.conet.techtalk.simplewebapp.model.User;

public class DbConnector {
	private static final Logger LOG = LoggerFactory.getLogger(DbConnector.class);
	private static JdbcConnectionPool connectionPool;
	
	static {
		// Persist DB in home directory
		// connectionPool = JdbcConnectionPool.create("jdbc:h2:~/test", "test", "test");
		// In Memory DB
		connectionPool = JdbcConnectionPool.create("jdbc:h2:mem:test", "test", "test");
		
		try {
			initUser();
			initStunden();
			printDB();
		} catch (SQLException e) {
			LOG.error("Error initializing db: " + e.getMessage(),e);
		}
	}
	
	public static Connection getConnection() {
		try {
			Connection c = connectionPool.getConnection();
			c.setAutoCommit(true);
			return c;
		} catch (SQLException e) {
			LOG.error("Error getting connection: " + e.getMessage(),e);
		}
		return null;
	}
	
	public static void main(String[] args) {
		try (Connection c = DbConnector.getConnection()) {
			// Simple test query
			c.createStatement().executeQuery("select 1");
		} catch(SQLException e) {
			LOG.error("Error in test query: " + e.getMessage(),e);
		}
	}
	
	/**
	 * Create user table and init some data
	 * @throws SQLException
	 */
	private static void initUser() throws SQLException {
		Connection c = DbConnector.getConnection();
		c.createStatement().execute("CREATE TABLE IF NOT EXISTS user (id INT PRIMARY KEY, name VARCHAR(255) NOT NULL UNIQUE, passwort VARCHAR(255) NOT NULL)");
		c.createStatement().execute("INSERT INTO user (id,name,passwort) VALUES (1,'thomas','tpasswort')");
		c.createStatement().execute("INSERT INTO user (id,name,passwort) VALUES (2,'uli','upasswort')");
		c.createStatement().execute("INSERT INTO user (id,name,passwort) VALUES (3,'christian','cpasswort')");
		c.close();
	}
	
	private static void initStunden() throws SQLException {
		Connection c = DbConnector.getConnection();
		c.createStatement().execute("CREATE TABLE IF NOT EXISTS stunden (id INT PRIMARY KEY AUTO_INCREMENT, fk_user_id INT NOT NULL, anzahl INT NOT NULL, projekt VARCHAR(255), kommentar VARCHAR(1000), freigegeben BOOLEAN NOT NULL, FOREIGN KEY(fk_user_id) REFERENCES user(id))");
		c.createStatement().execute("INSERT INTO stunden (fk_user_id, anzahl, freigegeben, projekt, kommentar) VALUES (1,300,true,'Techtalk','Dies und das...')");
		c.createStatement().execute("INSERT INTO stunden (fk_user_id, anzahl, freigegeben, projekt, kommentar) VALUES (2,50,true,'Techtalk','Schalten und verwalten')");
		c.createStatement().execute("INSERT INTO stunden (fk_user_id, anzahl, freigegeben, projekt, kommentar) VALUES (3,1000,false,'Techtalk','Füße hochlegen')");
		c.close();
	}
	
	/**
	 * Print tables and content.
	 * @throws SQLException
	 */
	private static void printDB() throws SQLException {
		Connection c = DbConnector.getConnection();
		LOG.info("----- Table user: id,user,passwort -----");
		ResultSet rs = c.createStatement().executeQuery("select * from user");
		while(rs.next()) {
			LOG.info(mapUser(rs).toString());
		}
		
		LOG.info("----- Table stunden: id,fk_user_id,anzahl,freigegeben, projekt, kommentar -----");
		rs = c.createStatement().executeQuery("select * from stunden");
		while(rs.next()) {
			LOG.info(mapStunden(rs).toString());
		}
		c.close();
	}
	
	public static List<Stunden> getStunden() {
		List<Stunden> result = new ArrayList<Stunden>();
		
		try (Connection c = DbConnector.getConnection()) {
			Statement stm = c.createStatement();
			ResultSet rs = stm.executeQuery("select * from stunden");
			while(rs.next()) {
				result.add(mapStunden(rs));
			}
		} catch(SQLException e) {
			LOG.error(e.getMessage(),e);
		}
		return result;
	}
	
	public static Stunden mapStunden(ResultSet rs) throws SQLException {
		Stunden s = new Stunden();
		s.setId(rs.getInt(1));
		s.setUserid(rs.getInt(2));
		s.setAnzahl(rs.getInt(3));
		s.setProjekt(rs.getString(4));
		s.setKommentar(rs.getString(5));
		s.setFreigegeben(rs.getBoolean(6));
		return s;
	}
	
	public static User mapUser(ResultSet rs) throws SQLException {
		User u = new User();
		u.setId(rs.getInt(1));
		u.setName(rs.getString(2));
		u.setPasswort(rs.getString(3));
		return u;
	}
	
}
