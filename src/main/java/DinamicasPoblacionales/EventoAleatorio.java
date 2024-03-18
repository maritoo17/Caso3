package DinamicasPoblacionales;

import Entidades.*;

import java.util.Random;

public class EventoAleatorio {
    private String[] eventos = {"desastre natural", "enfermedad", "cambio climático"};

    public String generarEvento() {
        Random random = new Random();
        int indice = random.nextInt(eventos.length);
        return eventos[indice];
    }

    public void aplicarEvento(String evento, Animal animal, Ambiente ambiente) {
        switch (evento) {
            case "desastre natural":
                animal.setSalud(animal.getSalud() - 10);
                ambiente.setRecursosDisponibles (ambiente.getRecursosDisponibles()- 20);
                break;
            case "enfermedad":
                animal.setSalud(animal.getSalud() - 20);
                break;
            case "cambio climático":
                ambiente.setRecursosDisponibles(ambiente.getRecursosDisponibles() - 30);
                break;
        }
    }
}