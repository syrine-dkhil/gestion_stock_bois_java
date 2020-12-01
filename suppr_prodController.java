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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class suppr_prodController implements Initializable{

	public TextField code_art;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
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
	public void delete(ActionEvent event) throws IOException  {
		String code=this.code_art.getText();
		stock.stock.supprimer_article(code);
	}

}
