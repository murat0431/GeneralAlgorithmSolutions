package test;

import impl.Permutations;

public class PermutationsTest {
    public static void main(String[] args) {
        Permutations p = new Permutations();
        int[] arr = new int[]{1, 2, 3, 4};
        p.permute(arr);
    }
}
