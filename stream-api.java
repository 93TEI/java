import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordCount {

    private static List<String> WORDS = Arrays.asList("a","bb","Ccc","dddd");

    private static Map<String, Integer> firstWord() {
        Map<String, Integer> cntMap = new HashMap<>();
        WORDS.stream().map(w -> w.substring(0, 1)).forEach(prefix -> cntMap.merge(prefix, 1, (oldValue, newValue) -> (newValue += oldValue)));
        return cntMap;
    }
    /*
        Map<String, Integer> cntMap = new HashMap<>();
        String prefix;
        Integer count;
        for (String word : WORDS) {
            prefix = word.substring(0, 1);
            count = cntMap.get(prefix);
            if (count == null) {
                cntMap.put(prefix, 1);
            } else {
                cntMap.put(prefix, count + 1);
            }
        }
    */

    public static void main(String[] args) {
        final Map<String, Integer> map = wordPrefixFreq();
        map.keySet().forEach(k -> System.out.println(k + ": " + map.get(k)));
    }

}
