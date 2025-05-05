package searchAlgorithm;

import java.util.*;

public class BreadthFirstSearch {
    private int startNode;
    private int targetNode;
    private boolean[] visited;
    private List<List<Integer>> adj;

    public BreadthFirstSearch(int startNode, int targetNode) {
        this.startNode = startNode;
        this.targetNode = targetNode;
        this.visited = new boolean[]{false, false, false, false, false, false};
        int numberOfNode = 6;
        List<List<Integer>> adj = new ArrayList<>(numberOfNode);

        for (int i = 0; i < numberOfNode; i++) {
            adj.add(new ArrayList<>());
        }

        adj.get(0).addAll(Arrays.asList(1, 2));
        adj.get(1).add(3);
        adj.get(2).add(4);
        adj.get(3).add(5);
        adj.get(4).add(5);

        this.adj = adj;
    }

    public boolean bfsPathExists() {
        Queue<Integer> queue = new LinkedList<>();
        visited[startNode] = true;

        queue.offer(startNode);

        while (!queue.isEmpty()) {
            int currentNode = queue.poll();
            System.out.println(currentNode + " ");

            for (int neighbor : adj.get(currentNode)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                }
            }
        }
        return visited[targetNode];
    }

    public void printResult() {
        System.out.println("Path exists from " + startNode + " to " + targetNode + ": " + bfsPathExists()); // Expected: true
    }

}
