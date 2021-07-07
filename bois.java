package bois;

public class bois {
	protected String code_article;
	protected String quantite;
	protected String epaisseur;
	protected String longueur;
	protected String largeur;
	protected String prix_unite;
	protected String nom_complet;
	
	protected String choix;
	protected String couleur;
	
	public bois() {}

	
	
	public bois(String code_article, String quantite, String epaisseur, String longueur, String largeur,String prix_unite,
			String nom_complet, String choix, String couleur) {
		super();
		this.code_article = code_article;
		this.quantite = quantite;
		this.epaisseur = epaisseur;
		this.longueur = longueur;
		this.largeur = largeur;
		this.prix_unite = prix_unite;
		this.nom_complet = nom_complet;
		this.choix = choix;
		this.couleur = couleur;
	}



	public String getChoix() {
		return choix;
	}

	public void setChoix(String choix) {
		this.choix = choix;
	}

	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	
	public String getEpaisseur() {
		return epaisseur;
	}

	public void setEpaisseur(String epaisseur) {
		this.epaisseur = epaisseur;
	}

	public String getLongueur() {
		return longueur;
	}

	public void setLongueur(String longueur) {
		this.longueur = longueur;
	}

	public String getLargeur() {
		return largeur;
	}

	public void setLargeur(String largeur) {
		this.largeur = largeur;
	}

	public String getCode_article() {
		return code_article;
	}

	public void setCode_article(String code_article) {
		this.code_article = code_article;
	}

	
	
	public String getPrix_unite() {
		return prix_unite;
	}

	public void setPrix_unite(String prix_unite) {
		this.prix_unite = prix_unite;
	}

	public String getNom_complet() {
		return nom_complet;
	}

	public void setNom_complet(String nom_complet) {
		this.nom_complet = nom_complet;
	}









	public String getQuantite() {
		return quantite;
	}



	public void setQuantite(String quantite) {
		this.quantite = quantite;
	}



	@Override
	public String toString() {
		return "bois [code_article=" + code_article + ", quantite=" + quantite + ", epaisseur=" + epaisseur
				+ ", longueur=" + longueur + ", largeur=" + largeur + ", prix_unite=" + prix_unite + ", nom_complet="
				+ nom_complet + ", choix=" + choix + ", couleur=" + couleur + "]";
	}

	

	
	
	
	
	
}
