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
    private int ancho;
    private int alto;
    private JRadioButton[] bDificultad = new JRadioButton[4];
    private ButtonGroup buttonGroup = new ButtonGroup();
    private JButton bJugar = new JButton("Jugar");
    private JLabel titulo = new JLabel("<html><i><u>AHORCADO</u></i></html>", SwingConstants.CENTER);
    private JLabel msgDificultad = new JLabel();

    public int centrarElemento(Component component){

        return this.ancho/2-component.getWidth()/2;
    }

    public MenuInicio(int ancho, int alto) {
        this.ancho = ancho;
        this.alto = alto;
        this.setLayout(null);
        this.setSize(ancho, alto);
        this.setBackground(this.bgColor);

        this.titulo.setSize(400, 50);
        this.titulo.setLocation(centrarElemento(this.titulo), 0);
        this.titulo.setBorder(BorderFactory.createLineBorder(Color.black));
        this.titulo.setFont(getFont().deriveFont(32.0f));
        this.titulo.setForeground(this.fontColor);
        this.titulo.setBackground(this.elementBGColor);
        this.titulo.setOpaque(true);
        this.add(this.titulo);

        int bAncho = this.titulo.getHeight()+50;
        for (int i = 0; i < this.bDificultad.length; i++){
            this.bDificultad[i] = new JRadioButton();
            this.bDificultad[i].setName(""+i);
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

            this.add(this.bDificultad[i]);
        }

        this.msgDificultad.setSize(150, bAncho-(this.titulo.getHeight()+50));
        this.msgDificultad.setLocation(10, this.titulo.getHeight()+50);
        this.msgDificultad.setFont(getFont().deriveFont(22.0f));
        this.msgDificultad.setBackground(elementBGColor);
        this.msgDificultad.setForeground(fontColor);
        this.msgDificultad.setOpaque(true);
        this.msgDificultad.setVisible(false);
        this.add(this.msgDificultad);

        this.bJugar.setSize(200, 50);
        this.bJugar.setLocation(centrarElemento(this.bJugar),bAncho+50);
        this.bJugar.setBackground(this.elementBGColor);
        this.bJugar.setForeground(this.fontColor);
        this.bJugar.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                bJugar.setForeground(elementBGColor);
                bJugar.setBackground(fontColor);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                bJugar.setBackground(elementBGColor);
                bJugar.setForeground(fontColor);
            }
        });
        this.add(this.bJugar);

        this.bDificultad[0].setText("Muy Facil.");
        this.bDificultad[1].setText("Facil.");
        this.bDificultad[2].setText("Normal.");
        this.bDificultad[3].setText("Dificil.");

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
        for (int i = 0; i < this.bDificultad.length; i++) {
            if (this.bDificultad[i].isSelected()){
                switch (this.bDificultad[i].getName()){
                    case "0":
                        this.msgDificultad.setText("<html><hr/> No vaya a ser que vayan a herir te los sentimientos. <hr/></html>");
                        this.msgDificultad.setVisible(true);
                        break;
                    case "1":
                        this.msgDificultad.setText("<html><hr/> No te olvides de los pañales... <hr/></html>");
                        this.msgDificultad.setVisible(true);
                        break;
                    case "2":
                        this.msgDificultad.setText("<html><hr/> Y aun se creera valiente. <hr/></html>");
                        this.msgDificultad.setVisible(true);
                        break;
                    case "3":
                        this.msgDificultad.setText("<html><hr/> Enseñanos de que madera estas echo. <hr/></html>");
                        this.msgDificultad.setVisible(true);
                        break;
                    default:
                        break;
                }
            }
        }
    }
}
