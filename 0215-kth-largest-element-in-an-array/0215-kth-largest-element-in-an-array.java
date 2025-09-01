class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int num : nums) {
            pq.add(num);
        }

        int index = 0;
        while (index < k - 1) {
            pq.poll();
            index++;
        }

        return pq.poll();
    }
}