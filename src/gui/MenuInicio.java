package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Esta clase muestra un menu de incio en la ventana de MainFrame
 * Muestra un titulo en medio.
 * 4 niveles de dificultad en el centro debajo del titulo
 * Jlabler a la izquierda de los nuveles, que mostrara un mensaje de que se debe seleccionar un nivel.
 * Y tambien mostrara mensaje relacionado con la dificultad.
 * A la derecha de los niveles se muestra una imagen determinada con el nivel seleccionado.
 */
public class MenuInicio extends JPanel implements ActionListener {
    private Color fontColor = new Color(253, 255, 252);
    private Color bgColor = new Color(1, 22, 39);
    private Color elementBGColor = new Color(231, 29, 54);
    private Color colorYellow = new Color(255, 159, 28);
    private int ancho;
    private int alto;
    private JRadioButton[] bDificultad = new JRadioButton[4];
    private ButtonGroup buttonGroup = new ButtonGroup();
    private JButton bJugar = new JButton("Jugar");
    private JLabel titulo = new JLabel("<html><i><u>AHORCADO</u></i></html>", SwingConstants.CENTER);
    private JLabel msgDificultad = new JLabel();
    private JLabel carrusel = new JLabel();
    private Dimension dimension;

    public MenuInicio(int ancho, int alto) {
        this.ancho = ancho;
        this.alto = alto;
        this.dimension = new Dimension(this.ancho, this.alto);
        this.setLayout(null);
        this.setSize(dimension);
        this.setBackground(this.bgColor);

        this.setbDificultad(this.crearBotonesDificultad());

        this.add(crearTituloLabel());
        this.add(crearMsgLabel());
        for (int i = 0; i < this.getbDificultad().length; i++)
            this.add(getbDificultad()[i]);
        this.add(crearBotonJugar());
        this.add(crearCarrusel());
        this.bDificultad[1].addActionListener(this);
    }

    /**
     * Este metodo adapta el panel segun el tamaño de la ventana.
     * Basicamente elimina todos los elementos creados en el constructor
     * y los vuelve a crearlos de nuevo.
     * Enfasis en 'crearlos de nuevo' por que si el usuario ha seleccionado
     * una opcion cuyo valor podria estar guardado en una variable, pero si
     * las dimensiones se modifican, la opcion seleccionada, desaparcera
     * pero el valor previamente seleccionada, seguira estando almacenada en esa
     * variable.
     * @param dimension
     */
    public void restablecerTamanyo(Dimension dimension) {
        // Borramos todos los componentes.
        this.removeAll();
        // Borramos los valores guardados antes de cambiar de dimension.
        this.buttonGroup = new ButtonGroup();

        this.setAncho(dimension.width);
        this.setAlto(dimension.height);
        this.setLayout(null);
        this.setSize(dimension);
        this.setBackground(this.bgColor);
        this.setbDificultad(this.crearBotonesDificultad());

        this.add(crearTituloLabel());
        this.add(crearMsgLabel());
        for (int i = 0; i < this.getbDificultad().length; i++)
            this.add(getbDificultad()[i]);
        this.add(crearBotonJugar());
        this.add(crearCarrusel());
    }

    /**
     * Se usa para centrar componentes.
     * Se divide la anchura de la ventana en 2, con ello ya tendriamos el centro de la ventana
     * pero sucede que el componente comienza en la mitad. Para solucionar esto divides la anchura
     * del componente que deseas centrar.
     *
     * @param component
     * @return
     */
    public int centrarElemento(Component component) {
        return this.ancho / 2 - component.getWidth() / 2;
    }

    /**
     * Crea y establece parametros del JLabel que mostrara imagenes segun se seleccione el nivel de dificultad.
     *
     * @return
     */
    public JLabel crearCarrusel() {
        this.carrusel.setVisible(false);
        this.carrusel.setOpaque(true);
        this.carrusel.setSize(this.getMsgDificultad().getSize());
        int posicion = this.msgDificultad.getX();
        this.carrusel.setLocation((75*this.getAncho()/100)-this.carrusel.getWidth()/2, this.getMsgDificultad().getY());
        this.carrusel.setBackground(this.getColorYellow());
        return this.carrusel;
    }

