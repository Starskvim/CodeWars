package kyu5;

import java.util.HashMap;
import java.util.Map;

public class GreedIsGood {


    public static void main(String[] args) {
        System.out.println(greedy(new int[]{5,1,3,4,1}));
    }


    public static int greedy(int[] dice){
        Map<Integer, Integer> numbersCount = new HashMap<>();
        int score = 0;
        for (int number: dice) {
            if (!numbersCount.containsKey(number)){
                numbersCount.put(number, 1);
            } else{
                numbersCount.replace(number, numbersCount.get(number) + 1);
            }
        }
        for(Map.Entry<Integer, Integer> pair : numbersCount.entrySet()){
            switch(pair.getKey()) {
                case 1: {
                    if (pair.getValue() >= 3) {
                        score += 1000;
                        if(pair.getValue() > 3){
                        score += (pair.getValue() - 3) * 100;
                        }
                        break;
                    } else if (pair.getValue() > 0){
                        score += pair.getValue() * 100;
                    } break;
                }
                case 2: {
                    if (pair.getValue() >= 3) {
                        score += 200;
                    } break;
                }
                case 3: {
                    if (pair.getValue() >= 3) {
                        score += 300;
                    } break;
                }
                case 4: {
                    if (pair.getValue() >= 3) {
                        score += 400;
                    } break;
                }
                case 5: {
                    if (pair.getValue() >= 3) {
                        score += 500;
                        if(pair.getValue() > 3){
                            score += (pair.getValue() - 3) * 50;
                        }
                        break;
                    } else if (pair.getValue() > 0){
                        score += pair.getValue() * 50;
                    } break;
                }
                case 6: {
                    if (pair.getValue() >= 3) {
                        score += 600;
                    } break;
                }
            }
        }
        return score;
    }

    public static int greedy2(int[] dice){
        int res = 0;
        int[] count = new int[]{0, 0, 0, 0, 0, 0};
        int[] weight = new int[]{100, 0, 0, 0, 50, 0};
        int[] weight3 = new int[]{1000, 200, 300, 400, 500, 600};

        for (int die : dice) count[die-1]++;

        for (int i = 0; i < count.length; i++) res+=(count[i]/3*weight3[i]) + (count[i]%3 * weight[i]);

        return res;
    }

    public static int greedy3(int[] dice) {
        int n[] = new int[7];
        for (int d : dice) n[d]++;
        return n[1]/3*1000 + n[1]%3*100 + n[2]/3*200 + n[3]/3*300 + n[4]/3*400 + n[5]/3*500 + n[5]%3*50 + n[6]/3*600;
    }
}
