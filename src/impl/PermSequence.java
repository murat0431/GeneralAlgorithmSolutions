package impl;

import java.util.ArrayList;
import java.util.List;

public class PermSequence {
    public String getPermutation(int n, int k) {
        List<Integer> remains = new ArrayList<>();
        int[] factorials = new int[n+1];
        factorials[0] = 1;
        for(int i=1;i<n+1;i++) {
            remains.add(i);
            factorials[i] = factorials[i-1]*i;
        }
        StringBuilder rs = new StringBuilder();
        while(!remains.isEmpty()) {
            int size = remains.size();
            int index = (size==1 || size==2) && k>0 ? k-1 :(k/factorials[size-1]);
            rs.append(remains.get(index));
            k %= factorials[size-1];
            remains.remove(index);
        }
        return rs.toString();
    }

}


/*

    1 2 3 4 5 6    n=6 k=83

    k%(n-1)! = 83
    k/(n-1)! = 0

   res = 1


    83%(n-2)! = 11
    k/(n-2)! = 3

   res =  14

    11/(n-3)! = 1
    11%(n-3)! = 5

    res = 142;

    5/2 = 2
    5%2 = 1

    1423

*/