    /**
     * Crea y establece parametros de JButtton que se usara para accionar y empezar a jugar.
     * Tambien indicamos que al pasar el mause por encima del boton, cambie de color.
     *
     * @return
     */
    public JButton crearBotonJugar() {
        int posicionBotonArriba = this.getbDificultad()[3].getY();
        posicionBotonArriba += this.getbDificultad()[3].getHeight();
        this.bJugar.setSize(200, 50);
        this.bJugar.setLocation(centrarElemento(this.bJugar), posicionBotonArriba + 50);
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

    /**
     * Crear y configurar parametros del JLabel que aparece cuando seleccionamos un nivel de dificultad.
     *
     * @return
     */
    public JLabel crearMsgLabel() {
        int tamAltura = 0;
        for (int i = 0; i < this.getbDificultad().length; i++)
            tamAltura += this.getbDificultad()[i].getHeight() + 10;
        this.msgDificultad.setSize(150, tamAltura);
        this.msgDificultad.setLocation(25*this.getAncho()/100-(this.msgDificultad.getWidth()/2), this.titulo.getHeight() + 50);
        this.msgDificultad.setFont(getFont().deriveFont(22.0f));
        this.msgDificultad.setBackground(this.getColorYellow());
        this.msgDificultad.setForeground(this.getBgColor());
        this.msgDificultad.setOpaque(true);
        this.msgDificultad.setVisible(false);
        return msgDificultad;
    }

    /**
     * Array de botones de seleccion, estos botones seran usados para seleccionar el nivel de
     * dificultad.
     * Importante mencionar que estos botones reciben un nombre, el mismo que el valor i de la iteracion.
     * Se añaden tambien al ButtonGroup.
     *
     * @return
     */
    public JRadioButton[] crearBotonesDificultad() {
        int bAncho = this.titulo.getHeight();
        bAncho += this.titulo.getY() + 100;
        for (int i = 0; i < this.getbDificultad().length; i++) {
            this.bDificultad[i] = new JRadioButton();
            this.bDificultad[i].setName(String.valueOf(i)); // Se indica el nombre.
            this.buttonGroup.add(this.bDificultad[i]);
            this.bDificultad[i].setFont(getFont().deriveFont(16.0f));
            this.bDificultad[i].setSize(100, 30);
            this.bDificultad[i].setLocation(centrarElemento(bDificultad[i]), bAncho);
            bAncho += this.bDificultad[i].getHeight() + 10;
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

    /**
     * Se crea el JLabel encargado de mostrar el titulo del juego "AHORCADO"
     *
     * @return
     */
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


    /**
     * Setter & Getters
     */

    public Dimension getDimension() {
        return dimension;
    }

    public void setDimension(Dimension dimension) {
        this.dimension = dimension;
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

    public void restablecer() {
        this.getButtonGroup().clearSelection();
    }

    public Color getColorYellow() {
        return colorYellow;
    }

    public Color getBgColor() {
        return bgColor;
    }

    public int getAncho() {
        return ancho;
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

    public JButton getbJugar() {
        return bJugar;
    }

    public JLabel getMsgDificultad() {
        return msgDificultad;
    }

    /**
     * Invocado cuando una accion ocure.
     * Contiene un bucle for{
     * e ira comprobando(si bDificultad[i] es seleccionado){
     * Switch recibe el nombre del boton y es convertido a un Integer
     * (No hace falta que recibamos el nombre del boton, pues es el mismo que del iterador).
     * Segun el boton selecionado, se mostrara un mensaje o otro.
     * Y hace que sea visible el JLabel.
     * Y por ultimo llamara al metodo anyadirImagen(Int);
     * }
     * }
     *
     * @param e El evento a procesar.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < this.getbDificultad().length; i++) {
            if (this.getbDificultad()[i].isSelected()) {
                switch (Integer.valueOf(this.getbDificultad()[i].getName())) {
                    case 0:
                        this.msgDificultad.setText("<html><hr/><p align=\"center\"> No vaya a ser que vayan a herir te los sentimientos. </p><hr/></html>");
                        this.msgDificultad.setVisible(true);
                        anyadirImagen(1);
                        break;
                    case 1:
                        this.msgDificultad.setText("<html><hr/><p align=\"center\"> No te olvides de los pañales... </p><hr/></html>");
                        this.msgDificultad.setVisible(true);
                        anyadirImagen(3);
                        break;
                    case 2:
                        this.msgDificultad.setText("<html><hr/><p align=\"center\"> Y aun se creera valiente. </p><hr/></html>");
                        this.msgDificultad.setVisible(true);
                        anyadirImagen(5);
                        break;
                    case 3:
                        this.msgDificultad.setText("<html><hr/><p align=\"center\"> Enseñanos de que madera estas echo. </p><hr/></html>");
                        this.msgDificultad.setVisible(true);
                        anyadirImagen(8);
                        break;
                    default:
                        break;
                }
            }
        }
    }

    /**
     * Segun el numero recibido, mostrara una imagen u otro.
     * La imagen se muestra a la derecha.
     *
     * @param numero
     */
    public void anyadirImagen(int numero) {
        Image image;
        ImageIcon imageIcon = new ImageIcon("src\\imagenes\\AhorcadoFase" + numero + ".png");
        image = imageIcon.getImage().getScaledInstance(this.getMsgDificultad().getWidth(), this.getMsgDificultad().getHeight(), Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(image);
        this.carrusel.setIcon(imageIcon);
        this.carrusel.setVisible(true);
    }
}
