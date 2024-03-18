package Entidades;

import java.util.Random;

public abstract class Animal extends Organismo {
    private double energia;

    public Animal(int posicionX, int posicionY, int salud, int edad, boolean esReproductivo, int cantidadAlimento) {
        super(posicionX, posicionY, salud, edad, esReproductivo);
        this.energia = energia;
    }

    @Override
    public void mover() {
        Random random = new Random();
        this.posicionX = random.nextInt(10) - 1;
        this.posicionY = random.nextInt(10) - 1;
        this.energia = this.energia - 1;
    }

    @Override
    public void reproducirse(Organismo pareja) {
        if (this.esReproductivo && this.energia > 50 && pareja instanceof Animal) {
        }
    }

    @Override
    public void envejecer() {
        this.edad++;
        this.salud -= 0.5;
        if (this.edad > 1) ;
    }

    public void comer (double cantidadAlimento) {
        this.energia += cantidadAlimento;
        if (this.energia > 100) {
            this.energia = 100;
        }
    }

    public double getEnergia() {
        return energia;
    }

    public void setEnergia(double energia) {
        this.energia = energia;
    }
}