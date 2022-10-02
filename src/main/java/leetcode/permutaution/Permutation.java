package leetcode.permutaution;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Permutation {

    public static List<List<Integer>> getPermutations(Integer[] items) {
        List<List<Integer>> result = new ArrayList<>();
        calculatePermutations(result, items, new Stack<>(), new boolean[items.length]);
        return result;
    }

    private static void calculatePermutations(List<List<Integer>> result, Integer[] nums, Stack<Integer> permutation, boolean[] used) {
        if (permutation.size() == nums.length) {
            result.add(permutation.stream().toList());
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (!used[i]) {
                    used[i] = true;
                    permutation.push(nums[i]);
                    calculatePermutations(result, nums, permutation, used);
                    used[i] = false;
                    permutation.pop();
                }
            }

        }
    }

    public static void main(String[] args) {
        List<List<Integer>> permutations = getPermutations(new Integer[]{1, 2, 3});
        permutations.forEach(System.out::println);
    }
}
