package Year2025;

public class Jan8Easy {
    public void solve() {
//        System.out.println(countPrefixSuffixPairs(new String[]{"a","aba","ababa","aa"}));
//        System.out.println(countPrefixSuffixPairs(new String[]{"pa","papa","ma","mama"}));
//        System.out.println(countPrefixSuffixPairs(new String[]{"abab","ab"}));
        System.out.println(countPrefixSuffixPairs(new String[]{"abc","abcba","abccba","cbabc","cbaabc","cbacba","abc","abcabc"}));
//        System.out.println(countPrefixSuffixPairs(new String[]{"abccba","abcabc"}));
//        System.out.println(countPrefixSuffixPairs(new String[]{"abc","abc"}));
    }

    public boolean compute(String str1, String str2) {
        if(str1.length()>str2.length()) return false;

        if(str2.startsWith(str1) && str2.endsWith(str1)) return true;

        return false;
    }

    public int countPrefixSuffixPairs(String[] words) {
        int cnt = 0;
        for(int i=0; i<words.length; i++) {
            for(int j=i+1; j<words.length; j++) {
                if (compute(words[i], words[j])==true)  cnt++;
            }
        }
        return cnt;
    }
}
