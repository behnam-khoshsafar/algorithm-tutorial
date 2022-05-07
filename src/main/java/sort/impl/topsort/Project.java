package sort.impl.topsort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Project {
    private String name;
    private State state;
    private List<Project> children = new ArrayList<>();
    private Map<String, Project> map = new HashMap<>();

    public Project(String name) {
        this.name = name;
        this.state = State.BLANK;
    }

    public void addNeighbor(Project node) {
        if (!map.containsKey(node.name)) {
            children.add(node);
            map.put(name, node);
        }
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public List<Project> getChildren() {
        return children;
    }

    public String getName() {
        return name;
    }

    public enum State {COMPLETE, PARTIAL, BLANK}

}