package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import model.contrat;
import model.meuble;
import utility.Bdd;

public class contratDAO {

	public static void addContrat() {
		//TODO

	}

	public static List<contrat> getContratAvecClient(String _idClient) {
		Statement s;
		List<contrat> la = new LinkedList<contrat>();

		try {

			s = Bdd.c.createStatement();
			ResultSet rs = s.executeQuery("SELECT * FROM contrat,client_parent, where client_parent.IdClient= '" + _idClient + "' ;");
			rs.next();
			while (rs.next()) {meuble m = new meuble(rs.getFloat("meuble.prix"), rs.getFloat("meuble.longueur"),
					rs.getFloat("meuble.largeur"), rs.getFloat("meuble.hauteur"),
					rs.getString("meuble.fournisseur"));
			la.add();
			}
		s.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return la;

	}

}
