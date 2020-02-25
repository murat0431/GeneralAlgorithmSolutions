package impl;

import java.util.List;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s.equals("")) return true;
        for(String word : wordDict) {
            if(word.length() > s.length()) continue;
            StringBuilder sb = new StringBuilder(s);
            if(sb.substring(0, word.length()).equals(word)
                    && wordBreak(sb.substring(word.length(), sb.length()).toString(), wordDict)) {
                return true;
            }
        }
        return false;
    }

}
