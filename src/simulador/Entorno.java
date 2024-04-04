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

    // Método para imprimir el estado actual del entorno
    public void imprimirEntorno() {
        System.out.println("Estado actual del entorno:");
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (aspiradora.getPosicionX() == j && aspiradora.getPosicionY() == i) {
                    // Si la aspiradora está en esta celda, la representamos con 'A'
                    System.out.print("[A]");
                } else if (suciedad[i][j]) {
                    // Si la celda está sucia, la representamos con 'S'
                    System.out.print("[S]");
                } else {
                    // Si la celda está limpia, la representamos con un espacio en blanco
                    System.out.print("[ ]");
                }
            }
            System.out.println();
        }
    }

    // Método para imprimir el movimiento de la aspiradora hacia la celda donde estaba la suciedad
    public void imprimirMovimientoAspiradora(int x, int y) {
        System.out.println("Movimiento de la aspiradora hacia la celda donde estaba la suciedad:");
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (aspiradora.getPosicionX() == j && aspiradora.getPosicionY() == i) {
                    // Si la aspiradora está en esta celda, la representamos con 'A'
                    System.out.print("[A]");
                } else if (x == j && y == i) {
                    // Si la celda era donde estaba la suciedad, la representamos con 'X'
                    System.out.print("[X]");
                } else {
                    // Si la celda está limpia, la representamos con un espacio en blanco
                    System.out.print("[ ]");
                }
            }
            System.out.println();
        }
    }
}
