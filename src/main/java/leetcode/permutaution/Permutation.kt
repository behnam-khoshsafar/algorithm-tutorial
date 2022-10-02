package leetcode.permutaution

import java.util.*

fun getPermutations(items: Array<Int>): List<List<Int>> {
    val result: MutableList<List<Int>> = ArrayList()
    calculatePermutations(result, items, Stack(), BooleanArray(items.size))
    return result
}

private fun calculatePermutations(
    result: MutableList<List<Int>>,
    nums: Array<Int>,
    permutation: Stack<Int>,
    used: BooleanArray
) {
    if (permutation.size == nums.size) {
        result.add(permutation.stream().toList())
    } else {
        for (i in nums.indices) {
            if (!used[i]) {
                used[i] = true
                permutation.push(nums[i])
                calculatePermutations(result, nums, permutation, used)
                used[i] = false
                permutation.pop()
            }
        }
    }
}

fun main() {
    val permutations = getPermutations(arrayOf(1, 2, 3))
    println(permutations)
}