package impl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MaxUncrossedLines {
    public int maxUncrossedLines(int[] A, int[] B) {
        int size1= A.length;
        int size2= B.length;
        Map<Integer, Set<Integer>> table = size1>size2 ? initMap(A) : initMap(B);
        if(size1>size2) return maxUnCrossedLines(0, 0, B, A, 0, table);
        return maxUnCrossedLines(0, 0, A, B, 0, table);
    }

    private int maxUnCrossedLines(int index1, int index2, int[] small, int[] big, int result,
                                  Map<Integer, Set<Integer>> table) {
        if(index1 >= small.length || index2>= big.length) return result;
        int curr = small[index1];
        //int res1 = maxUnCrossedLines(index1+1, index2, small, big, result, table);
        if(!table.containsKey(curr))
            return maxUnCrossedLines(index1+1, index2, small, big, result, table);
        int currIndex =-1;
        for(int index : table.get(curr)) {
            if(index>=index1 && index>=index2) {
                currIndex = index;
                break;
            }
        }
        if(currIndex==-1)
            return maxUnCrossedLines(index1+1, index2, small, big, result, table);
        return Math.max(maxUnCrossedLines(index1+1, index2, small, big, result, table), maxUnCrossedLines(index1+1, currIndex+1, small, big, result+1, table));
    }

    private Map<Integer, Set<Integer>> initMap(int[] big) {
        Map<Integer, Set<Integer>> table = new HashMap<>();
        for(int i=0;i<big.length;i++) {
            int curr = big[i];
            if(table.containsKey(curr)) {
                table.get(curr).add(i);
            } else {
                Set<Integer> set = new HashSet<>();
                set.add(i);
                table.put(curr, set);
            }

        }
        return table;
    }
}