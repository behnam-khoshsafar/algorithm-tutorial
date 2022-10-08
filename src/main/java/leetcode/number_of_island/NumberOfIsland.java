package leetcode.number_of_island;

import kotlin.Pair;

import java.util.*;

public class NumberOfIsland {
    public static void main(String[] args) {
        int[][] country = new int[][]{
                {1, 1, 0, 0, 0},
                {0, 1, 0, 0, 1},
                {1, 0, 0, 1, 1},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1}};
        System.out.println("Number of islands is: " + getNumberOfIslandBFS(country));
        System.out.println("Number of islands is: " + getNumberOfIslandDFS(country));
    }

    public static int getNumberOfIslandBFS(int[][] matrix) {
        int island = 0;
        int row = matrix.length;
        int column = matrix[0].length;

        Set<Pair<Integer, Integer>> visited = new HashSet<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (matrix[i][j] == 1 && !visited.contains(new Pair<>(i, j))) {
                    bfs(i, j, visited, matrix);
                    island++;
                }
            }
        }

        return island;
    }

    private static void bfs(int row, int column, Set<Pair<Integer, Integer>> visited, int[][] matrix) {
        Queue<Pair<Integer, Integer>> queue = new ArrayDeque<>();
        queue.add(new Pair<>(row, column));
        visited.add(new Pair<>(row, column));
        while (!queue.isEmpty()) {
            Pair<Integer, Integer> poll = queue.poll();
            List<Pair<Integer, Integer>> directions = List.of(new Pair<>(0, 1),
                                                              new Pair<>(0, -1),
                                                              new Pair<>(1, 0),
                                                              new Pair<>(-1, 0));
            for (Pair<Integer, Integer> direction : directions) {
                int dirR = direction.component1() + poll.component1();
                int dirC = direction.component2() + poll.component2();
                Pair<Integer, Integer> newPair = new Pair<>(dirR, dirC);
                if (dirR < matrix.length &&
                        dirR >= 0 &&
                        dirC < matrix[0].length &&
                        dirC > 0 &&
                        matrix[dirR][dirC] == 1 &&
                        !visited.contains(newPair)) {
                    visited.add(newPair);
                    queue.add(newPair);
                }
            }
        }
    }

    public static int getNumberOfIslandDFS(int[][] matrix) {
        int island = 0;
        int row = matrix.length;
        int column = matrix[0].length;

        Set<Pair<Integer, Integer>> visited = new HashSet<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (matrix[i][j] == 1 && !visited.contains(new Pair<>(i, j))) {
                    dfs(matrix, i, j, visited);
                    island++;
                }
            }
        }

        return island;
    }

    private static void dfs(int[][] matrix, int row, int column, Set<Pair<Integer, Integer>> visited) {
        Pair<Integer, Integer> newPair = new Pair<>(row, column);

        if (row >= matrix.length ||
                row < 0 ||
                column >= matrix[0].length ||
                column < 0 ||
                matrix[row][column] != 1 ||
                visited.contains(newPair)) {
            return;
        }

        visited.add(newPair);

        //moves in right direction
        dfs(matrix, row + 1, column, visited);
        //moves in left direction
        dfs(matrix, row - 1, column, visited);
        //moves in downward direction
        dfs(matrix, row, column + 1, visited);
        //moves in upward direction
        dfs(matrix, row, column - 1, visited);
    }

}
