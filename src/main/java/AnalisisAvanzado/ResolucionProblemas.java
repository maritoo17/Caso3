package AnalisisAvanzado;

import UsuariosYSimulaciones.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ResolucionProblemas {
    private Simulacion simulacion;
    private Registro registro;

    public ResolucionProblemas(Simulacion simulacion, Registro registro) {
        this.simulacion = simulacion;
        this.registro = registro;
    }

    public void buscarEquilibriosEcologicos() {
        simulacion.iniciarSimulacion();
        simulacion.ejecutarSimulacion();
        String resultados = simulacion.obtenerResultados();
        registro.agregarRegistro(resultados);
    }

    public void evaluarEstrategiasConservacion() {
        simulacion.iniciarSimulacion();
        simulacion.ejecutarSimulacion();
        String resultados = simulacion.obtenerResultados();
        registro.agregarRegistro(resultados);
    }

    public void guardarResultados(String nombreArchivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {
            writer.write(registro.obtenerRegistros());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}