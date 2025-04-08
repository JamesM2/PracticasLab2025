package Actividad02Pitagora;

import javax.swing.*;
import java.awt.*;

public class PythagorasTree extends JPanel {

    private int profundidad;

    public PythagorasTree(int profundidad) {
        this.profundidad = profundidad;
        setPreferredSize(new Dimension(800, 800));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        // Fondo negro
        g2d.setColor(Color.BLACK);
        g2d.fillRect(0, 0, getWidth(), getHeight());

        // Color inicial del árbol
        g2d.setColor(Color.GREEN);

        // Llamada inicial al árbol
        trazaArbol(g2d, 400, 700, 100, -90, profundidad);  // Comienza desde el centro inferior
    }

    // Función recursiva para dibujar el árbol
    private void trazaArbol(Graphics2D g, int x, int y, int lado, double angulo, int nivel) {
        // Caso base: si el nivel llega a 0 o el lado es muy pequeño
        if (nivel == 0 || lado < 2) return;

        // Coordenadas del otro extremo del lado
        int x2 = x + (int) (lado * Math.cos(Math.toRadians(angulo)));
        int y2 = y + (int) (lado * Math.sin(Math.toRadians(angulo)));

        // Dibujar línea (rama)
        g.drawLine(x, y, x2, y2);

        // Reducimos el tamaño de la rama
        int nuevoLado = (int) (lado * 0.7);

        // Colores opcionales por nivel (solo visual)
        float tono = (float) nivel / profundidad;
        g.setColor(Color.getHSBColor(tono, 1.0f, 1.0f));

        // Llamadas recursivas: izquierda y derecha
        trazaArbol(g, x2, y2, nuevoLado, angulo - 45, nivel - 1); // izquierda
        trazaArbol(g, x2, y2, nuevoLado, angulo + 45, nivel - 1); // derecha
    }

    // Main para probar diferentes niveles
    public static void main(String[] args) {
        int[] niveles = {20}; // Puedes probar estos

        for (int nivel : niveles) {
            JFrame frame = new JFrame("Árbol de Pitágoras - Nivel " + nivel);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(new PythagorasTree(nivel));
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        }
    }
}
