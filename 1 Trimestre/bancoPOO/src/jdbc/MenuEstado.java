package jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import dao.DAOEstado;
import entidade.Estado;

public class MenuEstado {
	public void menuEstado() throws SQLException {
		Scanner scann = new Scanner(System.in);
		Estado estado = new Estado();
		DAOEstado dao = new DAOEstado();
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
				ResultSet rs = dao.consultar();
				String resultado = "";
				while (rs.next()) {
					resultado = resultado + rs.getInt("ID")+"- "+rs.getString("NOME")+" - "+rs.getString("SIGLA")+"\n";
				}
				System.out.print(resultado);
				
			} else if (opcao == 3) {
				System.out.println("Informe o ID do Estado a ser alterado: ");
				String id1 = scann.nextLine();
				int id = Integer.parseInt(id1);
				estado.setId(id);
				
				System.out.println("Novo nome: ");
				String nome = scann.nextLine();
				estado.setNome(nome);
				
				System.out.println("Nova sigla: ");
				String sigla = scann.nextLine();
				estado.setSigla(sigla);	
			
				dao.alterar(estado);
				
			} else if (opcao == 4) {
				System.out.print("Informe ID do Estado que deseja excluir: ");
				int id = scann.nextInt();
				estado.setId(id);
				dao.excluir(estado);
			}
		}while(opcao != 6);
			System.out.print("Opção Inválida");
	}
}
