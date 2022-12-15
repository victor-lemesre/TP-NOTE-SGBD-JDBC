package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import model.client_parent;
import model.particulier;
import utility.Bdd;

public class clientController {

	public static List<client_parent> getClientsInfo() {
		Statement s;
		List<client_parent> la = new LinkedList<client_parent>();

		try {

			s = Bdd.c.createStatement();
			ResultSet rs = s.executeQuery("SELECT * FROM client_parent, particulier;");
			rs.next();
			while (rs.next()) {
			// TODO
				//select * from client_parent, entreprise where Idclient = fk_idclient
				//select * from client_parent, particulier where Idclient = fk_idclient
			}
			s.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return la;

	}
}
