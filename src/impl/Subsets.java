package impl;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            subsets(nums, 0, new ArrayList<Integer>(), result);
            result.add(new ArrayList<>());
            return result;

        }

        private void subsets(int[] nums, int index, List<Integer> list, List<List<Integer>> result) {
            if (index == nums.length) {
                return;
            }
            for (int i = index; i < nums.length; i++) {
                List<Integer> newList = new ArrayList<Integer>(list);
                newList.add(nums[i]);
                result.add(newList);
                subsets(nums, i + 1, newList, result);
            }
        }
}
