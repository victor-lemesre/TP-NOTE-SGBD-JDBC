package model;

public class employe {
	private String prenom;
	private String domaine;
	private contrat contrat;
	
	public employe(String _prenom,String _domaine,contrat _contrat) {
		this.setPrenom(_prenom);
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

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	

}
