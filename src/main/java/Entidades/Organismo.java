package Entidades;

public abstract class Organismo {
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

    public abstract void mover();
    public abstract void reproducirse(Organismo pareja);
    public abstract void envejecer();


    public int getSalud() {
        return salud;
    }

    public void setSalud(int salud) {
        this.salud = salud;
    }
}
