package HackerRank.map.ransom_note;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

class RansomNoteTest {

    @Test
    void firstSolution() {
        RansomNote.firstSolution("give me one grand today night".split(" "), "give one grand today".split(" ")); //yes
        RansomNote.firstSolution("ive got a lovely bunch of coconuts".split(" "), "ive got some coconuts".split(" ")); //no
    }

    @Test
    void secondSolution() {
        RansomNote.secondSolution(Arrays.stream("give me one grand today night".split(" ")).toList(), Arrays.stream("give one grand today".split(" ")).toList());
        RansomNote.secondSolution(Arrays.stream("ive got a lovely bunch of coconuts".split(" ")).toList(), Arrays.stream("ive got some coconuts".split(" ")).toList());
    }
}