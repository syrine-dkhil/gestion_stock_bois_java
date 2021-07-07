package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class directeurController {
	Button ajout_trav;
	Button modif_trav;
	Button modif_resp;
	
	public void ajout_trav(ActionEvent event) throws IOException  {
		Parent add=FXMLLoader.load(getClass().getResource("ajout_trav.fxml"));
	     Scene scene=new Scene(add);
	     Stage app_stage=(Stage) ((Node) event.getSource()).getScene().getWindow();
	     app_stage.setScene(scene);
	     app_stage.show();
	}
	public void modif_resp(ActionEvent mouseEvent)throws Exception
	{
		Parent add=FXMLLoader.load(getClass().getResource("modif_resp.fxml"));
	     Scene scene=new Scene(add);
	     Stage app_stage=(Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
	     app_stage.setScene(scene);
	     app_stage.show();
	}
	
	public void modif_trav(ActionEvent mouseEvent)throws Exception
	{
		Parent add=FXMLLoader.load(getClass().getResource("modif_trav.fxml"));
	     Scene scene=new Scene(add);
	     Stage app_stage=(Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
	     app_stage.setScene(scene);
	     app_stage.show();
	}
	
}
