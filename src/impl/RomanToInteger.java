package impl;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    public int romanToInt(String s) {
        int result =0;
        Map<String, Integer> table = new HashMap<>();
        initMap(table);
        return romanToInt(s, 0, result, table);
    }

    private int romanToInt(String s, int index, int result, Map<String, Integer> table) {
        if(s.length() == index) return result;
        String s1 = "" + s.charAt(index);
        String s2 = index != s.length()-1 ? s1+s.charAt(index+1) : "";
        if(!s2.equals("") && table.containsKey(s2)) {
            return result + table.get(s2) + romanToInt(s, index+2, result, table);
        } else {
            return result + table.get(s1) + romanToInt(s, index+1, result, table);
        }
    }

    private void initMap(Map<String, Integer> table) {
        table.put("I", 1);
        table.put("IV", 4);
        table.put("V", 5);
        table.put("IX", 9);
        table.put("X", 10);
        table.put("XL", 40);
        table.put("L", 50);
        table.put("XC", 90);
        table.put("C", 100);
        table.put("CD", 400);
        table.put("D", 500);
        table.put("CM", 900);
        table.put("M", 1000);
    }
}