package org.year2024;

public class Dec19Easy {
    public void solve() {
//        finalPrices(new int[]{8,4,6,2,3});
//        finalPrices(new int[]{1,2,3,4,5});
        finalPrices(new int[]{10,1,1,6});
    }

    /*
    8,4,6,2,3
    4,2,2,2,3
    4,2,4,2,3

    8,4,6,3,2
    4,3,3,3,2

    10,1,1,6
    01,1,1,6
    09,0,1,6

    [8,7,4,2,8,1,7,7,10,1]
    09,12,8,1
    08,08,1,-


     */

    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        int[] a = new int[n];
        a[n-1] = prices[n-1];

        for(int i=0; i<n-1; i++) {
            int j = i+1;
            while(j<n) {
                if (prices[j]<=prices[i]) {
                    a[i] = prices[i] - prices[j];
                    break;
                }
                j++;
            }
            if(j==n) {
                a[i] = prices[i];
            }
        }

        return a;
    }

    public int[] finalPrices2(int[] prices) {
        int n = prices.length;
        int[] a = new int[n];
        a[n-1] = prices[n-1];

        for(int i=0; i<n-1; i++) {
            int j = i+1;
            while(j<n) {
                if (prices[j]<=prices[i]) {
                    a[i] = prices[i] - prices[j];
                    break;
                }
                j++;
            }
            if(j==n) {
                a[i] = prices[i];
            }
        }

        return a;
    }
}
