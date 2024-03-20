package DinamicasPoblacionales;

import java.util.Random;

import Entidades.*;

public class EventoAleatorio {
    private String[] eventos = {"desastre natural", "enfermedad", "cambio climático"};

    public String generarEvento() {
        Random random = new Random();
        int indice = random.nextInt(eventos.length);
        return eventos[indice];
    }

    public String aplicarEvento(String evento, Animal animal, Ambiente ambiente) {
        if (animal == null || ambiente == null) {
            throw new IllegalArgumentException("El animal y el ambiente no pueden ser nulos");
        }
        String mensajeEvento = "";
        switch (evento) {
            case "desastre natural":
                animal.setSalud(animal.getSalud() - 10);
                ambiente.setRecursosDisponibles(ambiente.getRecursosDisponibles() - 20);
                mensajeEvento = "Desastre natural: los recursos disponibles en el ambiente disminuyeron en 20 unidades y la salud del animal disminuyó en 10 unidades.";
                break;
            case "enfermedad":
                animal.setSalud(animal.getSalud() - 5);
                mensajeEvento = "Enfermedad: la salud del animal disminuyó en 5 unidades.";
                break;
            case "cambio climático":
                ambiente.setRecursosDisponibles(ambiente.getRecursosDisponibles() - 30);
                mensajeEvento = "Cambio climático: los recursos disponibles en el ambiente disminuyeron en 30 unidades.";
                break;
            default:
                throw new IllegalArgumentException("Evento no válido");
        }
        return mensajeEvento;
    }
}
