package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import model.client_parent;
import model.contrat;
import model.entreprise;
import model.particulier;
import model.telephone;
import utility.Bdd;

public class clientDAO {

	public static List<client_parent> getClientsInfoWhithNom() {
		Statement s;
		List<client_parent> la = new LinkedList<client_parent>();

		try {

			s = Bdd.c.createStatement();
			ResultSet rsEntreprise = s.executeQuery("select * from client_parent, entreprise, contrat where client_parent.Idclient=entreprise.idclient and client_parent.Idclient=contrat.idclient;");
			rsEntreprise.next();
			while (rsEntreprise.next()) {
			List<contrat> lcE = new LinkedList<contrat>();
			s.execute("SELECT * FROM contrat where IdClient_parent=" + rsEntreprise.getInt("client_parent.IdClient") + " ;");
			ResultSet rsContrat = s.getResultSet();
			while (rsContrat.next()) {
				contrat contrat = new contrat(rsContrat.getString("contrat.dateDeConclusion"),rsContrat.getString("contrat.adresseDeLivraison"));
				lcE.add(contrat);
			}
			List<telephone> lt = new LinkedList<telephone>();
			s.execute("SELECT * FROM telephone where IdClient_parent=" + rsEntreprise.getInt("client_parent.IdClient") + " ;");
			ResultSet rsTelephone = s.getResultSet();
			while (rsContrat.next()) {
				telephone telephone = new telephone(rsTelephone.getString("telephon.numTelephone"));
				lt.add(telephone);
				
			}
			entreprise e = new entreprise(rsEntreprise.getString("client_parent.adresse"),lcE,
					rsEntreprise.getInt("entreprise.numeroTVA"),
					rsEntreprise.getString("entreprise.nomSociete"),lt);
				
				la.add(e);
			}
			
			ResultSet rsParticulier = s.executeQuery("select * from client_parent, particulier where client_parent.Idclient= particulier.idclient;");
			rsParticulier.next();
			while (rsParticulier.next()) {
			List<contrat> lcP = new LinkedList<contrat>();
			s.execute("SELECT * FROM contrat where IdClient_parent=" + rsEntreprise.getInt("client_parent.IdClient") + " ;");
			ResultSet rsContrat = s.getResultSet();
			while (rsContrat.next()) {
				contrat contrat = new contrat(rsContrat.getString("contrat.dateDeConclusion"),rsContrat.getString("contrat.adresseDeLivraison"));
				lcP.add(contrat);
			}
			particulier p = new particulier(rsParticulier.getString("client_parent.adresse"),lcP,
					rsParticulier.getString("particulier.nom"),
					rsParticulier.getString("particulier.prenom"),
					rsParticulier.getString("particulier.telephone"));
				la.add(p);
			}
			s.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return la;

	}
}
