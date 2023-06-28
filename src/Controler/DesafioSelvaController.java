package Controler;

import Model.Puntuacion;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.application.Application.launch;
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
import Model.Tiempo;

public class DesafioSelvaController implements Initializable {

    @FXML
    private Button BotonDomar;

    @FXML
    private Button BotonRoca;

    @FXML
    private Button BotonHuir;

    @FXML
    private Puntuacion puntuacion;

    @FXML
    private Label PuntuacionLabel;

    @FXML
    private Label TiempoLabel;

    @FXML
    private Stage nuevaVentana;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Tiempo.iniciarCronometro(TiempoLabel, this::abrirNuevaVentana);
        puntuacion = Puntuacion.getInstance();
        actualizarPuntuacion();
    }

    @FXML
    public void aumentarPuntuacionBotonDomar() {
        puntuacion.aumentarPuntuacion(0);
        actualizarPuntuacion();
        //mostrarAlerta("Obtuviste 20 puntos");
        abrirNuevaVista();
    }

    @FXML
    public void aumentarPuntuacionBotonRoca() {
        puntuacion.aumentarPuntuacion(20);
        actualizarPuntuacion();
        //mostrarAlerta("Obtuviste 5 puntos");
        abrirNuevaVista();
    }

    @FXML
    public void aumentarPuntuacionBotonHuir() {
        puntuacion.aumentarPuntuacion(5);
        actualizarPuntuacion();
        //mostrarAlerta("Obtuviste 0 puntos");
        abrirNuevaVista();
    }

    private void actualizarPuntuacion() {
        PuntuacionLabel.setText(Integer.toString(puntuacion.getPuntuacion()));
    }

    private void abrirNuevaVista() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/DesafioIncendio.fxml"));
            AnchorPane root = loader.load();

            Stage stage = new Stage();
            stage.setTitle("Nueva Vista");
            stage.setScene(new Scene(root));
            stage.show();

            // Cerrar la vista actual
            //Stage currentStage = (Stage) BotonDomar.getScene().getWindow();
            //currentStage.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

// Método para abrir la nueva ventana
    private void abrirNuevaVentana() {
        // Crear una instancia de FXMLLoader para cargar el contenido de la nueva ventana desde un archivo FXML
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/FinTiempo.fxml"));

        try {
            Parent root = loader.load(); // Cargar el contenido del archivo FXML en un objeto Parent

            // Crear una nueva instancia de Stage y configurarla
            nuevaVentana = new Stage();
            nuevaVentana.setTitle("Nueva Ventana");
            nuevaVentana.setScene(new Scene(root));
            nuevaVentana.show();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
