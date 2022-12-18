package model;

public class meuble {
	private String typeMeuble;
	private Float prix;
	private Float longueur;
	private Float largeur;
	private Float hauteur;
	private String fournisseur;
	private Boolean estReserve;
	

	
	public meuble(String _typeMeuble,Float _prix,Float _longueur, Float _largeur, Float _hauteur, String _fournisseur,Boolean _estReserve) {
		this.typeMeuble = _typeMeuble;
		this.prix = _prix;
		this.longueur = _longueur;
		this.largeur = _largeur;
		this.hauteur = _hauteur;
		this.fournisseur = _fournisseur;
		this.estReserve = _estReserve;
	}

	
	
	public String getTypeMeuble() {
		return typeMeuble;
	}



	public void setTypeMeuble(String typeMeuble) {
		this.typeMeuble = typeMeuble;
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
	
	@Override
	public String toString() {
		String dispo;
		if(this.estReserve) {
			dispo = "non";
		}else {
			dispo = "oui";
		}
		String result = "typeMeuble = "+ this.typeMeuble+" prix = "+this.prix+"|longueur = "+this.longueur+"|largeur = "+this.largeur+"|hauteur = "+this.hauteur+"|fournisseur = "+this.fournisseur+"|disponible"+dispo
				+"\n___________________________________________________________________________________________________________________________";
		return result;
	}

	
	

}
