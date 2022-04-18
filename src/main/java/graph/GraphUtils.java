package graph;

import graph.model.Graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class GraphUtils {

    public static <E> boolean isThereRoute(Graph<E> directedGraph, E startNode, E endNode) {
        if (!directedGraph.contains(startNode) || !directedGraph.contains(endNode))
            return false;
        if (startNode.equals(endNode))
            return true;
        Queue<E> queue = new ArrayDeque<>();
        queue.add(startNode);
        List<E> visitedItem = new ArrayList<>();
        while (!queue.isEmpty()) {
            E item = queue.poll();
            if (item != null) {
                List<E> edges = directedGraph.getEdges(item);
                for (E edge : edges) {
                    if (!visitedItem.contains(item)) {
                        if (edge.equals(endNode))
                            return true;
                        else {
                            queue.add(edge);
                            visitedItem.add(edge);
                        }

                    }
                }
            }
        }
        return false;
    }
