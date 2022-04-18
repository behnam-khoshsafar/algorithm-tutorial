package graph.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GraphTest {

    @Test
    public void addNodeWithoutEdgeToGraph() {
        Graph<String> directedGraph = new Graph<>();
        String startNode = "Start";
        directedGraph.addNode(startNode);
        assertEquals(List.of(), directedGraph.getEdges(startNode));
    }

    @Test
    public void addNodeWithEdgeToGraph() {
        Graph<String> directedGraph = new Graph<>();
        String startNode = "Start";
        List<String> edges = Arrays.asList("A", "B");
        directedGraph.addNode(startNode, edges);
        assertEquals(edges, directedGraph.getEdges(startNode));
    }
}