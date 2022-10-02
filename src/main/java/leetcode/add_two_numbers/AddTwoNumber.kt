package leetcode.add_two_numbers

import java.util.*

fun main() {
    println(addTwoNumber(LinkedList(listOf(2, 4, 3)), LinkedList(listOf(5, 6, 4))))
    println(addTwoNumber(LinkedList(listOf(5, 6, 4)), LinkedList(listOf(2, 4, 3, 3))))
}

fun addTwoNumber(first: LinkedList<Int>, second: LinkedList<Int>): LinkedList<Int>? {
    val result = LinkedList<Int>()
    /*instead of finding the biggest one we can use iterator*/
    val small = if (first.size > second.size) second else first
    val big = if (first.size > second.size) first else second
    var carry = 0
    for (i in big.indices) {
        val value = big[i] + (if (i >= small.size) 0 else small[i]) + carry
        carry = value / 10
        result.add(value % 10)
    }
    if (carry > 0) result.add(carry)
    return result
}