import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MakeDeadfishSwim {

    public static void main(String[] args) {

        System.out.println(Arrays.toString(parse("iiisdosodddddiso")));

    }

    public static int[] parse(String data) {


        char[] commands = data.toCharArray();
        int currentNumber = 0;
        ArrayList<Integer> currentList = new ArrayList<>();
        for (char ch: commands){
            if (ch == 'i'){
                currentNumber += 1;
            } else if (ch == 'd'){
                currentNumber -= 1;
            } else if (ch == 's'){
                currentNumber *= currentNumber;
            } else if (ch == 'o'){
                currentList.add(currentNumber);
            }
        }
        return currentList.stream().mapToInt(Integer::intValue).toArray();

    }

    public static int[] parse2(String data) {
        int value = 0;
        List<Integer> result = new ArrayList<>();
        for(char letter : data.toCharArray()) {
            switch(letter) {
                case 'i': value++; break;
                case 'd': value--; break;
                case 's': value *= value; break;
                case 'o': result.add(value); break;
                default: throw new IllegalArgumentException("Not valid code letter");
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
