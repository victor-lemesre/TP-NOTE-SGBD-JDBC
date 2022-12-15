package model;

import java.time.LocalDate;

public class contrat {
	private LocalDate dateDeConclusion;
	private String adresseDeLivraison;
	private employe employe;
	private client_parent client;
	
	public contrat(LocalDate _dateDeConclusion, String _adresseDeLivraison, employe _employe, client_parent _client) {
		this.dateDeConclusion = _dateDeConclusion;
		this.adresseDeLivraison = _adresseDeLivraison;
		this.employe = _employe;
		this.client = _client;
	}
	
	
	public LocalDate getDateDeConclusion() {
		return dateDeConclusion;
	}
	public void setDateDeConclusion(LocalDate dateDeColclusion) {
		this.dateDeConclusion = dateDeColclusion;
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
