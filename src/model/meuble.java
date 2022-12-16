package model;

public class meuble {
	private Float prix;
	private Float longueur;
	private Float largeur;
	private Float hauteur;
	private String fournisseur;
	private Boolean estReserve;
	

	
	public meuble(Float _prix,Float _longueur, Float _largeur, Float _hauteur, String _fournisseur,Boolean _estReserve) {
		this.prix = _prix;
		this.longueur = _longueur;
		this.largeur = _largeur;
		this.hauteur = _hauteur;
		this.fournisseur = _fournisseur;
		this.estReserve = _estReserve;
	}

	
	
	public Float getPrix() {
		return prix;
	}
	public void setPrix(Float prix) {
		this.prix = prix;
	}
	
	public Float getLongueur() {
		return longueur;
	}
	public void setLongueur(Float longueur) {
		this.longueur = longueur;
	}
	
	public Float getLargeur() {
		return largeur;
	}
	public void setLargeur(Float largeur) {
		this.largeur = largeur;
	}
	
	public Float getHauteur() {
		return hauteur;
	}
	public void setHauteur(Float hauteur) {
		this.hauteur = hauteur;
	}
	
	public String getFournisseur() {
		return fournisseur;
	}
	public void setFournisseur(String fournisseur) {
		this.fournisseur = fournisseur;
	}


	public Boolean getEstReserve() {
		return estReserve;
	}


	public void setEstReserve(Boolean estReserve) {
		this.estReserve = estReserve;
	}
	

	
	

}
