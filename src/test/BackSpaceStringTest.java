package test;

import impl.BackSpaceString;

public class BackSpaceStringTest {
    public static void main(String[] args) {
        BackSpaceString bss = new BackSpaceString();
        bss.backspaceCompare("e##e#o##oyof##q",
                "e##e#fq##o##oyof##q");
    }
}
