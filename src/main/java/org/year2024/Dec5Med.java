package org.year2024;

import java.util.ArrayList;
import java.util.List;

public class Dec5Med {

  /*
  public boolean canChange(String s, String t) {
    StringBuffer start = new StringBuffer(s);
    StringBuffer target = new StringBuffer(t);

//    System.out.println(start.length()+" "+target.length());

    int n = start.length();

    List<Integer> lLoc = getLocArr(n, start, 'L');
    List<Integer> rLoc = getLocArr(n, start, 'R');

    int i=0;

    while(i<n) {
      char targetChar = target.charAt(i);
      char currChar = start.charAt(i);

      if(currChar!='L' && targetChar=='L') {
        int j = lLoc.remove(0);
        if(j<n && i<j && start.charAt(j)=='L') {
          start.setCharAt(i, 'L');
          start.setCharAt(j, '_');
        }
      }
      i++;
    }

    lLoc = getLocArr(n, start, 'L');
    rLoc = getLocArr(n, start, 'R');

    i=n-1;

    while(i>=0) {
      char targetChar = target.charAt(i);
      char currChar = start.charAt(i);

      if(currChar!='R' && targetChar=='R') {
        int j = rLoc.remove(rLoc.size()-1);
        while(j>=0 && j<i && start.charAt(j)=='_') {
          j--;
        }
        if(j>=0 && start.charAt(j)=='R') {
          start.setCharAt(i, 'R');
          start.setCharAt(j, '_');
        }
      }

      i--;
    }

    return start.toString().equals(target.toString());
  }
   */

  private void skipSpaces(String s, int n, int[] pos) {
    while (pos[0] < n && s.charAt(pos[0]) == '_') {
      pos[0]++;
    }
  }

  // techdose code
  public boolean canChange(String start, String target) {
    int n = start.length();
    int first = 0, second = 0;
    int limitIdx = -1;

    int[] firstPos = {first};
    int[] secondPos = {second};

    while (firstPos[0] < n) {
      // Skip all spaces
      skipSpaces(start, n, firstPos);
      skipSpaces(target, n, secondPos);

      first = firstPos[0];
      second = secondPos[0];

      if (first == n && second == n) return true;
      if (first == n || second == n || start.charAt(first) != target.charAt(second)) return false;

      if (start.charAt(first) == 'L' && (second <= limitIdx || second > first)) {
        return false;
      } else if (start.charAt(first) == 'R' && first > second) {
        return false;
      }

      limitIdx = second;
      firstPos[0]++;
      secondPos[0]++;
    }

    // Skip leftover spaces (if any)
    skipSpaces(start, n, firstPos);
    skipSpaces(target, n, secondPos);

    return firstPos[0] == n && secondPos[0] == n;
  }

  private List<Integer> getLocArr(int n, StringBuffer str, char c) {
    List<Integer> loc = new ArrayList<>();
    for(int i=0; i<n; i++) {
      if(str.charAt(i)==c) {
        loc.add(i);
      }
    }
    return loc;
  }

  public void solve() {
//    System.out.println(canChange("_L__R__R_", "L______RR"));
    System.out.println(canChange("R_L_", "__LR"));
//    System.out.println(canChange("_R", "R_"));
//    System.out.println(canChange("_", "_"));
//    System.out.println(canChange("R_L_", "R__L"));
//    System.out.println(canChange("_LL___R__R_", "L___L____RR"));
  }
}
