package Controler;
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

    private Stage nuevaVentana2;
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
    }
    /**
     * Método para aumentar la puntuación al hacer clic en el botón "Zona Segura".
     * Aumenta la puntuación en 20 y actualiza la puntuación en la interfaz.
     * Hace visible el botón "IncendioContinuar".
     */
    @FXML
    public void aumentarPuntuacionBotonZonaSegura() {
        puntuacion.aumentarPuntuacion(20);
        actualizarPuntuacion();
        IncendioContinuar.setVisible(true);
        // mostrarAlerta("Obtuviste 20 puntos");
    }

    @FXML
    public void aumentarPuntuacionBotonApagarIncendio() {
        puntuacion.aumentarPuntuacion(5);
        actualizarPuntuacion();
        IncendioContinuar.setVisible(true);
        // mostrarAlerta("Obtuviste 5 puntos");
    }

    @FXML
    public void  aumentarPuntuacionBotonNohacernd() {
        puntuacion.aumentarPuntuacion(0);
        actualizarPuntuacion();
        IncendioContinuar.setVisible(true);
        //mostrarAlerta("Obtuviste 0 puntos");
    }

    private void actualizarPuntuacion() {
        PuntuacionLabel.setText(Integer.toString(puntuacion.getPuntuacion()));
    }
    /**
     * Método para avanzar a la siguiente escena (Desafío de inundación).
     * Se ejecuta al hacer clic en el botón "IncendioContinuar".
     *
     * @param event El evento de acción.
     */
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


    //finaliza posible error codigo

    // Método para abrir la nueva ventana

}
