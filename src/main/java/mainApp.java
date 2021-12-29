import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class mainApp {

    public static void main(String[] args) {

        System.out.println(countBits(1234));

    }

    static String alternateCase(final String string) {

//        System.out.println(alternateCase(""));
//        System.out.println(alternateCase("ABC"));
//        System.out.println(alternateCase("abc"));
//        System.out.println(alternateCase("hELLO wORLD!"));

        if (!string.isEmpty()) {
            char[] chars = string.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if (Character.isUpperCase(chars[i])) {
                    chars[i] = Character.toLowerCase(chars[i]);
                } else if (Character.isLowerCase(chars[i])) {
                    chars[i] = Character.toUpperCase(chars[i]);
                }
            }
            return String.valueOf(chars);
        }
        return string;
    }

    public static String createPhoneNumber(int[] numbers) {

//        System.out.println(createPhoneNumber(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 0}));

        char[] resNumber = new char[numbers.length+4];
        int count = 0;
        for (int i = 0; i < numbers.length+4; i++) {
            if(i == 0){
                resNumber[i] = '(';
            }else if(i == 4){
                resNumber[i] = ')';
            } else if(i == 5){
                resNumber[i] = ' ';
            }else if(i == 9){
                resNumber[i] = '-';
            } else {
                resNumber[i] = Character.forDigit(numbers[count], 10);
                count += 1;
            }
        }

        return String.valueOf(resNumber);
    }

    public static String createPhoneNumber2(int[] numbers) {
        return String.format("(%d%d%d) %d%d%d-%d%d%d%d", IntStream.of(numbers).boxed().toArray());
    }

    public static boolean checkPangram(String sentence){

//        System.out.println(checkPangram("The quick brown fox jumps over the lazy dog."));

        String string = sentence.toUpperCase();
        String[] chars = new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q",
                "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        int count = 0;
        for (String h: chars){
            if (string.contains(h)){
                count ++;
            }
        }
        return count == 26;
    }

    public boolean checkPangram2(String sentence){
        return sentence.chars().map(Character::toLowerCase).filter(Character::isAlphabetic).distinct().count() == 26;
    }

    public static int countBits(int n){
        return (int) Integer.toBinaryString(n).chars().filter(i -> i == '1').count();
    }

    public static int countBits2(int n){
        String string = Integer.toBinaryString(n);
        int sum= 0;
        for (char ch : string.toCharArray()){
            if (Character.isDigit(ch)){
                sum+=(ch-'0');
            }
        }
        return sum;
    }

    public static int countBits3(int n){
        return Integer.bitCount(n);
    }
}
