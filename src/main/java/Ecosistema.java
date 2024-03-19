import Entidades.*;
import DinamicasPoblacionales.*;
import UsuariosYSimulaciones.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;

public class Ecosistema {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Por favor, ingrese su nombre de usuario:");
        String nombreUsuario = scanner.nextLine();

        System.out.println("Por favor, ingrese su contraseña:");
        String contraseña = scanner.nextLine();

        Autentificacion autentificacion = new Autentificacion();
        autentificacion.registrarUsuario("admin", "adminpass", "admin");
        boolean acceso = autentificacion.iniciarSesion(nombreUsuario, contraseña);

        if (acceso) {
            Ambiente ambiente = new Ambiente("Templado", "Bosque", 400);

            List<Animal> animales = new ArrayList<>();
            animales.add(new Animal("Tigre", 10, 5, 100, 3, true, 100));
            animales.add(new Animal("Mono", 5, 10, 90, 5, true, 100));

            Planta planta = new Planta("Margarita", 0, 0, 70, 1, true, 7, 0.05);

            CrecimientoYReproduccion crecimiento = new CrecimientoYReproduccion(2, 0.05);
            EventoAleatorio eventoAleatorio = new EventoAleatorio();

            Simulacion simulacion = new Simulacion(crecimiento, eventoAleatorio, animales, ambiente);

            boolean continuar = true;
            while (continuar) {
                System.out.println ("Por favor, elija una opción:");
                System.out.println ("1. Ver los organismos del ecosistema");
                System.out.println ("2. Simular un evento durante 10 días");
                System.out.println ("3. Salir");

                int opcion = scanner.nextInt();
                switch (opcion) {
                    case 1:
                        System.out.println("Animales:");
                        for (Animal animal : animales) {
                            System.out.println("Animal en posición (" + animal.getPosicionX() + ", " + animal.getPosicionY() + ") con salud " + animal.getSalud());
                        }
                        System.out.println("Planta en posición (" + planta.getPosicionX() + ", " + planta.getPosicionY() + ") con salud " + planta.getSalud());
                        break;
                    case 2:
                        int días = 10;
                        Random random = new Random();
                        for (int i = 0; i < días; i++ ) {
                            System.out.println ("Día " + (i + 1));

                            ambiente.cambiarClima();
                            System.out.println("Clima actual: " + ambiente.getClimaActual());

                            if (random.nextDouble() < 0.5) {
                                String evento = eventoAleatorio.generarEvento();
                                System.out.println("Evento: " + evento);
                                for (Animal animal : animales) {
                                    eventoAleatorio.aplicarEvento(evento, animal, ambiente);
                                }
                            }

                            for (Animal animal : animales) {
                                animal.mover();

                                animal.comer(10);

                                if (animal.getEnergia() > 50) {
                                    Animal pareja = new Animal ("Leon", 0, 5, 100, 4, true, 100);
                                    animal.reproducirse(pareja);
                                    break;
                                }

                                animal.envejecer();
                            }

                            simulacion.presentarEstadisticas();
                        }
                        simulacion.reset();
                        break;
                    case 3:
                        continuar = false;
                        break;
                    default:
                        System.out.println("Opción no válida. Por favor, elija una opción del 1 al 3.");
                }
            }
        } else {
            System.out.println("Acceso denegado.");
        }
    }
}
