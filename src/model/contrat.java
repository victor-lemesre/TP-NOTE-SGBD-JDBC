package model;

import java.util.List;

public class contrat {
	private String dateDeConclusion; 
	private String adresseDeLivraison;
	private List<meuble> listMeuble;
	private List<livraison> listLivraison;
	
	public contrat(String _dateDeConclusion, String _adresseDeLivraison,List<meuble> _listMeuble,List<livraison> _listLivraison) {
		this.dateDeConclusion = _dateDeConclusion;
		this.adresseDeLivraison = _adresseDeLivraison;
		this.listMeuble = _listMeuble;
		this.listLivraison = _listLivraison;
	}
	
	public contrat(String _dateDeConclusion, String _adresseDeLivraison) {
		this.dateDeConclusion = _dateDeConclusion;
		this.adresseDeLivraison = _adresseDeLivraison;
	}
	
	
	public String getDateDeConclusion() {
		return dateDeConclusion;
	}
	public void setDateDeConclusion(String dateDeConclusion) {
		this.dateDeConclusion = dateDeConclusion;
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
	
	@Override
	public String toString() {
		String result;
		String livre;
		String meuble="";
		if(listLivraison != null) {
			livre = "oui";
		}else {
			livre = "non";
		}
		for(meuble m : listMeuble) {
			meuble += "\n			-"+m.getTypeMeuble();
		}
		result = "_________________________________________________________________________________________\n"
				+ "date de conclusion = "+this.dateDeConclusion+"|adresse de divraison = "+this.adresseDeLivraison+"|est livre = "+livre+""
				+ "\n liste des meubles"+meuble
				+"\n_________________________________________________________________________________________\n";
		return result;
	}

}
