import java.util.Scanner;

public class DivisionPorCero {
    public static void main(String[] args) {
        // Crear un objeto Scanner para leer los datos del usuario
        Scanner scanner = new Scanner(System.in);

        try {
            // Solicitar al usuario que ingrese dos números
            System.out.print("Ingrese el primer número (dividendo): ");
            double dividendo = scanner.nextDouble();

            System.out.print("Ingrese el segundo número (divisor): ");
            double divisor = scanner.nextDouble();

            // Intentar realizar la división
            if (divisor == 0) {
                throw new ArithmeticException("No se puede dividir entre cero.");
            }

            double resultado = dividendo / divisor;

            // Mostrar el resultado
            System.out.println("El resultado de la división es: " + resultado);

        } catch (ArithmeticException e) {
            // Manejar la excepción de división por cero
            System.out.println("Error: " + e.getMessage());
        } finally {
            // Cerrar el objeto Scanner
            scanner.close();
            System.out.println("Programa terminado.");
        }
    }
}
