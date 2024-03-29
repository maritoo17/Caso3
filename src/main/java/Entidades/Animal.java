package Entidades;

import DinamicasPoblacionales.CrecimientoYReproduccion;

import java.util.Random;

public class Animal extends Organismo {
    private double energia;

    public Animal(String nombre, int posicionX, int posicionY, int salud, int edad, boolean esReproductivo, int cantidadAlimento) {
        super (posicionX, posicionY, salud, edad, esReproductivo, nombre);
        this.energia = cantidadAlimento;
    }

    @Override
    public void mover() {
        Random random = new Random();
        this.posicionX = random.nextInt(10) - 1;
        this.posicionY = random.nextInt(10) - 1;
        this.energia = this.energia - 1;
    }

    @Override
    public void reproducirse(Organismo pareja, CrecimientoYReproduccion crecimiento) {
        if (this.esReproductivo && this.energia > 50 && pareja instanceof Animal) {
            Animal parejaAnimal = (Animal) pareja;
            if (parejaAnimal.esReproductivo && parejaAnimal.getEnergia() > 50) {
                this.energia -= 25;
                parejaAnimal.setEnergia(parejaAnimal.getEnergia() - 25);
                crecimiento.setHaHabidoReproduccion(true);
            }
        }
    }

    @Override
    public void envejecer() {
        this.edad++;
        this.salud --;
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

    public int getPosicionX() {
        return posicionX;
    }

    public int getPosicionY() {
        return posicionY;
    }

    public void setPosicionX(int posicionX) {
        this.posicionX = posicionX;
    }

    public void setPosicionY(int posicionY) {
        this.posicionY = posicionY;
    }
}
