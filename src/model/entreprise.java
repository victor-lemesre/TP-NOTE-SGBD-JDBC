package model;

import java.util.List;

public class entreprise extends client_parent {
	private Integer numeroTVA;
	private String nomSociete;
	private List<telephone> listTelephone;

	public entreprise(String _adresse, List<contrat> _listContrat, Integer _numeroTVA, String _nomSociete,List<telephone> _listTelephone) {
		super(_adresse, _listContrat);
		this.numeroTVA = _numeroTVA;
		this.nomSociete = _nomSociete;
		this.listTelephone = _listTelephone;
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

	public List<telephone> getListTelephone() {
		return listTelephone;
	}

	public void setListTelephone(List<telephone> listTelephone) {
		this.listTelephone = listTelephone;
	}
	

}
