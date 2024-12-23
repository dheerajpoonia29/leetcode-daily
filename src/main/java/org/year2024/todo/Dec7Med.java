package org.year2024.todo;

import java.util.Collections;
import java.util.PriorityQueue;

//https://leetcode.com/problems/minimum-limit-of-balls-in-a-bag/
public class Dec7Med {
    public int minimumSize(int[] nums, int mo) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(Integer i: nums) {
            pq.add(i);
        }

//        sol1(mo, pq);
        sol2(mo, pq);

        return pq.poll();
    }

    private void sol2(int mo, PriorityQueue<Integer> pq) {

    }

    private static void sol1(int mo, PriorityQueue<Integer> pq) {
        while(mo>0) {
            int maxNo = pq.poll();

            int a, b;
            if(maxNo%2==0) {
                a = maxNo/2;
                b = maxNo - maxNo/2;
            } else {
                a = maxNo/(mo+1);
                b = maxNo - maxNo/(mo+1);
            }
            pq.add(a);
            pq.add(b);
            mo--;
        }
    }

    public void solve() {
//        System.out.println(minimumSize(new int[]{2,4,8,2}, 4));
//        System.out.println(minimumSize(new int[]{9}, 1));
//        System.out.println(minimumSize(new int[]{9}, 2));
//        System.out.println(minimumSize(new int[]{2,4,8,2}, 4));
        System.out.println(minimumSize(new int[]{19, 9}, 3));
    }
}
