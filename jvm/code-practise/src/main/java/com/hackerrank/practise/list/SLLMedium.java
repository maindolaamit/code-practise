package com.hackerrank.practise.list;

public class SLLMedium {
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
        // tried using List but space complexity will increase
//        List<Integer> values = new ArrayList<>();
//         insert the elements into an array
//        while (head != null) {
//            values.add(head.val);
//            head = head.next;
//        }
//        List<Integer> newList = new ArrayList<>();
//        for (int i = 0; i < Math.ceil(values.size() / 2.0); i++) {
//            newList.add(values.get(i));
//            if (values.size() - 1 - i != i) newList.add(values.get(values.size() - 1 - i));
//        }
        // to solve with O(1) space complexity, use fast and slow pointers
        ListNode slow = head, fast = head;
        // start with first node
        while (fast != null) {
            slow = slow.next; // increase slow by one
            fast = fast.next.next; // increase fast by two
        }

        // once we reach the end we know the middle node
        // reverse the list from middle node
        ListNode curr = slow.next, prev = null, next = null, newNodeHead = slow.next;
        slow.next = null; // cut the slow node
        while (curr != null) {
            next = curr.next;
            prev = curr;
            curr.next = prev;
            curr = next;
        }

        // now we have two nodes, one is reversed
        slow = head;
        fast = newNodeHead;
        while (fast != null) {
            newNodeHead = slow;
            newNodeHead.next = fast;
            // increase slow and fast by one
            slow = slow.next;
            fast = fast.next;
        }
        // add the remaining portion of the node
        newNodeHead.next = slow;

    }

    public static boolean isPalindrome(ListNode head) {
        if(head.next == null) return true;
        ListNode slow = head, fast = head, left = null;
        // reach the middle of the node
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            ListNode tmp = slow.next;
            slow.next = left;
            left = slow;
            slow = tmp;
        }

        // reverse the LL
        slow = slow.next;
        while(left != null && slow != null ){
            if(left.val != slow.val) return false;
            left = left.next;
            slow = slow.next;
        }

        return true;
    }
}
