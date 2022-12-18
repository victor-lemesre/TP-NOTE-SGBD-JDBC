package model;

import java.util.List;

public class particulier extends client_parent{
	private String nom;
	private String prenom;
	private String telephone;
	
	public particulier(String _adresse,List<contrat> _listContrat,String _nom,String _prenom,String _telephone) {
		super(_adresse,_listContrat);
		this.nom = _nom;
		this.prenom = _prenom;
		this.telephone = _telephone;
		
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	public String tostring() {
		String result = "_________________________________________________________________________________________\n"
				+ "nom: "+ this.nom+"\nprenom: "+prenom+"\nadresse: "+super.getAdresse()+"\ntelephone: "+telephone
				+"\n_________________________________________________________________________________________\n";
		return result;
	}
	
	

}
