public class ColaDinamica<T> {
    private Nodo<T> frente;
    private Nodo<T> fin;
    private int tamaño;

    // Clase interna Nodo genérica
    private static class Nodo<T> {
        T dato;
        Nodo<T> siguiente;

        public Nodo(T dato) {
            this.dato = dato;
            this.siguiente = null;
        }
    }

    // Constructor
    public ColaDinamica() {
        this.frente = null;
        this.fin = null;
        this.tamaño = 0;
    }

    // Método para encolar (añadir elemento)
    public void encolar(T elemento) {
        Nodo<T> nuevoNodo = new Nodo<>(elemento);
        
        if (estaVacia()) {
            frente = nuevoNodo;
            fin = nuevoNodo;
        } else {
            fin.siguiente = nuevoNodo;
            fin = nuevoNodo;
        }
        tamaño++;
    }

    // Método para desencolar (eliminar y retornar elemento)
    public T desencolar() {
        if (estaVacia()) {
            System.out.println("La cola está vacía");
            return null;
        }
        
        T elemento = frente.dato;
        frente = frente.siguiente;
        tamaño--;
        
        // Si la cola queda vacía, actualizar fin
        if (frente == null) {
            fin = null;
        }
        
        return elemento;
    }

    // Método para ver el frente sin eliminarlo
    public T frente() {
        if (estaVacia()) {
            System.out.println("La cola está vacía");
            return null;
        }
        return frente.dato;
    }

    // Métodos de verificación
    public boolean estaVacia() {
        return frente == null;
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
        Nodo<T> actual = frente;
        while (actual != null) {
            System.out.print(actual.dato + " ");
            actual = actual.siguiente;
        }
        System.out.println();
    }

    // Método para vaciar la cola
    public void vaciar() {
        frente = null;
        fin = null;
        tamaño = 0;
    }

    // Método para convertir la cola a array
    @SuppressWarnings("unchecked")
    public T[] toArray() {
        T[] array = (T[]) new Object[tamaño];
        Nodo<T> actual = frente;
        int index = 0;
        
        while (actual != null) {
            array[index++] = actual.dato;
            actual = actual.siguiente;
        }
        
        return array;
    }
}
