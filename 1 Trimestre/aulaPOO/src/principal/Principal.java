package principal;

import dao.daoEstado;
import entidade.Estado;
import fabrica.Fabrica;

public class Principal {
	public static void main (String args[]) {
		// respons�vel pelo mapeamento OR pesado, recomendado criar somente um
		Fabrica fabrica = new Fabrica();
		
		//EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("aulaPU");
		// gerenciador... criar um para cada dao representa a conex�o e tem o met�dos CRUD
		daoEstado dao = new daoEstado();
		
		Estado estado = new Estado();
		estado.setNome("S�O PAULO");
		estado.setSigla("SP");
		
		//gerenciador.remove apaga, gerenciador.find busca, gerenciador.merge
		
	}
}
