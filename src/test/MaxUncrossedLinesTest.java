package test;

import impl.MaxUncrossedLines;

public class MaxUncrossedLinesTest {
    public static void main(String[] args) {
        MaxUncrossedLines ml = new MaxUncrossedLines();
        ml.maxUncrossedLines(new int[]{4,1,2,5,1,5,3,4,1,5},
                new int[]{3,1,1,3,2,5,2,4,1,3,2,2,5,5,3,5,5,1,2,1});
    }
}
