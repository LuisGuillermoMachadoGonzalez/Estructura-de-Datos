public class MetodosRecursivos {

    // Suma de los primeros n números naturales
    public int suma(int n) {
        if (n <= 0) return 0;
        return n + suma(n - 1);
    }

    // Factorial de un número
    public int factorial(int n) {
        if (n <= 1) return 1;
        return n * factorial(n - 1);
    }

    // Tabla de multiplicar de un número hasta cierto límite
    public void tablaMultiplicar(int numero, int limite) {
        if (limite <= 0) return;
        tablaMultiplicar(numero, limite - 1);
        System.out.println(numero + " x " + limite + " = " + (numero * limite));
    }

    // Invertir una cadena
    public String invertirCadena(String cadena) {
        if (cadena.isEmpty()) return cadena;
        return invertirCadena(cadena.substring(1)) + cadena.charAt(0);
    }

    // Sumar los elementos de un arreglo
    public int sumaArreglo(int[] arreglo, int indice) {
        if (indice >= arreglo.length) return 0;
        return arreglo[indice] + sumaArreglo(arreglo, indice + 1);
    }

    // Buscar un elemento en un arreglo
    public boolean buscarElemento(int[] arreglo, int elemento, int indice) {
        if (indice >= arreglo.length) return false;
        if (arreglo[indice] == elemento) return true;
        return buscarElemento(arreglo, elemento, indice + 1);
    }

    // Contar los dígitos de un número
    public int contarDigitos(int numero) {
        numero = Math.abs(numero); // Para manejar números negativos
        if (numero < 10) return 1;
        return 1 + contarDigitos(numero / 10);
    }

    // Método principal para probar
    public static void main(String[] args) {
        MetodosRecursivos mr = new MetodosRecursivos();

        System.out.println("Suma: " + mr.suma(5));
        System.out.println("Factorial: " + mr.factorial(5));
        System.out.println("Tabla de multiplicar:");
        mr.tablaMultiplicar(3, 10);
        System.out.println("Invertir cadena: " + mr.invertirCadena("Hola"));
        int[] arreglo = {1, 2, 3, 4, 5};
        System.out.println("Suma arreglo: " + mr.sumaArreglo(arreglo, 0));
        System.out.println("Buscar elemento 3: " + mr.buscarElemento(arreglo, 3, 0));
        System.out.println("Contar dígitos de 12345: " + mr.contarDigitos(12345));
    }
}
