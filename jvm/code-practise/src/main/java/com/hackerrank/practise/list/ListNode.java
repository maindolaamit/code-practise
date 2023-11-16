package com.hackerrank.practise.list;

public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    public static void printNode(ListNode head) {
        if (head == null) {
            System.out.println("Empty List");
        } else {
            ListNode tmp = head;
            while (tmp.next != null) {
                System.out.print(tmp.val + "->");
                tmp = tmp.next;
            }
            System.out.println(tmp.val);
        }
    }

}
