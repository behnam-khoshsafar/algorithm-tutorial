package leetcode.longest_substring

fun main() {
    println(getLengthOfLongestSubstring("abcabcbb"))
}

fun getLengthOfLongestSubstring(input: String): Int {
    val characters: MutableSet<Char> = HashSet()
    var length = 0
    var left = 0
    for (right in input.indices) {
        val c = input[right]
        while (characters.contains(c)) {
            characters.remove(input[left])
            left++
        }
        characters.add(c)
        if (length < characters.size) length = characters.size
    }
    return length
}