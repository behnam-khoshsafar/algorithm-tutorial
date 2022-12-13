package HackerRank.map.anagram;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SherlockAndAnagramsTest {

    @Test
    public void firstSolution() {
        Assertions.assertEquals(4, SherlockAndAnagrams.firstSolution("abba"));
        Assertions.assertEquals(10, SherlockAndAnagrams.firstSolution("kkkk"));
        Assertions.assertEquals(0, SherlockAndAnagrams.firstSolution("abcd"));
    }

    @Test
    public void secondSolution() {
        Assertions.assertEquals(4, SherlockAndAnagrams.secondSolution("abba"));
        Assertions.assertEquals(10, SherlockAndAnagrams.secondSolution("kkkk"));
        Assertions.assertEquals(0, SherlockAndAnagrams.secondSolution("abcd"));
    }

}