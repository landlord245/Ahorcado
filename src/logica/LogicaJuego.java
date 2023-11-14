package logica;

import java.util.Random;

public class LogicaJuego {
    private int numeroAleatorio;
    private boolean correcto;
    private int nivelDificultad;
    public LogicaJuego(int nivelDificultad) {
        this.nivelDificultad = nivelDificultad;
        this.correcto = false;
    }
    public LogicaJuego() {}
    public boolean comprobarNumero(int adivinar) {
        if (adivinar == this.getNumeroAleatorio())
            this.setCorrecto(true);
        else
            this.setCorrecto(false);

        return this.isCorrecto();
    }
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
