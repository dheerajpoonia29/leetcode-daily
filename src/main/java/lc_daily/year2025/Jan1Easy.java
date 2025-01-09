package lc_daily.year2025;

public class Jan1Easy {
    public void solve() {
        System.out.println(maxScore("011101"));
        System.out.println(maxScore("00111"));
        System.out.println(maxScore("1111000"));
    }

    public int maxScore(String s) {
        int n = s.length();

        int[] a = new int[n];
        int[] b = new int[n];

        if(s.charAt(0)=='0') a[0] = 1;
        if(s.charAt(n-1)=='1') b[n-1] = 1;

        for(int i=1; i<n; i++) {
            if(s.charAt(i)=='0') {
                a[i] = a[i-1]+1;
            } else {
                a[i] = a[i-1];
            }
        }

        for(int i=n-2; i>=0; i--) {
            if(s.charAt(i)=='1') {
                b[i] = b[i+1]+1;
            } else {
                b[i] = b[i+1];
            }
        }

        int ans = 0;
        for(int i=0; i<n-1; i++) {
            ans = Math.max(ans, a[i]+b[i+1]);
        }

        return ans;
    }
}
