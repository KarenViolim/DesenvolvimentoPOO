package principal;

import java.util.Scanner;

import javax.persistence.EntityManagerFactory;
import dao.daoEstado;
import entidade.Estado;
import fabrica.Fabrica;

public class Principal {
	public static void main (String args[]) {
		EntityManagerFactory fabrica = Fabrica.get();
		
		//EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("aulaPU");
		// gerenciador... criar um para cada dao representa a conexão e tem o metódos CRUD
		daoEstado dao = new daoEstado();
		Estado estado = new Estado();
		Scanner scann = new Scanner(System.in);
		
		int opcao = 0;
		do {
			System.out.println("Digite a opção desejada:");
			System.out.println("01 - Inserir");
			System.out.println("02 - Consultar");
			System.out.println("03 - Alterar ");
			System.out.println("04 - Excluir");
			System.out.println("05 - Sair");
			opcao = scann.nextInt();
			scann.nextLine();
			if (opcao == 1) {
				System.out.println("NOME: ");
				String nome = scann.nextLine();
				estado.setNome(nome);
				
				System.out.println("SIGLA: ");
				String sigla = scann.nextLine();
				estado.setSigla(sigla);
				
				dao.inserir(estado);
			} else if (opcao == 2) {
				System.out.println("Digite o id que deseja consultar: ");
				long id;
				dao.consultar(id);
			}
		}while(opcao != 6);
		//gerenciador.remove apaga, gerenciador.find busca, gerenciador.merge alterar.
		}
}
