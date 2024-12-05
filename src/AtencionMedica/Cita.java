package AtencionMedica;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Cita implements Imprimible {
    private Paciente paciente;
    private Medico medico;
    private LocalDateTime fechaHora;

    public Cita(Paciente paciente, Medico medico, LocalDateTime fechaHora) {
        this.paciente = paciente;
        this.medico = medico;
        this.fechaHora = fechaHora;
    }

    @Override
    public void imprimir() {
        System.out.println("\n====== Cita ======");
        System.out.println("Paciente: " + paciente.getNombre());
        System.out.println("Médico: " + medico.getNombre());
        System.out.println("Fecha y hora: " + fechaHora.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
        System.out.println("==================");
    }
}

