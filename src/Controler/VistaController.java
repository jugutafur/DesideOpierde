package Controler;

import javafx.fxml.FXML;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
/**
 * Controlador para gestionar la vista del menu principal.
 */
public class VistaController implements Initializable {

    /**
     * @fxml btnAayuda permite establecer una relacion entre la ID de un boton ubicado en la vista hacia el controlador en este caso el boton de ayuda
     *
     * @fxml btnIniciar permite establecer una relacion entre la ID de un boton ubicado en la vista hacia el controlador en este caso el boton de iniciar
     */
    @FXML
    private Button btnIniciar;
    
    @FXML
    private Button btnAyuda;
    /**
     * inicia el controlador después de que se haya cargado la interfaz de usuario.
     *
     * @param url  La ubicación utilizada para resolver rutas relativas para el objeto raíz o null si la ubicación no es conocida.
     * @param rb   El recurso del paquete utilizado para localizar el objeto raíz o null si el recurso no se encuentra.
     */

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    /**
     * Abre la vista Iniciar cuando se hace clic en el botón "Iniciar".
     *
     * @param event evento tipo accion que permite la apertura de la vista iniciar.
     */

    @FXML
    private void abrirIniciar(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/Iniciar.fxml"));
            Parent root = loader.load();

            //Abrir Vista Iniciar
            IniciarController iniciarController = loader.getController();

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.showAndWait();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    /**
     * Abre la vista Ayuda cuando se hace clic en el botón "Ayuda".
     *
     * @param event   evento de tipo accion que permite la apertura de la vista "Ayuda".
     */
    @FXML
    private void abrirAyuda(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/Ayuda.fxml"));
            Parent root = loader.load();

            //Abrir Vista Iniciar
            AyudaController ayudaController = loader.getController();

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.showAndWait();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
