package controller;

import java.util.List;

import model.client_parent;
import model.entreprise;
import model.particulier;

public class gestionClient {

	public static void afficherClientInfo() {
		List<particulier> lcp = particulierDAO.getClientsParticulierInfo();
		List<entreprise> lce = entrepriseDAO.getClientsEntrepriseInfo();
		for (particulier c : lcp) {
			System.out.println(c.tostring()); 
		}
		for (entreprise c : lce) {
			System.out.println(c.tostring()); 
		}
	}

}
