package contest.jan;

public class Jan6Med {
    public void solve() {
//        int[] ans = minOperations("110");
        int[] ans = minOperations("001011");
        for(int i: ans) {
            System.out.print(i+" ");
        }
    }

    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] ans = new int[n];

        for (int i=0; i<n; i++) {
            int cnt = 0;
            for (int j=0; j<n; j++) {
                if (i!=j && boxes.charAt(j)=='1') {
                   cnt += Math.abs(i-j);
                }
            }
            ans[i] = cnt;
        }

        String s = "sdfdsf";
        s.indexOf("fd");

        return ans;
    }
}
