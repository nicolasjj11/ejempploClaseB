import java.util.ArrayList;
import java.util.Scanner;

public class GestionDeListas {
    public static void main(String[] args) {
        
        ArrayList<String> lista = new ArrayList<>();
        lista.add("Elemento 1");
        lista.add("Elemento 2");
        lista.add("Elemento 3");

       
        Scanner scanner = new Scanner(System.in);

        try {
            
            System.out.println("Lista de elementos: " + lista);

           
            System.out.print("Ingrese el índice del elemento que desea acceder: ");
            int indice = scanner.nextInt();

        
            String elemento = lista.get(indice);
            System.out.println("Elemento en el índice " + indice + ": " + elemento);

        } catch (IndexOutOfBoundsException e) {
           
            System.out.println("Error: Índice fuera de rango. Por favor, ingrese un índice válido.");
        } finally {
         
            scanner.close();
            System.out.println("Programa terminado.");
        }
    }
}
