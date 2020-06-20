package impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindAnagrams {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int size = s.length();
        int pSize = p.length();
        if(size < pSize) return result;
        Set<Integer> notEquals = new HashSet<>();
        int[] anagramP = new int[26];
        int[] curr = new int[26];
        for(char c : p.toCharArray()) anagramP[c-'a']++;
        for(char c : s.substring(0, pSize).toCharArray()) curr[c-'a']++;
        for(int i=0;i<26;i++)
            if(anagramP[i] != curr[i]) notEquals.add(i);
        for(int i=0;i<=size-pSize;i++) {
            if(notEquals.isEmpty()) result.add(i);
            int left = s.charAt(i)-'a';
            if(i+pSize==size) return result;
            int right = s.charAt(i+pSize)-'a';
            curr[left]--;
            curr[right]++;
            if(curr[left] != anagramP[left])
                notEquals.add(left);
            else
                if(notEquals.contains(left)) notEquals.remove(left);
            if(curr[right] != anagramP[right]) notEquals.add(right);
            else
                if(notEquals.contains(left)) notEquals.remove(left);
        }
        return result;

    }
}