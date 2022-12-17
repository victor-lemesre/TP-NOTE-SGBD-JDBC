package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import model.contrat;
import model.livraison;
import model.meuble;
import utility.Bdd;

public class contratDAO {

	public static void addContrat() {
		Statement stmt;
		try {

			stmt = Bdd.c.createStatement();
			Scanner scanner = new Scanner(System. in);
			String choix = scanner.nextLine();
			stmt.execute("INSERT INTO contrat (dateDeConclusion,adresseDeLivraison,IdClient,IdEmploye) VALUES ('2022-9-9','45 allee ferdinand de lesseps',1,1)");
			stmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//TODO
		
		// demander nom et prenom du detenteur du contrat
		// demander date de conclusion 
		// demander adresse de livraison 
		// demander la liste des meubles compris dans le contrat 
		// demander si la livraison à deja ete effectue
		// demander qui est le vendeur

	}

	public static List<contrat> getContratFromClientById(String _idClient) {
		
		Statement s;
		List<contrat> lc = new LinkedList<contrat>();
		List<meuble> lm = new LinkedList<meuble>();
		List<livraison> ll = new LinkedList<livraison>();

		try {

			s = Bdd.c.createStatement();
			s.executeQuery("SELECT * FROM contrat,client_parent, where client_parent.IdClient= '" + _idClient + "' ;");
			ResultSet rsContrat = s.getResultSet();
			//rsContrat.next();
			while (rsContrat.next()) {	
				s.executeQuery("SELECT * FROM meuble where meuble.IdContrat= '" + rsContrat.getInt("contrat.IdContrat") + "' ;");
				ResultSet rsMeuble = s.getResultSet();
				//rsMeuble.next();
				while (rsMeuble.next()) {
					meuble m = new meuble(rsMeuble.getString("meuble.typeMeuble"),
						rsMeuble.getFloat("meuble.prix"),
						rsMeuble.getFloat("meuble.longueur"),
						rsMeuble.getFloat("meuble.largeur"),
						rsMeuble.getFloat("meuble.hauteur"),
						rsMeuble.getString("meuble.fournisseur"),
						rsMeuble.getBoolean("meuble.estReserve"));
				lm.add(m);
				}
				
				s.executeQuery("SELECT * FROM livraison where livraison.IdContrat= '" + rsContrat.getInt("contrat.IdContrat") + "' ;");
				ResultSet rsLivraison = s.getResultSet();
				//rsLivraison.next();
				while (rsLivraison.next()) {
					livraison l = new livraison(rsLivraison.getString("livraison.dateHeureLivraison"));
					ll.add(l);
				}
				
				contrat c = new contrat(rsContrat.getString("contrat.dateDeConclusion"),rsContrat.getString("contrat.adresseDeLivraison"),lm,ll);
				lc.add(c);
			}
		s.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lc;
	
	}

}
