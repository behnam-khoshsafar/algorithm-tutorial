package leetcode.add_two_numbers;

import java.util.LinkedList;
import java.util.List;

public class AddTwoNumber {

    public static void main(String[] args) {
        System.out.println(addTwoNumber(new LinkedList<>(List.of(2, 4, 3)), new LinkedList<>(List.of(5, 6, 4))));
        System.out.println(addTwoNumber(new LinkedList<>(List.of(5, 6, 4)), new LinkedList<>(List.of(2, 4, 3, 3))));
    }

    public static LinkedList<Integer> addTwoNumber(LinkedList<Integer> first, LinkedList<Integer> second) {
        LinkedList<Integer> result = new LinkedList<>();
        /*instead of finding the biggest one we can use iterator*/
        var small = first.size() > second.size() ? second : first;
        var big = first.size() > second.size() ? first : second;

        int carry = 0;
        for (int i = 0; i < big.size(); i++) {
            int value = big.get(i) + (i >= small.size() ? 0 : small.get(i)) + carry;
            carry = value / 10;
            result.add(value % 10);
        }
        if (carry > 0)
            result.add(carry);
        return result;
    }

}
