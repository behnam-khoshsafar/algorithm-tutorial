package recursion;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PermutationTest {

    private Permutation permutation;

    @BeforeEach
    public void init() {
        permutation = new Permutation();
    }

    @Test
    public void permutationWithOneCharacter() {
        List<String> perms = permutation.getPerms("b");
        assertEquals(1, perms.size());
        assertEquals("b", perms.get(0));
    }

    @Test
    public void permutationWithTwoCharacter() {
        List<String> perms = permutation.getPerms("be");
        assertEquals(2, perms.size());
        assertTrue(perms.contains("be"));
        assertTrue(perms.contains("eb"));
    }

    @Test
    public void permutationWithMoreCharacter() {
        List<String> perms = permutation.getPerms("beh");
        assertEquals(6, perms.size());
        assertTrue(perms.contains("beh"));
        assertTrue(perms.contains("bhe"));
        assertTrue(perms.contains("hbe"));
        assertTrue(perms.contains("ebh"));
        assertTrue(perms.contains("ehb"));
        assertTrue(perms.contains("heb"));
    }

    @Test
    public void permutationWithDuplicateCharacter() {
        List<String> perms = permutation.getPerms("behh");
        assertEquals(12, perms.size());
        assertTrue(perms.contains("behh"));
        assertTrue(perms.contains("bheh"));
        assertTrue(perms.contains("bhhe"));

        assertTrue(perms.contains("ebhh"));
        assertTrue(perms.contains("ehbh"));
        assertTrue(perms.contains("ehhb"));

        assertTrue(perms.contains("hbeh"));
        assertTrue(perms.contains("hbhe"));
        assertTrue(perms.contains("hehb"));
        assertTrue(perms.contains("hebh"));
        assertTrue(perms.contains("hhbe"));
        assertTrue(perms.contains("hheb"));

    }

}