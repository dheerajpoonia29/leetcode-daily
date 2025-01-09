package lc_contest.jan;

public class Jan4 {

    public void solve() {
        System.out.println(hasMatch("jjv", "*j")); // Expected: true
        System.out.println(hasMatch("luck", "u*")); // Expected: true
    }

    public boolean hasMatch(String s, String p) {
        // Special case where p is "*"
        if (p.equals("*")) {
            return true;
        }

        // Split the pattern p by '*', so we get the prefix and suffix
        String[] parts = p.split("\\*", -1); // -1 to handle empty prefix or suffix
        String prefix = parts[0];  // Part before '*'
        String suffix = parts.length > 1 ? parts[1] : "";  // Part after '*'

        // Case when pattern starts with '*', meaning prefix is empty
        if (prefix.isEmpty()) {
            // We check if the string contains the suffix anywhere
            return s.contains(suffix);
        }

        // Case when pattern ends with '*', meaning suffix is empty
        if (suffix.isEmpty()) {
            // We check if the string contains the prefix anywhere
            return s.contains(prefix);
        }

        // Case when both prefix and suffix exist
        for (int i = 0; i + prefix.length() <= s.length(); i++) {
            if (s.substring(i, i + prefix.length()).equals(prefix)) {
                // Check if the remainder contains the suffix
                if (s.substring(i + prefix.length()).contains(suffix)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Jan4 jan4 = new Jan4();
        jan4.solve();
    }
}