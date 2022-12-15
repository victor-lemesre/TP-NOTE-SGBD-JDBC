package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import model.client_parent;
import model.contrat;
import model.meuble;
import utility.Bdd;

public class meubleController {

	public static List<meuble> getHauteurAvecHauteur(float _hauteur) {
		Statement s;
		List<meuble> la = new LinkedList<meuble>();

		try {
			
			s = Bdd.c.createStatement();
			ResultSet rs = s.executeQuery("SELECT * FROM meuble, contrat, livraison where hauteur= '"+ _hauteur + "' ;");
			rs.next();
			while (rs.next()) {
				client_parent cp = new client_parent();
				contrat c = new contrat();// LocalDate _dateDeConclusion, String _adresseDeLivraison, employe _employe, client_parent _client
				// livraison l = new livraison(rs.getString("meuble.fournisseur",c));// LocalDateTime _dateHeureLivraison, contrat _contrat
				meuble m = new meuble(rs.getFloat("meuble.prix"),rs.getFloat("meuble.longueur"),
						rs.getFloat("meuble.largeur"),rs.getFloat("meuble.hauteur"),
						rs.getString("meuble.fournisseur"),c,l);

			}
			s.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return la;

	}

}
