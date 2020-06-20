package impl;

public class ContArray  {
    public int findMaxLength(int[] nums) {
        int size = nums.length;
        if(size<2) return 0;
        int[] tab = new int[size+1];
        for(int i=size-1;i>=0;i--) tab[i] = + nums[i]==0 ? tab[i+1]-1 : tab[i+1]+1;
        int newSize = size%2==0 ? size : size-1;
        while(newSize>0) {
            int i=0;
            int j=i+newSize;
            while(j<=size) {
                int temp = tab[i]-tab[j];
                if(temp==0) return newSize;
                j++;
                i++;
            }
            newSize -= 2;
        }
        return 0;
    }
}

/**

 1 1 1 1 1 0 0 0 1 0 0 1 1 0 1 1

 */