
import java.util.Scanner;

public class ejeroperaciones {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("ingrese numero 1 ");
        double numero1 = sc.nextDouble();
        System.out.println("ingrese numero 2 ");
        double numero2 = sc.nextDouble();
  
    double suma ;
    double resta ;
    double multiplicar ;
    double dividir ;

        
     System.out.println(" ingrese el caso ");
     System.out.println( " 1 sumar  , 2 restar  ,  3 multiplicar  ,   4 dividir ");
       int caso = sc.nextInt();
       switch (caso) {
           case 1:
               suma=numero1+numero2;
               System.out.println(" la suma es igual  " + suma );
               break;
             case 2:
               resta=numero1-numero2;
               System.out.println(" la resta es igual " + resta );
               break;
            case 3 :
            multiplicar= numero1 * numero2 ;   
            System.out.println(" la multiplicacion es igual : " + multiplicar);
            break;
            case 4:
                dividir=numero1/numero2;
                System.out.println(" la division es " + dividir );
           default:
               throw new AssertionError();
       }

    }
}
