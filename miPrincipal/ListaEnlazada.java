public class ListaEnlazada<T> {
    private Nodo inicio;
    private Nodo fin;

    // Clase interna Nodo
    private class Nodo {
        private T dato;
        private Nodo siguiente;

        public Nodo(T dato) {
            this.dato = dato;
            this.siguiente = null;
        }

        public T getDato() {
            return dato;
        }

        public Nodo getSiguiente() {
            return siguiente;
        }

        public void setSiguiente(Nodo siguiente) {
            this.siguiente = siguiente;
        }
    }

    // Constructor de la lista
    public ListaEnlazada() {
        this.inicio = null;
        this.fin = null;
    }

    // Método para verificar si la lista está vacía
    public boolean vacia() {
        return inicio == null;
    }

    // Insertar al inicio
    public void insertarInicio(T dato) {
        Nodo nuevo = new Nodo(dato);
        if (vacia()) {
            inicio = fin = nuevo;
        } else {
            nuevo.setSiguiente(inicio);
            inicio = nuevo;
        }
    }

    // Insertar al final
    public void insertarFinal(T dato) {
        Nodo nuevo = new Nodo(dato);
        if (vacia()) {
            inicio = fin = nuevo;
        } else {
            fin.setSiguiente(nuevo);
            fin = nuevo;
        }
    }

    // Mostrar la lista
    public void mostrar() {
        if (vacia()) {
            System.out.println("La lista está vacía.");
        } else {
            Nodo actual = inicio;
            while (actual != null) {
                System.out.print(actual.getDato() + " -> ");
                actual = actual.getSiguiente();
            }
            System.out.println("null");
        }
    }
    public void eliminarInicio() {
    if (vacia()) {
        System.out.println("La lista ya está vacía. No se puede eliminar.");
    } else {
        inicio = inicio.getSiguiente();
        if (inicio == null) {
            // Si la lista queda vacía después de eliminar, actualizamos también el fin
            fin = null;
        }
    }
}
}

