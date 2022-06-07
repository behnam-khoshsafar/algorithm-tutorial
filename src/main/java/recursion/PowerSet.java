package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PowerSet {

    public static void main(String[] args) {
        List<List<Integer>> powerSet = getPowerSet(Arrays.asList(1,2));
        System.out.println(powerSet);
    }

    public static List<List<Integer>> getPowerSet(List<Integer> items) {
        return getPowerSet(items, 0);
    }

    private static List<List<Integer>> getPowerSet(List<Integer> set, int index) {
        List<List<Integer>> allSubsets;
        if (set.size() == index) {
            allSubsets = new ArrayList<>();
            allSubsets.add(new ArrayList<>());
        } else {
            allSubsets = getPowerSet(set, index + 1);
            int item = set.get(index);

            List<List<Integer>> moreSubsets = new ArrayList<>();
            for (List<Integer> subset : allSubsets) {
                List<Integer> newSubset = new ArrayList<>(subset);
                newSubset.add(item);
                moreSubsets.add(newSubset);
            }

            allSubsets.addAll(moreSubsets);
        }
        return allSubsets;
    }
}
