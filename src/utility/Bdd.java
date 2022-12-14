package utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Bdd {
	public static Connection c;
	private static Statement stmt;
	private static PreparedStatement pstmt;

	public static void initConnection() {

		Properties userInfo = new Properties();
		userInfo.setProperty("user", "root");
		userInfo.setProperty("password", "root");

		try {
			c = DriverManager.getConnection("jdbc:mysql://localhost:3306/meubles", userInfo);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void createTables() {

		String meuble = "CREATE TABLE meuble (IdMeuble VARCHAR(50) not NULL, "
				+ "Prix DECIMAL(15,2) ,"
				+ "Fournisseur VARCHAR(50)," + "Longueur DECIMAL(15,2)," 
				+ "Largeur DECIMAL(15,2),"
				+ "Hauteur DECIMAL(15,2)," + "IdLivraison VARCHAR(50) ," 
				+ "IdContrat VARCHAR(50) ,"
				+ "PRIMARY KEY (IdMeuble) ," + "FOREIGN KEY (IdLivraison) REFERENCES livraison(IdLivraison) ,"
				+ "FOREIGN KEY (IdContrat) REFERENCES contrat(IdContrat));";

		String employe = "CREATE TABLE employe (IdEmploye VARCHAR(50) NOT NULL, " 
				+ "Domaine VARCHAR(100),"
				+ "PRIMARY KEY (IdEmploye));";

		String client_parent = "CREATE TABLE client_parent (IdClient VARCHAR(50) NOT NULL, " 
				+ "Adresse VARCHAR(100),"
				+ "PRIMARY KEY (IdClient));";

		String particulier = "CREATE TABLE particulier (IdClient VARCHAR(50) NOT NULL, " 
				+ "nom VARCHAR(50) ,"
				+ "prenom VARCHAR(50) ," 
				+ "telephone VARCHAR(20) ," 
				+ "PRIMARY KEY (IdClient) ,"
				+ "FOREIGN KEY (IdClient) REFERENCES client_parent(IdClient));";

		String entreprise = "CREATE TABLE entreprise (IdClient VARCHAR(50) NOT NULL, " 
				+ "numeroTVA INT ,"
				+ "nomSociete VARCHAR(50) ," 
				+ "PRIMARY KEY (IdClient) ,"
				+ "FOREIGN KEY (IdClient) REFERENCES client_parent(IdClient));";

		String contrat = "CREATE TABLE contrat (IdContrat VARCHAR(50) NOT NULL, " 
				+ "dateDeConclusion DATE ,"
				+ "adresseDeLivraison VARCHAR(100) ," 
				+ "IdClient VARCHAR(50) ," 
				+ "IdEmploye VARCHAR(50) ,"
				+ "PRIMARY KEY (IdContrat) ," 
				+ "FOREIGN KEY (IdEmploye) REFERENCES employe(IdEmploye) ,"
				+ "FOREIGN KEY (IdClient) REFERENCES client_parent(IdClient));";

		String livraison = "CREATE TABLE livraison (IdLivraison VARCHAR(50) NOT NULL," 
				+ "dateHeureLivraison DATETIME ,"
				+ "IdContrat VARCHAR(50) ," 
				+ "PRIMARY KEY (IdLivraison) ,"
				+ "FOREIGN KEY (IdContrat) REFERENCES contrat(IdContrat));";

		String telephone = "CREATE TABLE telephone (IdTelephone VARCHAR(50) NOT NULL,Telephone VARCHAR(20)" 
				+ "IdClient VARCHAR(50) ,"
				+ "PRIMARY KEY (IdTelephone) ," 
				+ "FOREIGN KEY (IdClient) REFERENCES entreprise(IdClient));";

		try {
			stmt = c.createStatement();
			stmt.executeUpdate("DROP TABLE IF EXISTS meuble;");
			stmt.executeUpdate("DROP TABLE IF EXISTS telephone");
			stmt.executeUpdate("DROP TABLE IF EXISTS livraison");
			stmt.executeUpdate("DROP TABLE IF EXISTS contrat");
			stmt.executeUpdate("DROP TABLE IF EXISTS employe");
			stmt.executeUpdate("DROP TABLE IF EXISTS client_parent");
			stmt.executeUpdate("DROP TABLE IF EXISTS entreprise");
			stmt.executeUpdate("DROP TABLE IF EXISTS particulier");

			stmt.executeUpdate(client_parent);
			stmt.executeUpdate(particulier);
			stmt.executeUpdate(entreprise);
			stmt.executeUpdate(employe);
			stmt.executeUpdate(contrat);
			stmt.executeUpdate(livraison);
			stmt.executeUpdate(telephone);
			stmt.executeUpdate(meuble);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void insertData() {

	}

}
