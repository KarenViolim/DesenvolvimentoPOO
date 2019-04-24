package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import entidade.Estado;
import fabrica.Fabrica;

public class daoEstado {
	private EntityManager gerenciador;
	private EntityTransaction transacao;
		
	public Estado inserir(Estado estado) {
		try {
			EntityManagerFactory fabrica = Fabrica.get();
			gerenciador = fabrica.createEntityManager();
			transacao = gerenciador.getTransaction();
			
			transacao.begin();
			gerenciador.persist(estado);
			transacao.commit();
		}catch (Exception e){
			e.printStackTrace();
			transacao.rollback();
		}return estado;
	}
	
	public Estado consultar(long id) {
		Estado estado = null;
		try {
			EntityManagerFactory fabrica = Fabrica.get();
			gerenciador = fabrica.createEntityManager();
			transacao = gerenciador.getTransaction();
			
			transacao.begin();
			estado = gerenciador.find(Estado.class, id);
			transacao.commit();
		}catch(Exception e) {
			e.printStackTrace();
			transacao.rollback();
		}return estado;
	}
	
	public List<Estado> buscar(){
		EntityManagerFactory fabrica = Fabrica.get();
		gerenciador = fabrica.createEntityManager();
		
		return gerenciador.createQuery("from Estado").getResultList();
	}
	
	public Estado alterar(long id) {
		Estado estado = null;
		try {
			EntityManagerFactory fabrica = Fabrica.get();
			gerenciador = fabrica.createEntityManager();
			transacao = gerenciador.getTransaction();
			
			transacao.begin();
			estado = gerenciador.find(Estado.class, id);
			gerenciador.merge(estado);
			transacao.commit();
		}catch(Exception e){
			e.printStackTrace();
			transacao.rollback();
		}return estado;
	}
	
	public Estado excluir(long id) {
		Estado estado = null;
		try {
			EntityManagerFactory fabrica = Fabrica.get();
			gerenciador = fabrica.createEntityManager();
			transacao = gerenciador.getTransaction();
			
			transacao.begin();
			estado = gerenciador.find(Estado.class, id);
			gerenciador.remove(estado);
			transacao.commit();
		}catch(Exception e){
			e.printStackTrace();
			transacao.rollback();
		}return estado;
	}
}
