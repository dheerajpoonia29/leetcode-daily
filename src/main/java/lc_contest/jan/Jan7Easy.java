package lc_contest.jan;

import java.util.ArrayList;
import java.util.List;

public class Jan7Easy {
    public void solve() {
        List<String> ans = stringMatching(new String[]{"mass","as","hero","superhero"});
        for(String i: ans) {
            System.out.print(i+" ");
        }
    }

    public List<String> stringMatching(String[] words) {
        int n = words.length;

        List<String> ans = new ArrayList<>();

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if(j!=i && words[j].length()>words[i].length() && words[j].indexOf(words[i])!=-1) {
                    ans.add(words[i]);
                    break;
                }
            }
        }

        return ans;
    }
}
