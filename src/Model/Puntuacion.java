package Model;

public class Puntuacion {
private static Puntuacion instancia = null;
private int puntuacion;

        public void reiniciarPuntuacion() {
                puntuacion = 0;
        }

private Puntuacion() {
        puntuacion = 0;
        }

public static Puntuacion getInstance() {
        if (instancia == null) {
        instancia = new Puntuacion();
        }
        return instancia;
        }

public int getPuntuacion() {
        return puntuacion;
        }

public void aumentarPuntuacion(int puntos) {
        puntuacion += puntos;
        }
        }


