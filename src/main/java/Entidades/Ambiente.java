package Entidades;

import java.util.Random;

public class Ambiente {
    private String[] climas = {"Templado", "Tropical", "Desértico", "Polar", "Montañoso"};
    private String climaActual;
    private String terreno;
    private int recursosDisponibles;

    public Ambiente(String climaInicial, String terreno, int recursosDisponibles) {
        this.climaActual = climaInicial;
        this.terreno = terreno;
        this.recursosDisponibles = recursosDisponibles;
    }

    public void cambiarClima () {
        int indice = new Random().nextInt(climas.length);
        this.climaActual = climas[indice];
    }

    public String getClimaActual() {
        return climaActual;
    }

    public void setClimaActual(String climaActual) {
        this.climaActual = climaActual;
    }

    public String getTerreno() {
        return terreno;
    }

    public void setTerreno(String terreno) {
        this.terreno = terreno;
    }

    public int getRecursosDisponibles() {
        return recursosDisponibles;
    }

    public void setRecursosDisponibles(int recursosDisponibles) {
        this.recursosDisponibles = recursosDisponibles;
    }
}