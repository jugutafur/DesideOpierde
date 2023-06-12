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
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.Stage;

public class IniciarController implements Initializable {

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
