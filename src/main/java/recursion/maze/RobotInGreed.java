package recursion.maze;

import java.util.ArrayList;
import java.util.List;

public class RobotInGreed {

    public static List<Point> getPath(boolean[][] maze) {
        List<Point> path = new ArrayList<>();
        getPath(maze, maze.length - 1, maze[0].length - 1, path);
        return path;
    }

    private static boolean getPath(boolean[][] maze, int row, int col, List<Point> path) {
        if (row < 0 || col < 0 || !maze[row][col])
            return false;

        boolean isAtOrigin = row == 0 && col == 0;

        if (isAtOrigin || getPath(maze, row - 1, col, path) || getPath(maze, row, col - 1, path)) {
            Point point = new Point(row, col);
            path.add(point);
            return true;
        }
        return false;
    }

}
