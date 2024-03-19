package UsuariosYSimulaciones;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;

public class Usuario {
    private String nombreUsuario;
    private byte[] contraseñaHash;
    private byte[] sal;
    private String rol;

    public Usuario(String nombreUsuario, String contraseña, String rol) throws NoSuchAlgorithmException, InvalidKeySpecException {
        this.nombreUsuario = nombreUsuario;
        this.rol = rol;
        this.sal = generarSal();
        this.contraseñaHash = hashContraseña(contraseña.toCharArray(), this.sal);
    }

    private static byte[] generarSal() {
        SecureRandom random = new SecureRandom();
        byte[] sal = new byte[16];
        random.nextBytes(sal);
        return sal;
    }

    private static byte[] hashContraseña(final char[] contraseña, final byte[] sal) throws NoSuchAlgorithmException, InvalidKeySpecException {
        PBEKeySpec spec = new PBEKeySpec(contraseña, sal, 65536, 128);
        Arrays.fill(contraseña, Character.MIN_VALUE);
        SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        return skf.generateSecret(spec).getEncoded();
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public boolean verificarContraseña(String contraseña) throws NoSuchAlgorithmException, InvalidKeySpecException {
        byte[] hashCalculado = hashContraseña(contraseña.toCharArray(), this.sal);
        return Arrays.equals(this.contraseñaHash, hashCalculado);
    }

    public String getRol() {
        return rol;
    }
}