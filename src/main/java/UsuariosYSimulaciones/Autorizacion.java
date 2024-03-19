package UsuariosYSimulaciones;

public class Autorizacion {
    public boolean verificarAcceso(Usuario usuario, String accion) {
        if ("admin".equals(usuario.getRol()) && "configurarSimulacion".equals(accion)) {
            return true;
        }
        return false;
    }
}