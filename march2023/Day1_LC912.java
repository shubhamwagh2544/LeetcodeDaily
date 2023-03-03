package CODE2023.march2023;

import java.util.Arrays;

public class Day1_LC912 {

    public static void quickSort(int[] nums) {
        quickSort(nums, 0, nums.length-1);
    }
    private static void quickSort(int[] array, int start, int end) {
        if (start >= end) {
            return;
        }
        int pivot = partition(array, start, end);
        quickSort(array, start, pivot-1);
        quickSort(array, pivot+1, end);
    }
    private static int partition(int[] array, int start, int end) {
        int pivot = array[end];
        int count = start;
        for (int i=start; i<=end; i++) {
            if (array[i] < pivot) {
                swap(array, count, i);
                count++;
            }
        }
        swap(array, count, end);
        return count;
    }
    private static void swap(int[] array, int first, int second) {
        int temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }

    public static void main(String[] args) {
        int[] array = {8, 7, 1, 2, 4, 5, 6, 3};
        quickSort(array);
        Arrays.stream(array).forEach(System.out::println);
    }
}
