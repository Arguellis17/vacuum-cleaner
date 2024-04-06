package simulador;

import java.util.Random;

public class Entorno {

    private boolean[][] suciedad;
    private int filas;
    private int columnas;
    private Aspiradora aspiradora;

    // Constructor
    public Entorno(int filas, int columnas, Aspiradora aspiradora) {
        this.filas = filas;
        this.columnas = columnas;
        this.aspiradora = aspiradora;
        suciedad = new boolean[filas][columnas];
    }

    // Método para generar suciedad aleatoria en el entorno
    public void generarSuciedadAleatoria() {
        Random rand = new Random();
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                suciedad[i][j] = rand.nextBoolean(); // Genera un valor booleano aleatorio (true/false)
            }
        }
    }

    // Método para verificar si una celda está sucia
    public boolean esCeldaSucia(int x, int y) {
        return suciedad[y][x]; // Invertimos las coordenadas debido al formato de la matriz
    }

    // Método para limpiar una celda
    public void limpiarCelda(int x, int y) {
        suciedad[y][x] = false; // Invertimos las coordenadas debido al formato de la matriz
        aspiradora.setPosicion(x, y); // Actualizamos la posición de la aspiradora
    }

    // Método para obtener el número de filas
    public int getFilas() {
        return filas;
    }

    // Método para obtener el número de columnas
    public int getColumnas() {
        return columnas;
    }

    // Método para obtener las coordenadas de la aspiradora
    public int[] getPosicionAspiradora() {
        return new int[]{aspiradora.getPosicionX(), aspiradora.getPosicionY()};
    }
}
