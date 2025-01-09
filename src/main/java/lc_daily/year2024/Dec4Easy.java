package lc_daily.year2024;

public class Dec4Easy {
//    https://leetcode.com/problems/make-string-a-subsequence-using-cyclic-increments/description/
    public boolean isSubsequence(String seq, String subSeq) {
        int tLen = seq.length();
        int sLen = subSeq.length();

        if(sLen > tLen) return false;

        int j = 0;
        for (int i=0; i<tLen; i++) {
            if(j<sLen && subSeq.charAt(j) == seq.charAt(i)) {
                j++;
            }
        }

        if (j == sLen) return true;

        return false;
    }

    public boolean canMakeSubsequence(String str1, String str2) {
        int i=0, j=0;

        if(str2.length()>str1.length()) return false;

        while(i<str1.length() && j<str2.length()) {
            char a = str1.charAt(i);
            char b = str2.charAt(j);
            if(a == b) {
                j++;
            } else if(a!='z' && a+1==b) {
                j++;
            } else if(a=='z' && b=='a') {
                j++;
            }
            i++;
        }

        return j==str2.length();
    }

    public void solve() {
//        System.out.println(canMakeSubsequence("abcd", "ac"));
//        System.out.println(canMakeSubsequence("abcg", "az"));
//        System.out.println(canMakeSubsequence("abc", "ad"));
//        System.out.println(canMakeSubsequence("zc", "ad"));
//        System.out.println(canMakeSubsequence("ab", "d"));
    }
}
