package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import model.contrat;
import model.particulier;
import utility.Bdd;

public class particulierDAO {

	public static List<particulier> getClientsParticulierInfo() {
		Statement s;
		Statement stmt;
		List<particulier> la = new LinkedList<particulier>();

		try {

			s = Bdd.c.createStatement();
			stmt = Bdd.c.createStatement();
			// recuperation de tout les clients de type particulier
			s.execute("select * from client_parent, particulier where client_parent.Idclient= particulier.idclient;");
			ResultSet rsParticulier = s.getResultSet();
			// rsParticulier.next();
			while (rsParticulier.next()) {
				int IdClient = rsParticulier.getInt("client_parent.IdClient");
				String adresseParticulier = rsParticulier.getString("client_parent.adresse");
				String nom = rsParticulier.getString("particulier.nom");
				String prenom = rsParticulier.getString("particulier.prenom");
				String telephone = rsParticulier.getString("particulier.telephone");
				List<contrat> lcP = new LinkedList<contrat>();
				stmt.execute("SELECT * FROM contrat where IdClient=" + IdClient + " ;");
				ResultSet rsContrat = stmt.getResultSet();
				while (rsContrat.next()) {
					contrat contrat = new contrat(rsContrat.getString("contrat.dateDeConclusion"),
							rsContrat.getString("contrat.adresseDeLivraison"));
					lcP.add(contrat);
				}
				particulier p = new particulier(adresseParticulier, lcP, nom, prenom, telephone);
				la.add(p);
			}
			s.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return la;

	}

	public static int getIdByName(String _name) {
		Statement s;
		int Idclient = -1;
		try {

			s = Bdd.c.createStatement();
			s.execute("select IdClient from particulier where nom = '"+ _name + "';");
			ResultSet rsIdClient = s.getResultSet();
			rsIdClient.next();
			
			Idclient = rsIdClient.getInt("particulier.IdClient");

			s.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Idclient;

	}
}
