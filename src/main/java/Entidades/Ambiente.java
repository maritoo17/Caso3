package Entidades;

public class Ambiente {
    private String clima;
    private String terreno;
    private int recursosDisponibles;

    public Ambiente(String clima, String terreno, int recursosDisponibles) {
        this.clima = clima;
        this.terreno = terreno;
        this.recursosDisponibles = recursosDisponibles;
    }

    public void cambiarAmbiente (String evento) {
        switch (evento) {
            case "lluvia":
                this.clima = "lluvioso";
                this.recursosDisponibles += 20;
                break;
            case "sequia":
                this.clima = "seco";
                this.recursosDisponibles -= 20;
                break;
            default:
                System.out.println ("Evento no reconocido");
                break;
        }
    }

    public String getClima() {
        return clima;
    }

    public void setClima(String clima) {
        this.clima = clima;
    }

    public String getTerreno() {
        return terreno;
    }

    public void setTerreno(String terreno) {
        this.terreno = terreno;
    }

    public int getRecursosDisponibles() {
        return recursosDisponibles;
    }

    public void setRecursosDisponibles(int recursosDisponibles) {
        this.recursosDisponibles = recursosDisponibles;
    }
}