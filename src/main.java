import java.util.HashMap;
import java.util.Map;

public class main{
    public static void main(String[] args) {

        String[][] clothes = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};

        Map<String, Integer> map = new HashMap<>();

        for(String[] items : clothes){
            String itemClass = items[items.length-1];
            if(map.get(itemClass) == null){
                map.put(itemClass, 1);
            } else {
                map.put(itemClass, map.get(itemClass)+1);
            }
        }


    }
}
