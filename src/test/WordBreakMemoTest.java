package test;

import impl.WordBreakMemo;

import java.util.ArrayList;
import java.util.List;

public class WordBreakMemoTest {
  public static void main(String[] args) {
    WordBreakMemo wbm = new WordBreakMemo();
    String s = "leetcode";
    List<String> dict = new ArrayList<>();
    dict.add("leet");
    dict.add("code");
    wbm.wordBreak(s, dict);
  }
}
