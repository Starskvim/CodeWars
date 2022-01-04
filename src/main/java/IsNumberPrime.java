import java.math.BigInteger;


public class IsNumberPrime {

    public static void main(String[] args) {


        System.out.println(isPrime(-5));

    }

    public static boolean isPrime(int num) {

        if (num < 2){
            return false;
        }
        BigInteger bigInteger = BigInteger.valueOf(num);
        return bigInteger.isProbablePrime(num);
    }

    public static boolean isPrime2(int number) {
        if(number < 2)
            return false;
        for (int i=2; i<=Math.sqrt(number); i++){
            if(number % i == 0)
                return false;
        }
        return true;
    }

}
