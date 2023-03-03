package CODE2023.feb2023;

import java.util.Arrays;

/*
https://leetcode.com/problems/shuffle-the-array/
 */
public class Day6_LC1470 {
    private static void shuffleArray(int[] arr, int n) {

        int[] buffer = new int[n];
        int i=0;
        while (i < n) {
            buffer[i] = arr[i];
            i++;
        }
        int j=n;
        i=0;
        for (int x=0; x<2*n;) {
            arr[x++] = buffer[i++];
            arr[x++] = arr[j++];
        }
        Arrays.stream(arr).forEach(System.out::println);
    }
    public static void main(String[] args) {
        int[][] arr = {{2,5,1,3,4,7}, {1,2,3,4,4,3,2,1}, {1,1,2,2}};

        for (int i=0; i<arr.length; i++) {
            shuffleArray(arr[i], arr[i].length/2);
            System.out.println("-----------------------");
        }
    }

}
