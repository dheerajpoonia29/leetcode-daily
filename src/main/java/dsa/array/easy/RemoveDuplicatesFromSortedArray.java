package dsa.array.easy;

//https://leetcode.com/problems/remove-duplicates-from-sorted-array/

import java.util.HashSet;

public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{1,1,2}));
        System.out.println(removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4}));


        System.out.println(ocs1(new int[]{1,1,2}));
        System.out.println(ocs1(new int[]{0,0,1,1,1,2,2,3,3,4}));

        System.out.println(ocs2(new int[]{1,1,2}));
        System.out.println(ocs2(new int[]{0,0,1,1,1,2,2,3,3,4}));
    }

    public static int removeDuplicates(int[] nums) {
        int n = nums.length;

        HashSet<Integer> st = new HashSet<>();

        int i=0;
        while(i<n) {
            // if nums[i] not in set
            if(!st.contains(nums[i])) {
                st.add(nums[i]);
            } else {
                int j = i+1;
                while(j<n && st.contains(nums[j])) {
                    j++;
                }
                if(j<n) {
                    int tp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tp;
                    st.add(nums[i]);
                } else
                    break;
            }
            i++;
        }
        return i;
    }

    public static int ocs1(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();

        // start from 0th index
        int k = 0;
        for(int i=0; i<nums.length; i++) {
            // if ele not in hashset it means its unique
            if(!hs.contains(nums[i])) {
                // add in element
                hs.add(nums[i]);

                // as we don't care what after kth element so will not swap kth and ith element
                nums[k++] = nums[i];
            }
        }

        return k;
    }

    public static int ocs2(int[] nums) {
        // given array is already sorted

        int k = 1;
        for(int i=1; i<nums.length; i++) {
            // last element not equal to current element, it's means we found unique element
            if(nums[i] != nums[i-1]) {
                // so add unique element at last non-unique element present
                nums[k++] = nums[i-1];
            }
        }

        return k;
    }
}
