package model;

import java.util.List;

public class livraison {
	private String dateHeureLivraison; //TODO change to LocalDateTime 
	private List<meuble> listMeuble;
	
	public livraison(String _dateHeureLivraison,List<meuble> _listMeuble) {
				this.dateHeureLivraison = _dateHeureLivraison;
				this.listMeuble = _listMeuble;
	}
	
	public livraison(String _dateHeureLivraison) {
		this.dateHeureLivraison = _dateHeureLivraison;
}
	
	
	public String getDateHeureLivraison() {
		return dateHeureLivraison;
	}
	public void setDateHeureLivraison(String dateHeureLivraison) {
		this.dateHeureLivraison = dateHeureLivraison;
	}


	public List<meuble> getListMeuble() {
		return listMeuble;
	}


	public void setListMeuble(List<meuble> listMeuble) {
		this.listMeuble = listMeuble;
	}

	
	

}
