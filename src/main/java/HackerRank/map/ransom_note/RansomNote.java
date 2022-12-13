package HackerRank.map.ransom_note;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RansomNote {

    public static void firstSolution(String[] magazine, String[] note) {
        boolean isReplicable = isReplicable(magazine, note);
        printResult(isReplicable);
    }

    private static boolean isReplicable(String[] magazine, String[] notes) {
        Map<String, Integer> magazineMap = getSourceMap(magazine);
        Map<String, Integer> noteMap = getSourceMap(notes);
        for (Map.Entry<String, Integer> noteEntry : noteMap.entrySet()) {
            String noteKey = noteEntry.getKey();
            if (!magazineMap.containsKey(noteKey) || noteEntry.getValue() > magazineMap.get(noteKey))
                return false;
        }
        return true;
    }

    private static Map<String, Integer> getSourceMap(String[] sources) {
        Map<String, Integer> sourceMap = new HashMap<>();
        Arrays.stream(sources).forEach(source -> {
            if (!sourceMap.containsKey(source))
                sourceMap.put(source, 1);
            else
                sourceMap.put(source, sourceMap.get(source) + 1);
        });
        return sourceMap;
    }

    private static void printResult(boolean isReplicable) {
        if (isReplicable) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    public static void secondSolution(List<String> magazine, List<String> note) {
        Map<String, Long> magazineWord = magazine.stream().collect(Collectors.groupingBy(s -> s, Collectors.counting()));
        Map<String, Long> noteWord = note.stream().collect(Collectors.groupingBy(s -> s, Collectors.counting()));
        noteWord.entrySet().stream()
                .filter(entry -> entry.getValue() > magazineWord.getOrDefault(entry.getKey(), 0L))
                .findAny()
                .ifPresentOrElse(entry -> System.out.print("No"), () -> System.out.print("Yes"));
    }
}
