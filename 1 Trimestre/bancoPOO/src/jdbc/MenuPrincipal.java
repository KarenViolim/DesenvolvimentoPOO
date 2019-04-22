package jdbc;

import java.sql.SQLException;
import java.util.Scanner;

public class MenuPrincipal {


public static void main (String [] args) throws SQLException {
	MenuCliente cliente = new MenuCliente();
	MenuEstado estado = new MenuEstado();
	Scanner scann = new Scanner(System.in);
	
	int menu = 0;
	do {
		System.out.println("Deseja alterar qual menu?");
		System.out.println("1 - Menu Cliente");
		System.out.println("2 - Menu Estado");
		System.out.println("3 - Sair");
		menu = scann.nextInt();
		scann.nextLine();
		if (menu == 1) {
			cliente.menuCliente();
		}else if (menu == 2) {
			estado.menuEstado();
		}
	}while(menu != 3); 
}
}