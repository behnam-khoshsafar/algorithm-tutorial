package sort.impl.topsort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {

    private ArrayList<Project> nodes = new ArrayList<>();
    private Map<String, Project> map = new HashMap<>();

    public Project getOrCreateNode(String name) {
        if (!map.containsKey(name)) {
            Project project = new Project(name);
            nodes.add(project);
            map.put(name, project);
        }
        return map.get(name);
    }


    public void addEdge(String startName, String endName) {
        Project start = getOrCreateNode(startName);
        Project end = getOrCreateNode(endName);
        start.addNeighbor(end);
    }

    public List<Project> getNodes() {
        return nodes;
    }

    public void creatNode(String name) {
        Project project = new Project(name);
        nodes.add(project);
        map.put(name, project);
    }
}