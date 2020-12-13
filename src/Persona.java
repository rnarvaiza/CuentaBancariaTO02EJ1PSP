/**
 * @author Rafael Narvaiza
 * PSP - TO 02
 *
 * Persona is designed to do three different things: Transfer between accounts, withdraw from an account,
 * or deposit to account.
 *
 * We randomize the access for this interactions in order to each instance of persona works aleatory.
 *
 */


import java.util.HashMap;

public class Persona extends Thread{

    Banco banco = new Banco();
    Utils utils = new Utils();

    HashMap<Integer, CuentaBancaria> cuentas = new HashMap<>();

    @Override
    public void run(){

        int iterations = utils.generateRandom(Constants.RANDOM_MAX_ITERATION);

        for(int i = 0; i<iterations ; i++){
            int randomReturn = utils.generateRandom(Constants.RANDOM_MAX_BETWEEN);
            int maxMoney = utils.generateRandom(Constants.RANDOM_MAX_MONEY);
            int randomAccount = utils.generateRandom(Constants.RANDOM_AMOUNT_ACCOUNT);
            try{
                Thread.sleep(200);
                switch (randomReturn){
                    //Random transfers.
                    case 1:
                        banco.transferenciaEntreCuentas(maxMoney,Banco.cuentas.get(1), Banco.cuentas.get(2));
                        break;
                    //Random deposits.
                    case 2:
                        Banco.cuentas.get(randomAccount).deposito(maxMoney);
                        break;
                    //Random withdraw.
                    case 3:
                        Banco.cuentas.get(randomAccount).retirada(maxMoney);
                        break;
                }
            } catch (InterruptedException e){
                System.out.println(e.getMessage());
            }
        }
    }

}

