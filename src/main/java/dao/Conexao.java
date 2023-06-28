package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import dominio.EntidadeDominio;

public class Conexao{
	private static String user;
	private static String url;
	private static String driver;
	private static String password;
	
	private static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, user, password);
		return con;
	}
	
	public static Connection getConnectionMySQL() throws ClassNotFoundException, SQLException {
		driver = "com.mysql.cj.jdbc.Driver";
		url = "jdbc:mysql://localhost/testeesiii";
		user = "root";
		password = "Doni@3698";
		return getConnection();
	}
	
}
