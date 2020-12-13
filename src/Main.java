import java.util.HashMap;

/**
 * @author Rafael Narvaiza
 * PSP - TO 02
 *
 * Here we set the properties of both bank accounts. Setted the ID number account and its balance.
 * Then we achieve it on an hashmap. Working on this way we can randomize the access to accounts.
 * Persona class can withdraw, deposit or transfer between accounts. So we initialize four instances of
 * this class to work in the two accounts.
 */

public class Main {

    public static void main(String[] args) {

        Utils utils = new Utils();
        HashMap<Integer, CuentaBancaria> cuentas = new HashMap<>();

        CuentaBancaria cuentaBancaria1= new CuentaBancaria();
        CuentaBancaria cuentaBancaria2 = new CuentaBancaria();

        cuentaBancaria1.setBalance(utils.generateRandom(Constants.RANDOM_MAX_MONEY));
        cuentaBancaria1.setNumeroDeCuenta(1234);
        cuentaBancaria2.setBalance(utils.generateRandom(Constants.RANDOM_MAX_MONEY));
        cuentaBancaria2.setNumeroDeCuenta(4321);
        cuentas.put(1, cuentaBancaria1);
        cuentas.put(2, cuentaBancaria2);
        Banco.cuentas.putAll(cuentas);

        System.out.println(Banco.cuentas.get(1).toString());
        System.out.println(Banco.cuentas.get(2).toString());

        Persona persona1 = new Persona();
        persona1.start();
        Persona persona2 = new Persona();
        persona2.start();
        Persona persona3 = new Persona();
        persona3.start();
        Persona persona4 = new Persona();
        persona4.start();




    }

}
