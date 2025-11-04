public class Arbol {
    // Clase Nodo dentro de la clase Arbol
    static class Nodo {
        int valor;
        Nodo LI;  // Hijo izquierdo
        Nodo LD;  // Hijo derecho

        // Constructor del Nodo
        public Nodo(int valor) {
            this.valor = valor;
            this.LI = null;
            this.LD = null;
        }
    }

    // Atributo raíz del árbol
    private Nodo raiz;

    // Constructor de la clase ArbolBinario
    public Arbol() {
        this.raiz = null;
    }

    // Método para insertar un valor en el árbol
    public void insertar(int valor) {
        if (raiz == null) {
            raiz = new Nodo(valor);  // Si el árbol está vacío, el primer nodo será la raíz
        } else {
            insertarRecursivo(raiz, valor);  // Llamada recursiva para insertar en el árbol
        }
    }

    // Método recursivo para insertar en el árbol binario de búsqueda
    private void insertarRecursivo(Nodo nodo, int valor) {
        if (valor < nodo.valor) {
            if (nodo.LI == null) {
                nodo.LI = new Nodo(valor);  // Insertar a la izquierda si es menor
            } else {
                insertarRecursivo(nodo.LI, valor);  // Recursión en el subárbol izquierdo
            }
        } else {
            if (nodo.LD == null) {
                nodo.LD = new Nodo(valor);  // Insertar a la derecha si es mayor o igual
            } else {
                insertarRecursivo(nodo.LD, valor);  // Recursión en el subárbol derecho
            }
        }
    }

    // Método para recorrer el árbol en orden (izquierda, raíz, derecha)
    public void recorrerInorden(Nodo nodo) {
        if (nodo != null) {
            recorrerInorden(nodo.LI);  // Recorrer el subárbol izquierdo
            System.out.print(nodo.valor + " ");  // Imprimir el valor del nodo
            recorrerInorden(nodo.LD);  // Recorrer el subárbol derecho
        }
    }

    // Método público para iniciar el recorrido inorden desde la raíz
    public void mostrarInorden() {
        recorrerInorden(raiz);
        System.out.println();  // Salto de línea al final del recorrido
    }

    // Método para buscar un nodo por su valor
    public Nodo buscar(int valor) {
        return buscarRecursivo(raiz, valor);
    }

    // Método recursivo para buscar un nodo por su valor
    private Nodo buscarRecursivo(Nodo nodo, int valor) {
        if (nodo == null) {
            return null;  // Si no encontramos el nodo, devolvemos null
        }
        if (nodo.valor == valor) {
            return nodo;  // Si encontramos el nodo, lo devolvemos
        } else if (valor < nodo.valor) {
            return buscarRecursivo(nodo.LI, valor);  // Buscar en el subárbol izquierdo
        } else {
            return buscarRecursivo(nodo.LD, valor);  // Buscar en el subárbol derecho
        }
    }

    // Método para mostrar un nodo por su valor
    public void mostrarNodo(int valor) {
        Nodo nodo = buscar(valor);
        if (nodo != null) {
            System.out.println("Nodo encontrado: " + nodo.valor);
        } else {
            System.out.println("Nodo con valor " + valor + " no encontrado.");
        }
    }

    // Método para encontrar el mayor de los menores (el nodo más grande del subárbol izquierdo)
    public int mayorDeLosMenores() {
        if (raiz != null && raiz.LI != null) {
            Nodo nodo = mayorNodo(raiz.LI);
            return nodo.valor;
        }
        throw new IllegalStateException("No existe subárbol izquierdo o raíz es nula.");
    }

    // Método para encontrar el menor de los mayores (el nodo más pequeño del subárbol derecho)
    public int menorDeLosMayores() {
        if (raiz != null && raiz.LD != null) {
            Nodo nodo = menorNodo(raiz.LD);
            return nodo.valor;
        }
        throw new IllegalStateException("No existe subárbol derecho o raíz es nula.");
    }

    // Método para encontrar el nodo más grande de un subárbol (más a la derecha)
    private Nodo mayorNodo(Nodo nodo) {
        while (nodo.LD != null) {
            nodo = nodo.LD;  // Nos movemos hacia el nodo más a la derecha
        }
        return nodo;
    }

    // Método para encontrar el nodo más pequeño de un subárbol (más a la izquierda)
    private Nodo menorNodo(Nodo nodo) {
        while (nodo.LI != null) {
            nodo = nodo.LI;  // Nos movemos hacia el nodo más a la izquierda
        }
        return nodo;
    }

    // Método principal (main) para probar el árbol
    public static void main(String[] args) {
        // Crear el árbol
        Arbol arbol = new Arbol();

        // Insertar nodos
        arbol.insertar(10);
        arbol.insertar(5);
        arbol.insertar(15);
        arbol.insertar(3);
        arbol.insertar(7);

        // Mostrar el recorrido inorden
        System.out.println("Recorrido Inorden:");
        arbol.mostrarInorden();  // Salida esperada: 3 5 7 10 15

        // Buscar y mostrar un nodo
        arbol.mostrarNodo(7);  // Nodo encontrado: 7
        arbol.mostrarNodo(20); // Nodo no encontrado

        // Mostrar el mayor de los menores (el valor más grande en el subárbol izquierdo de la raíz)
        try {
            System.out.println("Mayor de los menores: " + arbol.mayorDeLosMenores());  // 7
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }

        // Mostrar el menor de los mayores (el valor más pequeño en el subárbol derecho de la raíz)
        try {
            System.out.println("Menor de los mayores: " + arbol.menorDeLosMayores());  // 15
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }
}



