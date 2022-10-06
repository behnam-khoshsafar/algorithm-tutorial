package leetcode.course_schedule;

import java.util.*;

public class CourseSchedule {

    public static void main(String[] args) {
        System.out.println(canTakeAllCourse(5, List.of(List.of(0, 1), List.of(0, 2), List.of(1, 3), List.of(1, 4), List.of(3, 4))));
        System.out.println(canTakeAllCourse(2, List.of(List.of(0, 1), List.of(1, 0))));
        System.out.println(canTakeAllCourse(3, List.of(List.of(0, 1), List.of(1, 2), List.of(2, 0))));
    }

    public static boolean canTakeAllCourse(int numCourse, List<List<Integer>> preReqs) {
        Map<Integer, List<Integer>> adjacencyMap = new HashMap<>();
        for (List<Integer> preReq : preReqs) {
            List<Integer> adj;
            if (adjacencyMap.containsKey(preReq.get(0))) {
                adj = adjacencyMap.get(preReq.get(0));
            } else {
                adj = new ArrayList<>();
            }
            adj.add(preReq.get(1));
            adjacencyMap.put(preReq.get(0), adj);
        }
        for (int i = 0; i < numCourse; i++) {
            if (!adjacencyMap.containsKey(i)) {
                List<Integer> adj = new ArrayList<>();
                adjacencyMap.put(i, adj);
            }
        }

        Set<Integer> visited = new HashSet<>();
//        when our graph is not fully connected you need to check all vertexes
        for (int i = 0; i < numCourse; i++) {
            if (!canTakeAllCourseDFS(adjacencyMap, visited, i)) return false;
        }
        return true;
    }

    private static boolean canTakeAllCourseDFS(Map<Integer, List<Integer>> adjacencyMap, Set<Integer> visited, Integer vertex) {
        if (visited.contains(vertex))
            return false;
        if (adjacencyMap.get(vertex).size() == 0)
            return true;
        
        visited.add(vertex);
        for (Integer item : adjacencyMap.get(vertex)) {
            if (!canTakeAllCourseDFS(adjacencyMap, visited, item))
                return false;
        }
        visited.remove(vertex);
        adjacencyMap.put(vertex, new ArrayList<>()); //        when our graph is not fully connected, we are removing the adj to not checking it again
        return true;
    }
}
