package ch_07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Graph {
    private final List<Vertex> graph;

    public Graph() {
        graph = new ArrayList<>();
    }

    public int size() {
        return graph.size();
    }

    public void addVertex(Vertex vertex) {
        graph.add(vertex);
        vertex.setIndex(graph.size() - 1);
    }

    public void removeVertex(Vertex vertex) {
        graph.remove(vertex);
        for (int i = 0; i < graph.size(); ++i) {
            graph.get(i).setIndex(i);
        }
    }

    public void showAllVertex() {
        int x = 0;
        StringBuilder stringBuilder = new StringBuilder();
        for (var el: graph) {
            stringBuilder.append(String.format("%3d", ++x)).append(". ").append(el.getName()).append("\n");
        }
        System.out.print(stringBuilder);
    }

    public void showVertex(final int x) {
        if (x < 1 || x > graph.size()) return;
        System.out.println(graph.get(x - 1));
    }

    //
    public String findBestWay(final int start, final int end) {
        int from = start - 1;
        int to = end - 1;

        int[] dist = new int[graph.size()];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[from] = 0;

        int[] predecessors = new int[graph.size()];
        Arrays.fill(predecessors, -1);

        boolean[] visited = new boolean[graph.size()];
        Arrays.fill(visited, false);

        int i = from;
        while (i != -1) {
            visited[i] = true;
            Map<Vertex, Integer> neighbors = graph.get(i).getNeighbors();
            for (var el: neighbors.entrySet()) {
                int j = el.getKey().getIndex();
                int distance = dist[i] + el.getValue();
                if (!visited[j] && distance < dist[j]) {
                    dist[j] = distance;
                    predecessors[j] = i;
                }
            }
            i = findMinIndex(dist, visited);
        }

        return formResponce(from, to, dist, predecessors);
    }

    // Method finds min index from unvisited vertices
    private int findMinIndex(final int[] dist, final boolean[] visited) {
        int min = Integer.MAX_VALUE;
        int index = -1;
        for (int i = 0; i < dist.length; ++i) {
            if (!visited[i] && dist[i] < min) {
                min = dist[i];
                index = i;
            }
        }
        return index;
    }

    // Form response using all formed resources in the previous method
    private String formResponce(final int from, final int to, final int[] dist, final int[] predecessors) {
        int p = predecessors[to];
        Stack<String> reversePath = new Stack<>();
        while (p != from) {
            reversePath.add(graph.get(p).getName());
            p = predecessors[p];
        }
        StringBuilder stringBuilder = new StringBuilder("Відстань: " + dist[to] + " км.\n");
        stringBuilder.append("Маршрут: ").append(graph.get(from).getName());
        while (!reversePath.isEmpty()) {
            stringBuilder.append(" => ").append(reversePath.pop());
        }
        stringBuilder.append(" => ").append(graph.get(to).getName()).append("\n");
        return stringBuilder.toString();
    }
}
