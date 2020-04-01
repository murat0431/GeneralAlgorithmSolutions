package impl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestPalindromicSubstring {
  //memoization solution
  public String longestPalindrome(String s) {
    int size = s.length();
    if(size<2) return s;
    Map<String, String> table = new HashMap<>();
    Set<String> palindromes = new HashSet<>();
    return longestPalindrome(0, size-1, s, table, palindromes);
  }

  private String longestPalindrome(int i, int j, String s,
                                   Map<String, String> table, Set<String> palindromes) {
    if(i==j) return s.charAt(i)+"";
    if(table.containsKey(s)) return table.get(s);
    String s1 = longestPalindrome(i, j-1, s.substring(i,j), table, palindromes);
    String s2 = longestPalindrome(i+1, j, s.substring(i+1, j+1), table, palindromes);
    boolean isPalindrome = isPalindrome(s, palindromes);
    if(isPalindrome) return s;
    if(s1.length() < s2.length()) return s2;
    return s1;
  }

  private boolean isPalindrome(String s, Set<String> palindromes) {
    int size = s.length();
    if(size <2 || (size==2 && s.charAt(0) == s.charAt(1)) ) {
      palindromes.add(s);
      return true;
    }
    if(s.charAt(0) == s.charAt(size-1) && palindromes.contains(s.substring(1, size-1))) {
      palindromes.add(s);
      return true;
    }
    return false;
  }
}
