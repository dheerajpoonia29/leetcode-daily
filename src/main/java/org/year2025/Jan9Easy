package Year2025;

public class Jan9Easy {
    public void solve() {
        System.out.println(prefixCount(new String[]{"pay","attention","practice","attend"}, "at"));
        System.out.println(prefixCount(new String[]{"leetcode","win","loops","success"}, "code"));
    }

    public int prefixCount(String[] words, String pref) {
        int cnt = 0;
        for(String s: words) {
            if(s.startsWith(pref)) cnt++;
        }
        return cnt;
    }
}
