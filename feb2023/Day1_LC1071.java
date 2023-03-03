package CODE2023.feb2023;
/*
https://leetcode.com/problems/greatest-common-divisor-of-strings/description/
*/

import java.util.Scanner;

public class Day1_LC1071 {
    public static String getGreatestDivisorString (String s1, String s2) {
        if (!(s1+s2).equals(s2+s1)) {
            return "";
        }
        else if (s1.equals(s2)) {
            return s1;
        }
        else if (s1.length() > s2.length()) {
            return getGreatestDivisorString(s1.substring(s2.length()), s2);
        }
        else {
            return getGreatestDivisorString(s2.substring(s1.length()), s1);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cap = sc.nextInt();
        String s1, s2;
        for (int i = 0; i < cap; i++) {
            s1 = sc.next();
            s2 = sc.next();
            System.out.println(getGreatestDivisorString(s1, s2));
        }
    }
}
