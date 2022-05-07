package sort.impl.topsort;

import java.util.List;
import java.util.Stack;

public class TopSortImpl implements sort.TopSort {

    @Override
    public Stack<Project> findBuildOrder(String[] projects, String[][] dependencies) {
        Graph graph = buildGraph(projects, dependencies);
        return orderProjects(graph.getNodes());
    }

    private Stack<Project> orderProjects(List<Project> projects) {
        Stack<Project> stack = new Stack<>();
        for (Project project : projects) {
            if (project.getState().equals(Project.State.BLANK))
                if (!doDFS(project, stack))
                    return null;
        }
        return stack;
    }

    private boolean doDFS(Project project, Stack<Project> stack) {
        if (project.getState().equals(Project.State.PARTIAL))
            return false; //CYCLE

        if (project.getState().equals(Project.State.BLANK)) {
            project.setState(Project.State.PARTIAL);
            List<Project> children = project.getChildren();
            for (Project child : children) {
                if (!doDFS(child, stack))
                    return false;
            }
            project.setState(Project.State.COMPLETE);
            stack.push(project);
        }
        return true;
    }

    private Graph buildGraph(String[] projects, String[][] dependencies) {
        Graph graph = new Graph();
        for (String project : projects) {
            graph.creatNode(project);
        }

        for (String[] dependency : dependencies) {
            String start = dependency[0];
            String end = dependency[1];
            graph.addEdge(start, end);
        }

        return graph;
    }

}
