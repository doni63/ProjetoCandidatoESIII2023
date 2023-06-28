package dao;

import java.sql.Connection;
import java.sql.SQLException;

public class TesteConexao {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Connection con = Conexao.getConnectionMySQL();
		System.out.println("Yesssss!!!");
		con.close();
	}

}
