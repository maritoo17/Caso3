package UsuariosYSimulaciones;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public class Interfaz {
    private JFrame frame;
    private JPanel panel;
    private JButton startButton;
    private JButton stopButton;
    private JTextArea resultArea;
    private JTextField userField;
    private JPasswordField passwordField;
    private Usuario usuario;
    private Simulacion simulacion;
    private Registro registro;

    public Interfaz() throws NoSuchAlgorithmException, InvalidKeySpecException {
        frame = new JFrame("Simulación");
        panel = new JPanel();
        startButton = new JButton("Iniciar Simulación");
        stopButton = new JButton("Detener Simulación");
        resultArea = new JTextArea(15, 30);
        userField = new JTextField(20);
        passwordField = new JPasswordField(20);
        usuario = new Usuario("nombreUsuario", "contraseña", "rol");
        simulacion = new Simulacion();
        registro = new Registro();

        panel.setLayout(new FlowLayout());
        panel.add(new JLabel("Usuario:"));
        panel.add(userField);
        panel.add(new JLabel("Contraseña:"));
        panel.add(passwordField);
        panel.add(startButton);
        panel.add(stopButton);
        panel.add(new JScrollPane(resultArea));

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (usuario.verificarContraseña(new String(passwordField.getPassword()))) {
                        // Iniciar la simulación
                        // Guardar los resultados y configuraciones en el registro
                    } else {
                        JOptionPane.showMessageDialog(frame, "Contraseña incorrecta");
                    }
                } catch (NoSuchAlgorithmException | InvalidKeySpecException ex) {
                    ex.printStackTrace();
                }
            }
        });

        frame.add(panel);
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}


