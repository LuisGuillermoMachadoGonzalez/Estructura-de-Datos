public class RecursividadDirecta{
    public static void main(String[] args) {
        int n = 5;
    System.out.println("la suma de los primeros " + n + " numeros naturales es: " + suma(n));
    System.out.println("el factorial de " + n + " es: " + factorial(n));
    System.out.println("la potencia de " + n + " elevado a " + n + " es: " + potencia(n, n));
    System.out.println("el numero fibonacci en la posicion " + n + " es: " + fibonacci(n));
    imprimirHola(10);
}

    public static int suma(int n){
        if(n == 0){
            return 0;
        } else {
            return n + suma(n - 1);
        }
    }
    public static int factorial(int n){
        if(n == 0){
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }
    public static int potencia(int base, int exponente){
        if(exponente == 0){
            return 1;
        } else {
            return base * potencia(base, exponente - 1);
        }
    }
    public static int fibonacci(int n){
        if(n == 0){
            return 0;
        } else if(n == 1){
            return 1;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }
    //metodo recursivo que imprima 10 veces hola
    public static void imprimirHola(int n){
        if(n == 0){
            return;
        } else {
            System.out.println("hola");
            imprimirHola(n - 1);
        }
    }
    
}