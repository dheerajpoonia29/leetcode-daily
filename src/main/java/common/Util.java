package common;

public class Util {
    public static <T> void printArray(T[] arr) {
        for (T i: arr) {
            System.out.print(i +" ");
        }
        System.out.println();
    }
}
