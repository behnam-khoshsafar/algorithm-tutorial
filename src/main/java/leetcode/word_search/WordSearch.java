package leetcode.word_search;

import kotlin.Pair;

import java.util.HashSet;
import java.util.Set;

public class WordSearch {

    public static boolean exist(Character[][] matrix, String word) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (dfs(matrix, i, j, word, 0, new HashSet<>()))
                    return true;
            }
        }
        return false;
    }

    private static boolean dfs(Character[][] matrix, int row, int column, String word, int index, Set<Pair<Integer, Integer>> visitedSet) {
        if (index == word.length())
            return true;
        Pair<Integer, Integer> newPair = new Pair<>(row, column);
        if (row < 0 ||
                row >= matrix.length ||
                column < 0 ||
                column >= matrix[0].length ||
                visitedSet.contains(newPair) ||
                matrix[row][column] != word.charAt(index))
            return false;

        visitedSet.add(newPair);

        return (dfs(matrix, row + 1, column, word, index + 1, visitedSet) ||
                dfs(matrix, row - 1, column, word, index + 1, visitedSet) ||
                dfs(matrix, row, column + 1, word, index + 1, visitedSet) ||
                dfs(matrix, row, column - 1, word, index + 1, visitedSet));
    }

    public static void main(String[] args) {
        Character[][] wordMatrix = new Character[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}};
        System.out.println(exist(wordMatrix, "ABCCED"));
    }
}
