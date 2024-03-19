import AnalisisAvanzado.*;
import UsuariosYSimulaciones.*;

public class Ecosistema {
    public static void main(String[] args) {
        try {
            Usuario usuario = new Usuario("maritoo17", "contraseña", "Investigador");

            Simulacion simulacion = new Simulacion();

            NuevasFunciones nuevasFunciones = new NuevasFunciones();

            FuncionPersonalizada funcionPersonalizada = new FuncionPersonalizada() {
                @Override
                public double calcular(double input) {
                    return input * 2;
                }
            };

            nuevasFunciones.agregarFuncion(funcionPersonalizada);

            double resultado = nuevasFunciones.aplicarFunciones(simulacion.obtenerDatos());

            VisualizacionDatos visualizacionDatos = new VisualizacionDatos(simulacion);
            visualizacionDatos.visualizarResultados();

            visualizacionDatos.guardarGrafico("resultados.png");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}