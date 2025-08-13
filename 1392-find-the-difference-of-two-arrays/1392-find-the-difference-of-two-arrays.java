class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Map<Integer, int[]> map = new HashMap<>();

        List<List<Integer>> answer = new ArrayList<>();
        answer.add(new ArrayList<>());
        answer.add(new ArrayList<>());

        for(int num : nums1) {
            if (map.get(num) == null) {
                map.put(num, new int[]{1, 0});
            }
        }

        for(int num : nums2) {
            if (map.get(num) != null) {
                int[] arr = map.get(num);
                arr[1] = 1;
            } else {
                map.put(num, new int[]{0, 1});
            }
        }

        for(int i=0; i<nums1.length; i++) {
            int[] arr = map.get(nums1[i]);
            if (arr[0] - arr[1] > 0 && !answer.get(0).contains(nums1[i])) {
                answer.get(0).add(nums1[i]);
            }
        }

        for(int i=0; i<nums2.length; i++) {
            int[] arr = map.get(nums2[i]);
            if (arr[0] - arr[1] < 0 && !answer.get(1).contains(nums2[i])) {
                answer.get(1).add(nums2[i]);
            }
        }

        return answer;
    }
}