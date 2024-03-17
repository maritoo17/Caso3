import Organismos.*;

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

    public void competirPorRecursos (Organismo organismo1, Organismo organismo2){
        if (organismo1.getSalud() > 0 && organismo2.getSalud() > 0){
            System.out.println("Competencia por recursos...");
            if (organismo1.getSalud() > organismo2.getSalud()){
                organismo1.setSalud(organismo1.getSalud() + organismo2.getSalud());
                organismo2.setSalud(0);
            } else {
                organismo2.setSalud(organismo2.getSalud() + organismo1.getSalud());
                organismo1.setSalud(0);
            }
        } else {
            System.out.println("No pueden competir, uno de los dos está muerto");
        }
    }
}