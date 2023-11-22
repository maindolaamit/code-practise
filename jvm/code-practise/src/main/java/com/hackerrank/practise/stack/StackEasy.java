package com.hackerrank.practise.stack;

import java.util.List;
import java.util.Stack;

public class StackEasy {

    /*
     * Complete the 'equalStacks' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY h1
     *  2. INTEGER_ARRAY h2
     *  3. INTEGER_ARRAY h3
     */

    public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
        // Write your code here
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        Stack<Integer> s3 = new Stack<>();

        int cumSumm = 0;
        for(Integer i: h1){
            cumSumm = cumSumm + i;
            s1.push(cumSumm);
        }
        cumSumm = 0;
        for(Integer i: h2){
            cumSumm = cumSumm + i;
            s2.push(cumSumm);
        }
        cumSumm = 0;
        for(Integer i: h3){
            cumSumm = cumSumm + i;
            s3.push(cumSumm);
        }

        while(!s1.empty() && !s2.empty() && !s3.empty()){
            int h1Height = s1.peek(), h2Height = s2.peek(), h3Height = s3.peek();
            // if all stacks have same height
            if(h1Height == h2Height && h2Height == h3Height) break;
            // stack s1 height is more
            if(h1Height > h2Height && h1Height > h3Height) s1.pop();
            // stack s2 height is more
            if(h2Height > h1Height && h2Height > h3Height) s2.pop();
            // stack s3 height is more
            if(h3Height > h1Height && h3Height > h2Height) s3.pop();
        }
        return s1.pop();
    }
}
