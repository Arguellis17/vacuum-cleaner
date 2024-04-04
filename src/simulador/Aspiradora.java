
package simulador;

public class Aspiradora {
    
    private int posicionX;
    private int posicionY;

    // Constructor
    public Aspiradora(int posicionX, int posicionY) {
        this.posicionX = posicionX;
        this.posicionY = posicionY;
    }

    // Métodos para obtener la posición de la aspiradora
    public int getPosicionX() {
        return posicionX;
    }

    public int getPosicionY() {
        return posicionY;
    }

    // Método para establecer la posición de la aspiradora
    public void setPosicion(int x, int y) {
        this.posicionX = x;
        this.posicionY = y;
    }
   
}

    

