package gui;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

/**
 * El panel superior consiste en mostrar la imagen del ahorcado.
 */
public class PanelSuperior extends JPanel {
    private Color fontColor = new Color(253, 255, 252);
    private Color bgColor = new Color(1, 22, 39);
    private Color elementBGColor = new Color(231, 29, 54);
    private Color color4 = new Color(255, 159, 28);
    private LinkedList<ImageIcon> imageIcons = new LinkedList<>();
    private JLabel labelImagen = new JLabel();
    private int fase;
    private int ancho, alto;

    public PanelSuperior(int ancho, int alto) {
        this.ancho = ancho;
        this.alto = alto;
        this.setVisible(false);
        this.setSize(this.ancho, this.alto);
        this.setLocation(0, 0);
        this.setBackground(color4);
        this.setLayout(null);
        createImagenIconsList();

        this.add(createLabelImagen());
    }

    /**
     * Especificamos los atributos del JLabel labelImagen.
     *
     * @return
     */
    public JLabel createLabelImagen() {
        Image image;
        ImageIcon imageIcon = this.getImageIcons().get(0);
        this.getLabelImagen().setSize(this.ancho, this.alto);
        this.getLabelImagen().setLocation(0, 0);
        image = imageIcon.getImage().getScaledInstance(this.getAncho() / 2, this.getAlto(), Image.SCALE_FAST);
        imageIcon = new ImageIcon(image);
        this.getLabelImagen().setHorizontalAlignment(JLabel.CENTER);
        this.getLabelImagen().setIcon(imageIcon);
        return this.getLabelImagen();
    }

    /**
     * Añade las imagenes de las diferentes fases del ahorcado, en el LinkedList de imageIcons.
     *
     * @return
     */
    public LinkedList<ImageIcon> createImagenIconsList() {
        ImageIcon imageIcon = new ImageIcon();
        for (int i = 0; i < 8; i++) {
            imageIcon = new ImageIcon("src\\imagenes\\AhorcadoFase" + (i + 1) + ".png");
            this.imageIcons.add(imageIcon);
        }
        return this.imageIcons;
    }

    /**
     * Recibe por parametro la fase en la que estamos, este metodo se
     * llama en la clase MainFrame por el metodo actionPerformed() donde pasaremos la fase.
     * En este metodo se itera el LinkedList. Por cada iteracion se incrementa la variable Contador.
     * Cuando el contador sea igual al de la fase que le pasamos, se añadira la imagen al JLabel labelImagen.
     *
     * @param fase
     * @see MainFrame
     */
    public void cambioDeFase(int fase) {
        Image image;
        int contador = 0;
        for (ImageIcon i : this.getImageIcons()) {
            if (fase == contador) {
                image = i.getImage().getScaledInstance(this.getAncho() / 2, this.getAlto(), Image.SCALE_FAST);
                i = new ImageIcon(image);
                this.getLabelImagen().setIcon(i);
            }
            contador++;
        }
    }

    /**
     * Getter & Setters
     */
    public LinkedList<ImageIcon> getImageIcons() {
        return imageIcons;
    }

    public JLabel getLabelImagen() {
        return labelImagen;
    }

    public int getAncho() {
        return ancho;
    }

    public int getAlto() {
        return alto;
    }
}
