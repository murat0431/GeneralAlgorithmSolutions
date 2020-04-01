package impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordBreakMemo {
  public boolean wordBreak(String s, List<String> wordDict) {
    Map<Integer, Boolean> memo = new HashMap<>();
    wordBreak(0, s, wordDict, memo);
    return memo.get(0) == null ? false : memo.get(0);
  }

  private boolean wordBreak(int index, String s, List<String> wordDict, Map<Integer, Boolean> memo) {
    if(index == s.length()-1 || (memo.get(index) != null && memo.get(index))) return true;
    for(String word : wordDict) {
      if(s.substring(index).indexOf(word) == 0) {
        if(wordBreak(index+word.length(), s, wordDict, memo)) {
          memo.put(index, true);
          return true;
        }

      }
    }
    memo.put(index, false);
    return false;
  }
}
