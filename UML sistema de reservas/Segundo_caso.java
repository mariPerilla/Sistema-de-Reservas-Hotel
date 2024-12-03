import java.util.*;

public class Segundo_caso {
    // Base de datos simulada de habitaciones y sus disponibilidades
    static Map<String, List<String>> habitacionesDisponibles = new HashMap<>();
    static Map<String, String> reservas = new HashMap<>(); // Almacena las reservas (ID -> Detalles)

    public static void main(String[] args) {
        // Inicializar datos
        inicializarDatos();

        // Menú principal
        Scanner scanner = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("\n*** Sistema de Gestión de Hotel ***");
            System.out.println("1. Buscar habitaciones disponibles");
            System.out.println("2. Reservar una habitación");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    buscarHabitaciones(scanner);
                    break;
                case 2:
                    reservarHabitacion(scanner);
                    break;
                case 3:
                    System.out.println("¡Gracias por usar el sistema! Hasta luego.");
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        } while (opcion != 3);
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

    // Método para reservar una habitación
    public static void reservarHabitacion(Scanner scanner) {
        System.out.print("Ingrese la fecha (YYYY-MM-DD): ");
        String fecha = scanner.nextLine();

        List<String> habitaciones = habitacionesDisponibles.get(fecha);

        if (habitaciones == null || habitaciones.isEmpty()) {
            System.out.println("No hay habitaciones disponibles para la fecha " + fecha + ".");
            return;
        }

        System.out.println("Habitaciones disponibles para la fecha " + fecha + ":");
        for (int i = 0; i < habitaciones.size(); i++) {
            System.out.println((i + 1) + ". Habitación " + habitaciones.get(i));
        }

        System.out.print("Seleccione el número de la habitación que desea reservar: ");
        int seleccion = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer

        if (seleccion < 1 || seleccion > habitaciones.size()) {
            System.out.println("Selección inválida. Intente de nuevo.");
            return;
        }

        String habitacionSeleccionada = habitaciones.get(seleccion - 1);

        System.out.print("Ingrese su nombre de usuario: ");
        String usuario = scanner.nextLine();

        String idReserva = UUID.randomUUID().toString(); // Generar un ID único para la reserva
        String detallesReserva = "Usuario: " + usuario + ", Habitación: " + habitacionSeleccionada + ", Fecha: " + fecha;
        reservas.put(idReserva, detallesReserva);

        // Eliminar la habitación de la lista de disponibles
        habitaciones.remove(habitacionSeleccionada);

        System.out.println("¡Reserva confirmada! Su número de reserva es: " + idReserva);
        System.out.println("Detalles: " + detallesReserva);
    }
}
