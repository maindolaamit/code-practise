package com.hackerrank.practise.basic;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class StarPatterns {
    public static void nStarTriangle(int n) {
        // Write your code here

        StringBuilder spaces = new StringBuilder("");
        for (int i = 0; i < n - 1; i++) {
            spaces.append("-");
        }

        StringBuilder stars = new StringBuilder("*");
        String value = "";
        // System.out.println(value);
        for (int i = 0; i < n; i++) {
            if (i != 0) {
                spaces = new StringBuilder(spaces.substring(1));
                stars.append("**");
            }
            value = spaces + stars.toString() + spaces;
            System.out.println(value);
        }
    }

    public static void nStarDiamond(int n) {
        // Write your code here
        StringBuilder spaces = new StringBuilder();
        for (int i = 0; i < n - 1; i++) {
            spaces.append("-");
        }

        StringBuilder stars = new StringBuilder("*");

        for (int i = 0; i < n; i++) {
            if (i != 0) {
                spaces = new StringBuilder(spaces.substring(1));
                stars.append("**");
            }
            String value = spaces + stars.toString() + spaces;
            System.out.println(value);
        }

        spaces = new StringBuilder();
        for (int i = n; i > 0; i--) {
            if (i != n) {
                spaces.append("-");
                stars = new StringBuilder(stars.substring(2));
            }
            String value = spaces + stars.toString() + spaces;
            System.out.println(value);
        }
    }


    public static void symmetry(int n) {
        // Write your code here
        String space="--", star="*-";
        StringBuilder spaces = new StringBuilder();
        StringBuilder stars = new StringBuilder();
        int half = (int) Math.floor(n / 2.0);

        for (int i = 0; i < n; i++) {
            stars.append(star);
        }

        for (int i = 0; i < n; i++) {
            if (i != 0) {
                stars = new StringBuilder(stars.substring(2));
                spaces.append(space);
            }
            String value = stars.toString() + spaces + spaces + stars;
            System.out.println(value);
        }

        for (int i = n; i > 0; i--) {
            if (i != n) {
                stars.append(star);
                spaces = new StringBuilder(spaces.substring(2));
            }
            String value = stars.toString() + spaces + spaces + stars;
            System.out.println(value);
        }
    }
}
