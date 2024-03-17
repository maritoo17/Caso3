package Organismos;

public class Planta extends Organismo {
    private int cantidadFotosintesis;

    public Planta(int posicionX, int posicionY, int salud, int edad, boolean esReproductivo, int cantidadFotosintesis) {
        super(posicionX, posicionY, salud, edad, esReproductivo);
        this.cantidadFotosintesis = cantidadFotosintesis;
    }

    public void fotosintetizar() {
        System.out.println("Fotosintetizando...");
    }

    public void mostrarEstado() {
        super.mostrarEstado();
        System.out.println("Cantidad de fotosintesis: " + this.cantidadFotosintesis);
    }

    public void polinizar (Planta planta){
        if (this.salud > 0){
            System.out.println("Polinizando...");
            this.salud += planta.salud;
            planta.salud = 0;
        } else {
            System.out.println("No puede polinizar, está muerto");
        }
    }

    public void crecer() {
        this.salud += 10;
    }

}
