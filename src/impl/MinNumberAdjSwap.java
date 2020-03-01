package impl;

public class MinNumberAdjSwap {
    public int solution(String s) {
     int min = 0;
     int count = 0;
     StringBuilder sb = new StringBuilder(s);
     int hi = s.length() - 1;
     int low = 0;
     while (low < hi) {
         if(!(sb.charAt(low) == sb.charAt(hi))) {
             int index = -1;
             for (int i = hi - 1; i > low; i--) {
                 if (sb.charAt(i) == sb.charAt(low)) {
                     index = i;
                     break;
                 }
             }
             if (index == -1) {
                 if (s.length() % 2 == 0) return -1;
                 char temp = sb.charAt(low);
                 sb.insert(s.length() / 2 + 1, temp);
                 sb.deleteCharAt(low);
                 min += s.length() / 2 - low;
                 hi++;
                 low--;
             } else {
                 char temp = sb.charAt(index);
                 sb.insert(hi + 1, temp);
                 sb.deleteCharAt(index);
                 min += hi - index;
             }
         }
         low ++;
         hi--;

     }
     return min;
    }
}
