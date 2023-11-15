package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ventanaFinJuego extends JFrame implements ActionListener {
    private Color fontColor = new Color(253, 255, 252);
    private Color bgColor = new Color(1, 22, 39);
    private Color elementBGColor = new Color(231, 29, 54);
    private Color color4 = new Color(255, 159, 28);
    private JPanel panel = new JPanel();
    private JButton boton;
    private String titulo;
    private int ancho, alto;
    public ventanaFinJuego(){
    }
    public ventanaFinJuego(int ancho, int alto, String titulo) {
        this.ancho = ancho;
        this.titulo = titulo;
        this.alto = alto;
        this.setLayout(null);
        this.setBackground(this.bgColor);
        this.setTitle("Ahorcado: Winner winner chicken diner.");
        this.setSize(this.ancho, this.alto);
        this.setLocationRelativeTo(null);
        this.setLocation(this.getX()+20, this.getY()+20);
        this.setResizable(false);
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
        this.panel.add(creareBotonExit("Volver.", "volver",0));
        this.panel.add(creareBotonExit("Salir.", "salir",1));
        return this.panel;
    }
    public JButton creareBotonExit(String text, String name, int posicion) {
        this.boton = new JButton(text);
        this.boton.setName(name);
        this.boton.setSize(200, 75);
        if (posicion == 0){
            this.boton.setLocation(this.getWidth()/2-this.boton.getWidth()-10,this.getHeight()-this.boton.getHeight()-50);
        }else {
            this.boton.setLocation(this.getWidth()/2+10,this.getHeight()-this.boton.getHeight()-50);
        }
        this.boton.setBackground(elementBGColor);
        this.boton.setForeground(fontColor);
        this.boton.setBorder(null);
        this.boton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                boton.setForeground(elementBGColor);
                boton.setBackground(fontColor);
                boton.setBorder(null);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                boton.setBackground(elementBGColor);
                boton.setForeground(fontColor);
                boton.setBorder(null);
            }
        });
        this.boton.addActionListener(this);

        return this.boton;
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
        if (abstractButton.getName().equalsIgnoreCase("Salir")){
            System.exit(0);
        } else if (abstractButton.getName().equalsIgnoreCase("volver")) {

        }
    }
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public JButton getBoton() {
        return boton;
    }

    public void setBoton(JButton boton) {
        this.boton = boton;
    }
}
