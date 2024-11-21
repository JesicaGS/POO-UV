import java.util.Scanner;

import Escuela.Section;
import Escuela.Student;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        Section lis301 = new Section();
        int opcion;

        do {
            System.out.println("1) Agregar\n2) Buscar\n3) Borrar\n4) Imprimir por género\n5) Imprimir todos\n6) Salir");
            opcion = in.nextInt();

            switch (opcion) {
                case 1: // Agregar estudiante
                    System.out.println("Ingresa ID, Nombre, Edad, Género");
                    Student st = new Student(in.nextInt(), in.next(), in.nextInt(), in.next());
                    lis301.addStudent(st);
                    break;
                case 2: // Buscar estudiante
                    System.out.println("Ingresa Id a buscar: ");
                    lis301.searchStudent(in.nextInt());
                    break;
                case 3: // Borrar estudiante
                    
                    break;
                case 4: // Imprimir por género

                    break;
                case 5: // Imprimir todos los estudiantes
                    System.out.println(lis301.toString());
                    break;
                
                case 6: // Salir 
                    break;

                default:
                    break;
            }

        } while (opcion != 6);
    }
}
