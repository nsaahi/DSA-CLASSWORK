import java.util.*;

class KthLargest {

    PriorityQueue<Integer> q;
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        q = new PriorityQueue<>();

        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {

        if (q.size() < k) {
            q.add(val);
        }
        else if (val > q.peek()) {
            q.poll();
            q.add(val);
        }

        return q.peek();
    }
}