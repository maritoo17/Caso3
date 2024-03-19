package UsuariosYSimulaciones;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.HashMap;
import java.util.Map;

public class Autentificacion {
    private Map<String, Usuario> usuariosRegistrados = new HashMap<>();

    public boolean iniciarSesion(String nombreUsuario, String contraseña) {
        Usuario usuario = usuariosRegistrados.get(nombreUsuario);
        if (usuario != null) {
            try {
                return usuario.verificarContraseña(contraseña);
            } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public void registrarUsuario(String nombreUsuario, String contraseña, String rol) {
        try {
            usuariosRegistrados.put(nombreUsuario, new Usuario(nombreUsuario, contraseña, rol));
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            e.printStackTrace();
        }
    }
}