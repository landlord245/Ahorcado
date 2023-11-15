package gui;

import logica.LogicaJuego;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame implements ActionListener {
    private MenuInicio menuInicio = new MenuInicio(500, 500);
    private PanelSuperior panelSuperior = new PanelSuperior(500, 250);
    private PanelInferior panelInferior = new PanelInferior(500, 250);
    private LogicaJuego logicaJuego = new LogicaJuego();
    private ImageIcon imageIcon = new ImageIcon("src\\imagenes\\ahorcado.jpg");

    public MainFrame() {
        this.setTitle("Ahorcado");
        this.setIconImage(this.imageIcon.getImage());
        this.setLayout(null);
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);

        this.menuInicio.getbJugar().addActionListener(this);
        this.getPanelInferior().getbProbar().addActionListener(this);
        try {
            this.getPanelInferior().getVentanaFinJuego().getBoton().addActionListener(this);

        }catch (NullPointerException ex){}
        /**
         * Siguientes lineas temporales
         * ELIMINAR AL TERMINAR LA CREACION
         * DE LA SEGUNDA PARTE
         */

//        this.menuInicio.setVisible(false);
//        this.panelInferior.setVisible(true);
//        this.panelSuperior.setVisible(true);

        /**
         * END
         */
        this.add(this.menuInicio);
        this.add(this.panelSuperior);
        this.add(this.panelInferior);
        this.setVisible(true);
    }
    public MenuInicio getMenuInicio() {
        return menuInicio;
    }

    public void setMenuInicio(MenuInicio menuInicio) {
        this.menuInicio = menuInicio;
    }

    public ImageIcon getImageIcon() {
        return imageIcon;
    }

    public void setImageIcon(ImageIcon imageIcon) {
        this.imageIcon = imageIcon;
    }

    public PanelSuperior getPanelSuperior() {
        return panelSuperior;
    }

    public void setPanelSuperior(PanelSuperior panelSuperior) {
        this.panelSuperior = panelSuperior;
    }

    public PanelInferior getPanelInferior() {
        return panelInferior;
    }

    public void setPanelInferior(PanelInferior panelInferior) {
        this.panelInferior = panelInferior;
    }

    public LogicaJuego getLogicaJuego() {
        return logicaJuego;
    }

    public void setLogicaJuego(LogicaJuego logicaJuego) {
        this.logicaJuego = logicaJuego;
    }
    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        AbstractButton abstractButton = (AbstractButton) e.getSource();
        if (abstractButton.getName().equalsIgnoreCase(this.getMenuInicio().getbJugar().getName())){
            try {
                if (this.menuInicio.getButtonGroup().getSelection().isSelected()){
                    this.menuInicio.setVisible(false);
                    this.panelSuperior.setVisible(true);
                    this.panelInferior.setVisible(true);
                }
            }catch (NullPointerException exception){
                this.getMenuInicio().getMsgDificultad().setText("<html><hr/><p align=\"center\">Si no selecionas la dificultad, no te dejare ir.</p><hr/></html>");
                this.getMenuInicio().getMsgDificultad().setVisible(true);
            }
            String dificultad = "";
            int niveldificultad = 0;
            for (int i = 0; i < this.menuInicio.getbDificultad().length; i++) {
                if (this.menuInicio.getbDificultad()[i].isSelected()) {
                    dificultad = this.menuInicio.getbDificultad()[i].getText();
                    niveldificultad = Integer.parseInt(this.menuInicio.getbDificultad()[i].getName());

                }
            }
            this.getLogicaJuego().setNivelDificultad(niveldificultad);
            this.getLogicaJuego().generarNumero();
            this.getPanelInferior().setLogicaJuego(this.getLogicaJuego());
            this.setTitle("Ahorcado: "+dificultad);
        } else if (abstractButton.getName().equalsIgnoreCase(this.getPanelInferior().getbProbar().getName())) {
            int fase = this.getPanelInferior().getIntentos();
            System.out.println("Intentos (MainFrame): "+fase);
            if (fase != 666)
                this.getPanelSuperior().cambioDeFase(fase);
            else {
                System.out.println("In");
            }
        } else if (abstractButton.getName().equalsIgnoreCase(this.getPanelInferior().getVentanaFinJuego().getBoton().getName())) {
            this.menuInicio.setVisible(true);
            this.panelSuperior.setVisible(false);
            this.panelInferior.setVisible(false);

        }
    }
}
