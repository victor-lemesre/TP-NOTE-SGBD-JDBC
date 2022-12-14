package model;

import java.time.LocalDate;

public class contrat {
	private LocalDate dateDeColclusion;
	private String adresseDeLivraison;
	private employe employe;
	private client_parent client;
	
	
	public LocalDate getDateDeColclusion() {
		return dateDeColclusion;
	}
	public void setDateDeColclusion(LocalDate dateDeColclusion) {
		this.dateDeColclusion = dateDeColclusion;
	}
	public String getAdresseDeLivraison() {
		return adresseDeLivraison;
	}
	public void setAdresseDeLivraison(String adresseDeLivraison) {
		this.adresseDeLivraison = adresseDeLivraison;
	}
	public employe getEmploye() {
		return employe;
	}
	public void setEmploye(employe employe) {
		this.employe = employe;
	}
	public client_parent getClient() {
		return client;
	}
	public void setClient(client_parent client) {
		this.client = client;
	}
	
	

}
