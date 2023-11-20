package logica;

import java.util.Random;

/**
 * Esta clase contiene la generacion del numero aleatorio a adivinar.
 * Comprueba si el usuario ha hacertado el numero a adivinar.
 * Y tambien se encarga de devolver una pequeña ayuda al usuario.
 * El numero se genera en @see MainFrame.
 *
 * @see gui.PanelInferior
 * @see gui.MainFrame
 */
public class LogicaJuego {
    private int numeroAleatorio;
    private boolean correcto;
    private int nivelDificultad;
    public LogicaJuego() {}

    /**
     * Este metodo se usa para verificar si el numero indicado en el parametro
     * es el mismo que el del numero generad, devolviendo un buleano.
     * @see gui.PanelInferior
     * @param adivinar
     * @return
     */
    public boolean comprobarNumero(int adivinar) {
        if (adivinar == this.getNumeroAleatorio())
            this.setCorrecto(true);
        else
            this.setCorrecto(false);

        return this.isCorrecto();
    }

    /**
     * Generea un numero aleatorio, segun el nivel de dificultad.
     * @return
     */
    public int generarNumero() {
        Random random = new Random();
        switch (this.getNivelDificultad()) {
            case 0 -> this.setNumeroAleatorio(random.nextInt(25+1));
            case 1 -> this.setNumeroAleatorio(random.nextInt(50+1));
            case 2 -> this.setNumeroAleatorio(random.nextInt(75+1));
            case 3 -> this.setNumeroAleatorio(random.nextInt(100+1));
        }
        return this.getNumeroAleatorio();
    }

    /**
     * Metodo que devuelve una pequeña ayuda dependiendo de que proximo halla
     * sido el ultimo numero del usuario.
     * Eso si, si la dificultad seleccionada es Muy Facil, el metodo devuelve tambien el porcentaje
     * de cercania, haciendo mas facil.
     * @param numero
     * @return
     */
    public String hint(int numero){
        String hint = "";
        int proximidad = this.getNumeroAleatorio()-numero;
        proximidad = numero*100/this.getNumeroAleatorio();
        if (this.getNivelDificultad() == 0){
            if (proximidad < 25)
                hint = "Esto parece polo norte. \n"+proximidad+"%";
            else if (proximidad > 25 && proximidad < 50)
                hint = "Me estoy congelando. \n"+proximidad+"%";
            else if (proximidad > 50 && proximidad < 75)
                hint = "Muy bien, muy bien, empieza a ponerse la cosa calentita... \n"+proximidad+"%";
            else if (proximidad > 75 && proximidad < 100)
                hint = "Sopla un calido y agradable aire por esta zona... \n"+proximidad+"%";
            else
                hint = "Apuntas a lo alto, muy a lo alto... \n"+proximidad+"%";

        }else {
            if (proximidad < 25)
                hint = "Esto parece polo norte.";
            else if (proximidad > 25 && proximidad < 50)
                hint = "Me estoy congelando.";
            else if (proximidad > 50 && proximidad < 75)
                hint = "Muy bien, muy bien, empieza a ponerse la cosa calentita...";
            else if (proximidad > 75 && proximidad < 100)
                hint = "Sopla un calido y agradable aire por esta zona...";
            else
                hint = "Apuntas a lo alto, muy a lo alto...";

        }

        return hint;
    }

    /**
     * GETTER & SETTERS
     * @return
     */
    public int getNumeroAleatorio() {
        return numeroAleatorio;
    }

    public void setNumeroAleatorio(int numeroAleatorio) {
        this.numeroAleatorio = numeroAleatorio;
    }

    public boolean isCorrecto() {
        return correcto;
    }

    public void setCorrecto(boolean correcto) {
        this.correcto = correcto;
    }

    public int getNivelDificultad() {
        return nivelDificultad;
    }

    public void setNivelDificultad(int nivelDificultad) {
        this.nivelDificultad = nivelDificultad;
    }
}
