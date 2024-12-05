package AtencionMedica;

public class Medico implements Imprimible {
    private String nombre;
    private String especialidad;

    public Medico(String nombre, String especialidad) {
        this.nombre = nombre;
        this.especialidad = especialidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public Receta darReceta(Paciente paciente, String[] medicamentos, String indicaciones) {
        Receta receta = new Receta(paciente, this, medicamentos, indicaciones);
        System.out.println("Receta creada para el paciente " + paciente.getNombre());
        receta.imprimir();
        return receta;
    }

    @Override
    public void imprimir() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "====== Médico ======\n" +
                "Nombre: " + nombre + "\n" +
                "Especialidad: " + especialidad + "\n" +
                "====================";
    }
}
