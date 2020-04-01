package test;

import impl.MinDelToUniqFreq;

public class MinDelToUniqFreqTest implements Test{
    public static void main(String[] args) {
        MinDelToUniqFreq mq = new MinDelToUniqFreq();
        String test = "aabbbbcccdddd";
        int result = mq.solution(test);
        int expected = 3;
        MinDelToUniqFreqTest mt = new MinDelToUniqFreqTest();
        System.out.println(mt.test(expected, result) + " " + expected + " " + result);

    }

    @Override
    public <T> boolean test(T expected, T result) {
        return expected == result;
    }
}
