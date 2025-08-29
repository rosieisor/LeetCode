class Solution {

    List<List<Integer>> result;
    boolean[] visited;
    int[] selected;

    public List<List<Integer>> combinationSum3(int k, int n) {
        result = new ArrayList<>();
        selected = new int[k];
        visited = new boolean[10];

        backtracking(0, k, n, 1, 0);

        return result;
    }

    public void backtracking(int pick, int k, int n, int start, int sum) {
        if (pick == k) {
            if (sum == n) {
                List<Integer> list = new ArrayList<>();
                for(int num : selected) {
                    list.add(num);
                }

                result.add(list);
            }

            return;
        }

        for(int i=start; i<=9; i++) {
            if(!visited[i] && sum < n) {
                visited[i] = true;
                selected[pick] = i;
                backtracking(pick + 1, k, n, i + 1, sum + i);
                visited[i] = false;
            }
        }
    }
}