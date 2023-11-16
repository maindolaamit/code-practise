package com.hackerrank.practise.list;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MediumTest {
    @Test
    void test_removeNthNode() {
        ListNode list = new ListNode(1);
        ListNode.printNode(list);
        ListNode newList = Medium.removeNthFromEnd(list, 1);
        ListNode.printNode(newList);

        list = new ListNode(1);
        list.next = new ListNode(2);
        ListNode.printNode(list);
        newList = Medium.removeNthFromEnd(list, 1);
        ListNode.printNode(newList);

        list = new ListNode(1);
        list.next = new ListNode(2);
        ListNode.printNode(list);
        newList = Medium.removeNthFromEnd(list, 2);
        ListNode.printNode(newList);

        list = new ListNode(1);
        list.next = new ListNode(2);
        list.next.next = new ListNode(3);
        list.next.next.next = new ListNode(4);
        list.next.next.next.next = new ListNode(5);

        ListNode.printNode(list);
        newList = Medium.removeNthFromEnd(list, 2);
        ListNode.printNode(newList);
    }

    @Test
    public void test_reorderlist() {
        ListNode list = new ListNode(1);
        list.next = new ListNode(2);
        list.next.next = new ListNode(3);
        list.next.next.next = new ListNode(4);
//        list.next.next.next.next = new ListNode(5);

        ListNode.printNode(list);
        Medium.reorderList(list);
    }

}