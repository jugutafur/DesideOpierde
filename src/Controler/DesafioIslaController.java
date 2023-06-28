package Controler;
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
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Label;
import javafx.util.Duration;
import Model.Tiempo;
import Model.Puntuacion;
import java.io.IOException;


public class DesafioIslaController implements Initializable {

    @FXML
    private Button ContinuarDesafioIsla;

    @FXML
    private Button BotonFogata;

    @FXML
    private Button BotonRemar;

    @FXML
    private Button BotonNadar;

    @FXML
    private Label PuntuacionLabel;

    private Puntuacion puntuacion;

    @FXML
    private Label TiempoLabel;

    private Stage nuevaVentana;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Tiempo.iniciarCronometro(TiempoLabel, this::abrirNuevaVentana);
        puntuacion = Puntuacion.getInstance();
        actualizarPuntuacion();
    }

    @FXML
    public void aumentarPuntuacionBotonFogata() {
        puntuacion.aumentarPuntuacion(20);
        actualizarPuntuacion();
        ContinuarDesafioIsla.setVisible(true);
       // mostrarAlerta("Obtuviste 20 puntos");
    }

    @FXML
    public void aumentarPuntuacionBotonRemar() {
        puntuacion.aumentarPuntuacion(5);
        actualizarPuntuacion();
        ContinuarDesafioIsla.setVisible(true);
       // mostrarAlerta("Obtuviste 5 puntos");
    }

    @FXML
    public void aumentarPuntuacionBotonNadar() {
        puntuacion.aumentarPuntuacion(0);
        actualizarPuntuacion();
        ContinuarDesafioIsla.setVisible(true);
        //mostrarAlerta("Obtuviste 0 puntos");
    }

    private void actualizarPuntuacion() {
        PuntuacionLabel.setText(Integer.toString(puntuacion.getPuntuacion()));
    }
    @FXML
    private void handleContinuarIsla (ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/DesafioSelva.fxml"));
            Parent root = loader.load();

            //Abrir Vista Iniciar
            DesafioSelvaController DesafioSelvaController = loader.getController();

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.showAndWait();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    //finaliza posible error codigo

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
