package test;

import impl.LexSmallestString;

public class LexSmallestStringTest implements Test{
    public static void main(String[] args) {
        LexSmallestString ls = new LexSmallestString();
        String test = "abcde";
        String expected = "abcd";
        String result = ls.solution(test);
        Test t = new LexSmallestStringTest();
        System.out.println(t.test(expected, result) + " " + expected + " " + result);

    }

    @Override
    public <T> boolean test(T expected, T result) {
        return expected.equals(result);
    }
}
