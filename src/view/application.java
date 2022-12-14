package view;

import utility.Bdd;

public class application {

	public static void main(String[] args) {
		Bdd.initConnection();
		Bdd.createTables();

	}

}
