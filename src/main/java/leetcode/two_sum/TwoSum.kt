package leetcode

fun twoSum(items: Array<Int>, target: Int): Array<Int?> {
    val map = HashMap<Int, Int>()
    /*for ((index, element) in items.withIndex()) {
        val x = target - index
        if (map.containsKey(x))
            return arrayOf(map[x], index)
        map[element] = index
    }*/
    items.forEachIndexed { index, element ->
        val x = target - index
        if (map.containsKey(x))
            return arrayOf(map[x], index)
        map[element] = index
    }
    return emptyArray();
}