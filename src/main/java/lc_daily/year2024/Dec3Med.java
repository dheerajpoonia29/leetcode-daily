package lc_daily.year2024;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/adding-spaces-to-a-string/

public class Dec3Med {
    public String addSpaces(String s, int[] spaces) {
        List<String> lst = new ArrayList<>();
        for(int i=0; i<s.length(); i++) {
            lst.add(String.valueOf(s.charAt(i)));
        }

        for(int idx: spaces) {
            String ss = " "+lst.get(idx);
            lst.set(idx, ss);
        }

        return String.join("", lst);
    }

    public void solve() {
//        String ans = addSpaces("abc", new int[]{0, 2});
//        String ans = addSpaces("LeetcodeHelpsMeLearn", new int[]{8,13,15});
//        String ans = addSpaces("icodeinpython", new int[]{1,5,7,9});
        String ans = addSpaces("spacing", new int[]{0,1,2,3,4,5,6});
        System.out.println(ans);
    }
}
