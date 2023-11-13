package logica;

import java.util.Random;

public class LogicaJuego {
    private int numeroAleatorio;
    private boolean correcto;
    private int nivelDificultad;
    public LogicaJuego(int nivelDificultad) {
        this.nivelDificultad = nivelDificultad;
        this.correcto = false;
        generarNumero();
    }
    public boolean comprobarNumnero(int adivinar) {
        if (adivinar == this.getNumeroAleatorio())
            this.setCorrecto(true);
        else
            this.setCorrecto(false);
        return this.isCorrecto();
    }
    public int generarNumero() {
        Random random = new Random();

        switch (getNivelDificultad()) {
            case 0 -> this.setNumeroAleatorio(random.nextInt()*25);
            case 1 -> this.setNumeroAleatorio(random.nextInt()*50);
            case 2 -> this.setNumeroAleatorio(random.nextInt()*75);
            case 3 -> this.setNumeroAleatorio(random.nextInt()*1000);
        }
        return this.getNumeroAleatorio();
    }
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
