package HackerRank.map.anagram;

import java.util.*;
import java.util.stream.Collectors;

public class SherlockAndAnagrams {
    private static int N = 26;
    private static final Scanner scanner = new Scanner(System.in);

    private static boolean isAnagram(String a, String b) {
        int[] countA = new int[N];
        int[] countB = new int[N];

        for (char c : a.toCharArray()) {
            countA[c - 'a']++;
        }

        for (char c : b.toCharArray()) {
            countB[c - 'a']++;
        }

        for (int i = 0; i < N; i++) {
            if (countA[i] != countB[i]) {
                return false;
            }
        }

        return true;
    }

    public static int firstSolution(String s) {
        int count = 0;
        int length = s.length();

        List<String> subsets = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            for (int j = 1; j <= length - i; j++) {
                subsets.add(s.substring(i, i + j));
            }
        }

        for (int i = 0; i < subsets.size(); i++) {
            for (int j = i + 1; j < subsets.size(); j++) {
                String s1 = subsets.get(i);
                String s2 = subsets.get(j);
                if (i != j &&
                        s1.length() == s2.length() &&
                        isAnagram(s1, s2)) {
                    count++;
                }
            }
        }
        return count;
    }

    public static int secondSolution(String s) {
        Map<String, Integer> counterMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                char[] chars = s.substring(i, j + 1).toCharArray();
                Arrays.sort(chars);
                String sortedString = new String(chars);
                counterMap.put(sortedString, counterMap.getOrDefault(sortedString, 0) + 1);
            }
        }

        int count = 0;
        for (Map.Entry<String, Integer> entry : counterMap.entrySet()) {
            count += entry.getValue() * (entry.getValue() - 1) / 2;
        }
        return count;
    }
}

