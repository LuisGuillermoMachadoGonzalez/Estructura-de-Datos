public class ColaSencilla<T> {
    private T[] elementos;
    private int frente;
    private int fin;
    private int tamaño;
    private final int capacidad;

    // Constructor
    @SuppressWarnings("unchecked")
    public ColaSencilla(int capacidad) {
        this.capacidad = capacidad;
        this.elementos = (T[]) new Object[capacidad];
        this.frente = 0;
        this.fin = -1;
        this.tamaño = 0;
    }

    // Método para encolar (añadir elemento)
    public boolean encolar(T elemento) {
        if (estaLlena()) {
            System.out.println("La cola está llena. No se puede encolar " + elemento);
            return false;
        }
        
        fin = (fin + 1) % capacidad;
        elementos[fin] = elemento;
        tamaño++;
        return true;
    }

    // Método para desencolar (eliminar y retornar elemento)
    public T desencolar() {
        if (estaVacia()) {
            System.out.println("La cola está vacía");
            return null;
        }
        
        T elemento = elementos[frente];
        elementos[frente] = null; // Liberar referencia para garbage collection
        frente = (frente + 1) % capacidad;
        tamaño--;
        return elemento;
    }

    // Método para ver el frente sin eliminarlo
    public T frente() {
        if (estaVacia()) {
            System.out.println("La cola está vacía");
            return null;
        }
        return elementos[frente];
    }

    // Métodos de verificación
    public boolean estaVacia() {
        return tamaño == 0;
    }

    public boolean estaLlena() {
        return tamaño == capacidad;
    }

    public int tamaño() {
        return tamaño;
    }

    // Método para mostrar la cola
    public void mostrar() {
        if (estaVacia()) {
            System.out.println("Cola vacía");
            return;
        }
        
        System.out.print("Cola: ");
        for (int i = 0; i < tamaño; i++) {
            int index = (frente + i) % capacidad;
            System.out.print(elementos[index] + " ");
        }
        System.out.println();
    }

    // Método para obtener la capacidad máxima
    public int capacidad() {
        return capacidad;
    }
}