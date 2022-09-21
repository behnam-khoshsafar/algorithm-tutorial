package leetcode.two_some_2

fun twoSum(aceOrderedItems: Array<Int>, target: Int): Array<Int> {
    var left = 0
    var right: Int = aceOrderedItems.size - 1
    while (left < right) {
        val value: Int = aceOrderedItems[left] + aceOrderedItems[right]
        if (value > target) right--
        else if (value < target) left++
        else return arrayOf(left, right)
    }
    return emptyArray()
}