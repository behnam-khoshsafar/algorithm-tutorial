package graph;

import graph.model.Graph;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class GraphUtilsTest {

    @Test
    public void isThereAnyRouteBetweenNodes() {
        Graph<String> directedGraph = new Graph<>();
        directedGraph.addNode("A", Arrays.asList("B", "C"));
        directedGraph.addNode("B", Arrays.asList("C", "D"));
        directedGraph.addNode("C", Arrays.asList("D"));
        directedGraph.addNode("D");

        Assertions.assertTrue(GraphUtils.isThereRoute(directedGraph, "A", "D"));
    }

    @Test
    public void isThereAnyRouteBetweenNodes2() {
        Graph<String> directedGraph = new Graph<>();
        directedGraph.addNode("A", Arrays.asList("B", "C"));
        directedGraph.addNode("B", Arrays.asList("C", "D"));
        directedGraph.addNode("C", Arrays.asList("D"));
        directedGraph.addNode("D");

        Assertions.assertFalse(GraphUtils.isThereRoute(directedGraph, "D", "A"));
    }

    @Test
    public void isThereAnyRouteBetweenNodes3() {
        Graph<String> directedGraph = new Graph<>();
        directedGraph.addNode("A", Arrays.asList("B", "C"));
        directedGraph.addNode("B", Arrays.asList("C", "D"));
        directedGraph.addNode("C", Arrays.asList("D"));
        directedGraph.addNode("D");

        Assertions.assertTrue(GraphUtils.isThereRoute(directedGraph, "B", "C"));
    }

    @Test
    public void isThereAnyRouteBetweenNodesWithInvalidNode() {
        Graph<String> directedGraph = new Graph<>();
        directedGraph.addNode("A", Arrays.asList("B", "C"));
        directedGraph.addNode("B", Arrays.asList("C", "D"));
        directedGraph.addNode("C", Arrays.asList("D"));
        directedGraph.addNode("D");

        Assertions.assertFalse(GraphUtils.isThereRoute(directedGraph, "H", "C"));
    }

}