package controller;

import java.util.List;
import java.util.Scanner;

import model.meuble;

public class gestionMeuble {
	
	public static void afficherMeubleAvecHauteur() {
		
		System.out.println("choisi la hauteur du meuble");
		Scanner scanner = new Scanner(System. in); 
		float hauteur = scanner.nextFloat();
		List<meuble> lm = meubleDAO.getMeubleAvecHauteur(hauteur);
		for (meuble m : lm) {
			System.out.println(m.toString());
		}

		
	}

}
