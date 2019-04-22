package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	private static Connection conexao;
	
	public static Connection getConnection() throws SQLException {
		if(conexao == null)
            conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/banco?useTimezone=true&serverTimezone=UTC", "root", "");
		return conexao;
    }
}
