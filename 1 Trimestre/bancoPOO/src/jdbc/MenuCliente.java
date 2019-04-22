package jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Statement;
import java.util.Scanner;

import dao.DAOCliente;
import entidade.Cliente;

public class MenuCliente {
	public void menuCliente() throws SQLException {
		Scanner scann = new Scanner(System.in);
		Cliente cliente = new Cliente();
		DAOCliente dao = new DAOCliente();
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
				System.out.println("Nome: ");
				String nome = scann.nextLine();
				cliente.setNome(nome);
				
				System.out.println("CPF: ");
				String cpf = scann.nextLine();
				cliente.setCpf(cpf);
				
				System.out.println("Estado: ");
				String estado = scann.nextLine();
				cliente.setEstado(estado);
				
				System.out.println("Cidade: ");
				String cidade = scann.nextLine();
				cliente.setCidade(cidade);
				
				System.out.println("Endereço: ");
				String endereco = scann.nextLine();
				cliente.setEndereco(endereco);
				
				dao.inserir(cliente);
				
			} else if (opcao == 2) {
				ResultSet rs = dao.consultar();
				String resultado = "";
				while (rs.next()) {
					resultado = resultado + rs.getInt("ID")+"- "+rs.getString("NOME")+"\n";
				}
				System.out.print(resultado);
				
			} else if (opcao == 3) {
				System.out.println("Informe o ID do Cliente a ser alterado: ");
				String id1 = scann.nextLine();
				int id = Integer.parseInt(id1);
				cliente.setId(id);
				
				System.out.println("Novo nome: ");
				String nome = scann.nextLine();
				cliente.setNome(nome);
				
				System.out.println("Confirme o CPF: ");
				String cpf = scann.nextLine();
				cliente.setCpf(cpf);	
				
				System.out.println("Novo estado: ");
				String estado = scann.nextLine();
				cliente.setEstado(estado);
				
				System.out.println("Nova cidade: ");
				String cidade = scann.nextLine();
				cliente.setCidade(cidade);
				
				System.out.println("Novo endereço: ");
				String endereco = scann.nextLine();
				cliente.setEndereco(endereco);

				dao.alterar(cliente);
				
			} else if (opcao == 4) {
				System.out.print("Informe id que deseja excluir: ");
				int id = scann.nextInt();
				cliente.setId(id);
				dao.excluir(cliente);
			}
		}while(opcao != 6);
			System.out.print("Opção Inválida");
	}
	
}
