class Solution {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prevGroup = dummy;

        while (true) {
            ListNode kth = prevGroup;
            for (int i = 0; i < k && kth != null; i++) {
                kth = kth.next;
            }
            if (kth == null) break;

            ListNode groupStart = prevGroup.next;
            ListNode nextGroup = kth.next;

            // Reverse current k-group
            ListNode prev = nextGroup;
            ListNode curr = groupStart;
            while (curr != nextGroup) {
                ListNode temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }

            prevGroup.next = kth;
            prevGroup = groupStart;
        }

        return dummy.next;
    }
}
