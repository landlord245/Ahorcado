package gui;

import logica.LogicaJuego;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Esta clase contiene todos los paneles que iran
 * apareciendo excepto los de fin de juego que indican
 * la derrota o la victoria.
 */
public class MainFrame extends JFrame implements ActionListener {
    private MenuInicio menuInicio = new MenuInicio(500, 500);
    private PanelSuperior panelSuperior = new PanelSuperior(500, 250);
    private PanelInferior panelInferior = new PanelInferior(500, 250);
    private LogicaJuego logicaJuego = new LogicaJuego();
    private ImageIcon imageIcon = new ImageIcon("src\\imagenes\\ahorcado.jpg");

    /**
     * Contructor que no recibi nada por parametro, pero construye toda la ventana.
     * Caracteristicas a tener en cuenta:
     * No es redimensionable.
     * Tres botones que activan un evento.
     */
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
        this.getPanelInferior().getVentanaFinJuego().getBotonVolver().addActionListener(this);

        this.add(this.menuInicio);
        this.add(this.panelSuperior);
        this.add(this.panelInferior);
        this.setVisible(true);
    }

    /**
     * Getter & Setters
     * @return
     */
    public MenuInicio getMenuInicio() {
        return menuInicio;
    }
    public PanelSuperior getPanelSuperior() {
        return panelSuperior;
    }
    public PanelInferior getPanelInferior() {
        return panelInferior;
    }
    public LogicaJuego getLogicaJuego() {
        return logicaJuego;
    }

    /**
     * Es invocado cuando ocure un evento(cuando se pulsan los botones mencionados en el constructor).
     * Se instancia un Abstractbutton que contiene la informacion del boton accionado.
     *
     * El metodo contiene varias condiciones:
     *
     *                                      [ PRIMERA CONDICION ]
     * El primer boton aparece en el menu principal, donde el usuario elige el nivel de dificultad.
     * Si el boton es selecionado:
     *      MenuInicio>bJugar {
     *          1.- Si alguno de los botones del ButtonGroup a si do seleccionado {
     *              1.1.- Que el menu inicial (la de dificultades), se vuelva invisible e inaccesible.
     *              1.2.- Se hace visible el Panel Superior (gui.PanelSuperior), que es extiende de JPanel
     *              y es una instacia de esta clase.
     *              1.3.- Se hace visible el Panel Superior (gui.PanelSuperior), que es extiende de JPanel
     *              y es una instacia de esta clase.
     *              1.4.- De la clase menu inicial se comprueban atra vez de un bucle for
     *              se comprueba que boton ha sido seleccionado y de este se extra el texto
     *              con el metodo .getText.
     *              1.5.- Tambien se extrae el nombre para luego pasarselo a la clase LogicaJuego con el fin de
     *              determinar el nivel de dificultad seleccionado.
     *              1.6.- Una vez pasado la dificultad a la clase LogicaJuego, se llama al metodo .generarNumero()
     *              de la misma clase para generar el numero aleatorio.
     *
     *
     *          }
     *          Esto puede lanzar una excepcion debido a que si no esta seleccionada ninguna dificultad,
     *          ButtonGroup lanza "null", en caso de ser este el caso:
     *          2.- Se le comunica al usuario atra vez de JLabel que no se ha seleccionado el nivel de dificultad.
     *      }
     *                                      [ SEGUNDA CONDICION ]
     * Este boton se usa para cuando el usuario desea probar el numero insertado.
     * Si el boton es selecionado:
     *      PanelInferior>bProbar {
     *          Se llama al metodo .getIntentos, este tiene valor por defecto 1, y se ira incrementando hasta 7.
     *          si supera dicha cantidad, termina el juego.
     *          Los numero recibidos por el metodo indicado son comprobados por una condicion.
     *          Si los numeros dados son diferentes, se le indicara a la Clase PanelSuperior, sobre el cambio de fase.
     *          En caso de que sea igual a 666, no se cambiara de fase. Pues bien a sido derrota o victoria.
     *      }
     *
     *                                      [ TERCERA CONDICION ]
     * Este boton se usa cuando el juego a terminado y a aprece una ventana de la clase VentanaFinJuego.
     * Esta clase esta instanciada solo en la clase Panel Inferior.
     * Si el boton es selecionado:
     *      PanelInferior>VentanaFinJuego>BotonVolver {
     *          Llama al metodo restablecer();
     *      }
     * @param e Evento procesado.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        AbstractButton abstractButton = (AbstractButton) e.getSource();
        String name = abstractButton.getName();
        if (name.equalsIgnoreCase(this.getMenuInicio().getbJugar().getName())){
            try {
                if (this.menuInicio.getButtonGroup().getSelection().isSelected()){
                    this.menuInicio.setVisible(false);
                    this.panelSuperior.setVisible(true);
                    this.panelInferior.setVisible(true);

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
                }

            }catch (NullPointerException exception){
                this.getMenuInicio().getMsgDificultad().setText("<html><hr/><p align=\"center\">Si no selecionas la dificultad, no te dejare ir.</p><hr/></html>");
                this.getMenuInicio().getMsgDificultad().setVisible(true);
            }
        } else if (name.equalsIgnoreCase(this.getPanelInferior().getbProbar().getName())) {
            int fase = this.getPanelInferior().getIntentos();
            if (fase != 666)
                this.getPanelSuperior().cambioDeFase(fase);

        } else if (name.equalsIgnoreCase(this.getPanelInferior().getVentanaFinJuego().getBotonVolver().getName())) {
            restablecer();
        }
    }

    /**
     * Esta clase Restablece el juego.
     */
    public void restablecer() {
        this.menuInicio.setVisible(true);
        this.panelSuperior.setVisible(false);
        this.panelInferior.setVisible(false);
        this.menuInicio.restablecer();
        this.panelInferior.restablecer();
    }
}
