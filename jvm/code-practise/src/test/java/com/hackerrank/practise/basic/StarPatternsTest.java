package com.hackerrank.practise.basic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StarPatternsTest {

    @Test
    void get_n_star_triangle() {
//        Utility.nStarTriangle(1);
//        Utility.nStarTriangle(3);
        StarPatterns.nStarTriangle(6);
    }
    @Test
    void nStarDiamond() {
        StarPatterns.nStarDiamond(6);
    }

    @Test
    void symmetry() {
//        StarPatterns.symmetry(2);
//        StarPatterns.symmetry(7);
        StarPatterns.symmetry(3);
//        StarPatterns.symmetry(1);
    }
}