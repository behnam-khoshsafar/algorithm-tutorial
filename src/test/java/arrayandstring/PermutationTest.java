package arrayandstring;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PermutationTest {

    @Test
    public void permutationFailsWhenOneOfTheInputsIsEmptyWithoutSort(){
        Permutation permutation=new Permutation();
        assertFalse(permutation.checkPermutationWithoutSort(null,"Test"));
        assertFalse(permutation.checkPermutationWithoutSort("Test",null));
    }

    @Test
    public void permutationFailsWhenSizeOfInputsIsNotEqualsWithoutSort(){
        Permutation permutation=new Permutation();
        assertFalse(permutation.checkPermutationWithoutSort("Test","Tests"));
    }

    @Test
    public void permutationSuccessfulWithoutSort(){
        Permutation permutation=new Permutation();
        assertTrue(permutation.checkPermutationWithoutSort("Test","Test"));
    }

    @Test
    public void permutationFailsForInputWithSameSizeWithoutSort(){
        Permutation permutation=new Permutation();
        assertFalse(permutation.checkPermutationWithoutSort("Test","Tstb"));
    }

    @Test
    public void permutationFailsWhenOneOfTheInputsIsEmptyWithSort(){
        Permutation permutation=new Permutation();
        assertFalse(permutation.checkPermutationWithSort(null,"Test"));
        assertFalse(permutation.checkPermutationWithSort("Test",null));
    }

    @Test
    public void permutationFailsWhenSizeOfInputsIsNotEqualsWithSort(){
        Permutation permutation=new Permutation();
        assertFalse(permutation.checkPermutationWithSort("Test","Tests"));
    }

    @Test
    public void permutationSuccessfulWithSort(){
        Permutation permutation=new Permutation();
        assertTrue(permutation.checkPermutationWithSort("Test","Test"));
    }

    @Test
    public void permutationFailsForInputWithSameSizeWithSort(){
        Permutation permutation=new Permutation();
        assertFalse(permutation.checkPermutationWithSort("Test","Tstb"));
    }

}