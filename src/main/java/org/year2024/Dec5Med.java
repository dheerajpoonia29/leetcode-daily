public class Dec5Med {

  public boolean canChange(String s, String t) {
    StringBuffer start = new StringBuffer(s);
    StringBuffer target = new StringBuffer(t);

    System.out.println(start.length()+" "+target.length());

    int n = start.length();

    int lLoc = getLeftLocArr(n, start);
    int rLoc = getRightLoc(n, start);

    int i=0;

    while(i<n) {
      char targetChar = target.charAt(i);
      char currChar = start.charAt(i);

      if(currChar!='L' && targetChar=='L') {
        int j = i+1;
        while(j<n && start.charAt(j)=='_') {
          j++;
        }
        if(j<n && start.charAt(j)=='L') {
          start.setCharAt(i, 'L');
          start.setCharAt(j, '_');
        }
      }
      i++;
    }

    i=n-1;

    while(i>=0) {
      char targetChar = target.charAt(i);
      char currChar = start.charAt(i);

      if(currChar!='R' && targetChar=='R') {
        int j = i-1;
        while(j>=0 && start.charAt(j)=='_') {
          j--;
        }
        if(j>=0 && start.charAt(j)=='R') {
          start.setCharAt(i, 'R');
          start.setCharAt(j, '_');
        }
      }

      i--;
    }

    return start.equals(target);
  }

  private int getRightLoc(int n, StringBuffer target) {
    for(int i=0; i<n; i++) {
      if(target.charAt(i)=='R') {
        return i;
      }
    }
    return -1;
  }

  private int getLeftLocArr(int n, StringBuffer str) {
    for(int i=n-1; i>=0; i--) {
      if(str.charAt(i)=='L') {
        return i;
      }
    }
    return -1;
  }

  public void solve() {
    System.out.println(canChange("_L__R__R_", "L______RR"));
  }
}
