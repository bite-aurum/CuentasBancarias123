import java.util.Scanner;

/*
 * said miguel meza lopez 4 "A"
 * // utilize un poquito de ia profe :( no sabia como crear la interfaz grafica aunque conocia la consola pero me trabe :(
 *  es la main o la principal
 */
public class Main {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
       // adorno bonito
        System.out.println("Programa de: said meza");

        // datos para crear la cuentat
        System.out.print("Nombre del titular: ");
        String nombre = teclado.next();

        System.out.print("Saldo inicial: ");
        double saldoInicial = teclado.nextDouble();

        // Aquí se crea el objeto con la clase Cuenta
        Cuenta miCuenta = new Cuenta(nombre, saldoInicial);

        int opcion = 0;

        // El menú se repite hasta que escribas 5 osea eta condicionado :)
        while (opcion != 5) {
            System.out.println();
            miCuenta.mostrar();
            System.out.println("1. Depositar");
            System.out.println("2. Retirar");
            System.out.println("3. Cobrar comision");
            System.out.println("4. Proyectar saldo (recursivo)");
            System.out.println("5. Salir");
            System.out.print("Elige una opcion: ");
            opcion = teclado.nextInt();

            if (opcion == 1) {
                System.out.print("Cuanto depositas: ");
                double monto = teclado.nextDouble();
                miCuenta.depositar(monto);
            }

            if (opcion == 2) {
                System.out.print("Cuanto retiras: ");
                double monto = teclado.nextDouble();
                if (miCuenta.tieneFondos(monto)) {
                    miCuenta.retirar(monto);
                } else {
                    System.out.println("No te alcanza el saldo.");
                }
            }

            if (opcion == 3) {
                System.out.print("Porcentaje de comision: ");
                double porcentaje = teclado.nextDouble();
                double cobrado = miCuenta.aplicarComision(porcentaje);
                System.out.println("Se cobro: $" + cobrado);
            }

            if (opcion == 4) {
                System.out.print("Tasa anual en %: ");
                double tasa = teclado.nextDouble();
                System.out.print("Cuantos años: ");
                int anios = teclado.nextInt();
                double futuro = miCuenta.proyectarSaldo(tasa, anios);
                // aca no puse años si no anios para simular la ñ
                System.out.println("En " + anios + " años tendrias: $" + futuro);
            }
        }

        System.out.println("Fin del programa said meza lo hizo by said meza ");
    }
}