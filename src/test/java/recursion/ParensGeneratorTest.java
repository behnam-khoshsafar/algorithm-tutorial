package recursion;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ParensGeneratorTest {

    @Test
    public void generateZeroParens() {
        Set<String> parens = ParensGenerator.generateParens(0);
        assertEquals(1, parens.size());
        assertTrue(parens.contains(""));
    }

    @Test
    public void generateOneParens() {
        Set<String> parens = ParensGenerator.generateParens(1);

        assertEquals(1, parens.size());
        assertTrue(parens.contains("()"));
    }

    @Test
    public void generateTwoParens() {
        Set<String> parens = ParensGenerator.generateParens(2);

        assertEquals(2, parens.size());
        assertTrue(parens.contains("()()"));
        assertTrue(parens.contains("(())"));
    }

    @Test
    public void generateThreeParens() {
        Set<String> parens = ParensGenerator.generateParens(3);

        assertEquals(5, parens.size());
        assertTrue(parens.contains("()(())"));
        assertTrue(parens.contains("(())()"));
        assertTrue(parens.contains("()()()"));
        assertTrue(parens.contains("((()))"));
        assertTrue(parens.contains("(()())"));
    }

    @Test
    public void generateFourParens() {
        Set<String> parens = ParensGenerator.generateParens(4);

        assertEquals(14, parens.size());
        assertTrue(parens.contains("()((()))"));
        assertTrue(parens.contains("()(()())"));
        assertTrue(parens.contains("(())(())"));
        assertTrue(parens.contains("()()(())"));
        assertTrue(parens.contains("()(())()"));
        assertTrue(parens.contains("(()())()"));
        assertTrue(parens.contains("((()))()"));
        assertTrue(parens.contains("()()()()"));
        assertTrue(parens.contains("(())()()"));
        assertTrue(parens.contains("(()(()))"));
        assertTrue(parens.contains("((()()))"));
        assertTrue(parens.contains("(((())))"));
        assertTrue(parens.contains("(()()())"));
        assertTrue(parens.contains("((())())"));
    }

}