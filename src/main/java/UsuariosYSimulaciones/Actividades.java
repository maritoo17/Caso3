package UsuariosYSimulaciones;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Actividades {
    private static final Logger LOGGER = Logger.getLogger(Actividades.class.getName());

    public void registrar(String mensaje) {
        LOGGER.log(Level.INFO, mensaje);
    }
}