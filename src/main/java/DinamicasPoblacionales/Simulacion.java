package DinamicasPoblacionales;

import Entidades.*;

import java.util.List;

public class Simulacion {
    private CrecimientoYReproduccion crecimientoYReproduccion;
    private EventoAleatorio eventoAleatorio;
    private List<Animal> animal;
    private Ambiente ambiente;
    private int poblacionAnterior;
    private int saludPromedio;

    public Simulacion(CrecimientoYReproduccion crecimientoYReproduccion, EventoAleatorio eventoAleatorio, List<Animal> animales, Ambiente ambiente) {
        if (crecimientoYReproduccion == null || eventoAleatorio == null || animales == null || ambiente == null) {
            throw new IllegalArgumentException("Los argumentos no pueden ser nulos");
        }
        this.crecimientoYReproduccion = crecimientoYReproduccion;
        this.eventoAleatorio = eventoAleatorio;
        this.animal = animales;
        this.ambiente = ambiente;
        this.poblacionAnterior = crecimientoYReproduccion.getPoblacion();
    }

    public void simular() {
        String evento = eventoAleatorio.generarEvento();
        String mensajeEvento = "";
        for (Animal animal : animal) {
            if (mensajeEvento.isEmpty()) {
                mensajeEvento = eventoAleatorio.aplicarEvento(evento, animal, ambiente);
            } else {
                eventoAleatorio.aplicarEvento(evento, animal, ambiente);
            }
        }
        if (!mensajeEvento.isEmpty()) {
            System.out.println(mensajeEvento);
        }
        ambiente.cambiarClima();
        crecimientoYReproduccion.crecerPoblacion();
    }

    public void calcularEstadisticas() {
        int saludTotal = 0;
        if (!animal.isEmpty()) {
            for (Animal animal : animal) {
                saludTotal += animal.getSalud();
        }
            saludPromedio = saludTotal / animal.size();
        } else {
            saludPromedio = 0;
        }

        String tendenciaPoblacional = crecimientoYReproduccion.getHaHabidoReproduccion() ? "creciente" : "decreciente";
        poblacionAnterior = crecimientoYReproduccion.getPoblacion();
    }

    public void presentarEstadisticas() {
        calcularEstadisticas();
        System.out.println("Salud promedio de los animales: " + saludPromedio);
        System.out.println("Tendencia poblacional: " + (crecimientoYReproduccion.getHaHabidoReproduccion() ? "creciente" : "decreciente"));
        System.out.println("Recursos disponibles en el ambiente: " + ambiente.getRecursosDisponibles() + "\n");
        crecimientoYReproduccion.setHaHabidoReproduccion(false);
        poblacionAnterior = crecimientoYReproduccion.getPoblacion();
    }

    public void reset() {
        this.crecimientoYReproduccion.setPoblacion(poblacionAnterior);
        for (Animal animal : animal) {
            animal.setSalud(100);
        }
        ambiente.setRecursosDisponibles(100);
        ambiente.setClimaActual("normal");
    }
}