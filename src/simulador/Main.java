package simulador;

import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import img.Ventana;
import java.awt.Color;
import javax.swing.JOptionPane;

public class Main {

    private static Entorno entorno;
    private static JPanel panel;

    public static void main(String[] args) {
        // Crear una aspiradora en una posición aleatoria dentro del entorno
        int posXAspiradora = (int) (Math.random() * 3);
        int posYAspiradora = (int) (Math.random() * 3);
        Aspiradora aspiradora = new Aspiradora(posXAspiradora, posYAspiradora);

        // Crear un entorno de prueba con una cuadrícula de 3x3
        entorno = new Entorno(4, 4, aspiradora);

        // Generar suciedad aleatoria en el entorno
        entorno.generarSuciedadAleatoria();

        // Crear y configurar la interfaz gráfica
        JFrame frame = new JFrame("Simulador de Aspiradora");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new JPanel(new GridLayout(3, 3));
        actualizarInterfaz();
        frame.add(panel);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        panel.setBackground(Color.LIGHT_GRAY);

        // Centrar la ventana en la pantalla
        frame.setLocationRelativeTo(null);

        // Ajustar el tamaño de la ventana
        frame.setSize(300, 300); // Tamaño original: 300x300
        frame.setVisible(true);

        // Limpiar las celdas de suciedad en el entorno
        for (int i = 0; i < entorno.getFilas(); i++) {
            for (int j = 0; j < entorno.getColumnas(); j++) {
                if (entorno.esCeldaSucia(j, i)) {
                    entorno.limpiarCelda(j, i);
                    actualizarInterfaz();
                    try {
                        Thread.sleep(1000); // Esperar un segundo entre cada limpieza para visualizarlo
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        JOptionPane.showMessageDialog(null, "¡La aspiradora ha limpiado todas las celdas!");
    }

    private static void actualizarInterfaz() {
        panel.removeAll(); // Limpiar el panel antes de actualizarlo

        Ventana n = new Ventana();

        for (int i = 0; i < entorno.getFilas(); i++) {
            for (int j = 0; j < entorno.getColumnas(); j++) {
                JLabel label = new JLabel();

                if (entorno.getPosicionAspiradora()[0] == j && entorno.getPosicionAspiradora()[1] == i) {
                    // Si la aspiradora está en esta celda, la representamos con 'A'
                    label.setIcon(n.aspiradora.getIcon());
                } else if (entorno.esCeldaSucia(j, i)) {
                    // Si la celda está sucia, la representamos con 'S'
                    label.setIcon(n.suciedad.getIcon());
                } else {
                    // Si la celda está limpia, la representamos con un espacio en blanco
                    label.setText("[ ]");
                }
                panel.add(label); // Agregar la etiqueta al panel en la posición correspondiente

            }
        }

        panel.revalidate(); // Actualizar la interfaz gráfica
        panel.repaint();

    }

}
