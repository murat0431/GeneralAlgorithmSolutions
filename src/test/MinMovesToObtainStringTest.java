package test;

import impl.MinMovesToObtainString;

public class MinMovesToObtainStringTest {
    public static void main(String[] args) {
        String testCase1 = "baaaaa";
        int expected1 = 1;
        String testCase2 = "baaabbaabbba";
        int expected2 = 2;
        String testCase3 = "baabab";
        int expected3 = 0;
        String testCase4 = "baaaaaaaaaab";
        int expected4 = 3;
        String testCase5 = "baaaaaab";
        int expected5 = 2;

        test(testCase1, expected1);
        test(testCase2, expected2);
        test(testCase3, expected3);
        test(testCase4, expected4);
        test(testCase5, expected5);
    }

    public static void test(String S, int expected) {
        MinMovesToObtainString mo = new MinMovesToObtainString();
        int result = mo.solution(S);
        if (result == expected) {
            System.out.println("SUCCESS. Result: " + result + " " + "Expected: " + expected);
        } else {
            System.out.println("FAIL. Result: " + result + " " + "Expected: " + expected);
        }
    }
}
