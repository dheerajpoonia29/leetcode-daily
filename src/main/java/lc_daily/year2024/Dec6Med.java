package lc_daily.year2024;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Dec6Med {
    public int maxCount(int[] banned, int n, int maxSum) {
        Set<Integer> tempArr = Arrays.stream(banned).boxed().collect(Collectors.toSet());
        List<Integer> arr = new ArrayList<>();
        for(Integer i=1; i<=n; i++) {
            if(!tempArr.contains(i))
                arr.add(i);
        }

        for(Integer i: banned) {
            while(arr.contains(i)) {
                arr.remove(i);
            }
        }

        int ans = 0;
        int totalSum = 0;
        for(Integer i: arr) {
            if(totalSum+i<=maxSum) {
                totalSum+=i;
                ans++;
            } else {
                break;
            }
//            System.out.print(i+" ");
        }
//        System.out.println();
        System.out.println("ans = "+ans);

        return ans;
    }

    public void solve() {
//        maxCount(new int[]{1,6,5}, 5, 6);
//        maxCount(new int[]{1,2,3,4,5,6,7}, 8, 1);
//        maxCount(new int[]{11}, 7, 50);
//        maxCount(new int[]{1}, 10000, 1000000000);
        maxCount(new int[]{176,36,104,125,188,152,101,47,51,65,39,174,29,55,13,138,79,81,175,178,42,108,24,80,183,190,123,20,139,22,140,62,58,137,68,148,172,76,173,189,151,186,153,57,142,105,133,114,165,118,56,59,124,82,49,94,8,146,109,14,85,44,60,181,95,23,150,97,28,182,157,46,160,155,12,67,135,117,2,25,74,91,71,98,127,120,130,107,168,18,69,110,61,147,145,38}, 316, 240);
    }
}
