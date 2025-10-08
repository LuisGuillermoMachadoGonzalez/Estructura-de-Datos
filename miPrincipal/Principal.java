import java.util.ArrayList;
import java.util.Scanner;

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

        Scanner scanner = new Scanner(System.in);
        ArrayList<Contacto> contactos = new ArrayList<>();
        int opcion;

        do {
            System.out.println("\n--- MENÚ DE OPCIONES ---");
            System.out.println("1. Registrar nuevo contacto");
            System.out.println("2. Buscar contacto");
            System.out.println("3. Modificar contacto");
            System.out.println("4. Eliminar contacto");
            System.out.println("5. Mostrar todos los contactos");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    registrarContacto(scanner, contactos);
                    break;
                case 2:
                    buscarContacto(scanner, contactos);
                    break;
                case 3:
                    modificarContacto(scanner, contactos);
                    break;
                case 4:
                    eliminarContacto(scanner, contactos);
                    break;
                case 5:
                    mostrarContactos(contactos);
                    break;
                case 6:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        } while (opcion != 6);

        scanner.close();




         
    }

    // Método para registrar un nuevo contacto
    public static void registrarContacto(Scanner scanner, ArrayList<Contacto> contactos) {
        System.out.print("Ingrese el nombre del contacto: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el teléfono del contacto: ");
        String telefono = scanner.nextLine();
        System.out.print("Ingrese el correo del contacto: ");
        String correo = scanner.nextLine();
        contactos.add(new Contacto(nombre, telefono, correo));
        System.out.println("Contacto registrado exitosamente.");
    }

    // Métodos stub para evitar errores de compilación
    public static void buscarContacto(Scanner scanner, ArrayList<Contacto> contactos) {
        System.out.println("Funcionalidad de búsqueda no implementada.");
    }

    public static void modificarContacto(Scanner scanner, ArrayList<Contacto> contactos) {
        System.out.println("Funcionalidad de modificación no implementada.");
    }

    public static void eliminarContacto(Scanner scanner, ArrayList<Contacto> contactos) {
        System.out.println("Funcionalidad de eliminación no implementada.");
    }

    public static void mostrarContactos(ArrayList<Contacto> contactos) {
        if (contactos.isEmpty()) {
            System.out.println("No hay contactos registrados.");
        } else {
            for (Contacto c : contactos) {
                System.out.println("Nombre: " + c.getNombre() + ", Teléfono: " + c.getTelefono() + ", Correo: " + c.getCorreo());
            }
        }
    }

}

// Clase Contacto para almacenar la información de cada contacto
class Contacto {
    private String nombre;
    private String telefono;
    private String correo;

    public Contacto(String nombre, String telefono, String correo) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setNombre(String nextLine) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setNombre'");
    }

    public void setTelefono(String nextLine) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setTelefono'");
    }

    public void setCorreo(String nextLine) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setCorreo'");
    }
}