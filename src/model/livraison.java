package model;

import java.time.LocalDateTime;

public class livraison {
	private LocalDateTime dateHeureLivraison;
	private contrat contrat;
	
	
	public LocalDateTime getDateHeureLivraison() {
		return dateHeureLivraison;
	}
	public void setDateHeureLivraison(LocalDateTime dateHeureLivraison) {
		this.dateHeureLivraison = dateHeureLivraison;
	}
	public contrat getContrat() {
		return contrat;
	}
	public void setContrat(contrat contrat) {
		this.contrat = contrat;
	}
	
	

}
