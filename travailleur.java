package user;

public class travailleur implements user {
	private String nom;
	private String prenom;
	private String code;
	private String password;
	
	public travailleur(String nom,String prenom,String code,String password)
	{
		this.nom=nom;
		this.prenom=prenom;
		this.code=code;
		this.password=password;
	}
	

	public travailleur() {
		super();
	}


	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public void afficher(String ch) {
		System.out.println("nom: "+nom.toUpperCase()+"  prenom: "+prenom+"  code: "+code+"  password: "+password);
		
	}


	@Override
	public String toString() {
		return "travailleur [nom=" + nom + ", prenom=" + prenom + ", code=" + code + "]";
	}


	
	
}
