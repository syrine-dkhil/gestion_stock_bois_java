package users;
import java.sql.*;
import java.util.ArrayList;
import user.directeur;
import user.responsable_stock;	
import user.travailleur;
import java.sql.SQLException;
import com.mysql.cj.jdbc.exceptions.SQLError;

public class users{
	public directeur direc;
	public responsable_stock resp_stock;
	public ArrayList<travailleur> List_Travailleur;
	
	public users() {
		List_Travailleur=new ArrayList<travailleur>();
	}

	public static Connection connexion()throws Exception{
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC" ,"root","root");
	return con;
	}

	
	public directeur getDirec() {
		ResultSet myRs=null;
		try {
			Connection con=connexion();
			Statement myStmt=con.createStatement();
			 myRs=myStmt.executeQuery("SELECT * FROM demo.employees WHERE profil='directeur';");
			//direc= new directeur(myRs.getString("nom"),myRs.getString("prenom"),myRs.getString("code"),myRs.getString("password"));
			//con.close();
			 while(myRs.next()) {
				 direc= new directeur(myRs.getString("nom"),myRs.getString("prenom"),myRs.getString("code"),myRs.getString("password"));
			 }
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return direc;
	}

	public  static void supp_trav(String code)
	{
		try {
			
			Connection con=connexion();
			Statement myStmt=con.createStatement();
			int myRs=myStmt.executeUpdate("DELETE FROM `demo`.`employees` WHERE (`code` = '"+code+"');");
			
				
			
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}
	
	public void setDirec(directeur direc) {
		this.direc = direc;
		try {
			Connection con=connexion();
			Statement myStmt=con.createStatement();
			int myRs=myStmt.executeUpdate("UPDATE `demo`.`employees` SET `prenom` = '"+direc.getPrenom()+"', `nom` = '"+direc.getNom()+"' , `code` = '"+direc.getCode()+"' , `password` = '"+direc.getPassword()+"' WHERE (`profil` = 'directeur');");
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	public responsable_stock getResp_stock()  {
		responsable_stock resp_stock=null;
		try {
			Connection con=connexion();
			Statement myStmt=con.createStatement();
			ResultSet myRs=myStmt.executeQuery("SELECT * FROM demo.employees WHERE profil='responsable_stock';");
			while(myRs.next()) {
			resp_stock= new responsable_stock(myRs.getString("nom"),myRs.getString("prenom"),myRs.getString("code"),myRs.getString("password"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return resp_stock;
	}

	
	public void setResp_stock(responsable_stock resp_stock) {
		this.resp_stock = resp_stock;
		try {
			Connection con=connexion();
			Statement myStmt=con.createStatement();
			int myRs=myStmt.executeUpdate("UPDATE `demo`.`employees` SET `prenom` = '"+resp_stock.getPrenom()+"', `nom` = '"+resp_stock.getNom()+"' , `code` = '"+resp_stock.getCode()+"' , `password` = '"+resp_stock.getPassword()+"' WHERE (`profil` = 'responsable_stock');");
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	public ArrayList<travailleur> getList_Travailleur()  {
		try {
			Connection con=connexion();
			Statement myStmt=con.createStatement();
			ResultSet myRs=myStmt.executeQuery("SELECT * FROM demo.employees WHERE profil='travailleur';");
			while(myRs.next())
				List_Travailleur.add(new travailleur(myRs.getString("nom"),myRs.getString("prenom"),myRs.getString("code"),myRs.getString("password")));
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return List_Travailleur;
	}

	public travailleur getTra(String pass)
	{
		user.travailleur t= new travailleur();
		t=null;
		ResultSet myRs=null;
		try {
			Connection con=connexion();
			Statement myStmt=con.createStatement();
			 myRs=myStmt.executeQuery("SELECT * FROM demo.employees WHERE password='"+pass+"' ;");
			 while(myRs.next()) {
				  t= new travailleur(myRs.getString("nom"),myRs.getString("prenom"),myRs.getString("code"),myRs.getString("password"));
			 }
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return t;
	}
	
//initialisation_base_donnees
	public void setList_Travailleur(ArrayList<travailleur> list_Travailleur) {
		try {
			this.List_Travailleur =list_Travailleur ;
			Connection con=connexion();
			Statement myStmt=con.createStatement();
			int myRs=myStmt.executeUpdate("DELETE FROM `demo`.`employees`;");
			for(int i=0;i<list_Travailleur.size();i++)
				 myRs=myStmt.executeUpdate("INSERT INTO `demo`.`employees` (`code`, `nom`, `prenom`, `profil`, `password`) VALUES ('"+list_Travailleur.get(i).getCode()+"', '"+list_Travailleur.get(i).getNom()+"', '"+list_Travailleur.get(i).getPrenom()+"', 'travailleur', '"+list_Travailleur.get(i).getPassword()+"');");
				
			
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		
	}
//insertion d'un nouveau travailleur dans ma BD
	public static void ajouter_travailleur(travailleur t){
		try {
			
			Connection con=connexion();
			Statement myStmt=con.createStatement();
			int myRs=myStmt.executeUpdate("INSERT INTO `demo`.`employees` (`code`, `nom`, `prenom`, `profil`, `password`) VALUES ('"+t.getCode()+"', '"+t.getNom()+"', '"+t.getPrenom()+"', 'travailleur', '"+t.getPassword()+"');");
				
			
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) 
	{
		users us=new users();
	
			//us.resp_stock=us.getResp_stock();
		
			/*try {
				System.out.println(us.resp_stock.toString());
			}catch(Exception ex) {
				System.out.println("pas de responsable!!!!");
			}*/
		us.ajouter_travailleur(new travailleur("iyed","kkkk","165","jkfkr"));
		//us.List_Travailleur=us.getList_Travailleur();
		us.List_Travailleur.forEach(System.out::println);
		us.getList_Travailleur().forEach(System.out::println);
	}
}

