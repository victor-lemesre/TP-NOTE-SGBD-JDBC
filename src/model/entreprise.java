package model;

import java.util.List;

public class entreprise extends client_parent {
	private String numeroTVA;
	private String nomSociete;
	private List<telephone> listTelephone;

	public entreprise(String _adresse, List<contrat> _listContrat, String _numeroTVA, String _nomSociete,List<telephone> _listTelephone) {
		super(_adresse, _listContrat);
		this.numeroTVA = _numeroTVA;
		this.nomSociete = _nomSociete;
		this.listTelephone = _listTelephone;
	}

	public String getNumeroTVA() {
		return numeroTVA;
	}

	public void setNumeroTVA(String numeroTVA) {
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
	
	public String tostring() {
		String listTel="";
		for(telephone t : this.listTelephone) {
			listTel += "		-"+t.getNumTelephone()+"\n";
		}
		String result = "_________________________________________________________________________________________\n"
				+ "nom de la societe: "+ this.nomSociete+"\nnumero de TVA: "+this.numeroTVA+"\nadresse: "+super.getAdresse()+"\ntelephone(s): \n"+listTel
				+"_________________________________________________________________________________________\n";;
		return result;
	}

}
