package leetcode.subsets;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    public static List<List<Integer>> getSubsets(Integer[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        getSubsets(nums, result, 0, new ArrayList<>());
        return result;
    }

    private static void getSubsets(Integer[] nums, List<List<Integer>> result, int index, List<Integer> subset) {
        if (index >= nums.length) {
            result.add(new ArrayList<>(subset));
            return;
        }

//        decision to include nums[i]
        subset.add(nums[index]);
        getSubsets(nums, result, index + 1, subset);

        //        decision to not include nums[i]
        subset.remove(subset.size() - 1);
        getSubsets(nums, result, index + 1, subset);

    }

    public static void main(String[] args) {
        List<List<Integer>> result = getSubsets(new Integer[]{1, 2, 3});
        result.forEach(integers -> integers.toString());
    }

}
