class Solution {
    List<List<Integer>> result;
    int[] selected;
    boolean[] visited;

    public List<List<Integer>> combine(int n, int k) {
        result = new ArrayList<>();
        selected = new int[k];
        visited = new boolean[n];

        int[] nums = new int[n];

        for(int i=0; i<n; i++) {
            nums[i] = i + 1;
        }

        dfs(0, k, 0, nums);

        return result;
    }

    public void dfs(int pick, int k, int start, int[] nums) {
        if (pick == k) {
            List<Integer> combination = new ArrayList<>();

            for(int num : selected) {
                combination.add(nums[num]);
            }

            result.add(combination);

            return;
        }

        for(int i=start; i<nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                selected[pick] = i;
                dfs(pick + 1, k, i + 1, nums);
                visited[i] = false;
            }
        }
    };
}