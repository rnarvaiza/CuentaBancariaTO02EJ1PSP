import java.util.HashMap;

public class CuentaBancaria {

    public CuentaBancaria(){
    }

    private int balance;
    private int numeroDeCuenta;
    private int key;
    private CuentaBancaria value;

    public CuentaBancaria(int balance, int numeroDeCuenta){
        this.setBalance(balance);
        this.setNumeroDeCuenta(numeroDeCuenta);

    }

    public CuentaBancaria( int numeroDeCuenta){
        this.numeroDeCuenta = numeroDeCuenta;
    }

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

    public synchronized void transferenciaEntreCuentas (int cantidad, CuentaBancaria cuentaBancariaOrigen, CuentaBancaria cuentaBancariaDestino){

        if (cuentaBancariaDestino.getNumeroDeCuenta() != cuentaBancariaOrigen.getNumeroDeCuenta()){
            if(cuentaBancariaOrigen.getBalance()>cantidad){
                cuentaBancariaOrigen.retirada(cantidad);
                System.out.println(Constants.NEW_BALANCE_ACCOUNT_ES + cuentaBancariaOrigen.getBalance() + Constants.INFO_ACOUNT_ES + cuentaBancariaOrigen.getNumeroDeCuenta());
                cuentaBancariaDestino.deposito(cantidad);
                System.out.println(Constants.NEW_BALANCE_ACCOUNT_ES + cuentaBancariaDestino.getBalance() + Constants.INFO_ACOUNT_ES + cuentaBancariaDestino.getNumeroDeCuenta());
            }
            else{
                System.out.println(Constants.TRANSFERENCE_WARNING_NOT_ENOUGHT_ES);
            }
        }
        System.out.println(Constants.TRANSFERENCE_WARNING_SAME_ACCOUNT_ES);
    }

    public HashMap<Integer, CuentaBancaria> cuentasDelBanco(){
        HashMap<Integer, CuentaBancaria> cuentas = new HashMap<>();
        cuentas.put(key, value);

        return cuentas;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public CuentaBancaria getValue() {
        return value;
    }

    public void setValue(CuentaBancaria value) {
        this.value = value;
    }
}
