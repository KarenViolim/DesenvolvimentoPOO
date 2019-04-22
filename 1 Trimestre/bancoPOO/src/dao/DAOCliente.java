package dao;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import conexao.ConnectionFactory;
import entidade.Cliente;

public class DAOCliente {
	
	public boolean inserir(Cliente cliente) throws SQLException{
		Connection con = ConnectionFactory.getConnection();
		try {
			Statement st = con.createStatement();
			st.executeUpdate ("INSERT INTO cliente (nome, cpf, estado, cidade, endereco) "
					+ "VALUES('"+cliente.getNome()+"', '"+cliente.getCpf()+"', '"+cliente.getEstado()+"', '"+cliente.getCidade()+"', '"+cliente.getEndereco()+"') ");

			return true;
		}catch (SQLException e) {
			return false;
		}
	}
	public void alterar(Cliente cliente) throws SQLException {
		Connection con = ConnectionFactory.getConnection();
		Statement st = con.createStatement();
		try {
			st.executeLargeUpdate("UPDATE CLIENTE SET NOME='"+cliente.getNome()+"',CPF='"+cliente.getCpf()+"',ESTADO='"+cliente.getEstado()+"',CIDADE='"+cliente.getCidade()+"', ENDERECO='"+cliente.getEndereco()+"' WHERE ID = "+cliente.getId()+"");
		}catch(Exception e) {
			e.printStackTrace();

		}	
	}
	public ResultSet consultar() throws SQLException {
		Connection con = ConnectionFactory.getConnection();
		Statement st = con.createStatement();
		try {
			ResultSet rs = st.executeQuery("Select * FROM CLIENTE;");
			return rs;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public void excluir(Cliente cliente) throws SQLException {
		Connection con = ConnectionFactory.getConnection();
		Statement st = con.createStatement();
		try {
			st.executeUpdate("DELETE FROM cliente WHERE ID ="+cliente.getId()+"");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}