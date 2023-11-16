package com.hackerrank.practise.list;

import java.util.ArrayList;
import java.util.List;

public class Easy {

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        ListNode mergedList = new ListNode();
        ListNode head = mergedList;

        // check if both the nodes are not null
        while (true) {
            if (list1.val <= list2.val) {
                head.val = list1.val;
                list1 = list1.next;
            } else {
                head.val = list2.val;
                list2 = list2.next;
            }
            if (list1 == null || list2 == null) break;

            // move head by one
            head.next = new ListNode();
            head = head.next;
        }

        // one of the nodes is exhausted
        head.next = (list1 == null) ? list2 : list1;

        return mergedList;
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null) return null;
        // take start node
        ListNode curr = head, prev = null, next;
        // loop till the end of the list
        while (curr != null) {
            // save the next node and swap previous and current
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        // prev the new head
        return prev;
    }

}