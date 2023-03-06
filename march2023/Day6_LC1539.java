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
        //System.out.println(getKthNumberInSortedAnotherBrute(array, k));     // brute

        System.out.println(getKthNumberInSortedOptimal(array, k));  // binary-search
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
    /*
            arr[i] - (i+1) => denotes how many numbers missed before arr[i]
            so we are finding mid
            if
            arr[mid] - (mid+1) = 0 (no numbers dropped)
            arr[mid] - (mid+1) < k (numbers dropped are less than k :> means Kth number is to right :> hence start=mid+1
            else end = mid-1 (kth number is to the left only)
            hence in any case (start + k) leads to kth number

            eg. suppose numbers dropped are 3 to left and k = 2 :> then kth number is to left
            eg. suppose number dropped are 1 and k = 3 :> then kth number is to right (shift start to mid+1)
     */
    private static int getKthNumberInSortedOptimal(int[] array, int k) {
        int start = 0;
        int end = array.length-1;
        while (start <= end) {
            int mid = (start+end)/2;
            if (array[mid]-(mid+1) < k) {
                start = mid+1;
            }
            else {
                end = mid-1;
            }
        }
        return start+k;
    }
}
