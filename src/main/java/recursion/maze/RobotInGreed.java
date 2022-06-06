package recursion.maze;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RobotInGreed {

    public static List<Point> getPath(boolean[][] maze) {
        List<Point> path = new ArrayList<>();
        Set<Point> failedPointers = new HashSet<>();
        getPath(maze, maze.length - 1, maze[0].length - 1, path, failedPointers);
        return path;
    }

    private static boolean getPath(boolean[][] maze, int row, int col, List<Point> path, Set<Point> failedPointers) {
        if (row < 0 || col < 0 || !maze[row][col])
            return false;

        boolean isAtOrigin = row == 0 && col == 0;

        Point point = new Point(row, col);
        if (failedPointers.contains(point))
            return false;

        if (isAtOrigin || getPath(maze, row - 1, col, path, failedPointers) || getPath(maze, row, col - 1, path, failedPointers)) {
            path.add(point);
            return true;
        }
        failedPointers.add(point);
        return false;
    }

}
