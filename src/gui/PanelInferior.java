package gui;

import logica.LogicaJuego;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Esta clase es muy importante pues junto con MainFrame, hacen de interconexion con
 * las diferentes clases.
 * Este panel aparecera en la parte inferior de la aplicacion.
 */
public class PanelInferior extends JPanel implements ActionListener {
    private Color fontColor = new Color(253, 255, 252);
    private Color bgColor = new Color(1, 22, 39);
    private Color elementBGColor = new Color(231, 29, 54);
    private Color colorLightPink = new Color(250, 112, 112);
    private Color colorYellow = new Color(255, 159, 28);
    private JPanel panelLista = new JPanel();
    private JLabel[] pLabels = new JLabel[7];
    private JLabel msgInpt = new JLabel("<html>Inserte el numero a adivinar:</html>");
    private JTextField inptNum = new JTextField();
    private JLabel msgHint = new JLabel();
    private JButton bProbar = new JButton("Probar");
    private LogicaJuego logicaJuego = new LogicaJuego();
    private VentanaFinJuego ventanaFinJuego = new VentanaFinJuego();
    private int ancho, alto;
    private int intentos = 1;

    /**
     * Construye el frame y a su vez crea y añade los diferentes componentes.
     * Hay que tener en cuenta que el constructor llama al metodo que lanza la ventana de fin de juego.
     *
     * @param ancho
     * @param alto
     */
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
        lanzarVentanaGanadora();
    }

    /**
     * Crea el boton que servira para lanzar un evento para comprobar si el numero insertad
     * es el correcto o no.
     *
     * @return
     */
    public JButton crearBotonProbar() {
        this.bProbar.setSize(this.ancho / 2 - 50, 75);
        this.bProbar.setLocation(this.ancho / 2 + 20, this.msgHint.getHeight() + 20);
        this.bProbar.setBorder(null);
        this.bProbar.setBackground(elementBGColor);
        this.bProbar.setForeground(fontColor);
        this.bProbar.setName("Probar");
        this.bProbar.setBorder(null);
        this.bProbar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                bProbar.setForeground(elementBGColor);
                bProbar.setBackground(fontColor);
                bProbar.setBorder(null);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                bProbar.setBackground(elementBGColor);
                bProbar.setForeground(fontColor);
                bProbar.setBorder(null);
            }
        });
        this.bProbar.addActionListener(this);
        return this.bProbar;
    }

    /**
     * Se crea JLabel que mostrara un mensaje de ayuda para los jugadores.
     * @return
     */
    public JLabel crearHintMsg() {
        int sumarElementoAltura = 30 + 30 + this.alto / 2;
        this.msgHint.setBorder(BorderFactory.createLineBorder(Color.black));
        this.msgHint.setSize(this.ancho / 2 - 50, sumarElementoAltura - 75);
        this.msgHint.setLocation(this.ancho / 2 + 20, 10);
        this.msgHint.setBackground(getColorYellow());
        this.msgHint.setForeground(getFontColor());
        this.msgHint.setHorizontalAlignment(JLabel.CENTER);
        this.msgHint.setOpaque(true);
        this.msgHint.setVisible(false);
        return this.msgHint;
    }

    /**
     * Se crea este JLabel que muestra un texto indicando donde se añade el numero a adivina.
     *
     * @return
     */
    public JLabel crearInptMsg() {
        this.msgInpt.setSize(this.ancho / 2, 30);
        this.msgInpt.setLocation(10, this.getPanelLista().getHeight() + 5);
        this.msgInpt.setForeground(fontColor);
        return this.msgInpt;
    }

    /**
     * Se crea un JTextField donde el usuario añadira un numero
     * puede ser tambien un caracter.
     * @return
     */
    public JTextField crearInputNum() {
        this.inptNum.setSize(this.ancho / 2, this.alto / 2);
        this.inptNum.setLocation(10, this.msgInpt.getHeight() + 50);
        this.inptNum.setOpaque(true);
        this.inptNum.setBackground(getElementBGColor());
        this.inptNum.setForeground(getFontColor());
        this.inptNum.setBorder(null);
        this.inptNum.setHorizontalAlignment(SwingConstants.CENTER);
        this.inptNum.setFont(getFont().deriveFont(32.0f));
        return this.inptNum;
    }

    /**
     * Se crea un JPanel que contendra la lista de numeros o caracteres introducidos por el usuario.
     * Este metodo llama a otro metodo llamado crearEstilosListaNumeros();
     * @return
     */
    public JPanel crearPanelLista() {
        this.panelLista.setBackground(this.getColorLightPink());
        this.panelLista.setSize(this.ancho / 2, 50);
        this.panelLista.setLocation(10, 10);
        this.panelLista.setLayout(null);
        crearEstiloListaNumeros();
        return this.panelLista;
    }

    /**
     * Este crea una Array de JLabels que contendran en los caracteres y/o numero introducidos por el
     * usuario.
     * Estos Jlabels estaran detro del JPanel 'panelList'.
     */
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
                this.getpLabels()[i].setLocation(2, altura / 2 - this.getpLabels()[i].getHeight() / 2);
            else {
                espaciador += this.getpLabels()[i].getWidth() + 5;
                this.getpLabels()[i].setLocation(espaciador, altura / 2 - this.getpLabels()[i].getHeight() / 2);
            }
            this.getpLabels()[i].setFont(this.getFont().deriveFont(22.0f));
            this.getpLabels()[i].setHorizontalAlignment(JLabel.CENTER);
            this.getpLabels()[i].setOpaque(true);
            this.getPanelLista().add(getpLabels()[i]);
        }
    }

    /**
     * Este metodo es llamado al accionar un boton de esta clase,
     * el boron 'bPrueba' es el que lo llama.
     * este metodo se encarga de comprobar si el numero ha sido adivinado o no.
     * Primero comprueba el numero de intentos, por defecto 1.
     * Si es menor o igual a 7, pedira al JTextField previamente creado el valor introducido
     *
     *                                  [ EXCEPTION ]
     * Si son caracteres y no numeros lanza una exepcion que nos permitira decirle al usuario que el valor instroducido
     * no es aceptado.
     * Luego se llama a un metodo al que le pasaremos el caracterRecibido.
     *
     * En caso de ser un numero, no lanzara un error y seguira el bloque:
     * se llama al metodo de la clase:
     * @see LogicaJuego
     * .comprobarNumero este nos devolvera un valor true si el numero que le pasamos es correcto.
     *
     *                                  [ COMPROBAR EL NUMERO: FALSE ]
     * El valor retornado es comprobado en una condicion:
     * Si el valor añadido no es el correcto, el valor sera añadido a la lista de nuemeros probados
     * esto se hara llamando al metodo 'añadirNumeroLista(numero)'.
     * se llamara al metodo hint(numero) de la clase LogicaJuego, que nos retorna una cadena de texto
     * Esta se concatena al mensaje de ayuda que se mostrara al usuario.
     *
     *                                  [ COMPROBAR EL NUMERO: TRUE ]
     * Tambien llamamos al metodo añadirNumeroLista(numero)
     * para que se añada el ultimo numero aun que seal el correcto
     * y hacemos que el valor de Intentos sea 666
     *
     * Comprueba la cantidad de intentos que llevamos, si es igual a 8
     * llama al metodo lanzarVentanaPerdedor();
     *
     * Y Por ultimo limpia el JTextField.
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        boolean resultadoComprobacion = false;
        String ayuda = "";
        int numeroRecibido = 0;
        String caracteresRecibidos = "";
        this.getMsgHint().setVisible(true);
        if ((this.getIntentos() <= 7)) {
            try {
                numeroRecibido = Integer.parseInt(this.getInptNum().getText());
                resultadoComprobacion = this.getLogicaJuego().comprobarNumero(numeroRecibido);
                if (!resultadoComprobacion) {
                    anyadirNumeroLista(numeroRecibido);
                    ayuda = this.getLogicaJuego().hint(numeroRecibido);
                    this.getMsgHint().setText("<html><p align=\"center\">" + ayuda + "<p></html>");
                } else {
                    anyadirNumeroLista(numeroRecibido);
                    this.setIntentos(666);
                }
                if (this.getIntentos() == 8)
                    lanzarVentanaPerdedor();
            } catch (NumberFormatException ex) {
                this.getMsgHint().setText("<html><p align=\"center\">Solo se permiten numeros, nada mas.<p></html>");
                caracteresRecibidos = this.getInptNum().getText();
                anyadirNumeroLista(caracteresRecibidos);
            }
        } else {
            lanzarVentanaPerdedor();
        }
        this.getInptNum().setText("");
    }

    /**
     * Este metodo aun que se llame lanzar..., no lanza nada simplemente
     * modifica la ventana que ya se encuentra lanzada.
     */
    public void lanzarVentanaPerdedor() {
        this.getVentanaFinJuego().getTituloLabel().setText("Lo ahorcaste.");
        this.getVentanaFinJuego().setTitle("No conseguiste salvar una vida.");
        this.getVentanaFinJuego().setVisible(true);
    }

    /**
     * Este lanza la ventana de ganador desde el principio,
     * Pero esta invisible, esto se hace para que en MainFrame tenga acceso a la clase VentanaFinDeJuego sin errores
     * Si no hicieramos esto, el boton "Volver" de esta ventana, no se reconoceria en el MainFrame y es suma mente
     * importante que se reconozca si no nunca vuelve al menu principal.
     */
    public void lanzarVentanaGanadora() {
        this.ventanaFinJuego = new VentanaFinJuego(500, 500, "Salvado");
    }

    /**
     * Este metodo añade un NUMERO a la lista de caracteres probados.
     * @param numero
     */
    public void anyadirNumeroLista(int numero) {
        this.getpLabels()[this.getIntentos() - 1].setText("<html><p align='center'>" + numero + "</p></html>");
        intentosIncrementar();
    }

    /**
     * Este metodo añade CARACTER/ES a la lista de caracteres probados.
     * @param caracteres
     */
    public void anyadirNumeroLista(String caracteres) {
        JLabel label = new JLabel("<html><p align=\"center\">" + caracteres + "</p></html>");
        this.getpLabels()[this.getIntentos() - 1].setText(label.getText());
        intentosIncrementar();
    }

    /**
     * Incrementa los numeros de intentos cadavez que se le llama.
     */
    public void intentosIncrementar() {
        this.intentos++;
    }

    /**
     * Restablece esta ventana y la de VentanaFinDeJuego.
     */
    public void restablecer() {
        this.getInptNum().setEnabled(true);
        this.getbProbar().setEnabled(true);
        for (int i = 0; i < 7; i++) {
            this.getpLabels()[i].setText("");
        }
        this.setIntentos(1);
        this.getVentanaFinJuego().setVisible(false);
        this.getMsgHint().setVisible(false);
    }

    /**
     * Setters && Getters
     * @return
     */
    public Color getFontColor() {
        return fontColor;
    }

    public Color getElementBGColor() {
        return elementBGColor;
    }

    public JPanel getPanelLista() {
        return panelLista;
    }

    public JTextField getInptNum() {
        return inptNum;
    }

    public JLabel getMsgHint() {
        return msgHint;
    }

    public JButton getbProbar() {
        return bProbar;
    }

    public Color getColorLightPink() {
        return colorLightPink;
    }

    public Color getColorYellow() {
        return colorYellow;
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

    public int getIntentos() {
        return intentos;
    }

    public VentanaFinJuego getVentanaFinJuego() {
        return ventanaFinJuego;
    }

    /**
     * Al llegar a ese numero de intentos, desactiva JTextField y JButton.
     * Y Hace visible la ventana de VentanaFinJuego que habiamos lanzado en el constructor
     * con el metodo lanzarVentanaGanadora().
     * @param intentos
     */
    public void setIntentos(int intentos) {
        this.intentos = intentos;
        if (this.intentos == 666) {
            this.getInptNum().setEnabled(false);
            this.getbProbar().setEnabled(false);
            this.getVentanaFinJuego().setVisible(true);
        }
    }
}