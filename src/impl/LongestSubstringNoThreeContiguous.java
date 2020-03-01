package impl;

public class LongestSubstringNoThreeContiguous {
    public String solution(String s) {
        int size = s.length();
        if(size < 3) return s;
        int count = 1;
        String result = "";
        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(0));
        for(int i=1;i<size;i++) {
            if(s.charAt(i) == s.charAt(i-1)) {
                count++;
                if(count < 3) {
                    sb.append(s.charAt(i));
                } else {
                    if(sb.length() > result.length()) result = sb.toString();
                    sb.delete(0,sb.length());
                    sb.append(s.charAt(i-1));
                    count = 1;
                    i--;
                }
            } else {
                count = 1;
                sb.append(s.charAt(i));
            }

        }
        return sb.length() > result.length() ? sb.toString() : result;
    }
}
