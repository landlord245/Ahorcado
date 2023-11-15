package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VentanaFinJuego extends JFrame implements ActionListener {
    private Color fontColor = new Color(253, 255, 252);
    private Color bgColor = new Color(1, 22, 39);
    private Color elementBGColor = new Color(231, 29, 54);
    private Color color4 = new Color(255, 159, 28);
    private JPanel panel = new JPanel();
    private JButton botonSalir;
    private JButton botonVolver = new JButton();
    private String titulo;
    private ImageIcon imageIcon = new ImageIcon("src\\imagenes\\ahorcado.jpg");
    private int ancho, alto;
    private boolean volver = false;
    public VentanaFinJuego(){
    }
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
//        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);


        this.add(crearPanel());
        this.setVisible(true);
    }
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
    public JLabel crearLabel() {
        JLabel titulo = new JLabel();
        titulo.setText("<html><hr/><p>"+this.getTitulo()+"</p><hr/><html>");
        titulo.setHorizontalAlignment(JLabel.CENTER);
        titulo.setFont(titulo.getFont().deriveFont(64.0f));
        titulo.setFont(titulo.getFont().deriveFont(Font.ITALIC));
        titulo.setForeground(this.fontColor);
        titulo.setBackground(this.color4);
        titulo.setOpaque(true);
        titulo.setSize(this.getWidth(), 150);
        titulo.setLocation(0,10);

        return titulo;
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

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public JButton getBotonSalir() {
        return botonSalir;
    }

    public boolean isVolver() {
        return volver;
    }

    public JButton getBotonVolver() {
        return botonVolver;
    }

    public void setBotonVolver(JButton botonVolver) {
        this.botonVolver = botonVolver;
    }
}
