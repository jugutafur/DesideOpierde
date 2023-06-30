package Controler;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.application.Application.launch;

import Model.Puntuacion;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import Model.Usuario;
import javafx.scene.control.Label;
public class GanasteController implements Initializable {

    @FXML
    private Button Reintentar3;

    @FXML
    private Button Salir3;

    @FXML
    private Label Jugador1;

    @FXML
    private void ActivarReintentar3(ActionEvent event) {
        Puntuacion.getInstance().reiniciarPuntuacion();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/Instrucciones.fxml"));
            Parent root = loader.load();

            //Abrir Vista Iniciar
            InstruccionesController InstruccionesController = loader.getController();

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.showAndWait();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    private void ActivarSalir3(ActionEvent event) {
        try {

            System.exit(0);


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override

    public void initialize(URL url, ResourceBundle rb) {
        String nombreUsuario = Usuario.getNombreUsuario();
        Jugador1.setText(nombreUsuario);
    }


}
