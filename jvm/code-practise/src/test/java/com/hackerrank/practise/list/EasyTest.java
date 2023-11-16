package com.hackerrank.practise.list;

import org.junit.jupiter.api.Test;

import static com.hackerrank.practise.list.Easy.mergeTwoLists;
import static org.junit.jupiter.api.Assertions.assertEquals;

class EasyTest {

    @Test
    void test_mergeTwoLists() {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);

        ListNode mergedList = mergeTwoLists(list1, list2);
        assertEquals(1, mergedList.val);
    }


    @Test
    void test_reverseList() {
        ListNode list = new ListNode(1);
        list.next = new ListNode(2);
        list.next.next = new ListNode(3);

        ListNode reversedList = Easy.reverseList(list);
        assertEquals(3, reversedList.val);
        assertEquals(2, reversedList.next.val);
    }


}