package gui;

import logica.LogicaJuego;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;

public class PanelInferior extends JPanel implements ActionListener {
    private Color fontColor = new Color(253, 255, 252);
    private Color bgColor = new Color(1, 22, 39);
    private Color elementBGColor = new Color(231, 29, 54);
    private Color colorLightPink = new Color(250, 112, 112);
    private Color acertado = new Color(129, 170, 36);
    private Color colorYellow = new Color(255, 159, 28);
    private JPanel panelLista = new JPanel();
    private JLabel[] pLabels = new JLabel[7];
    private JLabel msgInpt = new JLabel("<html>Inserte el numero a adivinar:</html>");
    private JTextField inptNum = new JTextField();
    private JLabel msgHint = new JLabel();
    private JButton bProbar = new JButton("Probar");
    private LogicaJuego logicaJuego = new LogicaJuego();
    private int ancho, alto;
    private int intentos = 0;
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
        this.msgHint.setHorizontalAlignment(JLabel.CENTER);
        this.msgHint.setOpaque(true);
        this.msgHint.setVisible(false);
//        this.msgHint.setText("<html><p align=\"center\">Este es un texto de prueba, yo soy Gurjant el desarrollador <p><html>");
        return this.msgHint;
    }
    public JLabel crearInptMsg() {
        this.msgInpt.setSize(this.ancho/2, 30);
        this.msgInpt.setLocation(10, this.getPanelLista().getHeight()+5);
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
        this.panelLista.setBackground(this.getColorLightPink());
        this.panelLista.setSize(this.ancho/2, 50);
        this.panelLista.setLocation(10, 10);
        this.panelLista.setLayout(null);
        crearEstiloListaNumeros();
        return this.panelLista;
    }
    public void crearEstiloListaNumeros() {
        int anchura = this.getPanelLista().getWidth();
        int altura = this.getPanelLista().getHeight();
        int espaciador = 0;
        for (int i = 0; i < this.getpLabels().length; i++) {
            this.getpLabels()[i] = new JLabel();
            this.getpLabels()[i].setBackground(this.getElementBGColor());
            this.getpLabels()[i].setForeground(this.getFontColor());
            this.getpLabels()[i].setSize(30, 40);
            if (i == 0)
                this.getpLabels()[i].setLocation(2, altura/2-this.getpLabels()[i].getHeight()/2);
            else {
                espaciador += this.getpLabels()[i].getWidth()+5;
                this.getpLabels()[i].setLocation(espaciador, altura/2-this.getpLabels()[i].getHeight()/2);
            }
//            System.out.println(espaciador);
            this.getpLabels()[i].setFont(this.getFont().deriveFont(22.0f));
            this.getpLabels()[i].setHorizontalAlignment(JLabel.CENTER);
            this.getpLabels()[i].setOpaque(true);
            this.getPanelLista().add(getpLabels()[i]);
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        boolean resultadoComprobacion = false;
        String ayuda = "";
        this.getMsgHint().setVisible(true);
        System.out.println(this.getLogicaJuego().getNumeroAleatorio());
        try {
            int numero = Integer.parseInt(this.getInptNum().getText());
            resultadoComprobacion = this.getLogicaJuego().comprobarNumero(numero);
            if (!resultadoComprobacion){
                anyadirNumeroLista(numero);
                ayuda = this.getLogicaJuego().hint(numero);
                this.getMsgHint().setText("<html><p align=\"center\">"+ayuda+"<p></html>");
            }else
                System.out.println("Numero Adivinado: "+numero);

        }catch (NumberFormatException ex){
            this.getMsgHint().setText("<html><p align=\"center\">Solo se permiten numeros, nada mas.<p></html>");
            try {
                anyadirNumeroLista(this.getInptNum().getText());
            }catch (IndexOutOfBoundsException exc) {
                System.out.println(exc.getMessage());
            }
            System.out.println(ex.getMessage());
        }
        this.getInptNum().setText("");
    }
    public void anyadirNumeroLista(int numero) throws IndexOutOfBoundsException {
        this.getpLabels()[this.getIntentos()].setText("<html><p align='center'>"+numero+"</p></html>");
        intentosIncrementar();
    }
    public void anyadirNumeroLista(String caracteres) throws IndexOutOfBoundsException {
        JLabel label = new JLabel("<html><p align=\"center\">"+caracteres+"</p></html>");
        this.getpLabels()[this.getIntentos()].setText(label.getText());
        System.out.println(this.getIntentos());
        intentosIncrementar();
    }
    public void intentosIncrementar(){
        this.intentos++;
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

    public LogicaJuego getLogicaJuego() {
        return logicaJuego;
    }

    public void setLogicaJuego(LogicaJuego logicaJuego) {
        this.logicaJuego = logicaJuego;
    }

    public JLabel[] getpLabels() {
        return pLabels;
    }

    public void setpLabels(JLabel[] pLabels) {
        this.pLabels = pLabels;
    }

    public int getIntentos() {
        return intentos;
    }

    public void setIntentos(int intentos) {
        this.intentos = intentos;
    }
}
