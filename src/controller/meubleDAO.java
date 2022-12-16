package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import model.meuble;
import utility.Bdd;

public class meubleDAO {

	public static List<meuble> getHauteurAvecHauteur(float _hauteur) {
		Statement s;
		List<meuble> la = new LinkedList<meuble>();

		try {

			s = Bdd.c.createStatement();
			s.execute("SELECT * FROM meuble where hauteur= '" + _hauteur + "' ;");
			ResultSet rs = s.getResultSet();
			rs.next();
			while (rs.next()) {
				meuble m = new meuble(rs.getFloat("meuble.prix"),
						rs.getFloat("meuble.longueur"),
						rs.getFloat("meuble.largeur"),
						rs.getFloat("meuble.hauteur"),
						rs.getString("meuble.fournisseur"),
						rs.getBoolean("meuble.estReserve"));
				la.add(m);
			}
			s.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return la;

	}

}
