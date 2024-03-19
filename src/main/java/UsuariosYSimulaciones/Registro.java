package UsuariosYSimulaciones;

import java.util.ArrayList;
import java.util.List;

public class Registro {
    private List<String> registro;

    public Registro() {
        registro = new ArrayList<>();
    }

    public void agregarRegistro(String resultado) {
        registro.add(resultado);
    }

    public String obtenerRegistros() {
        return String.join ("\n", this.registro);
    }
}