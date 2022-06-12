package recursion;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PermutationWithoutDupTest {

    @Test
    public void permutationWithOneCharacter() {
        PermutationWithoutDup per = new PermutationWithoutDup();
        List<String> perms = per.getPerms("b");
        assertEquals(1, perms.size());
        assertEquals("b", perms.get(0));
    }

    @Test
    public void permutationWithTwoCharacter() {
        PermutationWithoutDup per = new PermutationWithoutDup();
        List<String> perms = per.getPerms("be");
        assertEquals(2, perms.size());
        assertTrue(perms.contains("be"));
        assertTrue(perms.contains("eb"));
    }

    @Test
    public void permutationWithMoreCharacter() {
        PermutationWithoutDup per = new PermutationWithoutDup();
        List<String> perms = per.getPerms("beh");
        assertEquals(6, perms.size());
        assertTrue(perms.contains("beh"));
        assertTrue(perms.contains("bhe"));
        assertTrue(perms.contains("hbe"));
        assertTrue(perms.contains("ebh"));
        assertTrue(perms.contains("ehb"));
        assertTrue(perms.contains("heb"));
    }

}