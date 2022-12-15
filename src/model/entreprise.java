package model;

import java.util.ArrayList;

public class entreprise extends client_parent{
	private Integer numeroTVA;
	private String nomSociete;
	
	public entreprise(String _adresse,Integer _numeroTVA, String _nomSociete) {
		super(_adresse);
		this.numeroTVA = _numeroTVA;
		this.nomSociete = _nomSociete;
	}
	
	public Integer getNumeroTVA() {
		return numeroTVA;
	}
	public void setNumeroTVA(Integer numeroTVA) {
		this.numeroTVA = numeroTVA;
	}
	public String getNomSociete() {
		return nomSociete;
	}
	public void setNomSociete(String nomSociete) {
		this.nomSociete = nomSociete;
	}
	
	

}
