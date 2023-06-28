package Model;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.util.Duration;
import javafx.scene.control.Label;
public class Tiempo {
    private static Integer tiempoRestante;
    private static Timeline timeline;
    private static Runnable accionAlFinalizar;

    public static void iniciarCronometro(Label tiempoLabel, Runnable accionFinalizar) {
        tiempoRestante = 1 * 60; // 10 minutos en segundos
        accionAlFinalizar = accionFinalizar;

        timeline = new Timeline(new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                tiempoRestante--;
                // Actualizar la visualización del tiempo restante en la etiqueta TiempoLabel
                tiempoLabel.setText(formatearTiempo(tiempoRestante));

                if (tiempoRestante <= 0) {
                    detenerCronometro();
                    // Realizar acciones necesarias cuando el tiempo llega a cero
                    accionAlFinalizar.run();
                }
            }
        }));

        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    public static void detenerCronometro() {
        timeline.stop();
    }

    private static String formatearTiempo(int segundos) {
        int minutos = segundos / 60;
        int segundosRestantes = segundos % 60;
        return String.format("%02d:%02d", minutos, segundosRestantes);
    }
}
