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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import users.users;
import user.*;
public class loginController implements Initializable{
	public TextField Nom;
	public PasswordField password;
	public Button login;
	public Button exit;
	public ChoiceBox <String> choix;
	
	public void exit(MouseEvent mouseEvent) {
		
		    Stage stage=(Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
			stage.close();
		
	}
	@FXML
	public void login(ActionEvent event) throws IOException {
		
		
		
		users us=new users();
		String passw=password.getText();
	    String choice=choix.getValue();
	    
		
			
		if( choice.equals("directeur")&& us.getDirec().getPassword().equals(passw)) {
			Parent add=FXMLLoader.load(getClass().getResource("directeur.fxml"));
		     Scene scene=new Scene(add);
		     Stage app_stage=(Stage) ((Node) event.getSource()).getScene().getWindow();
		     app_stage.setScene(scene);
		     app_stage.show();
		}
		if(choice.equals("responsable_stock") && us.getResp_stock().getPassword().equals(passw)) {
			Parent add=FXMLLoader.load(getClass().getResource("responsable_stock.fxml"));
		     Scene scene=new Scene(add);
		     Stage app_stage=(Stage) ((Node) event.getSource()).getScene().getWindow();
		     app_stage.setScene(scene);
		     app_stage.show();
		}
		if(choice.equals("travailleur") && !us.getTra(passw).equals(null)) {
			Parent add=FXMLLoader.load(getClass().getResource("travailleur.fxml"));
		     Scene scene=new Scene(add);
		     Stage app_stage=(Stage) ((Node) event.getSource()).getScene().getWindow();
		     app_stage.setScene(scene);
		     app_stage.show();
		}
	}
	
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
		choix.getItems().addAll("directeur","responsable_stock","travailleur");
			
	}

	public ChoiceBox getChoice(){
		return choix;
		
	}
}
