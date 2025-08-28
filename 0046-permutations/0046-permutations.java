// 순열 (순서 고려)
class Solution {
    List<List<Integer>> result;
    boolean[] visited;
    int[] selected;

    public List<List<Integer>> permute(int[] nums) {
        result = new ArrayList<>();
        
        visited = new boolean[nums.length];
        selected = new int[nums.length];

        dfs(0, nums);

        return result;
    }

    public void dfs(int pick, int[] nums) {
        if (pick == nums.length) {
            List<Integer> list = new ArrayList<>();

            for(int num : selected) {
                list.add(nums[num]);
            }
            
            result.add(list);

            return;
        }

        for(int i=0; i<nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                selected[pick] = i;
                dfs(pick + 1, nums);
                visited[i] = false;
            }
        }
    }
}