package AtencionMedica;

public class SistemaMedico {
    private Paciente[] pacientes;
    private Medico[] medicos;
    private Cita[] citas;

    private int numPacientes = 0;
    private int numMedicos = 0;
    private int numCitas = 0;

    public SistemaMedico(int capacidadPacientes, int capacidadMedicos, int capacidadCitas) {
        pacientes = new Paciente[capacidadPacientes];
        medicos = new Medico[capacidadMedicos];
        citas = new Cita[capacidadCitas];
    }

    public void agregarPaciente(Paciente paciente) {
        if (numPacientes < pacientes.length) {
            pacientes[numPacientes] = paciente;
            numPacientes++;
            System.out.println("Paciente agregado: " + paciente.getNombre());
        } else {
            System.out.println("No hay espacio para más pacientes.");
        }
    }

    public void agregarMedico(Medico medico) {
        if (numMedicos < medicos.length) {
            medicos[numMedicos] = medico;
            numMedicos++;
            System.out.println("Médico agregado: " + medico.getNombre());
        } else {
            System.out.println("No hay espacio para más médicos.");
        }
    }

    public void listarPacientes() {
        System.out.println("\nLista de pacientes:");
        for (int i = 0; i < numPacientes; i++) {
            System.out.println((i + 1) + ". " + pacientes[i].getNombre());
        }
    }

    public void listarMedicos() {
        System.out.println("\nLista de médicos:");
        for (int i = 0; i < numMedicos; i++) {
            System.out.println((i + 1) + ". " + medicos[i].getNombre());
        }
    }

    public void listarCitas() {
        System.out.println("\nLista de citas:");
        for (int i = 0; i < numCitas; i++) {
            citas[i].imprimir();
        }
    }

    public void mostrarPaciente(int index) {
        if (index >= 0 && index < numPacientes) {
            pacientes[index].imprimir();
        } else {
            System.out.println("Índice de paciente inválido.");
        }
    }

    public void mostrarMedico(int index) {
        if (index >= 0 && index < numMedicos) {
            medicos[index].imprimir();
        } else {
            System.out.println("Índice de médico inválido.");
        }
    }

    public Paciente getPaciente(int index) {
        return (index >= 0 && index < numPacientes) ? pacientes[index] : null;
    }

    public Medico getMedico(int index) {
        return (index >= 0 && index < numMedicos) ? medicos[index] : null;
    }
}
