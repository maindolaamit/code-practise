package com.leetcode;

import java.util.*;

class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int l = 0, r = 0;
        // loop and check the non zero elements
        int[] nz = new int[n];
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                nz[l++] = i;
            }
        }
//        l=0;
        //
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                if (r >= l || nz[r] < i) return;
                // swap l and i
                int ri = nz[r++];
                nums[i] = nums[ri] + nums[i] - (nums[ri] = nums[i]);
            }
        }
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        int n = strs.length;
        Map<String, List<String>> m = new HashMap<>();
        // put all strings based on code
        for (String s : strs) {
            String code = getCode(s);
            m.computeIfAbsent(code, k -> new ArrayList<>()).add(s);
        }
        // loop for Map
        return new ArrayList<>(m.values());
    }

    private String getCode(String s) {
        char[] charArray = s.toCharArray();
        Arrays.sort(charArray);
        return new String(charArray);
    }

    public int maxFrequencyElements(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> m = new HashMap<>();
        int maxF = 0;
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            m.put(num, m.getOrDefault(num, 0) + 1);
            maxF = Math.max(maxF, m.get(num));
        }
        // loop for max F
        int count = 0;
        for (Map.Entry<Integer, Integer> e : m.entrySet()) {
            if (e.getValue() == maxF) count += maxF;
        }
        return count;
    }

    private int maxH(TreeNode node) {
        if (node == null) return 0;
        int l = maxH(node.left);
        int r = maxH(node.right);
        System.out.println("l-" + l + ", r-" + r);
        return 1 + Math.max(l, r);
    }

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        int l = maxH(root.left);
        int r = maxH(root.left);
        return l + r;
    }

    public int search(int[] nums, int target) {
        int n = nums.length;
        int s = 0, e = n - 1;
        while (s <= e) {
            int m = (e + s) / 2;
            int mv = nums[m], sv = nums[s], ev = nums[e];
            // mid is the target
            if (mv == target) return m;
            if (sv == target) return s;
            if (ev == target) return e;
            // left portion sorted
            if (sv < mv) {
                // and target doesn't exist
                if (target > sv && target < mv) e = m - 1;
                else s = m + 1;
            } else if(mv < ev) {
                // right portion sorted and target exists
                if (ev > mv && target >= mv) s = m + 1;
                else e = m - 1;
            } else{
                // left and right are sorted
                if (target > mv) s = m + 1;
                else e = m - 1;
            }
        }
        return -1;
    }


}
