package impl;

import java.util.HashSet;
import java.util.Set;

public class PermInString {
    public boolean checkInclusion(String s1, String s2) {
        int size1 = s1.length();
        int size2 = s2.length();
        if(size1>size2) return false;
        int[] first = new int[26];
        for(char c:s1.toCharArray()) first[c-'a']++;
        int[] curr = new int[26];
        for(char c:s2.substring(0, size1).toCharArray()) curr[c-'a']++;
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<26;i++) {
            if(first[i]!=curr[i]) set.add(i);
        }
        for(int i=0;i<=size2-size1;i++) {
            if(set.isEmpty()) return true;
            if(i==size2-size1) break;
            int index = s2.charAt(i)-'a';
            int index2 = s2.charAt(i+size1)-'a';
            curr[index]--;
            if(curr[index] != first[index]) {
                set.add(index);
            } else {
                if(set.contains(index)) set.remove(index);
            }
            if(curr[index] != first[index]) {
                set.add(index);
            } else {
                if(set.contains(index)) set.remove(index);
            }
            curr[index2]++;
            if(curr[index2] != first[index2]) {
                set.add(index2);
            } else {
                if(set.contains(index2)) set.remove(index2);
            }
            if(curr[index2] != first[index2]) {
                set.add(index2);
            } else {
                if(set.contains(index2)) set.remove(index2);
            }


        }
        return set.isEmpty();

    }
}

/*

s1="abcd"

s2="zecdabff"









*/