package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class responsable_stockController implements Initializable{

	public void afficher(ActionEvent event) throws IOException  {
		Parent add=FXMLLoader.load(getClass().getResource("afficher.fxml"));
	     Scene scene=new Scene(add);
	     Stage app_stage=(Stage) ((Node) event.getSource()).getScene().getWindow();
	     app_stage.setScene(scene);
	     app_stage.show();
	}
	
	public void ajouter(ActionEvent event) throws IOException  {
		Parent add=FXMLLoader.load(getClass().getResource("ajouter_prod.fxml"));
	     Scene scene=new Scene(add);
	     Stage app_stage=(Stage) ((Node) event.getSource()).getScene().getWindow();
	     app_stage.setScene(scene);
	     app_stage.show();
	}
	public void modifier(ActionEvent event) throws IOException  {
		Parent add=FXMLLoader.load(getClass().getResource("modif_prod.fxml"));
	     Scene scene=new Scene(add);
	     Stage app_stage=(Stage) ((Node) event.getSource()).getScene().getWindow();
	     app_stage.setScene(scene);
	     app_stage.show();
	}
	
	public void supprimer(ActionEvent event) throws IOException  {
		Parent add=FXMLLoader.load(getClass().getResource("suppr_prod.fxml"));
	     Scene scene=new Scene(add);
	     Stage app_stage=(Stage) ((Node) event.getSource()).getScene().getWindow();
	     app_stage.setScene(scene);
	     app_stage.show();
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
