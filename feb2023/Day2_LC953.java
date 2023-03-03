package CODE2023.feb2023;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
https://leetcode.com/problems/verifying-an-alien-dictionary/
 */
public class Day2_LC953 {
    public static boolean isAlphabeticOrder(String[] words, String order) {
        //we will assign the order string in number format
        Map<Character, Integer> map = new HashMap<>();
        int weight=1;
        for (char c : order.toCharArray()) {
            map.put(c, weight);
            weight++;
        }
        for (int i=0; i<words.length-1; i++) {
            String first = words[i];
            String second = words[i+1];
            if (!compare(first, second, map)) {
                return false;
            }
        }
        return true;
    }
    private static boolean compare(String first, String second, Map<Character, Integer> map) {
        int i=0, j=0;
        while (i<first.length() && j<second.length()) {
            if (first.charAt(i) != second.charAt(j)) {
                if (map.get(first.charAt(i)) < map.get(second.charAt(j))) {
                    return true;
                }
                else return false;
            }
            i++;
            j++;
        }
        if (first.length() > second.length()) return false;
        else return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i=0; i<t; i++) {
            System.out.println("enter array length");
            int n = sc.nextInt();
            String[] words = new String[n];
            for (int j=0; j<n; j++) {
                words[j] = sc.next();
            }
            System.out.println("enter the order");
            String order = sc.next();
            System.out.println(isAlphabeticOrder(words, order));
        }

    }
}
