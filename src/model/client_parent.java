package model;

import java.util.List;

public class client_parent {
	private String adresse;
	private List<contrat> listContrat;
	

	public client_parent(String _adresse,List<contrat> _listContrat) {
		this.adresse = _adresse;
		this.listContrat = _listContrat;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public List<contrat> getListContrat() {
		return listContrat;
	}

	public void setListContrat(List<contrat> listContrat) {
		this.listContrat = listContrat;
	}
	
	

}
