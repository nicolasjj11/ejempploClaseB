import java.io.*;
import java.util.Scanner;

public class ManejoDeNotas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String fileName = "notas.txt";
        boolean salir = false;

        while (!salir) {
            System.out.println("\n--- Menú ---");
            System.out.println("1. Ingresar una nueva nota");
            System.out.println("2. Mostrar todas las notas guardadas");
            System.out.println("3. Salir");
            System.out.print("Elige una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir salto de línea

            switch (opcion) {
                case 1:
                    // Ingresar una nueva nota
                    System.out.print("Ingresa la nota: ");
                    String nota = scanner.nextLine();
                    guardarNotaEnArchivo(fileName, nota);
                    break;

                case 2:
                    // Mostrar notas guardadas
                    leerNotasDesdeArchivo(fileName);
                    break;

                case 3:
                    // Salir
                    System.out.println("Saliendo del programa...");
                    salir = true;
                    break;

                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
            }
        }
        scanner.close();
    }

    /**
     * Método para guardar una nota en el archivo.
     *
     * @param fileName Nombre del archivo.
     * @param nota     Nota a guardar.
     */
    public static void guardarNotaEnArchivo(String fileName, String nota) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write(nota);
            writer.newLine();
            System.out.println("Nota guardada exitosamente.");
        } catch (IOException e) {
            System.out.println("Error al guardar la nota: " + e.getMessage());
        }
    }

    /**
     * Método para leer y mostrar las notas desde el archivo.
     *
     * @param fileName Nombre del archivo.
     */
    public static void leerNotasDesdeArchivo(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String linea;
            System.out.println("\nNotas guardadas:");
            while ((linea = reader.readLine()) != null) {
                System.out.println("- " + linea);
            }
        } catch (FileNotFoundException e) {
            System.out.println("No se encontró el archivo. Aún no hay notas guardadas.");
        } catch (IOException e) {
            System.out.println("Error al leer las notas: " + e.getMessage());
        }
    }
}
