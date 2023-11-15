package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MenuInicio extends JPanel implements ActionListener {
    private Color fontColor = new Color(253, 255, 252);
    private Color bgColor = new Color(1, 22, 39);
    private Color elementBGColor = new Color(231, 29, 54);
    private Color color4 = new Color(250, 112, 112);
    private Color colorYellow = new Color(255, 159, 28);
    private int ancho;
    private int alto;
    private JRadioButton[] bDificultad = new JRadioButton[4];
    private ButtonGroup buttonGroup = new ButtonGroup();
    private JButton bJugar = new JButton("Jugar");
    private JLabel titulo = new JLabel("<html><i><u>AHORCADO</u></i></html>", SwingConstants.CENTER);
    private JLabel msgDificultad = new JLabel();
    private JLabel carrusel = new JLabel();

    public int centrarElemento(Component component){
        return this.ancho/2-component.getWidth()/2;
    }
    public MenuInicio() {
    }

    public MenuInicio(int ancho, int alto) {
        this.ancho = ancho;
        this.alto = alto;
        this.setLayout(null);
        this.setSize(ancho, alto);
        this.setBackground(this.bgColor);

        this.setbDificultad(this.crearBotonesDificultad());

        this.add(crearTituloLabel());
        this.add(crearMsgLabel());
        for (int i = 0; i < this.getbDificultad().length ; i++)
            this.add(getbDificultad()[i]);
        this.add(crearBotonJugar());
        this.add(crearCarrusel());
        this.bDificultad[1].addActionListener(this);
    }
    public JLabel crearCarrusel() {
        this.carrusel.setVisible(false);
        this.carrusel.setOpaque(true);
        this.carrusel.setSize(this.getMsgDificultad().getWidth(), this.getMsgDificultad().getHeight());
        this.carrusel.setLocation(this.getAncho()-(this.carrusel.getWidth()+20), this.getMsgDificultad().getY());
        this.carrusel.setBackground(this.getColorYellow());
        return this.carrusel;
    }
    public JButton crearBotonJugar() {
        int posicionBotonArriba = this.getbDificultad()[3].getY();
        posicionBotonArriba += this.getbDificultad()[3].getHeight();
        this.bJugar.setSize(200, 50);
        this.bJugar.setLocation(centrarElemento(this.bJugar),posicionBotonArriba+50);
        this.bJugar.setBackground(this.elementBGColor);
        this.bJugar.setForeground(this.fontColor);
        this.bJugar.setName("Start");
        this.bJugar.setBorder(null);
        this.bJugar.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                bJugar.setForeground(elementBGColor);
                bJugar.setBackground(fontColor);
                bJugar.setBorder(null);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                bJugar.setBackground(elementBGColor);
                bJugar.setForeground(fontColor);
                bJugar.setBorder(null);
            }
        });
        return this.bJugar;
    }
    public JLabel crearMsgLabel() {
        int tamAltura = 0;
        for (int i = 0; i < this.getbDificultad().length; i++)
            tamAltura += this.getbDificultad()[i].getHeight()+10;
        this.msgDificultad.setSize(150, tamAltura);
        this.msgDificultad.setLocation(15, this.titulo.getHeight()+50);
        this.msgDificultad.setFont(getFont().deriveFont(22.0f));
        this.msgDificultad.setBackground(this.getColorYellow());
        this.msgDificultad.setForeground(this.getBgColor());
        this.msgDificultad.setOpaque(true);
        this.msgDificultad.setVisible(false);
        return msgDificultad;
    }
    public JRadioButton[] crearBotonesDificultad() {
        int bAncho = this.titulo.getHeight();
        bAncho += this.titulo.getY()+100;
        for (int i = 0; i < this.getbDificultad().length; i++){
            this.bDificultad[i] = new JRadioButton();
            this.bDificultad[i].setName(String.valueOf(i));
            this.buttonGroup.add(this.bDificultad[i]);
            this.bDificultad[i].setFont(getFont().deriveFont(16.0f));
            this.bDificultad[i].setSize(100, 30);
            this.bDificultad[i].setLocation(centrarElemento(bDificultad[i]),bAncho);
            bAncho += this.bDificultad[i].getHeight()+10;
            this.bDificultad[i].setBackground(this.elementBGColor);
            this.bDificultad[i].setForeground(this.fontColor);

            int num = i;
            this.bDificultad[i].addMouseListener(new MouseAdapter() {
                public void mouseEntered(MouseEvent e) {
                    super.mouseEntered(e);
                    bDificultad[num].setBackground(fontColor);
                    bDificultad[num].setForeground(elementBGColor);

                }
                public void mouseExited(MouseEvent e) {
                    super.mouseEntered(e);
                    bDificultad[num].setBackground(elementBGColor);
                    bDificultad[num].setForeground(fontColor);

                }
            });
            this.bDificultad[i].addActionListener(this);
        }
        this.bDificultad[0].setText("Muy Facil.");
        this.bDificultad[1].setText("Facil.");
        this.bDificultad[2].setText("Normal.");
        this.bDificultad[3].setText("Dificil.");
        return this.bDificultad;
    }
    public JLabel crearTituloLabel() {
        this.titulo.setSize(400, 50);
        this.titulo.setLocation(centrarElemento(this.titulo), 0);
        this.titulo.setBorder(BorderFactory.createLineBorder(Color.black));
        this.titulo.setFont(getFont().deriveFont(32.0f));
        this.titulo.setForeground(this.fontColor);
        this.titulo.setBackground(this.elementBGColor);
        this.titulo.setOpaque(true);
        return this.titulo;
    }

    public Color getColorYellow() {
        return colorYellow;
    }

    public void setColorYellow(Color colorYellow) {
        this.colorYellow = colorYellow;
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

    public JRadioButton[] getbDificultad() {
        return bDificultad;
    }

    public void setbDificultad(JRadioButton[] bDificultad) {
        this.bDificultad = bDificultad;
    }

    public ButtonGroup getButtonGroup() {
        return buttonGroup;
    }

    public void setButtonGroup(ButtonGroup buttonGroup) {
        this.buttonGroup = buttonGroup;
    }

    public JButton getbJugar() {
        return bJugar;
    }

    public void setbJugar(JButton bJugar) {
        this.bJugar = bJugar;
    }

    public JLabel getTitulo() {
        return titulo;
    }

    public void setTitulo(JLabel titulo) {
        this.titulo = titulo;
    }

    public JLabel getMsgDificultad() {
        return msgDificultad;
    }

    public void setMsgDificultad(JLabel msgDificultad) {
        this.msgDificultad = msgDificultad;
    }

    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < this.getbDificultad().length; i++) {
            if (this.getbDificultad()[i].isSelected()){
                switch (Integer.valueOf(this.getbDificultad()[i].getName())){
                    case 0:
                        this.msgDificultad.setText("<html><hr/><p align=\"center\"> No vaya a ser que vayan a herir te los sentimientos. </p><hr/></html>");
                        this.msgDificultad.setVisible(true);
                        anyadirImagen(0);
                        break;
                    case 1:
                        this.msgDificultad.setText("<html><hr/><p align=\"center\"> No te olvides de los pañales... </p><hr/></html>");
                        this.msgDificultad.setVisible(true);
                        anyadirImagen(2);
                        break;
                    case 2:
                        this.msgDificultad.setText("<html><hr/><p align=\"center\"> Y aun se creera valiente. </p><hr/></html>");
                        this.msgDificultad.setVisible(true);
                        anyadirImagen(4);
                        break;
                    case 3:
                        this.msgDificultad.setText("<html><hr/><p align=\"center\"> Enseñanos de que madera estas echo. </p><hr/></html>");
                        this.msgDificultad.setVisible(true);
                        anyadirImagen(7);
                        break;
                    default:
                        break;
                }
            }
        }
    }
    public void anyadirImagen(int numero) {
        Image image;
        ImageIcon imageIcon = new ImageIcon("src\\imagenes\\AhorcadoFase"+numero+".png");
        image = imageIcon.getImage().getScaledInstance(this.getMsgDificultad().getWidth(), this.getMsgDificultad().getHeight(), Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(image);
        this.carrusel.setIcon(imageIcon);
        this.carrusel.setVisible(true);
    }
}
