/**
 * @author Rafael Narvaiza
 * PSP - TO 02
 *
 * Cuenta Bancaria object is designed to has an ammount of money called balance and
 * an id number called numeroDeCuenta.
 */

public class CuentaBancaria {

    public CuentaBancaria(){
    }

    private int balance;
    private int numeroDeCuenta;


    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getNumeroDeCuenta() {
        return numeroDeCuenta;
    }

    public void setNumeroDeCuenta(int numeroDeCuenta) {
        this.numeroDeCuenta = numeroDeCuenta;
    }

    public synchronized int deposito(int cantidad){
        this.balance = this.balance+cantidad;
        System.out.println(Thread.currentThread().getName() + Constants.DEPOSIT_ATTEMPT_ES + cantidad + Constants.NEW_BALANCE_ACCOUNT_ES + this.balance + Constants.INFO_ACOUNT_ES + this.numeroDeCuenta);

        return balance;
    }

    public synchronized int retirada(int cantidad){
        System.out.println(Thread.currentThread().getName() + Constants.WITHDRAW_ATTEMPT_ES + cantidad + Constants.INFO_ACOUNT_ES + this.numeroDeCuenta);
        if (cantidad>balance){
            System.out.println(Constants.WITHDRAW_UNSUCCESSFUL_ES + this.numeroDeCuenta);
            return 0;

        }
        else{
            this.balance=this.balance-cantidad;
            System.out.println(Thread.currentThread().getName() + Constants.WITHDRAW_SUCCESSFUL_ES + this.balance);
        }

        return cantidad;
    }




}