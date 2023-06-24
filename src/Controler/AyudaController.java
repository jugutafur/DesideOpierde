package Controler;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.stage.Stage;


public class AyudaController implements Initializable {

//probable error de codigo inicia aqui
@FXML
private Button BotonVolver ;    

    @FXML
    private void handleButtonClick(ActionEvent event) {
        Stage stage = (Stage) BotonVolver.getScene().getWindow();
        stage.close();
    }

    //probable error de codigo finaliza aqui

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
}
