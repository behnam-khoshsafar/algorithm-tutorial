package recursion.maze;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class RobotInGreedTest {

    @Test
    public void findPath() {
        boolean[][] maze = {{true, true, true},
                {true, false, true},
                {true, true, true}};

        List<Point> path = RobotInGreed.getPath(maze);
        Assertions.assertEquals(5, path.size());
        path.forEach(point -> System.out.printf("row %s col %s%n", point.getRow(), point.getCol()));
    }
}