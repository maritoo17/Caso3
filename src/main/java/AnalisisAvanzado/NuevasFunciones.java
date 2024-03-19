package AnalisisAvanzado;

import java.util.ArrayList;
import java.util.List;

public class NuevasFunciones {
    private List<FuncionPersonalizada> funciones;

    public NuevasFunciones() {
        this.funciones = new ArrayList<>();
    }

    public void agregarFuncion(FuncionPersonalizada funcion) {
        this.funciones.add(funcion);
    }

    public double aplicarFunciones(double input) {
        double resultado = input;
        for (FuncionPersonalizada funcion : funciones) {
            resultado = funcion.calcular(resultado);
        }
        return resultado;
    }
}