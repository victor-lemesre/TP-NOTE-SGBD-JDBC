package utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Bdd {
	public static Connection c;
	
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
		Statement stmt;

		String meuble = "CREATE TABLE meuble ("
				+ "IdMeuble INT NOT NULL AUTO_INCREMENT,"
				+ "typeMeuble VARCHAR(50),"
				+ "prix DECIMAL(15,2),"
				+ "fournisseur VARCHAR(50)," 
				+ "longueur DECIMAL(15,2)," 
				+ "largeur DECIMAL(15,2),"
				+ "hauteur DECIMAL(15,2),"
				+ "estReserve BOOLEAN NOT NULL,"
				+ "IdLivraison INT," 
				+ "IdContrat INT,"
				+ "PRIMARY KEY (IdMeuble),"
				+ "FOREIGN KEY (IdLivraison) REFERENCES livraison(IdLivraison),"
				+ "FOREIGN KEY (IdContrat) REFERENCES contrat(IdContrat));";

		String employe = "CREATE TABLE employe ("
				+ "IdEmploye INT NOT NULL AUTO_INCREMENT, "
				+ "Prenom VARCHAR(100),"
				+ "domaine VARCHAR(100),"
				+ "PRIMARY KEY (IdEmploye));";

		String client_parent = "CREATE TABLE client_parent ("
				+ "IdClient INT NOT NULL AUTO_INCREMENT, " 
				+ "adresse VARCHAR(100),"
				+ "PRIMARY KEY (IdClient));";

		String particulier = "CREATE TABLE particulier ("
				+ "IdClient INT, " 
				+ "nom VARCHAR(50) ,"
				+ "prenom VARCHAR(50) ," 
				+ "telephone VARCHAR(20) ," 
				+ "PRIMARY KEY (IdClient) ,"
				+ "FOREIGN KEY (IdClient) REFERENCES client_parent(IdClient));";

		String entreprise = "CREATE TABLE entreprise ("
				+ "IdClient INT, " 
				+ "numeroTVA VARCHAR(50) ,"
				+ "nomSociete VARCHAR(50) ," 
				+ "PRIMARY KEY (IdClient) ,"
				+ "FOREIGN KEY (IdClient) REFERENCES client_parent(IdClient));";

		String contrat = "CREATE TABLE contrat ("
				+ "IdContrat INT NOT NULL AUTO_INCREMENT, " 
				+ "dateDeConclusion DATE ,"
				+ "adresseDeLivraison VARCHAR(100) ," 
				+ "IdClient INT ," 
				+ "IdEmploye INT ,"
				+ "PRIMARY KEY (IdContrat) ," 
				+ "FOREIGN KEY (IdEmploye) REFERENCES employe(IdEmploye) ,"
				+ "FOREIGN KEY (IdClient) REFERENCES client_parent(IdClient));";

		String livraison = "CREATE TABLE livraison ("
				+ "IdLivraison INT NOT NULL AUTO_INCREMENT," 
				+ "dateHeureLivraison DATETIME ,"
				+ "IdContrat INT ," 
				+ "PRIMARY KEY (IdLivraison) ,"
				+ "FOREIGN KEY (IdContrat) REFERENCES contrat(IdContrat));";

		String telephone = "CREATE TABLE telephone (" 
				+ "IdTelephone INT NOT NULL AUTO_INCREMENT,"
				+ "numTelephone VARCHAR(20)," 
				+ "IdClient INT ,"
				+ "PRIMARY KEY (IdTelephone) ," 
				+ "FOREIGN KEY (IdClient) REFERENCES entreprise(IdClient));";

		try {
			stmt = c.createStatement();
			stmt.execute("DROP TABLE IF EXISTS meuble;");
			stmt.execute("DROP TABLE IF EXISTS telephone");
			stmt.execute("DROP TABLE IF EXISTS livraison");
			stmt.execute("DROP TABLE IF EXISTS contrat");
			stmt.execute("DROP TABLE IF EXISTS employe");
			stmt.execute("DROP TABLE IF EXISTS entreprise");
			stmt.execute("DROP TABLE IF EXISTS particulier");
			stmt.execute("DROP TABLE IF EXISTS client_parent");

			stmt.execute(client_parent);
			stmt.execute(particulier);
			stmt.execute(entreprise);
			stmt.execute(employe);
			stmt.execute(contrat);
			stmt.execute(livraison);
			stmt.execute(telephone);
			stmt.execute(meuble);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void fillDatabase() {
		Statement stmt;
		
		try {
			stmt = c.createStatement();
			// ajout des clients 
			stmt.execute("INSERT INTO client_parent (Adresse) VALUES ('45 allee ferdinand de lesseps')");
			stmt.execute("INSERT INTO client_parent (Adresse) VALUES ('32 rue charles richet')");
			
			//spécification  du client 1 en particulier
			stmt.execute("INSERT INTO particulier (IdClient,nom,prenom,telephone) VALUES (1,'LEMESRE' , 'Victor' ,'0606662415')");

			//spécification  du client 2 en entreprise 
			stmt.execute("INSERT INTO entreprise (IdClient,numeroTVA,nomSociete) VALUES (2,'FR 32 123456789' , 'polytech')");
			
			//ajout des telephone de l'entreprise
			
			stmt.execute("INSERT INTO telephone(IdClient,numTelephone) VALUES (2,'0666999013')");
			stmt.execute("INSERT INTO telephone(IdClient,numTelephone) VALUES (2,'0684759612')");
			stmt.execute("INSERT INTO telephone(IdClient,numTelephone) VALUES (2,'0619283264')");
			
			//ajout des employes
			
			stmt.execute("INSERT INTO employe (prenom,domaine) VALUES ('Paul','commercial')");
			stmt.execute("INSERT INTO employe (prenom,domaine) VALUES ('Theo','fabriquant')");
			stmt.execute("INSERT INTO employe (prenom,domaine) VALUES ('Martin','employe administratif')");
			
			//ajout des contrats
			stmt.execute("INSERT INTO contrat (dateDeConclusion,adresseDeLivraison,IdClient,IdEmploye) VALUES ('2022-9-9','45 allee ferdinand de lesseps',1,1)");
			stmt.execute("INSERT INTO contrat (dateDeConclusion,adresseDeLivraison,IdClient,IdEmploye) VALUES ('2022-10-10','32 rue charles richet',2,2)");
			stmt.execute("INSERT INTO contrat (dateDeConclusion,adresseDeLivraison,IdClient,IdEmploye) VALUES ('2022-11-11','32 rue charles richet',2,3)");
			
			//ajout des livraison
			stmt.execute("INSERT INTO livraison (dateHeureLivraison,IdContrat) VALUES ('2022-10-10 10:10:10',1)");
			stmt.execute("INSERT INTO livraison (dateHeureLivraison,IdContrat) VALUES ('2022-11-11 11:11:11',2)");
			stmt.execute("INSERT INTO livraison (dateHeureLivraison,IdContrat) VALUES ('2022-12-12 12:12:12',3)");
			stmt.execute("INSERT INTO livraison (dateHeureLivraison,IdContrat) VALUES ('2022-12-12 12:12:12',3)");
			
			//ajout des meubles
			stmt.execute("INSERT INTO meuble (typeMeuble,prix,fournisseur,longueur,largeur,hauteur,estReserve,IdLivraison,IdContrat) VALUES ('armoire',109.99,'leroy merlin',100.0,100.0,15,TRUE,1,1)");
			stmt.execute("INSERT INTO meuble (typeMeuble,prix,fournisseur,longueur,largeur,hauteur,estReserve,IdLivraison,IdContrat) VALUES ('etagere',109.99,'bricoman',100.0,100.0,200.0,TRUE,1,1)");
			stmt.execute("INSERT INTO meuble (typeMeuble,prix,fournisseur,longueur,largeur,hauteur,estReserve,IdLivraison,IdContrat) VALUES ('lit',109.99,'burolia',100.0,100.0,200.0,TRUE,2,2)");
			stmt.execute("INSERT INTO meuble (typeMeuble,prix,fournisseur,longueur,largeur,hauteur,estReserve,IdLivraison,IdContrat) VALUES ('table',109.99,'monsieur bureau',100.0,100.0,200.0,TRUE,2,2)");
			stmt.execute("INSERT INTO meuble (typeMeuble,prix,fournisseur,longueur,largeur,hauteur,estReserve,IdLivraison,IdContrat) VALUES ('table de chevet',109.99,'leroy merlin',100.0,100.0,200.0,TRUE,3,3)");
			stmt.execute("INSERT INTO meuble (typeMeuble,prix,fournisseur,longueur,largeur,hauteur,estReserve,IdLivraison,IdContrat) VALUES ('chaise',109.99,'bricoman',100.0,100.0,200.0,TRUE,3,3)");
			stmt.execute("INSERT INTO meuble (typeMeuble,prix,fournisseur,longueur,largeur,hauteur,estReserve,IdLivraison,IdContrat) VALUES ('armoire',109.99,'burolia',100.0,100.0,200.0,TRUE,4,3)");
			stmt.execute("INSERT INTO meuble (typeMeuble,prix,fournisseur,longueur,largeur,hauteur,estReserve,IdLivraison,IdContrat) VALUES ('armoire',109.99,'monsieur bureau',100.0,100.0,200.0,TRUE,4,3)");
			stmt.execute("INSERT INTO meuble (typeMeuble,prix,fournisseur,longueur,largeur,hauteur,estReserve) VALUES ('armoire',109.99,'leroy merlin',100.0,100.0,200.0,FALSE)");
			stmt.execute("INSERT INTO meuble (typeMeuble,prix,fournisseur,longueur,largeur,hauteur,estReserve) VALUES ('armoire',109.99,'bricoman',100.0,100.0,200.0,FALSE)");
			

			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		

	}

}
