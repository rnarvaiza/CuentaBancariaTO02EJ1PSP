/**
 * @author Rafael Narvaiza
 * PSP - TO 02
 *
 * Constructor designed to generate randoms.
 * The gap is setted on Constants class in order to
 * get a properly random number in each case.
 *
 */

public class Utils {


    public int generateRandom(int maxSize){
        int randomBetween=0;

        randomBetween=(int)(Math.random() * maxSize + Constants.RANDOM_MIN);
        return randomBetween;
    }


}
