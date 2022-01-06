package kyu5;


import java.util.*;

public class PickPeaks {

    public static void main(String[] args) {

        int[] arr = {1, 2, 5, 4, 3, 2, 3, 6, 4, 1, 2, 3, 3, 4, 5, 3, 2, 1, 2, 3, 5, 5, 4, 3};

        Map<String, List<Integer>> resultMap = getPeaks2(arr);
        for (Map.Entry<String, List<Integer>> item : resultMap.entrySet()) {
            System.out.printf("Key: %s  Value: %s \n", item.getKey(), item.getValue());
        }

    }

    public static Map<String, List<Integer>> getPeaks(int[] arr) {
        Map<String, List<Integer>> resultMap = new HashMap<>();
        List<Integer> pos = new LinkedList<>();
        List<Integer> peaks = new LinkedList<>();
        int startPlatoValue = -1;
        int startPlatoInd = 0;

        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i - 1] < arr[i] && arr[i] > arr[i + 1]) {
                pos.add(i);
                peaks.add(arr[i]);
                startPlatoValue = -1;
                startPlatoInd = 0;
            } else if (arr[i - 1] == arr[i]) {
                if (arr[i] != startPlatoValue) {
                    startPlatoValue = arr[i - 1];
                    startPlatoInd = i - 1;
                }
            }
            if (i == arr.length - 1) {
                if (arr[i - 1] < arr[i] && arr[i] > arr[i + 1]) {
                    pos.add(i);
                    peaks.add(arr[i]);
                }
            }
            if (arr[i + 1] < arr[i] && arr[i] == startPlatoValue) {
                if (arr[i] > arr[i + 1]) {
                    if (startPlatoInd != 0 && arr[startPlatoInd - 1] < arr[i]) {
                        pos.add(startPlatoInd);
                        peaks.add(startPlatoValue);
                    }
                    startPlatoValue = -1;
                    startPlatoInd = 0;
                } else if (i == arr.length - 3) {
                    if (arr[i] != arr[arr.length - 1]) {
                        pos.add(startPlatoInd);
                        peaks.add(startPlatoValue);
                        startPlatoValue = -1;
                        startPlatoInd = 0;
                    }
                }
            }
        }
        resultMap.put("pos", pos);
        resultMap.put("peaks", peaks);
        return resultMap;
    }

    public static Map<String, List<Integer>> getPeaks2(int[] arr) {

        Map<String, List<Integer>> ans = new HashMap<String, List<Integer>>() {{
            put("pos", new ArrayList<Integer>());
            put("peaks", new ArrayList<Integer>());
        }};
        int posMax = 0;
        boolean matchAsc = false;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] < arr[i]) {
                matchAsc = true;
                posMax = i;
            }
            if (matchAsc && arr[i - 1] > arr[i]) {
                matchAsc = false;
                ans.get("pos").add(posMax);
                ans.get("peaks").add(arr[posMax]);
            }
        }
        return ans;
    }
}
