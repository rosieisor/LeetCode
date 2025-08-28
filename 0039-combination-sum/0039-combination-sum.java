class Solution {
    List<List<Integer>> result;
    int[] selected;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();

        selected = new int[30];

        dfs(0, 0, 0, candidates, target);

        return result;
    }

    public void dfs(int pick, int sum, int start, int[] candidates, int target) {
        if (sum == target) {
            List<Integer> list = new ArrayList<>();

            for(int i=0; i<pick; i++) {
                list.add(selected[i]);
            }

            result.add(list);

            return;
        } else if (sum > target) {
            return;
        }

        for(int i=start; i<candidates.length; i++) {
            selected[pick] = candidates[i];
            dfs(pick + 1, sum + selected[pick], i, candidates, target);
        }
    }
}