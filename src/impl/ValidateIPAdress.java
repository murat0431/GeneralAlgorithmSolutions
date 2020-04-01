package impl;

import test.Test;
import test.ValidateIPAdressTest;

public class ValidateIPAdress {
    public static void main(String[] args) {
        Test vt = new ValidateIPAdressTest();
        String test = "192.168.0.1";
        boolean expected = true;
        vt.test(expected, validateIP(test));
    }
    static boolean validateIP(String ip) {
        // your code goes here
        String[] sections = ip.split(".");
        if(sections.length != 4) return false;
        for(String s : sections) {
            int val = Integer.parseInt(s);
            if (val < 0 || val > 255) return false;
        }
        return true;
    }
}