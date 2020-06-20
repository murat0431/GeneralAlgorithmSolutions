package impl;

import java.util.Arrays;
import java.util.Comparator;

public class PossibleBiPartition {
    public boolean possibleBipartition(int N, int[][] dislikes) {
        Arrays.sort(dislikes, Comparator.comparingInt(i->i[0]));
        int[] indexes = new int[N+1];
        Arrays.fill(indexes, -1);
        for(int[] dislike : dislikes) {
            int first = dislike[0];
            int second = dislike[1];
            int firstIndex = indexes[first];
            int secondIndex = indexes[second];
            if(firstIndex != -1 && secondIndex != -1) {
                if(firstIndex == secondIndex) return false;
            } else {
                if(firstIndex == -1) {
                    indexes[first] = secondIndex == 0 ? 1 : 0;
                } else if(secondIndex == -1){
                    indexes[second] = firstIndex == 0 ? 1 : 0;
                } else {
                    indexes[first] = 0;
                    indexes[second] = 1;
                }
            }
        }
        return true;
    }
}