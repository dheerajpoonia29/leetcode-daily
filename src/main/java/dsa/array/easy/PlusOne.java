package dsa.array.easy;

public class PlusOne {
    public static void main(String[] args) {
        common.Util.printArray(plusOne(new Integer[]{1,2,3}));
        common.Util.printArray(plusOne(new Integer[]{9}));
        common.Util.printArray(plusOne(new Integer[]{9,8,7,6,5,4,3,2,1,0}));
        common.Util.printArray(osc1(new Integer[]{7,2,8,5,0,9,1,2,9,5,3,6,6,7,3,2,8,4,3,7,9,5,7,7,4,7,4,9,4,7,0,1,1,1,7,4,0,0,6}));

        common.Util.printArray(osc1(new Integer[]{7,2,8,5,0,9,1,2,9,5,3,6,6,7,3,2,8,4,3,7,9,5,7,7,4,7,4,9,4,7,0,1,1,1,7,4,0,0,9}));
    }

    public static Integer[] plusOne(Integer[] digits) {
        String noStr = "";
        for(Integer digit: digits) {
            noStr += digit;
        }

        Long no = Long.parseLong(noStr);
        no += 1;

        noStr = no.toString();

        Integer[] res = new Integer[noStr.length()];
        for(int i=0; i<noStr.length(); i++) {
            res[i] = Character.getNumericValue(noStr.charAt(i));
        }

        return res;
    }

    public static Integer[] osc1(Integer[] digits) {
        int n = digits.length-1;

        if(digits[n] < 9) {
            digits[n] += 1;
            return digits;
        }

        int j = n-1;
        digits[j--] = 0;
        Integer[] res = new Integer[n+2];
        while(j>=0) {
            if(digits[j]==9) {
                digits[j] += 1;
            }
            digits[j] = 0;
            j--;
        }

        return res;
    }
}
