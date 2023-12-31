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




/**
 * Controlador para gestionar la vista de "iniciar".
 */

public class IniciarController implements Initializable {
    //esta linea de codigo permite verificar nombre de usuario y da una alerta si el usuario escribio correctamente su nombre

    @FXML
    private Button BotonFlotante;

    @FXML
    private TextArea nombreUsuarioTextArea;


    /**
     * Maneja el evento del botón Guardar.
     *
     * @param event El evento de acción que desencadena el guardado del nombre de usuario.
     */

    @FXML
    private void handleGuardarButtonClick(ActionEvent event) {
        String nombreUsuario = nombreUsuarioTextArea.getText();
        if (verificarNombreUsuario(nombreUsuario)) {
            Usuario.setNombreUsuario(nombreUsuario);
            String mensajeFelicitaciones = "¡Felicitaciones, " + nombreUsuario + "! Tu usuario está correctamente verificado";

            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Mensaje de Felicitaciones");
            alert.setHeaderText(null);
            alert.setContentText(mensajeFelicitaciones);
            alert.showAndWait();
            BotonFlotante.setVisible(true);

        } else {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("El nombre de usuario no es válido. Por favor, inténtelo nuevamente.");
            alert.showAndWait();
        }
    }
    /**
     * Verifica si el nombre de usuario es válido y si lo es muestra una alerta inidica que exitosamente se guardo el nombre en el metodo Usuario.
     *
     * @param nombreUsuario  El nombre de usuario a verificar.
     * @return true si el nombre de usuario no está vacío, false en caso contrario.
     */

    private boolean verificarNombreUsuario(String nombreUsuario) {

        return !nombreUsuario.isEmpty(); // Verifica que el nombre de usuario no esté vacío
    }

    /**
     * Abre la vista de Instrucciones cuando se hace clic en el botón "Instrucciones".
     *
     * @param event  El evento de acción que desencadena la apertura de la vista de Instrucciones.
     */

    @FXML
    private void abrirInstrucciones(ActionEvent event) {
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

    /**
     * Inicializa el controlador después de que se haya cargado la interfaz de usuario.
     *
     * @param url       La ubicación utilizada para resolver rutas relativas para el objeto raíz o null si la ubicación no es conocida.
     * @param rb        El recurso del paquete utilizado para localizar el objeto raíz o null si el recurso no se encuentra.
     */

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("Va a pintar el componente");

        try {
            FXMLLoader loader = new FXMLLoader();
            //loader.setLocation(Main.class.getResource("/View/Iniciar.fxml"));
            loader.getLocation();
            Pane ventana = (Pane)loader.load();
            // Cargar la imagen crear objeto Nombre
            System.out.println("Va 1");
            Image img2 = new Image(getClass().getResourceAsStream("/resources/Nombre.JPG"));
            System.out.println("Va 2");
            ImageView imgView2 = new ImageView(img2);
            // Añadir el ImageView al panel principal de la pantalla
            ventana.getChildren().add(imgView2);

            //Position
            imgView2.setX(50);
            imgView2.setY(50);  
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }

}
