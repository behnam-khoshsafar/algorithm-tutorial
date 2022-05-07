package sort.impl.topsort;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sort.TopSort;

import java.util.Stack;

class TopSortImplTest {

    private TopSort topSort;

    @BeforeEach
    public void init() {
        topSort = new TopSortImpl();
    }

    @Test
    public void sort() {
        String[] projects = {"f", "c", "b", "a", "e", "d", "g"};
        String[][] dependencies = new String[8][2];
        dependencies[0][0] = "f";
        dependencies[0][1] = "c";
        dependencies[1][0] = "f";
        dependencies[1][1] = "b";
        dependencies[2][0] = "f";
        dependencies[2][1] = "a";

        dependencies[3][0] = "d";
        dependencies[3][1] = "g";

        dependencies[4][0] = "b";
        dependencies[4][1] = "e";
        dependencies[5][0] = "b";
        dependencies[5][1] = "a";

        dependencies[6][0] = "c";
        dependencies[6][1] = "a";

        dependencies[7][0] = "a";
        dependencies[7][1] = "e";

        Stack<Project> order = topSort.findBuildOrder(projects, dependencies);

        while (!order.empty())
            System.out.println(order.pop().getName());

    }

}