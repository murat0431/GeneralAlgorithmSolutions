package impl;

import java.util.ArrayList;
import java.util.List;

public class ReverseInteger {
    public int reverse(int x) {
        if(x==0) return 0;
        boolean isNegative = x<0;
        int val = Math.abs(x);
        List<Integer> digits = new ArrayList<>();
        findDigits(x, digits);
        int number = 0;
        for(int i=0;i<digits.size();i++) {
            if(number == 0 && digits.get(i) == 0) continue;
            number += Math.pow(10, digits.size()-1-i)*digits.get(i);
            if(number >= Integer.MAX_VALUE) return 0;
        }
        if(number > Integer.MAX_VALUE) return 0;
        return isNegative ? -number : number;
    }

    private void findDigits(int x, List<Integer> digits) {
        while(x>0) {
            digits.add(x%10);
            x /= 10;
        }
    }
}