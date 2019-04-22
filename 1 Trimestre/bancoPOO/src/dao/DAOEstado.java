package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import conexao.ConnectionFactory;
import entidade.Estado;

public class DAOEstado {
	public boolean inserir(Estado estado) throws SQLException{
		Connection con = ConnectionFactory.getConnection();
		try {
			Statement st = con.createStatement();
			st.executeUpdate ("INSERT INTO estado (nome, sigla) "
					+ "VALUES('"+estado.getNome()+"', '"+estado.getSigla()+"') ");
			return true;
		}catch (SQLException e) {
			return false;
		}
	}
	public void alterar(Estado estado) throws SQLException {
		Connection con = ConnectionFactory.getConnection();
		Statement st = con.createStatement();
		try {
			st.executeLargeUpdate("UPDATE estado SET NOME='"+estado.getNome()+"',SIGLA='"+estado.getSigla()+"' WHERE ID = "+estado.getId()+"");
		}catch(Exception e) {
			e.printStackTrace();

		}	
	}
	public ResultSet consultar() throws SQLException {
		Connection con = ConnectionFactory.getConnection();
		Statement st = con.createStatement();
		try {
			ResultSet rs = st.executeQuery("SELECT * FROM estado;");
			return rs;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public void excluir(Estado estado) throws SQLException {
		Connection con = ConnectionFactory.getConnection();
		Statement st = con.createStatement();
		try {
			st.executeUpdate("DELETE FROM estado WHERE ID ="+estado.getId()+"");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
