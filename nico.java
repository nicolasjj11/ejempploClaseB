import  java.util.Scanner;
public class nico {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print(" ingresa un numero ");
        int numero = input.nextInt();

        if (numero  % 2 == 0) {
            System.out.println(" es numero par ");
        }else
        System.out.println(" es un numero impar");

    }
}
