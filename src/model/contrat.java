package model;

import java.time.LocalDate;
import java.util.List;

public class contrat {
	private LocalDate dateDeConclusion;
	private String adresseDeLivraison;
	private List<meuble> listMeuble;
	private List<livraison> listLivraison;
	
	public contrat(LocalDate _dateDeConclusion, String _adresseDeLivraison,List<meuble> _listMeuble,List<livraison> _listLivraison) {
		this.dateDeConclusion = _dateDeConclusion;
		this.adresseDeLivraison = _adresseDeLivraison;
		this.listMeuble = _listMeuble;
		this.listLivraison = _listLivraison;
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


	public List<meuble> getListMeuble() {
		return listMeuble;
	}


	public void setListMeuble(List<meuble> listMeuble) {
		this.listMeuble = listMeuble;
	}


	public List<livraison> getListLivraison() {
		return listLivraison;
	}


	public void setListLivraison(List<livraison> listLivraison) {
		this.listLivraison = listLivraison;
	}
	
	

}
