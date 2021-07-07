package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import bois.bois;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import stock.stock;

public class modif_prodController implements Initializable {
	public TextField code_art;
	public TextField nom_art;
	public TextField choix;
	public TextField epaisseur;
	public TextField largeur;
	public TextField longueur;
	public TextField couleur;
	public TextField Prix_U;
	public TextField quantite;
	public Button change;
	
	public Button exit;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
public void exit(MouseEvent mouseEvent) {
		
	    Stage stage=(Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
		stage.close();
	
}
public void change(ActionEvent event) throws IOException  {
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
	
	stock.modifier_article(b);
	
	
}
}
