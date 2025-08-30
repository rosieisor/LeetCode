class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i< nums.length; i++) {
            if (map.get(nums[i]) == null) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
            return map.get(o2) - map.get(o1);
        });

        for(int key : map.keySet()) {
            pq.add(key);
        }

        int[] result = new int[k];

        for(int i=0; i<k; i++) {
            result[i] = pq.poll();
        }

        return result;
    }
}