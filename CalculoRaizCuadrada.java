import java.util.Scanner;

// Excepción personalizada
class NumeroNegativoException extends Exception {
    public NumeroNegativoException(String mensaje) {
        super(mensaje);
    }
}

public class CalculoRaizCuadrada {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Solicitar un número al usuario
            System.out.print("Ingrese un número: ");
            double numero = scanner.nextDouble();

            // Verificar si el número es negativo
            if (numero < 0) {
                throw new NumeroNegativoException("No se puede calcular la raíz cuadrada de un número negativo.");
            }

            // Calcular la raíz cuadrada
            double raizCuadrada = Math.sqrt(numero);

            // Mostrar el resultado
            System.out.println("La raíz cuadrada de " + numero + " es: " + raizCuadrada);

        } catch (NumeroNegativoException e) {
            // Manejar la excepción personalizada
            System.out.println("Error: " + e.getMessage());
        } finally {
            // Cerrar el objeto Scanner
            scanner.close();
            System.out.println("Programa terminado.");
        }
    }
}

