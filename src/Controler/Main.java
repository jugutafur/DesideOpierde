package Controler;

import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Main extends Application {

@Override
    public void start(Stage primaryStage) {

        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/View/Vista.fxml"));
            Pane ventana = (Pane) loader.load();
            // Show the scene containing the root layout.
            Scene scene = new Scene(ventana);
            primaryStage.setScene(scene);
            primaryStage.show();

            // Cargar la imagen crear objeto Nombre
            Image img = new Image(getClass().getResourceAsStream("/resources/Nombre.JPG"));
            ImageView imgView = new ImageView(img);
            // Añadir el ImageView al panel principal de la pantalla
            ventana.getChildren().add(imgView);
            //Position
            imgView.setX(0);
            imgView.setY(0);

            // Cargar la imagen crear objeto logo
            Image logo = new Image(getClass().getResourceAsStream("/resources/logo.JPG"));
            ImageView imgViewlogo = new ImageView(logo);
            // Añadir el ImageView al panel principal de la pantalla
            ventana.getChildren().add(imgViewlogo);
            //Position
            imgViewlogo.setX(0);
            imgViewlogo.setY(150);

            // Cargar la imagen crear objeto reloj
            Image reloj = new Image(getClass().getResourceAsStream("/resources/reloj.JPG"));
            ImageView imgViewReloj = new ImageView(reloj);
            // Añadir el ImageView al panel principal de la pantalla
            ventana.getChildren().add(imgViewReloj);
            //Position
            imgViewReloj.setX(400);
            imgViewReloj.setY(200);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args){
        System.out.println("mensaje de prueba desde Main"); 
        launch(args);   
    } 
}
