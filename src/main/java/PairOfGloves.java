import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class PairOfGloves {

    public static void main(String[] args) {
        System.out.println(numberOfPairs(new String[]{"red", "green", "blue", "blue", "red", "green", "red", "red", "red"}));
    }

    public static int numberOfPairs(String[] gloves) {

        HashMap<String, Integer> glovsCount = new HashMap<>();
        int glovesPairCount = 0;

        for (String glov : gloves) {
            if (!glovsCount.containsKey(glov)) {
                glovsCount.put(glov, 1);
            } else {
                glovsCount.replace(glov, glovsCount.get(glov) + 1);
            }
        }

        for (Map.Entry<String, Integer> item : glovsCount.entrySet()) {
            glovesPairCount += item.getValue() / 2;
        }

        return glovesPairCount;
    }

    public static int numberOfPairs2(String[] a) {
        var s = new HashSet<String>();
        var r = 0;
        for (var x : a)
            if (s.contains(x)) {
                s.remove(x);
                r++;
            } else s.add(x);
        return r;
    }
}
