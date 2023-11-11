package com.hackerrank.practise.basic;

import java.util.Arrays;

class Arithmetic {
    public String sum(String[] arr) {
        return Arrays.stream(arr).reduce("", (i, s) -> i + s);
    }

    public int sum(Integer[] arr) {
        return Arrays.stream(arr).reduce(0, Integer::sum);
    }

}
