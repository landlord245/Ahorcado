package gui;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

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
        this.setLocation(0,0);
        this.setBackground(color4);
        this.setLayout(null);
        createImagenIconsList();

        this.add(createLabelImagen());
    }
    public JLabel createLabelImagen(){
        Image image;
        ImageIcon imageIcon = this.getImageIcons().get(0);
        this.getLabelImagen().setSize(this.ancho, this.alto);
        this.getLabelImagen().setLocation(0,0);
        image = imageIcon.getImage().getScaledInstance(this.getAncho()/2, this.getAlto(), Image.SCALE_FAST);
        imageIcon = new ImageIcon(image);
        this.getLabelImagen().setHorizontalAlignment(JLabel.CENTER);
        this.getLabelImagen().setIcon(imageIcon);
        return this.getLabelImagen();
    }
    public LinkedList<ImageIcon> createImagenIconsList() {
        ImageIcon imageIcon = new ImageIcon();
        for (int i = 0; i < 8; i++) {
            imageIcon = new ImageIcon("src\\imagenes\\AhorcadoFase"+i+".png");
            this.imageIcons.add(imageIcon);
        }
        return this.imageIcons;
    }
    public void cambioDeFase(int fase) {
        Image image;
        int contador = 0;
        for (ImageIcon i : this.getImageIcons()){
            if (fase == contador){
                image = i.getImage().getScaledInstance(this.getAncho()/2, this.getAlto(), Image.SCALE_FAST);
                i = new ImageIcon(image);
                this.getLabelImagen().setIcon(i);
            }
            contador++;
        }
    }
    public Color getFontColor() {
        return fontColor;
    }

    public void setFontColor(Color fontColor) {
        this.fontColor = fontColor;
    }

    public Color getBgColor() {
        return bgColor;
    }

    public void setBgColor(Color bgColor) {
        this.bgColor = bgColor;
    }

    public Color getElementBGColor() {
        return elementBGColor;
    }

    public void setElementBGColor(Color elementBGColor) {
        this.elementBGColor = elementBGColor;
    }

    public Color getColor4() {
        return color4;
    }

    public void setColor4(Color color4) {
        this.color4 = color4;
    }

    public LinkedList<ImageIcon> getImageIcons() {
        return imageIcons;
    }

    public void setImageIcons(LinkedList<ImageIcon> imageIcons) {
        this.imageIcons = imageIcons;
    }

    public JLabel getLabelImagen() {
        return labelImagen;
    }

    public void setLabelImagen(JLabel labelImagen) {
        this.labelImagen = labelImagen;
    }

    public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public int getAlto() {
        return alto;
    }

    public void setAlto(int alto) {
        this.alto = alto;
    }

    public int getFase() {
        return fase;
    }

    public void setFase(int fase) {
        this.fase = fase;
    }
}
