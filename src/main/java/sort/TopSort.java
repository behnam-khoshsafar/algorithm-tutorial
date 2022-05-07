package sort;

import sort.impl.topsort.Project;

import java.util.Stack;

public interface TopSort {

    Stack<Project> findBuildOrder(String[] projects, String[][] dependencies);

}
