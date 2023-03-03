package CODE2023.march2023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/*
https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/
 */
public class Day3_LC28 {
    static int indexOfFirstOccurrence(String haystack, String needle) {
        if (haystack == null || needle == null || haystack.isEmpty() || needle.isEmpty()) {
            return -1;
        }
        if (haystack.contains(needle)) {
            return haystack.indexOf(needle)+1;
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = 0;
        while(count++ < 3) {
            String haystack = br.readLine();
            String needle = br.readLine();
            System.out.println(indexOfFirstOccurrence(haystack, needle));
        }
    }
}
