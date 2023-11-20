package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * La ventana de fin de juego se lanzara cuando se instancie la clase PanelInferior,
 * ya que en su constructor hay metodo que lanza esta evntana, por tanto la ventana sera
 * lanzad mucho antes de que se de el resultado.
 * @see PanelInferior
 * @see MainFrame
 */
public class VentanaFinJuego extends JFrame implements ActionListener {
    private Color fontColor = new Color(253, 255, 252);
    private Color bgColor = new Color(1, 22, 39);
    private Color elementBGColor = new Color(231, 29, 54);
    private Color color4 = new Color(255, 159, 28);
    private JPanel panel = new JPanel();
    private JButton botonSalir;
    private JLabel tituloLabel;
    private JButton botonVolver = new JButton();
    private String titulo;
    private ImageIcon imageIcon = new ImageIcon("src\\imagenes\\ahorcado.jpg");
    private int ancho, alto;
    private boolean volver = false;

    /**
     * Este constructor esta vacio por que se lanza antes de que se de el
     * resultado.
     */
    public VentanaFinJuego(){
    }

    /**
     * Este constructor es llamado cuando ya sabemos el resultado de la partida.
     * @param ancho
     * @param alto
     * @param titulo
     */
    public VentanaFinJuego(int ancho, int alto, String titulo) {
        this.ancho = ancho;
        this.titulo = titulo;
        this.alto = alto;
        this.setLayout(null);
        this.setBackground(this.bgColor);
        this.setTitle("Ahorcado: Winner winner chicken dinner.");
        this.setSize(this.ancho, this.alto);
        this.setLocationRelativeTo(null);
        this.setLocation(this.getX()+20, this.getY()+20);
        this.setResizable(false);
        this.setIconImage(this.imageIcon.getImage());
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);


        this.add(crearPanel());
        this.setVisible(false);
    }

    /**
     * Crea el JPanel, donde iran todos los componentes de esta ventana.
     * @return
     */
    public JPanel crearPanel() {
        this.panel.setBackground(this.bgColor);
        this.panel.setForeground(this.fontColor);
        this.panel.setSize(this.getSize());
        this.panel.setLayout(null);

        this.panel.add(crearLabel());
        this.panel.add(crearBotonSalir("Salir.", "0",1));
        this.panel.add(crearBotonVolver("Volver.", "1",0));
        this.botonSalir.addActionListener(this);
        this.botonVolver.addActionListener(this);
        return this.panel;
    }

    /**
     * Crea el boton de salir, al accionar este boton terminara la partida.
     * El ActionListener para este boton, se implementa en el metodo crearPanel().
     * El parametro Posicion, es para indicar en que lado del centro estara, si a la
     * derecha o a la izquierda.
     * @param titulo
     * @param nombre
     * @param posicion
     * @return
     */
    public JButton crearBotonSalir(String titulo, String nombre, int posicion ) {
        this.botonSalir = new JButton();
        this.botonSalir.setText(titulo);
        this.botonSalir.setName(nombre);
        this.botonSalir.setSize(200,75);
        if (posicion == 0 )
            this.botonSalir.setLocation(this.getWidth()/2-this.botonSalir.getWidth()-10,this.getHeight()-this.botonSalir.getHeight()-50);
        else
            this.botonSalir.setLocation(this.getWidth()/2+10,this.getHeight()-this.botonSalir.getHeight()-50);
        this.botonSalir.setBackground(elementBGColor);
        this.botonSalir.setForeground(fontColor);
        this.botonSalir.setBorder(null);

        this.botonSalir.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                botonSalir.setForeground(elementBGColor);
                botonSalir.setBackground(fontColor);
                botonSalir.setBorder(null);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                botonSalir.setBackground(elementBGColor);
                botonSalir.setForeground(fontColor);
                botonSalir.setBorder(null);
            }
        });
        return this.botonSalir;
    }

    /**
     * Crea el boton de volver, al accionar este boton vuelve al menu de incio.
     * El ActionListener para este boton, se implementa en el metodo crearPanel().
     * El parametro Posicion, es para indicar en que lado del centro estara, si a la
     * derecha o a la izquierda.
     * @see MainFrame
     * @param titulo
     * @param nombre
     * @param posicion
     * @return
     */
    public JButton crearBotonVolver(String titulo, String nombre, int posicion) {
        this.botonVolver = new JButton();
        this.botonVolver.setText(titulo);
        this.botonVolver.setName(nombre);
        this.botonVolver.setSize(200,75);
        if (posicion == 0 )
            this.botonVolver.setLocation(this.getWidth()/2-this.botonVolver.getWidth()-10,this.getHeight()-this.botonVolver.getHeight()-50);
        else
            this.botonVolver.setLocation(this.getWidth()/2+10,this.getHeight()-this.botonVolver.getHeight()-50);
        this.botonVolver.setBackground(elementBGColor);
        this.botonVolver.setForeground(fontColor);
        this.botonVolver.setBorder(null);

        this.botonVolver.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                botonVolver.setForeground(elementBGColor);
                botonVolver.setBackground(fontColor);
                botonVolver.setBorder(null);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                botonVolver.setBackground(elementBGColor);
                botonVolver.setForeground(fontColor);
                botonVolver.setBorder(null);
            }
        });
        return this.botonVolver;
    }

    /**
     * JLabel que aparece como titulo, aqui se inserta si ha ganado o ha perdido.
     * @return
     */
    public JLabel crearLabel() {
        this.tituloLabel = new JLabel();
        this.tituloLabel.setText("<html><hr/><p>"+this.getTitulo()+"</p><hr/><html>");
        this.tituloLabel.setHorizontalAlignment(JLabel.CENTER);
        this.tituloLabel.setFont(this.tituloLabel.getFont().deriveFont(64.0f));
        this.tituloLabel.setFont(this.tituloLabel.getFont().deriveFont(Font.ITALIC));
        this.tituloLabel.setForeground(this.fontColor);
        this.tituloLabel.setBackground(this.color4);
        this.tituloLabel.setOpaque(true);
        this.tituloLabel.setSize(this.getWidth(), 150);
        this.tituloLabel.setLocation(0,10);

        return this.tituloLabel;
    }

    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        AbstractButton abstractButton = (AbstractButton) e.getSource();
        if (abstractButton.getName().equalsIgnoreCase("0")){
            System.exit(0);
        } else if (abstractButton.getName().equalsIgnoreCase("1")) {
            this.volver = true;
        }
    }
    public String getTitulo() {
        return titulo;
    }
    public JButton getBotonVolver() {
        return botonVolver;
    }

    public JLabel getTituloLabel() {
        return tituloLabel;
    }
}
