package Controler;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static javafx.application.Application.launch;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
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
import javafx.util.Duration;

/**
 * Controlador para la vista del desafío de incendio.
 */

public class DesafioIncendioController implements Initializable {

    @FXML
    private Button IncendioContinuar;

    @FXML
    private Button BotonNohacernd;

    @FXML
    private Button BotonZonaSegura;

    @FXML
    private Button BotonApagarIncendio;

    @FXML
    private Label PuntuacionLabel;

    private Puntuacion puntuacion;

    @FXML
    private Label TiempoLabel;
    private Timeline timeline;

    private Stage NuevaVentana;
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
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        puntuacion = Puntuacion.getInstance();
        actualizarPuntuacion();
        timeline = new Timeline(new KeyFrame(Duration.seconds(1), this::actualizarTemporizador));

        timeline.setCycleCount(Timeline.INDEFINITE); // Repetir indefinidamente
        timeline.play();
    }

    @FXML
    public void aumentarPuntuacionBotonZonaSegura() {
        puntuacion.aumentarPuntuacion(20);
        actualizarPuntuacion();
        IncendioContinuar.setVisible(true);
        BotonApagarIncendio.setDisable(true);
        BotonZonaSegura.setDisable(true);
        BotonApagarIncendio.setDisable(true);
        timeline.stop();
        // mostrarAlerta("Obtuviste 20 puntos");
    }

    @FXML
    public void aumentarPuntuacionBotonApagarIncendio() {
        puntuacion.aumentarPuntuacion(5);
        actualizarPuntuacion();
        IncendioContinuar.setVisible(true);
        BotonApagarIncendio.setDisable(true);
        BotonZonaSegura.setDisable(true);
        BotonApagarIncendio.setDisable(true);
        timeline.stop();
        // mostrarAlerta("Obtuviste 5 puntos");
    }

    @FXML
    public void  aumentarPuntuacionBotonNohacernd() {
        puntuacion.aumentarPuntuacion(0);
        actualizarPuntuacion();
        IncendioContinuar.setVisible(true);
        BotonApagarIncendio.setDisable(true);
        BotonZonaSegura.setDisable(true);
        BotonApagarIncendio.setDisable(true);
        timeline.stop();
        //mostrarAlerta("Obtuviste 0 puntos");
    }

    private void actualizarPuntuacion() {
        PuntuacionLabel.setText(Integer.toString(puntuacion.getPuntuacion()));
    }

    @FXML
    private void SiguienteEscenaIncendio (ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/DesafioInundacion.fxml"));
            Parent root = loader.load();

            //Abrir Vista Iniciar
            DesafioInundacionController DesafioInundacionController = loader.getController();

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
