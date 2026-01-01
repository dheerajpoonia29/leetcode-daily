package dsa.array.easy;

// https://leetcode.com/problems/move-zeroes/description/

import static common.Util.printArray;

public class MoveZeroes {
    public static void main(String[] args) {
//        Integer[] arr = new Integer[]{0,1,0,3,12};
//        Integer[] arr = new Integer[]{0};
        Integer[] arr = new Integer[]{0, 1, 0, 0, 0, 2, 3, 0, 0, 4, 5, 0, 6};
        moveZeroes(arr);
        printArray(arr);
    }

    public static void moveZeroes(Integer[] nums) {
        Integer k = 0;

        for (Integer i=0; i<nums.length; i++) {
            // skip zeroes
            if(nums[i]==0) continue;

            // for non-zero value assign it to kth possition and increment
            nums[k++] = nums[i];
        }

        // then fill last position with zeros
        for(; k<nums.length; k++) {
            nums[k] = 0;
        }
    }
}
