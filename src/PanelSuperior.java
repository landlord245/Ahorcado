import javax.swing.*;
import java.awt.*;

public class PanelSuperior extends JPanel {
    private Color fontColor = new Color(253, 255, 252);
    private Color bgColor = new Color(1, 22, 39);
    private Color elementBGColor = new Color(231, 29, 54);
    private Color color4 = new Color(255, 159, 28);
    private int ancho, alto;
    public PanelSuperior(int ancho, int alto) {
        this.ancho = ancho;
        this.alto = alto;
        this.setVisible(false);
        this.setSize(this.ancho, this.alto);
        this.setLocation(0,0);
        this.setBackground(color4);
    }
}
