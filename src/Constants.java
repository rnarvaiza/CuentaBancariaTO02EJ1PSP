/**
 * @author Rafael Narvaiza
 * PSP - TO 02
 *
 * Here we set all the messages and the limits for the random.
 * On this way we can reuse the random constructor as we want in each case.
 */


public class Constants {

    final static String TRANSFERENCE_WARNING_NOT_ENOUGHT_ES =" No es posible realizar la transferencia. Cuenta de origen sin saldo suficiente. ";
    final static String TRANSFERENCE_WARNING_SAME_ACCOUNT_ES =" No es posible realizar una transferencia con origen y destino en la misma cuenta. ";
    final static String WITHDRAW_UNSUCCESSFUL_ES = " Saldo insuficiente en la cuenta ";
    final static String WITHDRAW_SUCCESSFUL_ES = " Reintegro realizado. Disponible: ";
    final static String INFO_ACOUNT_ES = " en la cuenta ";
    final static String WITHDRAW_ATTEMPT_ES = " Realizando intento de reintegro de ";
    final static String DEPOSIT_ATTEMPT_ES = " Realizando deposito de ";
    final static String NEW_BALANCE_ACCOUNT_ES = " El nuevo balance es: ";
    final static int RANDOM_MAX_BETWEEN = 3;
    final static int RANDOM_MAX_MONEY = 100;
    final static int RANDOM_MAX_ITERATION = 25;
    final static int RANDOM_MIN = 1;
    final static int RANDOM_AMOUNT_ACCOUNT=2;

}
