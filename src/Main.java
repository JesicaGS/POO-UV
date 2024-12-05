import AtencionMedica.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SistemaMedico sistema = new SistemaMedico(10, 5, 15);
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("\n====== Menú del Sistema Médico ======");
            System.out.println("1. Agregar Paciente");
            System.out.println("2. Agregar Médico");
            System.out.println("3. Agendar Cita");
            System.out.println("4. Generar Receta");
            System.out.println("5. Listar Pacientes");
            System.out.println("6. Listar Médicos");
            System.out.println("7. Listar Citas");
            System.out.println("8. Ver Detalles de Paciente");
            System.out.println("9. Ver Detalles de Médico");
            System.out.println("10. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre del paciente: ");
                    String nombrePaciente = scanner.nextLine();
                    System.out.print("Ingrese la edad del paciente: ");
                    int edad = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Ingrese el género del paciente: ");
                    String genero = scanner.nextLine();
                    System.out.print("Ingrese el contacto de emergencia: ");
                    String contacto = scanner.nextLine();
                    sistema.agregarPaciente(new Paciente(nombrePaciente, edad, genero, contacto));
                    break;

                case 2:
                    System.out.print("Ingrese el nombre del médico: ");
                    String nombreMedico = scanner.nextLine();
                    System.out.print("Ingrese la especialidad del médico: ");
                    String especialidad = scanner.nextLine();
                    sistema.agregarMedico(new Medico(nombreMedico, especialidad));
                    break;

                case 3:
                    System.out.println("Seleccione un paciente por número:");
                    sistema.listarPacientes();
                    int indicePaciente = scanner.nextInt() - 1;
                    System.out.println("Seleccione un médico por número:");
                    sistema.listarMedicos();
                    int indiceMedico = scanner.nextInt() - 1;

                    System.out.print("Ingrese la fecha y hora de la cita (yyyy-MM-dd HH:mm): ");
                    scanner.nextLine();
                    String fechaHora = scanner.nextLine();
                    LocalDateTime fechaCita = LocalDateTime.parse(fechaHora, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));

                    Paciente paciente = sistema.getPaciente(indicePaciente);
                    Medico medico = sistema.getMedico(indiceMedico);
                    paciente.agendarCita(new Cita(paciente, medico, fechaCita));
                    break;

                case 4:

                    System.out.println("Seleccione un médico por número:");
                    sistema.listarMedicos();
                    int indiceMedicoReceta = scanner.nextInt() - 1;
                    System.out.println("Seleccione un paciente por número:");
                    sistema.listarPacientes();
                    int indicePacienteReceta = scanner.nextInt() - 1;

                    scanner.nextLine(); 
                    System.out.print("Ingrese los medicamentos separados por coma: ");
                    String[] medicamentos = scanner.nextLine().split(",");
                    System.out.print("Ingrese las indicaciones: ");
                    String indicaciones = scanner.nextLine();

                    Medico medicoReceta = sistema.getMedico(indiceMedicoReceta);
                    Paciente pacienteReceta = sistema.getPaciente(indicePacienteReceta);
                    medicoReceta.darReceta(pacienteReceta, medicamentos, indicaciones);
                    break;

                case 5:
                    sistema.listarPacientes();
                    break;

                case 6:
                    sistema.listarMedicos();
                    break;

                case 7:
                    sistema.listarCitas();
                    break;

                case 8:
                    sistema.listarPacientes();
                    System.out.print("Seleccione el número del paciente: ");
                    int pacienteIndex = scanner.nextInt() - 1;
                    sistema.mostrarPaciente(pacienteIndex);
                    break;

                case 9:
                    sistema.listarMedicos();
                    System.out.print("Seleccione el número del médico: ");
                    int medicoIndex = scanner.nextInt() - 1;
                    sistema.mostrarMedico(medicoIndex);
                    break;

                case 10:
                    salir = true;
                    System.out.println("¡Gracias por usar el sistema médico!");
                    break;

                default:
                    System.out.println("Opción inválida. Por favor, intente nuevamente.");
                    break;
            }
        }

        scanner.close();
    }
}