package AtencionMedica;
import java.util.Arrays;

public class Receta implements Imprimible {
    private Paciente paciente;
    private Medico medico;
    private String[] medicamentos;
    private String indicaciones;

    public Receta(Paciente paciente, Medico medico, String[] medicamentos, String indicaciones) {
        this.paciente = paciente;
        this.medico = medico;
        this.medicamentos = medicamentos;
        this.indicaciones = indicaciones;
    }

    @Override
    public void imprimir() {
        System.out.println("\n====== Receta Médica ======");
        System.out.println("Paciente: " + paciente.getNombre());
        System.out.println("Médico: " + medico.getNombre());
        System.out.println("Medicamentos: " + Arrays.toString(medicamentos));
        System.out.println("Indicaciones: " + indicaciones);
        System.out.println("===========================");
    }
}
