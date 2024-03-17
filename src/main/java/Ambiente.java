public class Ambiente {
    private String clima;
    private String terreno;
    private String recursosDisponibles;

    public Ambiente(String clima, String terreno, String recursosDisponibles) {
        this.clima = clima;
        this.terreno = terreno;
        this.recursosDisponibles = recursosDisponibles;
    }

    // Getters and setters for each attribute
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

    public String getRecursosDisponibles() {
        return recursosDisponibles;
    }

    public void setRecursosDisponibles(String recursosDisponibles) {
        this.recursosDisponibles = recursosDisponibles;
    }
}