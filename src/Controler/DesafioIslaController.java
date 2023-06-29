package Controler;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static javafx.application.Application.launch;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import Model.Puntuacion;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.util.Duration;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;


/**
 * Controlador para la vista del desafío de la isla.
 */

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

    private Stage NuevaVentana;

    private Timeline timeline;
    private int tiempoRestante = 30; // 2 minutos en segundos

    private void actualizarTemporizador(ActionEvent event) {
        int minutos = tiempoRestante / 60;
        int segundos = tiempoRestante % 60;
        TiempoLabel.setText(String.format("%02d:%02d", minutos, segundos));

        if (tiempoRestante > 0) {
            tiempoRestante--;
        } else {
            // Si el tiempo ha llegado a 0, detener el temporizador y abrir la nueva ventana
            timeline.stop();
            timeline.stop();
            abrirNuevaVentana();

        }
    }

    /**
     * Método inicializador del controlador.
     * Se llama automáticamente al cargar la vista.
     *
     * @param url            URL de la ubicación del objeto de raíz.
     * @param resourceBundle El paquete de recursos utilizado por el objeto de raíz.
     */



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        puntuacion = Puntuacion.getInstance();
        actualizarPuntuacion();
        timeline = new Timeline(new KeyFrame(Duration.seconds(1), this::actualizarTemporizador));

        timeline.setCycleCount(Timeline.INDEFINITE); // Repetir indefinidamente
        timeline.play();

    }
    /**
     * Método para aumentar la puntuación al hacer clic en el botón "Fogata".
     * Aumenta la puntuación en 20 y actualiza la puntuación en la interfaz.
     * Hace visible el botón "ContinuarDesafioIsla".
     */
//prob code error

    //prob code error

    @FXML
    public void aumentarPuntuacionBotonFogata() {
        puntuacion.aumentarPuntuacion(20);
        actualizarPuntuacion();
        ContinuarDesafioIsla.setVisible(true);
        BotonFogata.setDisable(true);
        BotonRemar.setDisable(true);
        BotonNadar.setDisable(true);
        timeline.stop();
       // mostrarAlerta("Obtuviste 20 puntos");
    }
    /**
     * Método para aumentar la puntuación al hacer clic en el botón "Remar".
     * Aumenta la puntuación en 5 y actualiza la puntuación en la interfaz.
     * Hace visible el botón "ContinuarDesafioIsla".
     */
    @FXML
    public void aumentarPuntuacionBotonRemar() {
        puntuacion.aumentarPuntuacion(5);
        actualizarPuntuacion();
        ContinuarDesafioIsla.setVisible(true);
        BotonRemar.setDisable(true);
        BotonFogata.setDisable(true);
        BotonNadar.setDisable(true);
        timeline.stop();
       // mostrarAlerta("Obtuviste 5 puntos");
    }
    /**
     * Método para aumentar la puntuación al hacer clic en el botón "Nadar".
     * No aumenta la puntuación y actualiza la puntuación en la interfaz.
     * Hace visible el botón "ContinuarDesafioIsla".
     */

    @FXML
    public void aumentarPuntuacionBotonNadar() {
        puntuacion.aumentarPuntuacion(0);
        actualizarPuntuacion();
        ContinuarDesafioIsla.setVisible(true);
        BotonNadar.setDisable(true);
        BotonRemar.setDisable(true);
        BotonFogata.setDisable(true);
        timeline.stop();
        //mostrarAlerta("Obtuviste 0 puntos");
    }
    /**
     * Actualiza la puntuación mostrada en la interfaz.
     */
    private void actualizarPuntuacion() {
        PuntuacionLabel.setText(Integer.toString(puntuacion.getPuntuacion()));
    }
    /**
     * Método para manejar el evento de clic en el botón "ContinuarDesafioIsla".
     * Se ejecuta al hacer clic en el botón y abre la siguiente escena (Desafío de la selva).
     *
     * @param event El evento de acción.
     */

    @FXML
    private void handleContinuarIsla (ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/DesafioSelva.fxml"));
            Parent root = loader.load();

            // Obtén el controlador de la nueva vista
            DesafioSelvaController DesafioSelvaController = loader.getController();
            // Pasa el valor del tiempo restante a la nueva vista



            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.showAndWait();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void abrirNuevaVentana() {

        // Crear una instancia de FXMLLoader para cargar el contenido de la nueva ventana desde un archivo FXML
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/FinTiempo.fxml"));

        try {
            Parent root = loader.load(); // Cargar el contenido del archivo FXML en un objeto Parent

            NuevaVentana = new Stage();
            NuevaVentana.setTitle("Nueva Ventana");
            NuevaVentana.setScene(new Scene(root));
            NuevaVentana.show();;

        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}




