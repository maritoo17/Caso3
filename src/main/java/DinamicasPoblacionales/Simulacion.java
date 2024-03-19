package DinamicasPoblacionales;

import Entidades.*;

public class Simulacion {
    private CrecimientoYReproduccion crecimientoYReproduccion;
    private EventoAleatorio eventoAleatorio;
    private Animal animal;
    private Ambiente ambiente;
    private int poblacionAnterior;

    public Simulacion(CrecimientoYReproduccion crecimientoYReproduccion, EventoAleatorio eventoAleatorio, Animal animal, Ambiente ambiente) {
        this.crecimientoYReproduccion = crecimientoYReproduccion;
        this.eventoAleatorio = eventoAleatorio;
        this.animal = animal;
        this.ambiente = ambiente;
        this.poblacionAnterior = crecimientoYReproduccion.getPoblacion();
    }

    public void simular() {
        String evento = eventoAleatorio.generarEvento();
        eventoAleatorio.aplicarEvento(evento, animal, ambiente);
        ambiente.cambiarAmbiente(evento);
        crecimientoYReproduccion.crecerPoblacion();
    }

    public void calcularEstadisticas() {
        int saludPromedio = animal.getSalud();
        int poblacionActual = crecimientoYReproduccion.getPoblacion();
        String tendenciaPoblacional = (poblacionActual > poblacionAnterior) ? "creciente" : "decreciente";
        poblacionAnterior = poblacionActual;
    }

    public void presentarEstadisticas() {
        System.out.println("Salud promedio de los animales: " + animal.getSalud());
        System.out.println("Tendencia poblacional: " + ((crecimientoYReproduccion.getPoblacion() > poblacionAnterior) ? "creciente" : "decreciente"));
    }
}