package AnalisisAvanzado;

import UsuariosYSimulaciones.*;

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
}