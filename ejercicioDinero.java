public class ejercicioDinero {
    public static void main(String[] args) {
        // Cantidad inicial en la cuenta
        double saldoInicial = 1000.0;

        double retiroSemanal = 200.0;

      
        int semanasEnUnMes = 4;

        double saldoFinal = saldoInicial - (retiroSemanal * semanasEnUnMes);

        System.out.println("Saldo inicial: $" + saldoInicial);
        System.out.println("Monto retirado por semana: $" + retiroSemanal);
        System.out.println("Saldo final después de un mes: $" + saldoFinal);
    }
}
