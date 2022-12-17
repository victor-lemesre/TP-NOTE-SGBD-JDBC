package view;

import java.util.List;

import controller.meubleDAO;
import model.meuble;
import utility.Bdd;

public class application {

	public static void main(String[] args) {
		Bdd.initConnection();
		Bdd.createTables();
		Bdd.fillDatabase();
		System.out.println("hello");
		List<meuble> lm = meubleDAO.getMeubleAvecHauteur((float)200);
		for(meuble m: lm) {
			System.out.println("type de meuble :"+m.getTypeMeuble());
		}

	}

}
