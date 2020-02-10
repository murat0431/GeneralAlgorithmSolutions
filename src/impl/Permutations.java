package impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        List<Integer> remain = arrToList(nums);
        return permute(result, remain, list);
    }

    private List<List<Integer>> permute(List<List<Integer>> result, List<Integer> remain,                                                       List<Integer> list) {
        if(remain.isEmpty()) {
            result.add(list);
        }
        for (Integer i : remain) {
            List<Integer> newList = new ArrayList<>(list);
            List<Integer> newRemain = new ArrayList<>(remain);
            newList.add(i);
            newRemain.remove(i);
            permute(result, newRemain, newList);
        }
        return result;
    }

    public List<Integer> arrToList(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for (int i : arr) {
            list.add(i);
        }
        return list;
    }

}
