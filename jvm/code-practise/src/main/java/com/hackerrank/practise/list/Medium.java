package com.hackerrank.practise.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Medium {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null && n == 1) return null;
        ListNode start = head, nth = null;
        int count = 0;
        // go to the end of node
        while (start.next != null) {
            // keep on increasing the count to track the nth node k-n from the end
            count++;
            // once count is == n, reset the nth node to head and keep on increasing
            if (count >= n) {
                if (nth == null) nth = head;
                else nth = nth.next;
            }
            // increase the start node
            start = start.next;
        }
        // we have reached the end of the list
        // if nth is null, it means we have to remove the head n==sz
        if (nth == null) return head.next;
        // remove the nth node
        nth.next = nth.next.next;
        // return head
        return head;
    }

    public static void reorderList(ListNode head) {
        if (head.next == null) System.out.println(head.val);
        List<Integer> values = new ArrayList<>();
        // insert the elements into an array
        while (head != null) {
            values.add(head.val);
            head = head.next;
        }

//        List<Integer> newList = new ArrayList<>();
//        for (int i = 0; i < Math.ceil(values.size() / 2.0); i++) {
//            newList.add(values.get(i));
//            if (values.size() - 1 - i != i) newList.add(values.get(values.size() - 1 - i));
//        }
//
//        System.out.println(Arrays.toString(newList.toArray()));
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < Math.ceil(values.size() / 2.0); i++) {
            sb.append(values.get(i));
            sb.append(",");
            if (values.size() - 1 - i != i) sb.append(values.get(values.size() - 1 - i));
            sb.append(",");
        }
        // remove last comma
        sb.deleteCharAt(sb.length() - 1);
        sb.append("]");
        System.out.println(sb.toString());
    }
}
