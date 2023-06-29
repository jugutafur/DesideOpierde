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


public class DesafioSelvaController implements Initializable {

    @FXML
    private Button BotonContinuarSelva;

    @FXML
    private Button BotonDomar;

    @FXML
    private Button BotonRoca;

    @FXML
    private Button BotonHuir;

    @FXML
    private Label PuntuacionLabel;

    private Puntuacion puntuacion;

    @FXML
    private Label TiempoLabel;

    private Stage nuevaVentana2;
    private int tiempoRestante;
    private Tiempo tiempo;

    public void reiniciarCronometro() {
        tiempoRestante = 2 * 60; // Reiniciar el tiempo restante a 2 minuto
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        puntuacion = Puntuacion.getInstance();
        actualizarPuntuacion();
        TiempoLabel.setText(Tiempo.formatearTiempo(tiempoRestante));
    }

    public void setTiempoRestante(int tiempoRestante) {
        this.tiempoRestante = tiempoRestante;
    }


    @FXML
    public void aumentarPuntuacionBotonRoca() {
        puntuacion.aumentarPuntuacion(20);
        actualizarPuntuacion();
        BotonContinuarSelva.setVisible(true);
        // mostrarAlerta("Obtuviste 20 puntos");
    }

    @FXML
    public void aumentarPuntuacionBotonHuir() {
        puntuacion.aumentarPuntuacion(5);
        actualizarPuntuacion();
        BotonContinuarSelva.setVisible(true);
        // mostrarAlerta("Obtuviste 5 puntos");
    }

    @FXML
    public void  aumentarPuntuacionBotonDomar() {
        puntuacion.aumentarPuntuacion(0);
        actualizarPuntuacion();
        BotonContinuarSelva.setVisible(true);
        //mostrarAlerta("Obtuviste 0 puntos");
    }

    private void actualizarPuntuacion() {
        PuntuacionLabel.setText(Integer.toString(puntuacion.getPuntuacion()));
    }
    @FXML
    private void ContinuarSelva (ActionEvent event) {
        try {
            reiniciarCronometro();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/DesafioIncendio.fxml"));
            Parent root = loader.load();

            //Abrir Vista Iniciar
            DesafioIncendioController DesafioIncendioController = loader.getController();

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

}
