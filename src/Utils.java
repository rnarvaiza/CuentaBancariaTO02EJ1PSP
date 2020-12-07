public class Utils {


    public int generateRandom(int maxSize){
        int randomBetween=0;

        randomBetween=(int)(Math.random() * maxSize + Constants.RANDOM_MIN);
        return randomBetween;
    }


}
