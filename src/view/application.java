package view;

import java.util.Scanner;

import controller.*;
import utility.Bdd;

public class application {

	public static void main(String[] args) {
		int choix = -1;
		Bdd.initConnection();
		Bdd.createTables();
		Bdd.fillDatabase();
		while(choix!=5) {
			showMenu();
			System.out.println("Fais ton choix ");
			Scanner scanner = new Scanner(System. in); 
			choix = scanner.nextInt();
			switch(choix) {
				case 1:
					gestionClient.afficherClientInfo();
					break;
				case 2:
					gestionContrat.getContratFromClientByName();
					break;
				case 3:
					gestionMeuble.afficherMeubleAvecHauteur();
					break;
				case 4:
					gestionContrat.addContrat();
					break;
				case 5:
					break;
				default:
					System.out.println("Choix incorrect !");
					break;
			}
		}


	}
	
	private static void showMenu() {
		System.out.println("1. Afficher tous les clients ");
		System.out.println("2. Afficher les contrats d'un client");
		System.out.println("3. Afficher les meubles avec une certaine hauteur");
		System.out.println("4. Ajouter un contrat");
		System.out.println("5. Exit");
	}

}
