import java.util.ArrayList;
import java.util.Scanner;

public class Agenda {
    private ArrayList<Contacto> contactos;
    private Scanner scanner;

    public Agenda() {
        contactos = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void menu() {
        int opcion;
        do {
            System.out.println("\n--- MENÚ ---");
            System.out.println("1. Registrar contacto");
            System.out.println("2. Buscar contacto");
            System.out.println("3. Modificar contacto");
            System.out.println("4. Eliminar contacto");
            System.out.println("5. Mostrar todos los contactos");
            System.out.println("6. Salir");
            System.out.print("Opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    registrarContacto();
                    break;
                case 2:
                    buscarContacto();
                    break;
                case 3:
                    modificarContacto();
                    break;
                case 4:
                    eliminarContacto();
                    break;
                case 5:
                    mostrarContactos();
                    break;
                case 6:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida.");
                    break;
            }
        } while (opcion != 6);
    }

    private void registrarContacto() {
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Teléfono: ");
        String telefono = scanner.nextLine();
        System.out.print("Correo: ");
        String correo = scanner.nextLine();

        contactos.add(new Contacto(nombre, telefono, correo));
        System.out.println("Contacto agregado correctamente.");
    }

    private void buscarContacto() {
        System.out.print("Nombre a buscar: ");
        String nombre = scanner.nextLine();
        boolean encontrado = false;

        for (Contacto c : contactos) {
            if (c.getNombre().equalsIgnoreCase(nombre)) {
                System.out.println(c);
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Contacto no encontrado.");
        }
    }

    private void modificarContacto() {
        System.out.print("Nombre del contacto a modificar: ");
        String nombre = scanner.nextLine();

        for (Contacto c : contactos) {
            if (c.getNombre().equalsIgnoreCase(nombre)) {
                System.out.print("Nuevo nombre: ");
                c.setNombre(scanner.nextLine());
                System.out.print("Nuevo teléfono: ");
                c.setTelefono(scanner.nextLine());
                System.out.print("Nuevo correo: ");
                c.setCorreo(scanner.nextLine());
                System.out.println("Contacto modificado.");
                return;
            }
        }

        System.out.println("Contacto no encontrado.");
    }

    private void eliminarContacto() {
        System.out.print("Nombre del contacto a eliminar: ");
        String nombre = scanner.nextLine();

        for (int i = 0; i < contactos.size(); i++) {
            if (contactos.get(i).getNombre().equalsIgnoreCase(nombre)) {
                contactos.remove(i);
                System.out.println("Contacto eliminado.");
                return;
            }
        }

        System.out.println("Contacto no encontrado.");
    }

    private void mostrarContactos() {
        if (contactos.isEmpty()) {
            System.out.println("No hay contactos registrados.");
        } else {
            System.out.println("\n--- Lista de Contactos ---");
            for (Contacto c : contactos) {
                System.out.println(c);
            }
        }
    }
}

