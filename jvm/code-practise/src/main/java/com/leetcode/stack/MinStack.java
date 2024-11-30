package com.leetcode.stack;

import java.util.*;

public class MinStack {
    Stack<Integer> st;
    Stack<Integer> stm;
    int min=Integer.MAX_VALUE;

    public MinStack() {
        st = new Stack<>();
        stm = new Stack<>();
    }

    public void push(int val) {
        st.push(val);
        min = Math.min(min, val);
        stm.push(min);
//        if (!stm.isEmpty()) {
//            List<Integer> s = new ArrayList<>();
//            while (!stm.isEmpty() && val >= stm.peek()) {
//                s.add(stm.pop());
//            }
//            stm.push(val);
//            int n=s.size();
//            for (int i=n-1;i>=0 ; i--)
//                stm.push(s.get(i));
//        } else
//            stm.push(val);
    }

    public void pop() {
        int val = st.pop();
        if (stm.peek() == val) stm.pop();
    }

    public int top() {
        return st.peek();
    }

    public int getMin() {
        return stm.peek();
    }
}
