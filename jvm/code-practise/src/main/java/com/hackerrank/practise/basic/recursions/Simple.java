package com.hackerrank.practise.basic.recursions;

import java.util.ArrayList;
import java.util.List;

public class Simple {
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    /**
     * Sum of first n natural numbers
     * @param n number
     * @return sum of first n natural numbers
     */
    public static long sumFirstN(long n) {
        // Write your code here.
        if (n == 1) return 1;
        else return n + sumFirstN(n - 1);
    }

    /**
     * Factorial of a number
     * @param n number
     * @return factorial of a number
     */
    private static long factorial(long n) {
        if (n == 1) return 1;
        else return n * factorial(n - 1);
    }

    /**
     * Factorial numbers
     * return a list of factorial numbers less than n
     * @param n number
     * @return factorial numbers
     */
    public static List<Long> factorialNumbers(long n) {
        // Write Your Code Here
        List<Long> list = new ArrayList<>();
        if (n == 1) {
            list.add(1L);
        } else {
            int i = 1;
            while (true) {
                long fac = factorial(i++);
                if (fac > n) break;
                else list.add(fac);
            }
        }
        return list;
    }

    public  static boolean palindrome(String str) {
        if (str.length() == 1) return true;
        else if (str.length() == 2) return str.charAt(0) == str.charAt(1);
        else {
            int endIndex = str.length() - 1;
            if (str.charAt(0) == str.charAt(endIndex)) {
                return palindrome(str.substring(1, endIndex));
            } else return false;
        }
    }
}
