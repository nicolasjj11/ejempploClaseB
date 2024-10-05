
    import java.util.Scanner;

    public class ejercicioNveces {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Introduce un número: ");
            int n = sc.nextInt();
            
            int suma = 0;
            int contador = 1;
    
            // Ciclo while para sumar los primeros n números
            while (contador <= n) {
                suma += contador;
                contador++;
            }
    
            System.out.println("La suma de los primeros " + n + " números es: " + suma);
        }
    }
    

