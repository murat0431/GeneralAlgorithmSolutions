package impl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MinDelToUniqFreq {
    public int solution(String s) {
        Map<Character, Integer> table = new HashMap<>();
        char[] arr = s.toCharArray();
        for(char c : arr) {
            if(!table.containsKey(c)) {
                table.put(c, 1);
            } else {
                table.put(c, table.get(c) + 1);
            }
        }
        Set<Integer> set = new HashSet<>();
        int count = 0;
        for(Map.Entry<Character, Integer> entry : table.entrySet()) {
            int value = entry.getValue();
            while(set.contains(value) && value > 0) {
                value--;
                count++;
            }
            if(value != 0) set.add(value);
        }
        return count;
    }
}
