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

    public void predar (Animal presa){
        if (this.salud > 0){
            System.out.println("Predando...");
            this.salud += presa.salud;
            presa.salud = 0;
        } else {
            System.out.println("No puede predar, está muerto");
        }
    }

    public Animal reproducirse() {
        if (this.esReproductivo) {
            System.out.println("Reproduciendo...");
            return new Animal(this.posicionX, this.posicionY, this.salud, this.edad, this.esReproductivo, this.cantidadAlimento);
        } else {
            System.out.println("No es reproductivo");
            return null;
        }
    }
}
