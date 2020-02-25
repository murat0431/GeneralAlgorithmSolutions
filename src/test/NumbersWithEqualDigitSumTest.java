package test;

import impl.NumbersWithEqualDigitSum;

public class NumbersWithEqualDigitSumTest {
    public static void main(String[] args) {
        int[] A = {123, 321, 46, 37, 1081, 896, 15, 23, 34, 102};
        int[] B = {51, 71, 17, 42};
        int[] C = {42, 33, 60};
        int[] D = {51, 32, 43};
        int resultA = 1127;
        int resultB = 93;
        int resultC = 102;
        int resultD = -1;
        test(A, resultA);
        test(B, resultB);
        test(C, resultC);
        test(D, resultD);


    }

    public static void test(int[] A, int result) {
        NumbersWithEqualDigitSum nm = new NumbersWithEqualDigitSum();
        String message = "Program does not work properly";
        if (nm.solution(A) == result) {
            message = "It works properly";
        }
        System.out.println(message);
        System.out.println(nm.solution(A));
        System.out.println(nm.solution2(A));
    }
}
