import java.util.Scanner;

public class Promedio {
    Scanner entrada = new Scanner(System.in);
    static int numeroMaterias;
    int[] calificacion;
    int[] credito;
    int[] total;

    public Promedio(int numeroMaterias) {
        calificacion = new int[numeroMaterias];
        credito = new int[numeroMaterias];
        total = new int[numeroMaterias];
    }

    public void Calificaciones(int[] calificacion) {
        for (int i = 0; i < calificacion.length; i++) {
            System.out.print("Ingrese la calificación " + (i + 1) + ": ");
            calificacion[i] = entrada.nextInt();
        }
    }

    public void Creditos(int[] credito) {
        for (int j = 0; j < credito.length; j++) {
            System.out.print("Ingrese los créditos " + (j + 1) + ": ");
            credito[j] = entrada.nextInt();
        }
    }

    public int[] Total(int[] calificacion, int[] credito) {
        int[] totalMultiplicacion = new int[calificacion.length];
        for (int m = 0; m < calificacion.length; m++) {
            totalMultiplicacion[m] = calificacion[m] * credito[m];
        }
        return totalMultiplicacion;
    }

    public int Totales(int[] total, int[] calificacion, int[] credito) {
        int sumaTotales = 0;
        for (int k = 0; k < total.length; k++) {
            total[k] = calificacion[k] * credito[k];
            sumaTotales += total[k];
        }
        return sumaTotales;
    }

    public double promedioPonderado(int[] total, int[] calificacion, int[] credito) {
        int sumaTotales = 0;
        int sumaCreditos = 0;

        for (int l = 0; l < total.length; l++) {
            total[l] = calificacion[l] * credito[l];
            sumaTotales += total[l];
            sumaCreditos += credito[l];
        }
        return sumaTotales / sumaCreditos;
    }

    public void imprimirTabla() {
        System.out.println("\n| Calificación | Créditos | Total Multiplicado |");
        System.out.println("|--------------|----------|--------------------|");
        
        for (int i = 0; i < numeroMaterias; i++) {
            System.out.printf("| %12d | %8d | %18d |\n", calificacion[i], credito[i], total[i]);
        }
        
        System.out.println("|--------------|----------|--------------------|");
    }

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.print("Ingrese el número de materias: ");
        numeroMaterias = entrada.nextInt();

        Promedio promedio = new Promedio(numeroMaterias);
        
        promedio.Calificaciones(promedio.calificacion);
        promedio.Creditos(promedio.credito);
        
        int sumaTotales = promedio.Totales(promedio.total, promedio.calificacion, promedio.credito);
        double promedioPonderado = promedio.promedioPonderado(promedio.total, promedio.calificacion, promedio.credito);
        
        promedio.imprimirTabla();

        System.out.println("La suma total de calificaciones ponderadas es: " + sumaTotales);
        System.out.println("El promedio ponderado es: " + promedioPonderado);
    }
}