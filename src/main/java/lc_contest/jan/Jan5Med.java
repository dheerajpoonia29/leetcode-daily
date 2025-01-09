package lc_contest.jan;

public class Jan5Med {

    public void solve() {
        System.out.println(shiftingLetters("abc", new int[][]{{0,1,0},{1,2,1},{0,2,1}})); // Expected: true
        System.out.println(shiftingLetters("dztz", new int[][]{{0,0,0},{1,1,1}})); // Expected: true
    }

    public String shiftingLetters(String s, int[][] shifts) {
        int[] count = new int[s.length()];

        for(int i=0; i<s.length(); i++) {
            count[i] = s.charAt(i);
        }

        for(int[] q: shifts) {
            for(int i=q[0]; i<=q[1]; i++) {
                if(q[2]==0) {
                    count[i] -= 1;
                } else if(q[2]==1) {
                    count[i] += 1;
                }
            }
        }

        char[] ch = new char[s.length()];
        for(int i=0; i<s.length(); i++) {
            ch[i] = (char) ('a' + (count[i] - 'a') % 26);
        }

        return new String(ch);
    }
}
