package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame implements ActionListener {
    private MenuInicio menuInicio = new MenuInicio(500, 500);
    private PanelSuperior panelSuperior = new PanelSuperior(500, 250);
    private PanelInferior panelInferior = new PanelInferior(500, 250);
    private ImageIcon imageIcon = new ImageIcon("src\\imagenes\\ahorcado.jpg");

    public MainFrame() {
        this.setTitle("Ahorcado");
        this.setIconImage(this.imageIcon.getImage());
        this.setLayout(null);
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.menuInicio.getbJugar().addActionListener(this);

        /**
         * Siguientes lineas temporales
         * ELIMINAR AL TERMINAR LA CREACION
         * DE LA SEGUNDA PARTE
         */

        this.menuInicio.setVisible(false);
        this.panelInferior.setVisible(true);
        this.panelSuperior.setVisible(true);

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

    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (this.menuInicio.getButtonGroup().getSelection().isSelected()){
            this.menuInicio.setVisible(false);
            this.panelSuperior.setVisible(true);
            this.panelInferior.setVisible(true);
        }
        String dificultad = "";
        for (int i = 0; i < this.menuInicio.getbDificultad().length; i++) {
            if (this.menuInicio.getbDificultad()[i].isSelected()) {
                dificultad = this.menuInicio.getbDificultad()[i].getText();
                this.panelInferior.setDificultad(this.menuInicio.getbDificultad()[i].getName());

            }
        }
        this.setTitle("Ahorcado: "+dificultad);
    }
}
