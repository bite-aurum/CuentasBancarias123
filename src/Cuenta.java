/*
 * said miguel meza lopez
 * Clase  de la cuenta del tda guarda el titular y el saldo de una cuenta.
 */
public class Cuenta {

    // Atributos Privados
    private String titular;
    private double saldo;

    // Constructor de nw cuent y Valida que el sall no sea negativo
    public Cuenta(String titular, double saldo) {
        this.titular = titular;
        if (saldo < 0) {
            this.saldo = 0;
        } else {
            this.saldo = saldo;
        }
    }

    // Suma dinero al saldo pero  mayor a cero
    public void depositar(double monto) {
        if (monto > 0) {
            saldo = saldo + monto;
        }
    }

    // Resta dinero si es que tiene saldo
    public void retirar(double monto) {
        if (monto > 0 && monto <= saldo) {
            saldo = saldo - monto;
        }
    }

    // Dice si el saldo alcanza para cierto monto true o false
    public boolean tieneFondos(double monto) {
        return saldo >= monto;
    }

    // cobra un porcentaje del saldo y cuanto sobro
    public double aplicarComision(double porcentaje) {
        double comision = saldo * porcentaje / 100;
        saldo = saldo - comision;
        return comision;
    }

    // Dice si la cuenta está en cero tue y false
    public boolean estaVacia() {
        return saldo == 0;
    }

    // metodo recursivo y  calcula cuánto tendrías después de varios años
    // Caso base: si anios es 0, regresa el saldo actual
    // Avance: se llama a sí mismo con un año menos (anios - 1)
    public double proyectarSaldo(double tasa, int anios) {
        if (anios == 0) {
            return saldo;
        }
        return proyectarSaldo(tasa, anios - 1) * (1 + tasa / 100);
    }

    // Imprime los datos de la cuenta en pantalla
    public void mostrar() {
        System.out.println("Titular: " + titular);
        System.out.println("Saldo: $" + saldo);
    }
}