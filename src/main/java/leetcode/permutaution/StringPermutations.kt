package leetcode.permutaution


fun main() {
    permutation("123")
}

fun permutation(input: String) {
    val result = ArrayList<String>()
    permutation(result, "", input)
    println(result)
}

private fun permutation(result: MutableList<String>, perm: String, word: String) {
    if (word.isEmpty()) {
        result.add(perm)
    } else {
        for (i in word.indices) {
            permutation(result, perm + word[i], word.substring(0, i) + word.substring(i + 1))
        }
    }
}