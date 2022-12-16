package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import model.client_parent;
import model.entreprise;
import model.particulier;
import utility.Bdd;

public class clientDAO {

	public static List<client_parent> getClientsInfo() {
		Statement s;
		List<client_parent> la = new LinkedList<client_parent>();

		try {

			s = Bdd.c.createStatement();
			ResultSet rsEntreprise = s.executeQuery("select * from client_parent, entreprise where client_parent.Idclient=entreprise.idclient");
			rsEntreprise.next();
			while (rsEntreprise.next()) {
			entreprise e = new entreprise(rsEntreprise.getString("client_parent.adresse"),
					rsEntreprise.getInt("entreprise.numeroTVA"),
					rsEntreprise.getString("entreprise.nomSociete"));
				
				la.add(e);
			}
			
			ResultSet rsClient = s.executeQuery("select * from client_parent, particulier where client_parent.Idclient= particulier.idclient");
			rsClient.next();
			while (rsClient.next()) {
			particulier p = new particulier(rsClient.getString("client_parent.adresse"),
					rsClient.getString("particulier.nom"),
					rsClient.getString("particulier.prenom"),
					rsClient.getString("particulier.telephone"));
				la.add(p);
			}
			s.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return la;

	}
}
