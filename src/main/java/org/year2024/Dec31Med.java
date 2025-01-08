package org.year2024;

public class Dec31Med {
    public void solve() {
        System.out.println(mincostTickets(new int[]{1,4,6,7,8,20}, new int[]{2,7,15}));
    }

    public int mincostTickets(int[] days, int[] costs) {
        if(days.length==1) return Math.min(Math.min(costs[0], costs[1]), costs[2]);

        count(days, costs, 0, days[0], costs[0], days[0]+1);
        return count;
    }

    public static int count = 0;

    private int count(int[] days, int[] costs, int i, int cost, int expDate, int dollar) {
        if(i>days.length) return i;

        int currDate = days[i];

        if(currDate > expDate) {

        }

//        int a = count(days, costs, i+1, cost[0], dollar + cost);
//        int b = count(days, costs, i+1, cost[0], dollar + cost);
//        int c = count(days, costs, i+1, cost[0], dollar + cost);

//        return Math.min(Math.min(a,b),c);
        return 0;
    }
}
