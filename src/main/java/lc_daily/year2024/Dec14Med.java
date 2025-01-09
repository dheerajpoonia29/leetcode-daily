package lc_daily.year2024;

public class Dec14Med {
    public void solve() {
//        System.out.println(continuousSubarrays(new int[]{1,2,3,4}));
//        System.out.println(continuousSubarrays(new int[]{1,2,3}));
//        System.out.println(continuousSubarrays(new int[]{31,30,31,32}));
//        System.out.println(continuousSubarrays(new int[]{5,4,2,4}));
//        System.out.println(continuousSubarrays(new int[]{3, 4, 5, 4}));
//        System.out.println(continuousSubarrays(new int[]{1, 10, 1}));
//        System.out.println(continuousSubarrays(new int[]{1000000000, 1000000000, 1000000000, 1000000000}));
//        System.out.println(continuousSubarrays(new int[]{1, 3, 1, 3, 1}));
//        System.out.println(continuousSubarrays(new int[]{999999998, 999999999, 1000000000}));
        System.out.println(continuousSubarrays(new int[]{65,66,67,66,66,65,64,65,65,64}));
    }

    public long continuousSubarrays(int[] nums) {
        int n = nums.length;
        int cnt = 0;

        int left = 0;

        int mx = nums[left];
        int mn = nums[left];

        for (int right=0; right<n; right++) {
            mx = Math.max(nums[right], mx);
            mn = Math.min(nums[right], mn);

            while (mx-mn>2) {
                left++;
                mx = nums[left];
                mn = nums[left];

                for(int k = left; k <= right; k++) {
                    mx = Math.max(nums[k], mx);
                    mn = Math.min(nums[k], mn);
                }
            }

            cnt += right- left + 1;
        }

        return cnt;
    }

    /*
    public long continuousSubarrays(int[] nums) {
        int n = nums.length;
        long cnt = 0;

        List<List<Integer>> ss = new ArrayList<>();

        for(int s=1; s<=n; s++) {
            for (int i=0; i<n-(s-1); i++) {
                int j = i;
                int mx = nums[i];
                int mn = nums[i];
                j++;
                while(j<=(i+s)-1) {
                    mx = Math.max(mx, nums[j]);
                    mn = Math.min(mn, nums[j]);
                    j++;
                }
                if(j==(i+s) && (mx-mn)<3) {
                    cnt++;
                }
            }
        }

        return cnt;
    }

     */
}
