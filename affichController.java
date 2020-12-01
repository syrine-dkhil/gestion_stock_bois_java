package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

import bois.bois;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import stock.stock;

public class affichController implements Initializable {
	
	
	
	
	public TableView table;
	public TableColumn codes_art;
	public TableColumn nom_art ;
	public TableColumn choix ;
	public TableColumn epaisseur;
	public TableColumn largeur;
	public TableColumn longueur;
	public TableColumn couleur;
	public TableColumn Prix_U;
	public TableColumn quantite;
	public Button exit;
	
	public ObservableList<bois> getstock(){
		ObservableList<bois> st=FXCollections.observableArrayList();
		bois b=new bois();
		for(int i=0;i<stock.count();i++) {
			b=fetchbois(i);
			st.add(b);
		}
		return(st);
	}
	public bois fetchbois(int rang) {
		 bois b=new bois();
		try {
			Connection con=stock.connexion();
			Statement myStmt=con.createStatement();
			ResultSet myRs=myStmt.executeQuery("SELECT * FROM demo.stock;");
			for(int i=0;i<=rang;i++) {
				myRs.next();}
			 b=new bois(myRs.getString("code_art"), myRs.getString("quantite"),myRs.getString("epaisseur"), myRs.getString("longueur"),myRs.getString("largeur"),myRs.getString("Prix_U"),
						myRs.getString("nom_art"),myRs.getString("choix"),myRs.getString("couleur"));
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;
		
	}

public void exit(MouseEvent mouseEvent) {
		
	    Stage stage=(Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
		stage.close();
	
}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		codes_art.setCellValueFactory(new PropertyValueFactory<bois,String>("code_article"));
		couleur.setCellValueFactory(new PropertyValueFactory<bois,String>("couleur"));
		nom_art.setCellValueFactory(new PropertyValueFactory<bois,String>("nom_complet"));
		choix.setCellValueFactory(new PropertyValueFactory<bois,String>("choix"));
		largeur.setCellValueFactory(new PropertyValueFactory<bois,String>("largeur"));
		longueur.setCellValueFactory(new PropertyValueFactory<bois,String>("longueur"));
		epaisseur.setCellValueFactory(new PropertyValueFactory<bois,String>("epaisseur"));
		Prix_U.setCellValueFactory(new PropertyValueFactory<bois,String>("prix_unite"));
		quantite.setCellValueFactory(new PropertyValueFactory<bois,String>("quantite"));
		table.setItems(getstock());
	}

}
