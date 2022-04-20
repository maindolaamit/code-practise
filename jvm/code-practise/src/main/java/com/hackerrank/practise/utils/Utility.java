package com.hackerrank.practise.utils;

import java.util.List;

public class Utility {
    public static int getLcm(int a, int b) {
        if (Math.abs(a - b) == 1) return a * b;
        int step = Math.max(a, b);
        int lcm = step;
        while (!(lcm % a == 0 && lcm % b == 0)) {
            lcm += step;
        }
        return lcm;
    }

    public static int getHcf(int a, int b) {
        int hcf = 1, minValue = Math.min(a, b);
        if (Math.max(a, b) % minValue == 0) return minValue;
        // loop and find the HCF
        for (int i = 2; i <= minValue; i++) {
            if (a % i == 0 && b % i == 0) hcf = i;
            if (i > minValue / 2) i = minValue;
        }
        return hcf;
    }

    public static int getLcm(List<Integer> numbers) {
        return numbers.stream().reduce(numbers.get(0), Utility::getLcm);
    }

    public static int getHcf(List<Integer> numbers) {
        return numbers.stream().reduce(numbers.get(0), Utility::getHcf);
    }

}
