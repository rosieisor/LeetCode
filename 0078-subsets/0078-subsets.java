class Solution {
    List<List<Integer>> result;
    boolean[] visited;

    public List<List<Integer>> subsets(int[] nums) {
        visited = new boolean[nums.length];
        result = new ArrayList<>();

        backtracking(0, nums);

        return result;    
    }

    public void backtracking(int pick, int[] nums) {
        if (pick == nums.length) {
            List<Integer> list = new ArrayList<>();

            for(int i=0; i<nums.length; i++) {
                if (!visited[i]) {
                    list.add(nums[i]);
                }
            }

            result.add(list);

            return;
        }

        visited[pick] = true;
        backtracking(pick + 1, nums);

        visited[pick] = false;
        backtracking(pick + 1, nums);
    }

}