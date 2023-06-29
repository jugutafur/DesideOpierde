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

/**
 * Controlador que permite gestionar la vista de "Ayuda".
 */
public class AyudaController implements Initializable {


@FXML
private Button BotonVolver ;
    /**
     * Maneja el evento de clic en el botón "Volver".
     * Cierra la ventana actual .
     *
     * @param event Evento de acción que desencadena el cierre de la ventana.
     */
    @FXML
    private void handleButtonClick(ActionEvent event) {
        Stage stage = (Stage) BotonVolver.getScene().getWindow();
        stage.close();
    }



    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
}
