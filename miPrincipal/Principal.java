import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        EvaluacionU2 evaluacion = new EvaluacionU2();
        evaluacion.ingresarCalificaciones();

        double suma = evaluacion.calcularSuma();
        double promedio = evaluacion.calcularPromedio();
        double[] maxMin = evaluacion.obtenerMaxMin();

        System.out.println("Suma de calificaciones: " + suma);
        System.out.println("Promedio de calificaciones: " + promedio);
        System.out.println("Calificación máxima: " + maxMin[0]);
        System.out.println("Calificación mínima: " + maxMin[1]);
        evaluacion.mostrarResultados();
        
    }
}
    
       