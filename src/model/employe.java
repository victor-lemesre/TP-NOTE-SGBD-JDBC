package model;

public class employe {
	private String domaine;
	private contrat contrat;
	
	public employe(String _domaine,contrat _contrat) {
		this.domaine = _domaine;
		this.contrat = _contrat;
	}

	public String getDomaine() {
		return domaine;
	}

	public void setDomaine(String domaine) {
		this.domaine = domaine;
	}

	public contrat getContrat() {
		return contrat;
	}

	public void setContrat(contrat contrat) {
		this.contrat = contrat;
	}
	
	

}
