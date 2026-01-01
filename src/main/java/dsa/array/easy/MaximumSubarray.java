package dsa.array.easy;

public class MaximumSubarray {
    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
//        System.out.println(maxSubArray(new int[]{1}));
//        System.out.println(maxSubArray(new int[]{5,4,-1,7,8}));
//        System.out.println(maxSubArray(new int[]{-1}));
//        System.out.println(maxSubArray(new int[]{1}));
        System.out.println(maxSubArray(new int[]{1,2}));
    }

    public static int maxSubArray(int[] nums) {
        int n = nums.length;

        int ms = nums[0]; // maximum sum
        int ps = nums[0]; // previous sum

        for (int i=1; i<nums.length; i++) {
            int ele = nums[i];
            if(ele > ps + ele)
                // if current element is greater than previous sum + ele then new greater sum is current element
                // reset current maximum sum here, because we need the maximum subarray sum, and the current element is the current height sum value
                // taking this element forward will possibly make this the biggest negative value, or it's get shorter ahead with a negative element
                ps = ele;
            else
                // else take current element in previous sum
                ps += ele;

            if(ps > ms) {
                ms = ps;
            }
        }

        return ms;
    }
}
