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
        for (Animal animal : animal) {
            eventoAleatorio.aplicarEvento(evento, animal, ambiente);
        }
        ambiente.cambiarAmbiente(evento);
        crecimientoYReproduccion.crecerPoblacion();
    }

    public void calcularEstadisticas() {
        int saludTotal = 0;
        for (Animal animal : animal) {
            saludTotal += animal.getSalud();
        }
        saludPromedio = saludTotal / animal.size();
        int poblacionActual = crecimientoYReproduccion.getPoblacion();
        String tendenciaPoblacional = (poblacionActual > poblacionAnterior) ? "creciente" : "decreciente";
        poblacionAnterior = poblacionActual;
    }

    public void presentarEstadisticas() {
        calcularEstadisticas();
        System.out.println("Salud promedio de los animales: " + saludPromedio);
        System.out.println("Tendencia poblacional: " + ((crecimientoYReproduccion.getPoblacion() > poblacionAnterior) ? "creciente" : "decreciente"));
        System.out.println("Recursos disponibles en el ambiente: " + ambiente.getRecursosDisponibles());
        System.out.println("Clima actual: " + ambiente.getClima());
    }

    public void reset() {
        this.crecimientoYReproduccion.setPoblacion(poblacionAnterior);
        for (Animal animal : animal) {
            animal.setSalud(100);
        }
        ambiente.setRecursosDisponibles(100);
        ambiente.setClima("normal");
    }
}