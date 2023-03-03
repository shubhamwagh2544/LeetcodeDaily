package CODE2023.march2023;

import java.util.Arrays;

/*
https://leetcode.com/problems/sort-an-array/description/
 */

public class Day1_LC912_Better {
    public static void mergeSort(int[] nums) {
        mergeSort(nums, 0, nums.length-1);
    }
    private static void mergeSort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = (start+end)/2;
        mergeSort(nums, start, mid);
        mergeSort(nums, mid+1, end);
        merge(nums, start, mid, end);
    }
    private static void merge(int[] nums, int start, int mid, int end) {
        int i=start;
        int j=mid+1;

        int[] total = new int[end - start + 1];

        int index=0;
        while (i<=mid && j<=end) {
            if (nums[i] <= nums[j]) {
                total[index++] = nums[i++];
            }
            else {
                total[index++] = nums[j++];
            }
        }
        while (i<=mid) {
            total[index++] = nums[i++];
        }
        while (j<=end) {
            total[index++] = nums[j++];
        }
        index=0;
        for (int x=start; x<=end; x++) {
            nums[x] = total[index++];
        }
    }
    public static void main(String[] args) {
        int[] nums = {8, 7, 1, 2, 4, 5, 6, 3};
        mergeSort(nums);
        Arrays.stream(nums).forEach(System.out::println);
    }
}
