package UsuariosYSimulaciones;

public class Simulacion {
    private String estado;

    public Simulacion() {
        this.estado = "No iniciada";
    }

    public void iniciarSimulacion() {
        this.estado = "Iniciada";
    }

    public void ejecutarSimulacion() {
        this.estado = "Ejecutada";
    }

    public String obtenerResultados() {
        return "Resultados de la simulación: " + this.estado;
    }

    public double obtenerDatos() {
        return 10.0;
    }
}