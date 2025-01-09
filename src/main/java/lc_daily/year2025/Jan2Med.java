package lc_daily.year2025;

public class Jan2Med {
    public void solve() {
//        int[] ans = vowelStrings(new String[]{"aba","bcb","ece","aa","e"}, new int[][]{{0,2},{1,4},{1,1}});
//        int[] ans = vowelStrings(new String[]{"a","e","i"}, new int[][]{{0,2}, {0,1},{2,2}});
        int[] ans = vowelStrings(new String[]{"bzmxvzjxfddcuznspdcbwiojiqf","mwguoaskvramwgiweogzulcinycosovozppl","uigevazgbrddbcsvrvnngfrvkhmqszjicpieahs","uivcdsboxnraqpokjzaayedf","yalc","bbhlbmpskgxmxosft","vigplemkoni","krdrlctodtmprpxwditvcps","gqjwokkskrb","bslxxpabivbvzkozzvdaykaatzrpe","qwhzcwkchluwdnqjwhabroyyxbtsrsxqjnfpadi","siqbezhkohmgbenbkikcxmvz","ddmaireeouzcvffkcohxus","kjzguljbwsxlrd","gqzuqcljvcpmoqlnrxvzqwoyas","vadguvpsubcwbfbaviedr","nxnorutztxfnpvmukpwuraen","imgvujjeygsiymdxp","rdzkpk","cuap","qcojjumwp","pyqzshwykhtyzdwzakjejqyxbganow","cvxuskhcloxykcu","ul","axzscbjajazvbxffrydajapweci"}, new int[][]{{4, 4},{6, 17},{10, 17},{9, 18},{17, 22},{5, 23},{2, 5},{17, 21},{5, 17},{4, 8},{7, 17},{16, 19},{7, 12},{9, 20},{13, 23},{1, 5},{19, 19}});
        for(int i: ans) {
            System.out.print(i+" ");
        }
    }

    public int[] vowelStrings(String[] words, int[][] queries) {
        int[] preSum = new int[words.length];
        int i = 0;

        for(String s: words) {
            if(i<words.length && isVowel(s.charAt(0)) && isVowel(s.charAt(s.length()-1))) {
                if(i==0) {
                    preSum[i] = 1;
                } else {
                    preSum[i] = preSum[i-1]+1;
                }
            } else {
                if(i>0) {
                    preSum[i] = preSum[i-1];
                }
            }
            i++;
        }

        int[] ans = new int[queries.length];
        i=0;

        for(int[] q: queries) {
            int s = q[0];
            int e = q[1];

            if(s==0) {
                ans[i] = preSum[e];
            }
            else if(s>0) {
                ans[i] = preSum[e] - preSum[s-1];
            }

            i++;
        }

        return ans;
    }

    public boolean isVowel(char c) {
        switch(c) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
                return true;
            default:
                return false;
        }
    }
}
