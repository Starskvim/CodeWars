import java.util.Arrays;

public class StringArrayDuplicates {

    public static void main(String[] args) {

        String[] strings = new String[]{"ccooddddddewwwaaaaarrrrsssss","piccaninny","hubbubbubboo"};

        System.out.println(Arrays.toString(dup(strings)));

    }

    public static String[] dup(String[] arr){

        String[] result = new String[arr.length];

        int count = 0;
        for (String string: arr) {
            char[] word = string.toCharArray();
            StringBuilder newWord = new StringBuilder();

            char current = 0;
            for (char ch : word) {

                if (current == 0){
                    current = ch;
                    newWord.append(ch);
                } else if (current != ch) {
                    newWord.append(ch);
                    current = ch;
                }
            }
            result[count] = newWord.toString();
            count++;
        }
        return result;
    }

    public static String[] dup2(String[] arr){

        for(int i = 0; i < arr.length; i++)
            arr[i] = arr[i].replaceAll("(.)\\1+", "$1");
        return arr;

    }
}
