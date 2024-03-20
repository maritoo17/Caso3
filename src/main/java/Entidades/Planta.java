package Entidades;

public class Planta extends Organismo {
    private int cantidadFotosintesis;
    private double tasaCrecimiento;

    public Planta(String nombre, int posicionX, int posicionY, int salud, int edad, boolean esReproductivo, int cantidadFotosintesis, double tasaCrecimiento) {
        super(posicionX, posicionY, salud, edad, esReproductivo, nombre);
        this.cantidadFotosintesis = cantidadFotosintesis;
        this.tasaCrecimiento = tasaCrecimiento;
    }

    public double getTasaCrecimiento() {
        return tasaCrecimiento;
    }

    public void setTasaCrecimiento(double tasaCrecimiento) {
        this.tasaCrecimiento = tasaCrecimiento;
    }

    @Override
    public void mover() {
        this.salud += this.tasaCrecimiento;
    }

    @Override
    public void reproducirse (Organismo pareja) {
        if (this.esReproductivo && this.salud > 50) {
        }
    }

    @Override
    public void envejecer() {
        this.edad++;
        this.salud -= 0.5;
        if (this.edad > 1) {
            this.esReproductivo = true;
        }
    }

    public int getPosicionX() {
        return posicionX;
    }

    public int getPosicionY() {
        return posicionY;
    }
}
