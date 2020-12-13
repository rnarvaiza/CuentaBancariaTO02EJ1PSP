/**
 * @author Rafael Narvaiza
 * PSP - TO 02
 *
 * Banco class is designed to achieve all the bank accounts on a hashmap.
 * Saving the each account inside de map we can achieve two different things: Randomize the aleatory
 * access for each account, and save the BankAccount object on a dynamic way to synchronise different accounts actions on it.
 *
 */


import java.util.HashMap;

public class Banco {
    private static int key;
    private static CuentaBancaria value;
    public static HashMap<Integer, CuentaBancaria> cuentas=new HashMap<>();

    public Banco(){
    }

    public synchronized void transferenciaEntreCuentas (int cantidad, CuentaBancaria cuentaBancariaOrigen, CuentaBancaria cuentaBancariaDestino){

        if (cuentaBancariaDestino.getNumeroDeCuenta() != cuentaBancariaOrigen.getNumeroDeCuenta()){
            if(cuentaBancariaOrigen.getBalance()>cantidad){
                System.out.println(Thread.currentThread().getName() + Constants.ORIGING_BALANCE_ES + cuentaBancariaOrigen.getNumeroDeCuenta() + " : "+ cuentaBancariaOrigen.getBalance());
                System.out.println(Thread.currentThread().getName() + Constants.START_TRANSFER_ES + cuentaBancariaOrigen.getNumeroDeCuenta() + " Cantidad: " + cantidad +" a " + cuentaBancariaDestino.getNumeroDeCuenta());
                cuentaBancariaOrigen.retirada(cantidad);
                System.out.println(Thread.currentThread().getName() + Constants.NEW_BALANCE_ACCOUNT_ES + cuentaBancariaOrigen.getBalance() + Constants.INFO_ACOUNT_ES + cuentaBancariaOrigen.getNumeroDeCuenta());
                System.out.println(Thread.currentThread().getName()+ Constants.INITIAL_BALANCE_TO_ES+ cuentaBancariaDestino.getBalance());
                cuentaBancariaDestino.deposito(cantidad);
                System.out.println(Thread.currentThread().getName() + Constants.NEW_BALANCE_ACCOUNT_ES + cuentaBancariaDestino.getBalance() + Constants.INFO_ACOUNT_ES + cuentaBancariaDestino.getNumeroDeCuenta());
            }
            else{
                System.out.println(Constants.TRANSFERENCE_WARNING_NOT_ENOUGHT_ES);
            }
        }
        System.out.println(Constants.TRANSFERENCE_WARNING_SAME_ACCOUNT_ES);
    }




}
