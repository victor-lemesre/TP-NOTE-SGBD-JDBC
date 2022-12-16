package model;

import java.time.LocalDateTime;
import java.util.List;

public class livraison {
	private LocalDateTime dateHeureLivraison;
	private List<meuble> listMeuble;
	
	public livraison(LocalDateTime _dateHeureLivraison,List<meuble> _listMeuble) {
				this.dateHeureLivraison = _dateHeureLivraison;
				this.listMeuble = _listMeuble;
	}
	
	
	public LocalDateTime getDateHeureLivraison() {
		return dateHeureLivraison;
	}
	public void setDateHeureLivraison(LocalDateTime dateHeureLivraison) {
		this.dateHeureLivraison = dateHeureLivraison;
	}


	public List<meuble> getListMeuble() {
		return listMeuble;
	}


	public void setListMeuble(List<meuble> listMeuble) {
		this.listMeuble = listMeuble;
	}

	
	

}
