import java.util.HashMap;
import java.util.Map;
import static java.util.Arrays.stream;

public class FindOddInt {

    public static void main(String[] args) {

        System.out.println(findIt(new int[]{20,1,-1,2,-2,3,3,5,5,1,2,4,20,4,-1,-2,5}));

    }


    public static int findIt(int[] input) {
        HashMap<Integer, Integer> numbersCount = new HashMap<>();
        int maxOddNumber = 0;

        for (int number: input) {
            if (!numbersCount.containsKey(number)){
                numbersCount.put(number, 1);
            } else{
                numbersCount.replace(number, numbersCount.get(number) + 1);
            }
        }
        for(Map.Entry<Integer, Integer> item : numbersCount.entrySet()){
            if(item.getValue() % 2 > 0){
                maxOddNumber = item.getKey();
            }
        }
        return maxOddNumber;
    }

    public static int findIt2(int[] arr) {
        return stream(arr).reduce(0, (x, y) -> x ^ y);
    }

    public static int findIt3(int[] A) {
        int odd=0;
        for (int item: A)
        {
            odd = odd ^ item;
        }

        return odd;
    }
}
