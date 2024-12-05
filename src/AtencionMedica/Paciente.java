package AtencionMedica;

public class Paciente implements Imprimible {
    private String nombre;
    private int edad;
    private String genero;
    private String contactoEmergencia;
    private Cita[] citas;
    private int numCitas = 0;

    public Paciente(String nombre, int edad, String genero, String contactoEmergencia) {
        this.nombre = nombre;
        this.edad = edad;
        this.genero = genero;
        this.contactoEmergencia = contactoEmergencia;
        this.citas = new Cita[10];
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getContactoEmergencia() {
        return contactoEmergencia;
    }

    public void setContactoEmergencia(String contactoEmergencia) {
        this.contactoEmergencia = contactoEmergencia;
    }

    public void agendarCita(Cita cita) {
        if (numCitas < citas.length) {
            citas[numCitas] = cita;
            numCitas++;
            System.out.println("¡Cita agendada exitosamente!");
            cita.imprimir();
        } else {
            System.out.println("No se pueden agendar más citas para este paciente.");
        }
    }

    @Override
    public void imprimir() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "====== Paciente ======\n" +
                "Nombre: " + nombre + "\n" +
                "Edad: " + edad + "\n" +
                "Género: " + genero + "\n" +
                "Contacto de Emergencia: " + contactoEmergencia + "\n" +
                "======================";
    }
}
