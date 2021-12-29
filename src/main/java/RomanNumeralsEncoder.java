import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class RomanNumeralsEncoder {
    private static TreeMap<Integer, String> MAP;


    public static void main(String[] args) {
        System.out.println(solution(5));
    }

    public static String solution(int n) {
        String result = encode(n);
        return result;
    }

    public enum Numeral {
        M(1000), CM(900), D(500), CD(400), C(100), XC(90), L(50), XL(40), X(10), IX(9), V(5), IV(4), I(1);

        public final long weight;

        private static final Set<Numeral> SET = Collections.unmodifiableSet(EnumSet.allOf(Numeral.class));

        Numeral(long weight) {
            this.weight = weight;
        }

        public static Numeral getLargest(long weight) {
            return SET.stream()
                    .filter(numeral -> weight >= numeral.weight)
                    .findFirst()
                    .orElse(I);
        }
    }

    public static String encode(long n) {
        return LongStream.iterate(n, l -> l - Numeral.getLargest(l).weight)
                .limit(Numeral.values().length)
                .filter(l -> l > 0)
                .mapToObj(Numeral::getLargest)
                .map(String::valueOf)
                .collect(Collectors.joining());
    }

    //////////////////////////////////////////////////////////////
    static {
        MAP = new TreeMap<Integer, String>(Collections.reverseOrder());
        MAP.put( 1, "I" );
        MAP.put( 4, "IV" );
        MAP.put( 5, "V" );
        MAP.put( 9, "IX" );
        MAP.put( 10, "X" );
        MAP.put( 40, "XL" );
        MAP.put( 50, "L" );
        MAP.put( 90, "XC" );
        MAP.put( 100, "C" );
        MAP.put( 400, "CD" );
        MAP.put( 500, "D" );
        MAP.put( 900, "CM" );
        MAP.put( 1000, "M" );
    }

    public String solution2(int n) {
        StringBuilder builder = new StringBuilder();
        for( Map.Entry<Integer, String> entry: MAP.entrySet() ){
            int i = entry.getKey();
            String s = entry.getValue();
            while( n>=i ){
                builder.append(s);
                n -= i;
            }
        }
        return builder.toString();
    }

}
