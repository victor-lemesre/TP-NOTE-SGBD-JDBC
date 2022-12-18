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
			System.out.println("le client est une entreprise 0 ou un particulier 1");
			Scanner scanner = new Scanner(System. in);
			int choix = scanner.nextInt();
			int IdClient;
			if(choix == 1) {
				
				// recuperation du nom
				System.out.println("Renseigner le nom du detenteur du contrat");
				scanner = new Scanner(System. in);
				String nom = scanner.nextLine();
				System.out.println("resultat: "+nom+"\n");
				
				// recuperation du prenom
				System.out.println("Renseigner le prenom du detenteur du contrat");
				scanner = new Scanner(System. in);
				String prenom = scanner.nextLine();
				System.out.println("resultat: "+prenom+"\n");
				
				//recuperation de l'ID du client avec son nom et son prenom
				stmt.execute("select client_parent.IdClient from client_parent,particulier where client_parent.IdClient = particulier.IdClient and particulier.nom = '"+nom+"' and particulier.prenom= '"+prenom+"';");
				ResultSet rsIdClient = stmt.getResultSet();
				rsIdClient.next();
				IdClient = rsIdClient.getInt("client_parent.IdClient");
				
			}else {
				
				// recuperation du nom de la societe
				System.out.println("Renseigner le nom du detenteur du contrat");
				scanner = new Scanner(System. in);
				String nomSociete = scanner.nextLine();
				System.out.println("resultat: "+nomSociete+"\n");
				
				
				//recuperation de l'ID du client avec le nom de la societe
				stmt.execute("select client_parent.IdClient from client_parent,entreprise where client_parent.IdClient = entreprise.IdClient and particulier.nomSociete = '"+nomSociete+";");
				ResultSet rsIdClient = stmt.getResultSet();
				rsIdClient.next();
				IdClient = rsIdClient.getInt("client_parent.IdClient");
				
				
			}
			
			
			
			
			//recuperation de la date de conclusion du contrat
			System.out.println("Renseigner la date de conclusion du contrat au format AAAA-MM-JJ");
			scanner = new Scanner(System. in);
			String dateConclusion = scanner.nextLine();
			System.out.println("resultat: "+dateConclusion+"\n");
			
			//recuperation de l'adresse de livraison 
			System.out.println("Renseigner l'adresse de livraison");
			scanner = new Scanner(System. in);
			String adresseLivraison = scanner.nextLine();
			System.out.println("resultat: "+adresseLivraison+"\n");
			
			
			// affichage de tout les employes 
			System.out.println("liste des employes: ");
			stmt.execute("select IdEmploye,prenom from employe ; ");
			ResultSet rsEmploye = stmt.getResultSet();
			while(rsEmploye.next()) {
				System.out.println("-"+rsEmploye.getInt("employe.IdEmploye")+" : "+rsEmploye.getString("employe.prenom"));
				
			}
			
			//choix de l'employe du contrat
			System.out.println("veuillez choisire un employe en fonction de son numero");
			scanner = new Scanner(System. in);
			int IdEmploye = scanner.nextInt();
			System.out.println("resultat: "+IdEmploye+"\n");
			
			//affichage de tout les meubles non reserve
			List<Integer> li = new LinkedList<Integer>();
			Integer IdMeuble = -1;
			while(IdMeuble != 0) {
				stmt.execute("select IdMeuble,typeMeuble from meuble where estReserve = FALSE ; ");
				ResultSet rsMeuble = stmt.getResultSet();
				while(rsMeuble.next()) {
					System.out.println("-"+rsMeuble.getString("meuble.IdMeuble")+" : "+rsMeuble.getString("meuble.typeMeuble"));
				}
				System.out.println("veuillez renseigner le numero d'identifiant du meuble \n(appuyer sur entre a chaque iteration,renseigner 0 pour arreter )");
				scanner = new Scanner(System. in);
				IdMeuble = scanner.nextInt();
				System.out.println("resultat: "+IdMeuble+"\n");
				li.add(IdMeuble);
				
			}
			//création du contrat
			stmt.execute("INSERT INTO contrat (dateDeConclusion,adresseDeLivraison,IdClient,IdEmploye) VALUES ('"+dateConclusion+"','"+adresseLivraison+"',"+IdClient+","+IdEmploye+")");
			stmt.execute("Select IdContrat from contrat where dateDeConclusion = '"+dateConclusion+"' and adresseDeLivraison = '"+adresseLivraison+"' and IdClient = "+IdClient+" and IdEmploye = "+IdEmploye+";");
			ResultSet rsIdContrat = stmt.getResultSet();
			rsIdContrat.next();
			int IdContrat = rsIdContrat.getInt("contrat.IdContrat");
			//modification des meubles qui sont dans le contrat
			for(Integer i:li) {
				stmt.execute("update meuble set estReserve = TRUE, IdContrat = "+IdContrat+" where IdMeuble = "+ i);
			}
			
			stmt.close();
			System.out.println("contrat ajouter a la base de donnee avec succes ");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static List<contrat> getContratFromClientById(int _idClient) {
		
		Statement s;
		Statement stmt;
		List<contrat> lc = new LinkedList<contrat>();
		List<meuble> lm = new LinkedList<meuble>();
		List<livraison> ll = new LinkedList<livraison>();

		try {
			stmt = Bdd.c.createStatement();
			s = Bdd.c.createStatement();
			s.execute("SELECT * FROM contrat,client_parent where client_parent.IdClient = contrat.IdClient and client_parent.IdClient="+ _idClient + " ;");
			ResultSet rsContrat = s.getResultSet();
			//rsContrat.next();
			while (rsContrat.next()) {	
				stmt.execute("SELECT * FROM meuble where meuble.IdContrat= '" + _idClient + "' ;");
				ResultSet rsMeuble = stmt.getResultSet();
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
				
				stmt.execute("SELECT * FROM livraison where livraison.IdContrat= '" + rsContrat.getInt("contrat.IdContrat") + "' ;");
				ResultSet rsLivraison = stmt.getResultSet();
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
