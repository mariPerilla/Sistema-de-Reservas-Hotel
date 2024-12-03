import java.util.*;

public class Primer_caso {
    // Base de datos simulada de habitaciones y sus disponibilidades
    static Map<String, List<String>> habitacionesDisponibles = new HashMap<>();

    public static void main(String[] args) {
        // Inicializar datos
        inicializarDatos();

        // Menú principal
        Scanner scanner = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("\n*** Sistema de Gestión de Hotel ***");
            System.out.println("1. Buscar habitaciones disponibles");
            System.out.println("2. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    buscarHabitaciones(scanner);
                    break;
                case 2:
                    System.out.println("¡Gracias por usar el sistema! Hasta luego.");
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        } while (opcion != 2);
    }

    // Método para inicializar datos simulados
    public static void inicializarDatos() {
        habitacionesDisponibles.put("2024-12-01", Arrays.asList("101", "102", "103"));
        habitacionesDisponibles.put("2024-12-02", Arrays.asList("104", "105"));
        habitacionesDisponibles.put("2024-12-03", Arrays.asList("106", "107", "108"));
    }

    // Método para buscar habitaciones disponibles
    public static void buscarHabitaciones(Scanner scanner) {
        System.out.print("Ingrese la fecha (YYYY-MM-DD): ");
        String fecha = scanner.nextLine();

        List<String> habitaciones = habitacionesDisponibles.get(fecha);

        if (habitaciones != null && !habitaciones.isEmpty()) {
            System.out.println("Habitaciones disponibles para la fecha " + fecha + ":");
            for (String habitacion : habitaciones) {
                System.out.println("- Habitación " + habitacion);
            }
        } else {
            System.out.println("No hay habitaciones disponibles para la fecha " + fecha + ".");
        }
    }
}
