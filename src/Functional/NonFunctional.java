package Functional;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NonFunctional {

    private static List<String> WORDS = Arrays.asList("TONY", "a", "hULK", "B", "america", "X", "nebula", "Korea");

    private static Map<String, Integer> wordPrefixFreq() {
        Map<String, Integer> wordCountMap = new HashMap<>();
        String prefix;
        Integer count;
        for(String word : WORDS){
            prefix = word.substring(0, 1);
            count = wordCountMap.get(prefix);
            if(count == null){
                wordCountMap.put(prefix, 1);
            } else {
                wordCountMap.put(prefix, count + 1);
            }
        }

        return wordCountMap;
    }

    public static void main(String[] args) {
        final Map<String, Integer> map = wordPrefixFreq();
        map.keySet().forEach(k -> System.out.println(k + ": " + map.get(k)));
    }
}
