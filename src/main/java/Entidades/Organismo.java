package Entidades;

public abstract class Organismo {
    protected String nombre;
    protected int posicionX;
    protected int posicionY;
    protected int salud;
    protected int edad;
    protected boolean esReproductivo;

    public Organismo(int posicionX, int posicionY, int salud, int edad, boolean esReproductivo, String nombre) {
        this.posicionX = posicionX;
        this.posicionY = posicionY;
        this.salud = salud;
        this.edad = edad;
        this.esReproductivo = esReproductivo;
        this.nombre = nombre;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

}
