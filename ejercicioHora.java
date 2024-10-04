import java.util.Scanner;
public class ejercicioHora {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(" ingrese la hora ");
        int hora = scanner.nextInt();
        if (hora>=0 && hora<=5) {
            System.out.println(" es madrugada ");
        } else if ( hora>=6 && hora<=11) {
            System.out.println("  es mañana  ");
        }else if ( hora>=12 && hora<=13) {
            System.out.println(" medio dia ");
        }else if ( hora>=14 && hora<=19 ) {
            System.out.println(" tarde ");
        }else if ( hora>=20 && hora<=23){
            System.out.println(" noche ");
        } else 
         System.out.println( " dia no valido ");

    }
}
