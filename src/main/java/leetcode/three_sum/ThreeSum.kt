package leetcode.three_sum

fun threeSum(items: Array<Int>): List<Array<Int>> {
    val result = ArrayList<Array<Int>>()
    items.sort()

    items.forEachIndexed { index, element ->
        if (index > 0 && element == items[index - 1])
            return@forEachIndexed
        val indexes = twoSum(items, index + 1, items.size - 1, element)
        if (indexes != null)
            result.add(arrayOf(element, items[indexes[0]], items[indexes[1]]))
    }
    return result;
}

fun twoSum(items: Array<Int>, left: Int, right: Int, target: Int): Array<Int>? {
    var leftPointer = left
    var rightPointer = right
    while (leftPointer < rightPointer) {
        val value = items[left] + items[right]
        if (value < target)
            leftPointer++
        else if (value > target)
            rightPointer++
        else
            return arrayOf(leftPointer, rightPointer)
    }
    return null;
}