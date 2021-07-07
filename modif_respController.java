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
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import user.responsable_stock;
import user.travailleur;
import users.users;

public class modif_respController implements Initializable {

	public TextField code;
	public TextField nom;
	public TextField prenom;
	public TextField password;
	
	public void change(ActionEvent event) throws IOException  {
		responsable_stock t =new responsable_stock(nom.getText(),prenom.getText(),code.getText(),password.getText());
		
		users us=new users();
		us.setResp_stock(t);
		
	}
	
	public void back(ActionEvent event) throws IOException  {
		Parent add=FXMLLoader.load(getClass().getResource("directeur.fxml"));
	     Scene scene=new Scene(add);
	     Stage app_stage=(Stage) ((Node) event.getSource()).getScene().getWindow();
	     app_stage.setScene(scene);
	     app_stage.show();
	}
	
public void exit(ActionEvent event) {
		
	    Stage stage=(Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.close();
	
}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}


