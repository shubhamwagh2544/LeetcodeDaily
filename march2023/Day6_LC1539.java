package CODE2023.march2023;
/*
https://leetcode.com/problems/kth-missing-positive-number/
 */
public class Day6_LC1539 {
    public static void main(String[] args) {
        int[] array = {2,3,4,7,11};
        int k = 5;
        System.out.println(getKthNumberInSorted(array, k));     // brute
    }
    private static int getKthNumberInSorted(int[] array, int k) {
        for (int n : array) {
            if (n <= k) k++;
            else break;
        }
        return k;
    }
}
