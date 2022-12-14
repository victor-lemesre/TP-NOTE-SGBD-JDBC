package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import model.meuble;
import utility.Bdd;

public class meubleController {

	public static List<meuble> getHauteurAvecHauteur(float _hauteur) {
		Statement s;
		List<meuble> la = new LinkedList<meuble>();

		try {
			
			s = Bdd.c.createStatement();
			ResultSet rs = s.executeQuery("SELECT * FROM meuble where hauteur= '"+ _hauteur + "' ;");
			rs.next();
			while (rs.next()) {
				meuble m = new meuble();
				m.setPrix(rs.getFloat("meuble.prix"));
				m.setLongueur(rs.getFloat("meuble.longueur"));
				m.setLargeur(rs.getFloat("meuble.largeur"));
				m.setHauteur(rs.getFloat("meuble.hauteur"));
				m.setFournisseur(rs.getString("meuble.fournisseur"));
				m.setContrat(null); // TODO
				m.setLivraison(null); //TODO
			}
			s.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return la;

	}

}
