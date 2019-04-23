package principal;

import dao.daoEstado;
import entidade.Estado;
import fabrica.Fabrica;

public class Principal {
	public static void main (String args[]) {
		// responsável pelo mapeamento OR pesado, recomendado criar somente um
		Fabrica fabrica = new Fabrica();
		
		//EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("aulaPU");
		// gerenciador... criar um para cada dao representa a conexão e tem o metódos CRUD
		daoEstado dao = new daoEstado();
		
		Estado estado = new Estado();
		estado.setNome("SÃO PAULO");
		estado.setSigla("SP");
		
		//gerenciador.remove apaga, gerenciador.find busca, gerenciador.merge
		
	}
}
