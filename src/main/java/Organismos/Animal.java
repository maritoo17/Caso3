package Organismos;

public class Animal extends Organismo{
    private int cantidadAlimento;

    public Animal(int posicionX, int posicionY, int salud, int edad, boolean esReproductivo, int cantidadAlimento) {
        super(posicionX, posicionY, salud, edad, esReproductivo);
        this.cantidadAlimento = cantidadAlimento;
    }

    public void comer() {
        System.out.println("Comiendo...");
    }

    public void mostrarEstado() {
        super.mostrarEstado();
        System.out.println("Cantidad de alimento: " + this.cantidadAlimento);
    }
}
