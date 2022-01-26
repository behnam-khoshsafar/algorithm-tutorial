package arrayandstring;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UniqueCharTest {

    UniqueChar uniqueChar;

    @BeforeEach
    public void setup() {
        uniqueChar = new UniqueChar();
    }

    @Test
    public void isUnique() {
        assertIsUnique(true, null);
        assertIsUnique(true, " ");
        assertIsUnique(true, "Test");
        assertIsUnique(false, "Test Test");
        assertIsUnique(false, "Test T");
        assertIsUnique(true, "23432432432483749732432974932749327493247932" +
                "47329473294uhdkfhdksadsadgyuwewrtyuewrtuweytruewyrtuyewtruyewrt" +
                "rewuyrewyriuewyriewyuriewuyriewryieyreiyrieryeiwryieryeiryieryey" +
                "rewirioewuroiewuruewroueworuoewureowuroeiuroewuroewuroewuroewuroie" +
                "ewirioewuroiewuroewjdshfkjdsfdsgfyuteyrtewrgyrewytreyuwtrewrewurtuyt");
    }

    @Test
    public void isUniqueUsingSet() {
        assertIsUniqueUsingSet(true, null);
        assertIsUniqueUsingSet(true, " ");
        assertIsUniqueUsingSet(true, "Test");
        assertIsUniqueUsingSet(false, "Test Test");
        assertIsUniqueUsingSet(false, "Test T");
        assertIsUniqueUsingSet(true, "23432432432483749732432974932749327493247932" +
                "47329473294uhdkfhdksadsadgyuwewrtyuewrtuweytruewyrtuyewtruyewrt" +
                "rewuyrewyriuewyriewyuriewuyriewryieyreiyrieryeiwryieryeiryieryey" +
                "rewirioewuroiewuruewroueworuoewureowuroeiuroewuroewuroewuroewuroie" +
                "ewirioewuroiewuroewjdshfkjdsfdsgfyuteyrtewrgyrewytreyuwtrewrewurtuyt");
    }

    private void assertIsUnique(boolean result, String str) {
        assertEquals(result, uniqueChar.isUnique(str));
    }

    private void assertIsUniqueUsingSet(boolean result, String str) {
        assertEquals(result, uniqueChar.isUniqueUsingSet(str));
    }

}