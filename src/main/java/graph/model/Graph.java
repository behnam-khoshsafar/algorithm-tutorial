package graph.model;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph<E> {
    private final Map<E, List<E>> nodes;

    public Graph() {
        this.nodes = new HashMap<>();
    }

    public void addNode(E vector) {
        addNode(vector, null);
    }

    public void addNode(E vector, List<E> edges) {
        nodes.put(vector, edges == null ? Collections.emptyList() : edges);
    }

    public List<E> getEdges(E node) {
        return nodes.get(node);
    }

    public boolean contains(E node) {
        return nodes.containsKey(node);
    }
}
