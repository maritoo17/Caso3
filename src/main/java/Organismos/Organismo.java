package Organismos;

public class Organismo {
    protected int posicionX;
    protected int posicionY;
    protected int salud;
    protected int edad;
    protected boolean esReproductivo;

    public Organismo(int posicionX, int posicionY, int salud, int edad, boolean esReproductivo) {
        this.posicionX = posicionX;
        this.posicionY = posicionY;
        this.salud = salud;
        this.edad = edad;
        this.esReproductivo = esReproductivo;
    }

    public void mover(int x, int y) {
        this.posicionX = x;
        this.posicionY = y;
    }

    public void alimentar(int cantidad) {
        this.salud += cantidad;
    }

    public void envejecer() {
        this.edad++;
    }

    public void reproducir() {
        if (this.esReproductivo) {
            System.out.println("Reproduciendo...");
        } else {
            System.out.println("No es reproductivo");
        }
    }

    public void mostrarEstado() {
        System.out.println("Posicion: (" + this.posicionX + ", " + this.posicionY + ")");
        System.out.println("Salud: " + this.salud);
        System.out.println("Edad: " + this.edad);
        System.out.println("Es reproductivo: " + this.esReproductivo);
    }
}
