package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import bois.bois;
import stock.stock;
public class ajouter_prodController implements Initializable {

	public TextField code_art;
	public TextField nom_art;
	public TextField choix;
	public TextField epaisseur;
	public TextField largeur;
	public TextField longueur;
	public TextField couleur;
	public TextField Prix_U;
	public TextField quantite;
	public Button save;
	public Button back;
	public Button exit;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	public void save(ActionEvent event) throws IOException  {
		String code_art=this.code_art.getText();
		String nom_art=this.nom_art.getText();
		String choix=this.choix.getText();
		String epaisseur=this.epaisseur.getText();
		String largeur=this.largeur.getText();
		String longueur=this.longueur.getText();
		String couleur=this.couleur.getText();
		String Prix_U=this.Prix_U.getText();
		String quantite=this.quantite.getText();
		
		bois b=new bois( code_art, quantite,epaisseur,longueur, largeur, Prix_U,nom_art, choix,  couleur);
		
		stock.ajouter_article(b);
		
		
	}
	
	public void back(ActionEvent event) throws IOException  {
		Parent add=FXMLLoader.load(getClass().getResource("responsable_stock.fxml"));
	     Scene scene=new Scene(add);
	     Stage app_stage=(Stage) ((Node) event.getSource()).getScene().getWindow();
	     app_stage.setScene(scene);
	     app_stage.show();
	}
	public void exit(MouseEvent mouseEvent) {
		
	    Stage stage=(Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
		stage.close();
	
}
	

}
