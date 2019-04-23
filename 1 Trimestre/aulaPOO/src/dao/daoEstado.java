package dao;

import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import entidade.Estado;
import fabrica.Fabrica;

public class daoEstado {
	public boolean inserir(Estado estado) {
		Fabrica fabrica = new Fabrica();
		try {
			EntityManager gerenciador = fabrica.createEntityManagerFactory();
			EntityTransaction transacao = gerenciador.getTransaction();
			
			transacao.begin();
			gerenciador.persist(estado);
			transacao.commit();
			return true;
		}catch (SQLException e){
			return false;
		}
	}
}
