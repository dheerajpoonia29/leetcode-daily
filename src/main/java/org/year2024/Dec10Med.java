package org.year2024;

import java.util.*;

//https://leetcode.com/problems/find-longest-special-substring-that-occurs-thrice-i/?envType=daily-question&envId=2024-12-10

public class Dec10Med {
    public void solve() {
    }

    public int maximumLength(String s) {
        List<String> substrings = new ArrayList<>();
        Map<String, Integer> mp = new HashMap<>();

        // Outer loop for the start index of substrings
        for (int start = 0; start < s.length(); start++) {
            // Inner loop for the end index of substrings
            for (int end = start + 1; end <= s.length(); end++) {
                // Add the substring to the list
                String ss = s.substring(start, end);
                if(isSpecial(ss)) {
                    substrings.add(ss);
                    mp.put(ss, mp.getOrDefault(ss, 0)+1);
                }
            }
        }

        int len = -1;
        String ans;


        for(Map.Entry<String, Integer> entry: mp.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            if(value>2) {
                if(len<key.length()) {
                    len = key.length();
                    ans = key;
                }
            }
        }

        return len;
    }

    public boolean isSpecial(String ss) {
        if(ss.length()<1) return false;

        char[] arr = ss.toCharArray();

        for(int i=1; i<arr.length; i++) {
            if(arr[0]!=arr[i]) {
                return false;
            }
        }

        return true;
    }
}
