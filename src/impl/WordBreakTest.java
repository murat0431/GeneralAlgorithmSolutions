package impl;

import java.util.ArrayList;
import java.util.List;

public class WordBreakTest {
    public static void main(String[] args) {
        WordBreak wb = new WordBreak();
        String s = "leetcode";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");
        wb.wordBreak(s, wordDict);
    }
}
