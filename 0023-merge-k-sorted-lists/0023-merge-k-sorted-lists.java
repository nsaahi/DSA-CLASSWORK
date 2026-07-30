class Solution {

    public ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<ListNode> pq =
                new PriorityQueue<>((a, b) -> a.val - b.val);

        // Put the first node of each non-empty list into the heap
        for (ListNode node : lists) {
            if (node != null)
                pq.offer(node);
        }

        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;

        while (!pq.isEmpty()) {

            ListNode node = pq.poll();

            tail.next = node;
            tail = tail.next;

            if (node.next != null)
                pq.offer(node.next);
        }

        return dummy.next;
    }
}