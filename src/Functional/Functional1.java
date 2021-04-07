package Functional;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Functional1 {

    private static List<String> WORDS = Arrays.asList("TONY", "a", "hULK", "B", "america", "X", "nebula", "Korea");

    private static Map<String, Integer> wordPrefixFreq() {
        Map<String, Integer> wordCountMap = new HashMap<>();
        WORDS.stream().map(w -> w.substring(0, 1)).forEach(prefix -> wordCountMap.merge(prefix, 1, (oldValue, newValue) -> (newValue += oldValue)));
        return wordCountMap;
    }

    public static void main(String[] args) {
        final Map<String, Integer> map = wordPrefixFreq();
        map.keySet().forEach(k -> System.out.println(k + ": " + map.get(k)));
    }
}

/*

1. stream()을 통해 함수형 프로그래밍을 위한 Stream 객체 생성
2. map()을 통해 Stream 객체의 단어들을 prefix로 변형시킴
3. forEach를 통해서 prefix를 보고 map에 값 추가

*/