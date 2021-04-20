import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class Pairs2 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String [] k = new String[]{s.nextLine()};
        String[] input1 = {"X:-1", "Y:1", "X:-4", "B:3", "X:5"};

        String[] input2 = {"Z:0", "A:-1"};

        System.out.println(GroupTotals(k));

    }

    public static String GroupTotals(String[] arr) {

        Map<String, Integer> result = new HashMap<String, Integer>();
        String currentKey;
        Integer currentValue;

        for(String temp : arr) {
            currentKey = getKey(temp);
            currentValue = getValue(temp);

            if(result.get(currentKey) == null ) result.put(currentKey, currentValue);
            else result.put(currentKey, result.get(currentKey) + currentValue);
        }
        return convertResult(result);
    }

    public static String getKey(String pair) {
        return pair.substring(0, 1);
    }

    public static Integer getValue(String pair) {
        return Integer.parseInt(pair.substring(2, pair.length()));
    }

    public static String convertResult(Map<String, Integer> data) {

        StringBuilder result = new StringBuilder();

        for(Entry<String, Integer> temp : data.entrySet()) {
            if(temp.getValue() == 0) continue;
            result.append(temp.getKey()).append(":").append(temp.getValue()).append(", ");

        }

        result.delete(result.length()-2, result.length());

        return result.toString();

    }

}