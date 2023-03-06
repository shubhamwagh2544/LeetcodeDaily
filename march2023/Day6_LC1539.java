package CODE2023.march2023;

import Arrays.ArrayInsertAtEnd;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
https://leetcode.com/problems/kth-missing-positive-number/
 */
public class Day6_LC1539 {
    public static void main(String[] args) {
        //int[] array = {2,3,4,7,11};
        int[] array = {5,6,7,8,9};
        int k = 9;
        //int k = 5;
        //System.out.println(getKthNumberInSorted(array, k));     // brute
        //System.out.println(getKthNumberInSortedAnother(array, k));  // brute
        System.out.println(getKthNumberInSortedAnotherBrute(array, k));     // brute
    }
    private static int getKthNumberInSorted(int[] array, int k) {
        for (int n : array) {
            if (n <= k) k++;
            else break;
        }
        return k;
    }

    private static int getKthNumberInSortedAnother(int[] array, int k) {
        int i = 1;
        int j = 0;
        int res = 0;
        boolean flag = true;
        while (j<array.length) {
            if (array[j] != i) {
                flag = false;
                k--;
                res = i;
            }
            else j++;
            if (k == 0) return res;
            i++;
        }
        if (flag) {
            return array[array.length-1]+k;
        }
        if (j == array.length && !flag) {
            return array[array.length-1]+k;
        }
        return -1;
    }

    private static int getKthNumberInSortedAnotherBrute(int[] array, int k) {
        Set<Integer> set = new HashSet<>();
        for (int num : array) {
            set.add(num);
        }
        for (int i=1; i<=2000; i++) {
            if (set.add(i)) {
                k--;
            }
            if (k == 0) return i;
        }
        return -1;
    }
}
