package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import model.client_parent;
import model.contrat;
import model.entreprise;
import model.telephone;
import utility.Bdd;

public class entrepriseDAO {
	
public static List<entreprise> getClientsEntrepriseInfo() {
	
	Statement s;
	Statement stmt;
	List<entreprise> la = new LinkedList<entreprise>();

	try {

		s = Bdd.c.createStatement();
		stmt = Bdd.c.createStatement();
		// recuperation de tous les clients de type entreprise
		s.execute("select * from client_parent, entreprise where client_parent.Idclient=entreprise.idclient;");
		ResultSet rsEntreprise = s.getResultSet();
		//rsEntreprise.next();
		while (rsEntreprise.next()) {
			int IdClient = rsEntreprise.getInt("client_parent.IdClient");
			String adresseEntreprise = rsEntreprise.getString("client_parent.adresse");
			String numeroTVA = rsEntreprise.getString("entreprise.numeroTVA");
			String nomSociete = rsEntreprise.getString("entreprise.nomSociete");

			List<contrat> lcE = new LinkedList<contrat>();
			stmt.execute("SELECT * FROM contrat where IdClient=" + IdClient + " ;");
			ResultSet rsContrat = stmt.getResultSet();
			while (rsContrat.next()) {
				contrat contrat = new contrat(rsContrat.getString("contrat.dateDeConclusion"),
						rsContrat.getString("contrat.adresseDeLivraison"));
				lcE.add(contrat);
			}
			List<telephone> lt = new LinkedList<telephone>();
			stmt.execute("SELECT * FROM telephone where IdClient=" + IdClient + " ;");
			ResultSet rsTelephone = stmt.getResultSet();
			while (rsTelephone.next()) {
				telephone telephone = new telephone(rsTelephone.getString("telephone.numTelephone"));
				lt.add(telephone);

			}
			entreprise e = new entreprise(adresseEntreprise, lcE, numeroTVA, nomSociete, lt);
			la.add(e);
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
		s.execute("select IdClient from entreprise where nomSociete = '" + _name + "';");
		ResultSet rsIdClient = s.getResultSet();
		rsIdClient.next();
		Idclient = rsIdClient.getInt("entreprise.IdClient");

		s.close();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return Idclient;

}

}
