// n : 정점의 개수
// k : 시작 정점 
class Node {
    int target;
    int time;

    public Node(int target, int time) {
        this.target= target;
        this.time = time;
    }
}

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Node>> nodes = new ArrayList<>();

        for(int i=0; i<=n; i++) {
            nodes.add(new ArrayList<>());
        }

        for(int i=0; i<times.length; i++) {
            nodes.get(times[i][0]).add(new Node(times[i][1], times[i][2]));
        }
        
        return dijkstra(times, n, k, nodes);
    }

    public int dijkstra(int[][] times, int n, int k, List<List<Node>> nodes) {
        boolean[] visited = new boolean[n+1];   // 방문 여부
        int[] dist = new int[n+1];

        Arrays.fill(dist, Integer.MAX_VALUE);
        
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> {
            return o1.time - o2.time;
        });

        pq.offer(new Node(k, 0));     // 시작 정점 추가
        dist[k] = 0;

        while(!pq.isEmpty()) {
            int nowNode= pq.poll().target;

            if (visited[nowNode]) {
                continue;
            }

            visited[nowNode] = true;

            for(Node node : nodes.get(nowNode)) {     // 현재 정점과 연관된 정점 pq에 삽입
                if (dist[node.target] > dist[nowNode] + node.time) {
                    dist[node.target] = dist[nowNode] + node.time;

                    pq.offer(new Node(node.target, dist[node.target]));
                }
            }
        }

        int answer = 0;
        for(int i=1; i<=n; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                return -1;
            } 

            answer = Math.max(answer, dist[i]);
        }

        return answer;
    }
}