package recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Permutation {

    public List<String> getPerms(String s) {
        Map<Character, Integer> freqTable = getFreqTable(s);
        List<String> result = new ArrayList<>();
        getPerms(freqTable, "", s.length(), result);
        return result;
    }

    private void getPerms(Map<Character, Integer> freqTable, String prefix, int remaining, List<String> result) {
        if (remaining == 0) {
            result.add(prefix);
            return;
        }
        for (Character character : freqTable.keySet()) {
            Integer counter = freqTable.get(character);
            if (counter > 0) {
                freqTable.put(character, counter - 1);
                getPerms(freqTable, prefix + character, remaining - 1, result);
                freqTable.put(character, counter);
            }
        }
    }

    private Map<Character, Integer> getFreqTable(String s) {
        Map<Character, Integer> freq = new HashMap<>();
        for (Character c : s.toCharArray()) {
            int counter = freq.containsKey(c) ? freq.get(c) + 1 : 1;
            freq.put(c, counter);
        }
        return freq;
    }

}
