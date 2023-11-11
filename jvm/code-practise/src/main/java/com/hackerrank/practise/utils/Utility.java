package com.hackerrank.practise.utils;

import com.hackerrank.practise.basic.Mathematics;

import java.util.List;

public class Utility {

    public static int getLcm(List<Integer> numbers) {
        return numbers.stream().reduce(numbers.get(0), Mathematics::getLcm);
    }

    public static int getHcf(List<Integer> numbers) {
        return numbers.stream().reduce(numbers.get(0), Mathematics::getHcf);
    }

}
