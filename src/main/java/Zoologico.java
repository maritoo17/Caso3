import Organismos.*;
import java.util.ArrayList;
import java.util.List;

public class Zoologico {
    private List<Organismo> organismos;
    private Ambiente ambiente;

    public Zoologico(Ambiente ambiente) {
        this.organismos = new ArrayList<>();
        this.ambiente = ambiente;
    }

    public void agregarOrganismo(Organismo organismo) {
        this.organismos.add(organismo);
    }

    public void imprimirOrganismos() {
        for (Organismo organismo : this.organismos) {
            organismo.mostrarEstado();
        }
    }

    public void simular() {
        ambiente.eventoAleatorio(organismos);
        ambiente.mostrarEstadisticasa(organismos);
    }

    public static void main(String[] args) {
        Ambiente ambiente = new Ambiente ("Caluroso", "Bosque", "Agua");

        Zoologico zoologico = new Zoologico(ambiente);

        Animal animal = new Animal(0, 0, 100, 0, true, 50);
        Planta planta = new Planta(0, 0, 100, 0, true, 50);

        zoologico.agregarOrganismo(animal);
        zoologico.agregarOrganismo(planta);

        zoologico.imprimirOrganismos();

        zoologico.simular();
    }
}