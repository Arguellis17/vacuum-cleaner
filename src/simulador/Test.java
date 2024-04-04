package simulador;

public class Test {

    public static void main(String[] args) {
        // Crear una aspiradora en una posición aleatoria dentro del entorno
        int posXAspiradora = (int) (Math.random() * 3);
        int posYAspiradora = (int) (Math.random() * 3);
        Aspiradora aspiradora = new Aspiradora(posXAspiradora, posYAspiradora);

        // Crear un entorno de prueba con una cuadrícula de 3x3
        Entorno entorno = new Entorno(3, 3, aspiradora);

        // Generar suciedad aleatoria en el entorno
        entorno.generarSuciedadAleatoria();

        // Mostrar el estado inicial del entorno
        System.out.println("\nEntorno inicial:");
        entorno.imprimirEntorno();

        // Limpiar las celdas de suciedad en el entorno
        for (int i = 0; i < entorno.getFilas(); i++) {
            for (int j = 0; j < entorno.getColumnas(); j++) {
                if (entorno.esCeldaSucia(j, i)) {
                    entorno.limpiarCelda(j, i);
                    System.out.println("\nAspiradora limpia la celda en la posición (" + j + ", " + i + ")");
                    //System.out.println("Estado del entorno después de la limpieza:");
                    entorno.imprimirEntorno();
                }
            }
        }

        System.out.println("\nEl entorno ha sido completamente limpiado!");
    }
}
