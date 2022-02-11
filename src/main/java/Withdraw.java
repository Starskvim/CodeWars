import java.util.Arrays;

public class Withdraw {
    public static void main(String[] args) {

        int[] result = withdraw2(990);

        //990 [[9, 1, 2]]> but was:<[[8, 1, 7]]
        //

        System.out.println(Arrays.toString(result));
    }

    public static int[] withdraw(int n) {
        int[] result = new int[3];
        int h = 100;
        int f = 50;
        int t = 20;

        int count1 = 0;
        int count2 = 0;
        int[] result1 = new int[3];
        int[] result2 = new int[3];

        int hundreds = n / h;

        if (n % f == 0) {
            result1[0] = hundreds;
            result1[1] = 1;
            count1 += hundreds;
        } else {
            result1[0] = hundreds - 1;
            result1[1] = 1;
            count1 += 1;
            int i = (n - (h * (hundreds - 1)) - f) / t;
            result1[2] = i;
            count1 += i;
        }

        result2[0] = n / h;
        count2 += n / h;

        int ind2 = n - result2[0] * h;
        if (ind2 % t == 0) {
            int i2 = (n - result2[0] * h) / f;
            result2[2] = ind2 / t;
            count2 += ind2 / t;
        } else {
            result2[1] = (n - result2[0] * h) / f;
            int i3 = ((n - result2[0] * h) - result2[1] * f) / t;
            result2[2] = i3;
            count2 += i3;
        }

        if (count1 > count2 && count2 != 0){
            result = result2;
        } else {
            result = result1;
        }

        System.out.println(count1);
        System.out.println(Arrays.toString(result1));
        System.out.println(count2);
        System.out.println(Arrays.toString(result2));

        return result;
    }

    public static int[] withdraw2(int n) {
        int[] result = new int[3];
        int h = 100;
        int f = 50;
        int t = 20;

        float k = (float) n / t;
        System.out.println(k);

        int count1 = 0;
        int count2 = 0;
        int[] result1 = new int[3];
        int[] result2 = new int[3];

        float res1 = (int) (k / 5);
        result1[0] = (int) res1;
        System.out.println(res1);

        int res2 = (int) ((int) (k - res1 * 5) / 2.5f);
        result1[1] = res2;
        System.out.println(res2);

        int res3 = (int) ((k - res1 * 5 - res2 * 2.5f));
        result1[2] = res3;
        System.out.println(res3);

        result = result1;

        return result;
    }

    public static int[] withdraw3(int n){
        int[] r = new int[3];
        if(n % 20 == 0) {
            r[1] = 0;
        } else {
            r[1] = 1;
            n -= 50;
        }
        r[0] = n / 100;
        r[2] = (n % 100) / 20;
        return r;
    }
}


