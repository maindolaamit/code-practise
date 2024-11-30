package com.leetcode;

public class Utility {
    TreeNode loadTreeNodeFromArray(Integer[] arr) {
        TreeNode root = new TreeNode(arr[0]);
        for (int i = 0; i < arr.length; i++) {
            // i+1 is left node
            root.left = arr[i + 1] == null ? null : new TreeNode(arr[i + 1]);
            // i+2 is right node
            root.right = arr[i + 2] == null ? null : new TreeNode(arr[i + 2]);
            i += 2;
        }
        return root;
    }
}
