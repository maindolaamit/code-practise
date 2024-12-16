package com.leetcode;

import com.leetcode.stack.MinStack;
import lombok.val;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    void moveZeros() {
        Solution solution = new Solution();
        int[] nums = {0, 1, 0, 3, 12};
        nums = new int[]{1, 0};
        System.out.println("Before moving zeros" + Arrays.toString(nums));

        solution.moveZeroes(nums);

        System.out.println("After moving zeros" + Arrays.toString(nums));
    }

    @Test
    void groupAnagrams() {
        Solution solution = new Solution();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        strs = new String[]{"ac", "c"};
        System.out.println("Before grouping anagrams" + Arrays.toString(strs));
        List<List<String>> result = solution.groupAnagrams(strs);
        System.out.println("After grouping anagrams" + result);

//        System.out.println("Before grouping anagrams" + Arrays.toString(strs));
//        result = solution.groupAnagrams(strs);
//        System.out.println("After grouping anagrams" + result);
    }


    @Test
    void minStackTest() {
        MinStack minStack = new MinStack();
        minStack.push(2);
        minStack.push(0);
        minStack.push(3);
        minStack.push(0);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }

    @Test
    void diameterOfBinaryTree() {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        System.out.println("Diameter of binary tree: " + solution.diameterOfBinaryTree(root));
    }

    @Test
    void search() {
        Solution solution = new Solution();
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        val search = solution.search(nums, 0);
        assertEquals(0, search);
    }

}