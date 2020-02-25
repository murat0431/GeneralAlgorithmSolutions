package impl;

public class MinMovesToObtainString {
    public int solution(String S) {
        int size = S.length();
        int max = 0;
        if(size < 3) return max;
        int currentSum = 1;
        for (int i=1;i<size;i++) {
            char prev = S.charAt(i-1);
            char current = S.charAt(i);
            if(prev == current) {
                currentSum++;
                if (currentSum == 3) {
                    max ++;
                    currentSum = 0;
                }
            } else {
                currentSum = 1;
            }

        }
        return max;
    }
}
