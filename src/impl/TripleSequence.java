package impl;

public class TripleSequence {
    public boolean increasingTriplet(int[] nums) {
        int size = nums.length;
        if(size < 3) return false;
        int first = nums[0];
        int i = 0;
        int j = i+1;
        int k = j+1;
        while(i<size-2) {
            while(i< size-2 && first >= nums[i+1]) {
                first = nums[i+1];
                i++;
            }
            j = i+1;
            int second = nums[j];
            while(j<size-1 && second >= nums[j+1] && first <nums[j+1]) {
                second = nums[j+1];
                j++;
            }
            k = j+1;
            while(k<size) {
                if(nums[k] > second) return true;
                k++;
            }
            if(j<size-1) {
                first = nums[j+1];
                i=j+1;
            }
        }
        return false;
    }

}

/**

 4-3-7-2-7-3-1-6
 3-5-1-6
 3-5-1-2-3
 3-5-4-5
 4-3-7-2-10
 */