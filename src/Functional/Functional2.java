package Functional;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*

Functional1에서 추가 요구사항이 생겼다고 가정하자.
1. 단어의 크기가 2 이상인 경우에만 처리를 할 것
2. 모든 단어를 대문자로 변환하여 처리를 할 것
3. 스페이스로 구분한 하나의 문자열로 변환할 것

*/
public class Functional2 {

    private static List<String> WORDS = Arrays.asList("TONY", "a", "hULK", "B", "america", "X", "nebula", "Korea");

    public static String wordPrefixFreq() {
        return WORDS.stream().filter(w -> w.length() > 1).map(String::toUpperCase).map(w -> w.substring(0, 1)).collect(Collectors.joining(" "));
    }

    public static void main(String[] args) throws IOException {
        final String result = wordPrefixFreq();
        System.out.println(result);
    }
}
