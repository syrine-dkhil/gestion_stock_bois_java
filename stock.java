package stock;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import bois.bois;


public class stock {
	
	private ArrayList<bois> LB;
	
	
	public stock() {
		this.LB=new ArrayList<bois>();
		
	}
	
	
	public static Connection connexion()throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC" ,"root","root");
		return con;
		}
	public static int count() {
		int n=0;
		try {
			Connection con=connexion();
			Statement myStmt=con.createStatement();
			ResultSet myRs=myStmt.executeQuery("SELECT COUNT(code_art) FROM demo.stock;");
			myRs.next();
			n=myRs.getInt("COUNT(code_art)");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return(n);
	}

	
	public static void modifier_article(bois b)
	{
		try {
			Connection con=connexion();
			Statement myStmt=con.createStatement();
			int myRs=myStmt.executeUpdate("UPDATE `demo`.`stock` SET `nom_art` = '"+b.getNom_complet()+"', `choix` = '"+b.getChoix()+"', `epaisseur` = '"+b.getEpaisseur()+"', `largeur` = '"+b.getLargeur()+"', `longueur` = '"+b.getLongueur()+"', `couleur` = '"+b.getCouleur()+"', `Prix_U` = '"+b.getPrix_unite()+"', `quantite` = '"+b.getQuantite()+"' WHERE (`code_art` = '"+b.getCode_article()+"');");
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void supprimer_article(String code)
	{
		try {
			Connection con=connexion();
			Statement myStmt=con.createStatement();
			int myRs=myStmt.executeUpdate("DELETE FROM `demo`.`stock` WHERE (`code_art` = '"+code+"');");
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void ajouter_article(bois b) {
		try {
			Connection con=connexion();
			Statement myStmt=con.createStatement();
			int myRs=myStmt.executeUpdate("INSERT INTO `demo`.`stock` (`code_art`, `nom_art`, `choix`, `epaisseur`, `largeur`, `longueur`, `couleur`, `Prix_U`, `quantite`) VALUES ('"+b.getCode_article()+"', '"+b.getNom_complet()+"', '"+b.getChoix()+"', '"+b.getEpaisseur()+"', '"+b.getLargeur()+"', '"+b.getLongueur()+"', '"+b.getCouleur()+"', '45', '444');");
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<bois> get_article()
	{
		try {
			Connection con=connexion();
			Statement myStmt=con.createStatement();
			ResultSet myRs=myStmt.executeQuery("SELECT * FROM demo.stock;");
			while(myRs.next())
				LB.add(new bois(myRs.getString("code_art"), myRs.getString("quantite"),myRs.getString("epaisseur"), myRs.getString("longueur"),myRs.getString("largeur"),myRs.getString("Prix_U"),
						myRs.getString("nom_art"),myRs.getString("choix"),myRs.getString("couleur")));
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return LB;
	}
}
