package DinamicasPoblacionales;

public class CrecimientoYReproduccion {
    private int poblacion;
    private double tasaCrecimiento;

    public CrecimientoYReproduccion(int poblacion, double tasaCrecimiento) {
        if (poblacion < 0 || tasaCrecimiento < 0) {
            throw new IllegalArgumentException("La población y la tasa de crecimiento deben ser positivas");
        }
        this.poblacion = poblacion;
        this.tasaCrecimiento = tasaCrecimiento;
    }

    public int getPoblacion() {
        return this.poblacion;
    }

    public void setPoblacion(int poblacion) {
        if (poblacion < 0) {
            throw new IllegalArgumentException("La población debe ser positiva");
        }
        this.poblacion = poblacion;
    }

    public double getTasaCrecimiento() {
        return this.tasaCrecimiento;
    }

    public void setTasaCrecimiento(double tasaCrecimiento) {
        if (tasaCrecimiento < 0) {
            throw new IllegalArgumentException("La tasa de crecimiento debe ser positiva");
        }
        this.tasaCrecimiento = tasaCrecimiento;
    }

    public int crecerPoblacion() {
        this.poblacion = (int) (this.poblacion * (1 + this.tasaCrecimiento));
        return this.poblacion;
    }
}
