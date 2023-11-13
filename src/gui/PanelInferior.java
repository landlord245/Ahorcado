package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelInferior extends JPanel implements ActionListener {
    private Color fontColor = new Color(253, 255, 252);
    private Color bgColor = new Color(1, 22, 39);
    private Color elementBGColor = new Color(231, 29, 54);
    private Color colorLightPink = new Color(250, 112, 112);
    private Color acertado = new Color(129, 170, 36);
    private Color colorYellow = new Color(255, 159, 28);
    private JPanel panelLista = new JPanel();
    private JLabel[] numProbados = new JLabel[5];
    private JLabel msgInpt = new JLabel("<html>Inserte el numero a adivinar aqua:</html>");
    private JTextField inptNum = new JTextField();
    private JLabel msgHint = new JLabel();
    private JButton bProbar = new JButton("Probar");
    private int ancho, alto;
    private String dificultad;
    public PanelInferior(int ancho, int alto) {
        this.ancho = ancho;
        this.alto = alto;
        this.setVisible(false);
        this.setSize(this.ancho, this.alto);
        this.setLocation(0, this.alto);
        this.setBackground(bgColor);
        this.setLayout(null);

        this.add(crearPanelLista());
        this.add(crearInptMsg());
        this.add(crearInputNum());
        this.add(crearHintMsg());
        this.add(crearBotonProbar());
    }
    public JButton crearBotonProbar() {
        this.bProbar.setSize(this.ancho/2-50, 75);
        this.bProbar.setLocation(this.ancho/2+20, this.msgHint.getHeight()+20);
        this.bProbar.setBorder(null);
        this.bProbar.setBackground(elementBGColor);
        this.bProbar.setForeground(fontColor);
        this.bProbar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                bProbar.setForeground(elementBGColor);
                bProbar.setBackground(fontColor);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                bProbar.setBackground(elementBGColor);
                bProbar.setForeground(fontColor);
            }
        });
        this.bProbar.addActionListener(this);
        return this.bProbar;
    }
    public JLabel crearHintMsg(){
        int sumarElementoAltura = 30+30+this.alto/2;
        this.msgHint.setBorder(BorderFactory.createLineBorder(Color.black));
        this.msgHint.setSize(this.ancho/2-50, sumarElementoAltura-75);
        this.msgHint.setLocation(this.ancho/2+20, 10);
        this.msgHint.setBackground(getColorYellow());
        this.msgHint.setForeground(getFontColor());
        this.msgHint.setOpaque(true);
        this.msgHint.setVisible(false);
        this.msgHint.setText("<html><p align=\"center\">Este es un texto de prueba, yo soy Gurjant el desarrollador <p><html>");
        return this.msgHint;
    }
    public JLabel crearInptMsg() {
        this.msgInpt.setSize(this.ancho/2, 30);
        this.msgInpt.setLocation(10, this.getPanelLista().getHeight()+20);
        this.msgInpt.setForeground(fontColor);
        return this.msgInpt;
    }
    public JTextField crearInputNum() {
        this.inptNum.setSize(this.ancho/2, this.alto/2);
        this.inptNum.setLocation(10, this.msgInpt.getHeight()+50);
        this.inptNum.setOpaque(true);
        this.inptNum.setBackground(getElementBGColor());
        this.inptNum.setForeground(getFontColor());
        this.inptNum.setBorder(null);
        this.inptNum.setHorizontalAlignment(SwingConstants.CENTER);
        this.inptNum.setFont(getFont().deriveFont(32.0f));
        return this.inptNum;
    }
    public JPanel crearPanelLista() {
        this.panelLista.setBackground(colorLightPink);
        this.panelLista.setSize(this.ancho/2, 30);
        this.panelLista.setLocation(10, 10);
        return  this.panelLista;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (this.msgHint.isVisible())
            this.msgHint.setVisible(false);
        else
            this.msgHint.setVisible(true);

        System.out.println(this.getDificultad());
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
        return colorLightPink;
    }

    public void setColor4(Color color4) {
        this.colorLightPink = color4;
    }

    public Color getAcertado() {
        return acertado;
    }

    public void setAcertado(Color acertado) {
        this.acertado = acertado;
    }

    public JPanel getPanelLista() {
        return panelLista;
    }

    public void setPanelLista(JPanel panelLista) {
        this.panelLista = panelLista;
    }

    public JLabel[] getNumProbados() {
        return numProbados;
    }

    public void setNumProbados(JLabel[] numProbados) {
        this.numProbados = numProbados;
    }

    public JLabel getMsgInpt() {
        return msgInpt;
    }

    public void setMsgInpt(JLabel msgInpt) {
        this.msgInpt = msgInpt;
    }

    public JTextField getInptNum() {
        return inptNum;
    }

    public void setInptNum(JTextField inptNum) {
        this.inptNum = inptNum;
    }

    public JLabel getMsgHint() {
        return msgHint;
    }

    public void setMsgHint(JLabel msgHint) {
        this.msgHint = msgHint;
    }

    public JButton getbProbar() {
        return bProbar;
    }

    public void setbProbar(JButton bProbar) {
        this.bProbar = bProbar;
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

    public String getDificultad() {
        return dificultad;
    }

    public void setDificultad(String dificultad) {
        this.dificultad = dificultad;
    }

    public Color getColorLightPink() {
        return colorLightPink;
    }

    public void setColorLightPink(Color colorLightPink) {
        this.colorLightPink = colorLightPink;
    }

    public Color getColorYellow() {
        return colorYellow;
    }

    public void setColorYellow(Color colorYellow) {
        this.colorYellow = colorYellow;
    }
}
