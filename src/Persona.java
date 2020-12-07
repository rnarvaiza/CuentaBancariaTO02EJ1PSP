import java.util.HashMap;

public class Persona extends Thread{

    Banco banco = new Banco();
    Utils utils = new Utils();
    CuentaBancaria cuentaBancaria = new CuentaBancaria();
    HashMap<Integer, CuentaBancaria> cuentas = new HashMap<>();

    @Override
    public void run(){


        CuentaBancaria cuentaBancaria1=new CuentaBancaria(Constants.DEFAULT_BALANCE, 123456);

        cuentaBancaria.setKey(1);
        cuentaBancaria.setValue(cuentaBancaria1);
        cuentaBancaria.cuentasDelBanco();
        CuentaBancaria cuentaBancaria2 = new CuentaBancaria(Constants.DEFAULT_BALANCE, 654321);
        cuentaBancaria.setKey(2);
        cuentaBancaria.setValue(cuentaBancaria2);
        cuentaBancaria.cuentasDelBanco();

        System.out.println(cuentaBancaria.cuentasDelBanco());
        int iterations = utils.generateRandom(Constants.RANDOM_MAX_ITERATION);

        for(int i = 0; i<iterations ; i++){
            int randomReturn = utils.generateRandom(Constants.RANDOM_MAX_BETWEEN);
            int maxMoney = utils.generateRandom(Constants.RANDOM_MAX_MONEY);
            int randomAccount = utils.generateRandom(Constants.RANDOM_AMOUNT_ACCOUNT);
            switch (randomReturn){

                //Transferencias randoms.
                case 1:
                    cuentaBancaria.transferenciaEntreCuentas(maxMoney,cuentaBancaria1, cuentaBancaria2);
                    break;
                //Depositos randoms.
                case 2:
                    cuentaBancaria.cuentasDelBanco().get(randomAccount).deposito(maxMoney);
                    break;
                //Retiradas randoms.
                case 3:
                    cuentaBancaria.cuentasDelBanco().get(randomAccount).retirada(maxMoney);
                    break;
            }

        }
     }

}


