package searchAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DepthFirstSearch {
    private int currentNode;
    private List<List<Integer>> adj;
    private boolean[] visited;

    public DepthFirstSearch(int currentNode) {
        this.currentNode = currentNode;
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

    public void depthFirstSearch(int currentNode, List<List<Integer>> adj, boolean[] visited) {
        visited[currentNode] = true;
        System.out.println(currentNode + " ");

        for (int node : adj.get(currentNode)) {
            if (!visited[node]) {
                depthFirstSearch(node, adj, visited);
            }
        }
    }

    public void printOutput() {
        depthFirstSearch(currentNode, adj, visited);
        System.out.println(Arrays.toString(visited));
    }

}
