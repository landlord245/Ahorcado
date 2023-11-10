package logicaJuego;

import java.util.Random;

public class numeroAdivinar {
    private int nivelDificultad;
    private int numeroAleatorio;
    public numeroAdivinar() {
    }

    public numeroAdivinar(int nivelDificultad) {
        this.nivelDificultad = nivelDificultad;
    }

    public int generarNumeroAleatorio() {
        Random random = new Random();
        switch (this.getNivelDificultad()) {
            case 0:
                this.numeroAleatorio = (int) Math.floor(random.nextInt()*10);
                break;
            case 1:
                this.numeroAleatorio = (int) Math.floor(random.nextInt()*15);
                break;
            case 2:
                this.numeroAleatorio = (int) Math.floor(random.nextInt()*50);
                break;
            case 3:
                this.numeroAleatorio = (int) Math.floor(random.nextInt()*100000000);
                break;
        }
        return this.numeroAleatorio;
    }

    public int getNivelDificultad() {
        return nivelDificultad;
    }

    public void setNivelDificultad(int nivelDificultad) {
        this.nivelDificultad = nivelDificultad;
    }
}
