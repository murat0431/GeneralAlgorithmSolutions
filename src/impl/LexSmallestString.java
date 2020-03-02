package impl;

public class LexSmallestString {
    public String solution(String s) {
        int size = s.length();
        if(size < 2) return "";
        StringBuilder res = new StringBuilder();
        int index = 0;
        while(index < size-1 && s.charAt(index) < s.charAt(index+1)) {
            res.append(s.charAt(index));
            index++;
        }
        if(!(index == size-1)) {
            res.append(s.substring(index+1));
        }
        return res.toString();
    }
}
