package controller;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import model.contrat;

public class gestionContrat {
	
	public static void addContrat() {
		contratDAO.addContrat();
	}

	public static void getContratFromClientByName() {
		
		List<contrat> lc = new LinkedList<contrat>();
		System.out.println("le client est une entreprise (=0) ou un particulier(=1)");
		Scanner scanner = new Scanner(System. in);
		int choix = scanner.nextInt();
		int clientId = -1;
		if (choix == 0) {
			System.out.println("rentrer le nom de la societe");
			scanner = new Scanner(System. in);
			String nomSociete = scanner.nextLine();
			clientId = entrepriseDAO.getIdByName(nomSociete);
			
		}else {
			System.out.println("rentrer le nom du particulier");
			scanner = new Scanner(System. in);
			String nom = scanner.nextLine();
			clientId = particulierDAO.getIdByName(nom);
		}
		
		lc = contratDAO.getContratFromClientById(clientId);
		for(contrat c : lc) {
			System.out.println(c.toString());
		}
	}
}
