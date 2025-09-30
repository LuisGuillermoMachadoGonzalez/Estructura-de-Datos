
public class Principal {
    public static void main(String[] args) {
         
        Pilas<String> pila = new Pilas<>(8);
        pila.Insertar("memo");
        pila.Insertar("fer");
        pila.Insertar("arielin");
        pila.Insertar("jano");
        

        

        System.out.println("Contenido de la pila:");
        pila.Mostrar();
        System.out.println("Elemento borrado:" + pila.Retirar());

        System.out.println("Contenido de la pila despues de retirarla:");
        pila.Mostrar();

        System.out.println("\n¿Es palíndromo?: " + pila.esPalindromo());

        pila.invertirPila();
        System.out.println("\nPila invertida:");
        pila.Mostrar();
        
         ColaSencilla<String> colaStrings = new ColaSencilla<>(4);
        
        // Pruebas con Strings
        colaStrings.encolar("Hola");
        colaStrings.encolar("Mundo");
        colaStrings.encolar("Java");
        colaStrings.mostrar();
        
        System.out.println("Frente: " + colaStrings.frente());
        System.out.println("Desencolado: " + colaStrings.desencolar());
        colaStrings.mostrar();

        ColaDinamica<Double> colaDoubles = new ColaDinamica<>();
        
        // Pruebas con Doubles
        colaDoubles.encolar(10.5);
        colaDoubles.encolar(20.3);
        colaDoubles.encolar(30.7);
        colaDoubles.encolar(40.1);
        colaDoubles.mostrar();
        
        System.out.println("Frente: " + colaDoubles.frente());
        System.out.println("Desencolado: " + colaDoubles.desencolar());
        colaDoubles.mostrar();
        System.out.println("Tamaño: " + colaDoubles.tamaño());
        
        // Lista de enteros
        ListaEnlazada<Integer> listaEnteros = new ListaEnlazada<>();
        listaEnteros.insertarInicio(10);
        listaEnteros.insertarFinal(20);
        listaEnteros.insertarInicio(5);
        listaEnteros.mostrar(); // Salida: 5 -> 10 -> 20 -> null

        // Lista de cadenas
        ListaEnlazada<String> listaStrings = new ListaEnlazada<>();
        listaStrings.insertarFinal("Hola");
        listaStrings.insertarFinal("Mundo");
        listaStrings.mostrar(); // Salida: Hola -> Mundo -> null



         
    }

}