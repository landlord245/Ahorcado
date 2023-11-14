package gui;

import javax.swing.*;
import java.awt.*;

public class VentanaGanadora extends JFrame {
    private Color fontColor = new Color(253, 255, 252);
    private Color bgColor = new Color(1, 22, 39);
    private Color elementBGColor = new Color(231, 29, 54);
    private Color color4 = new Color(255, 159, 28);
    private int ancho, alto;
    public VentanaGanadora(int ancho, int alto) {
        this.ancho = ancho;
        this.alto = alto;
        this.setLayout(null);
        this.setBackground(this.bgColor);
        this.setTitle("Ahorcado: Winner winner chicken diner.");
        this.setVisible(true);
        this.setSize(ancho, alto);
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    }
}
