import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class EvaluacionU2 {

    private ArrayList<Double> calificaciones;

    // Constructor
    public EvaluacionU2() {
        this.calificaciones = new ArrayList<>();
    }

    // Método para ingresar calificaciones
    public void ingresarCalificaciones() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("Ingrese la calificación del estudiante (0-100): ");
                double calificacion = Double.parseDouble(scanner.nextLine());

                if (calificacion >= 0 && calificacion <= 100) {
                    calificaciones.add(calificacion);
                } else {
                    System.out.println("La calificación debe estar entre 0 y 100.");
                }

                System.out.print("¿Desea ingresar otra calificación? (s/n): ");
                String continuar = scanner.nextLine().toLowerCase();
                if (!continuar.equals("s")) {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingrese un número válido.");
            }
        }
    }

    // Calcular la suma de todas las calificaciones
    public double calcularSuma() {
        double suma = 0;
        for (double calificacion : calificaciones) {
            suma += calificacion;
        }
        return suma;
    }

    // Calcular el promedio
    public double calcularPromedio() {
        if (!calificaciones.isEmpty()) {
            return calcularSuma() / calificaciones.size();
        }
        return 0;
    }

    // Obtener calificación máxima y mínima
    public double[] obtenerMaxMin() {
        double max = Collections.max(calificaciones);
        double min = Collections.min(calificaciones);
        return new double[]{max, min};
    }

    // Contar aprobados y reprobados según umbral
    public int[] contarAprobadosReprobados(double umbral) {
        int aprobados = 0;
        int reprobados = 0;
        for (double calificacion : calificaciones) {
            if (calificacion >= umbral) {
                aprobados++;
            } else {
                reprobados++;
            }
        }
        return new int[]{aprobados, reprobados};
    }

    // Mostrar calificaciones ordenadas
    public void mostrarCalificacionesOrdenadas() {
        Collections.sort(calificaciones);
        System.out.println("Calificaciones ordenadas de menor a mayor:");
        for (int i = 0; i < calificaciones.size(); i++) {
            System.out.println("Estudiante " + (i + 1) + ": " + calificaciones.get(i));
        }
    }

    // Mostrar resultados finales
    public void mostrarResultados() {
        System.out.println("\n--- Resultados del análisis de calificaciones ---");
        System.out.println("Suma total de calificaciones: " + calcularSuma());
        System.out.printf("Promedio general: %.2f\n", calcularPromedio());

        double[] maxMin = obtenerMaxMin();
        System.out.println("Calificación máxima: " + maxMin[0]);
        System.out.println("Calificación mínima: " + maxMin[1]);

        int[] aprobReprob = contarAprobadosReprobados(70);
        System.out.println("Total de aprobados (>= 70): " + aprobReprob[0]);
        System.out.println("Total de reprobados (< 70): " + aprobReprob[1]);

        mostrarCalificacionesOrdenadas();
    }

    // Clase Principal para ejecutar el sistema
    public static void main(String[] args) {
        // Crear la instancia de la clase EvaluacionU2
        EvaluacionU2 sistema = new EvaluacionU2();

        // Ingresar las calificaciones
        sistema.ingresarCalificaciones();

        // Mostrar los resultados
        sistema.mostrarResultados();
    }
}
