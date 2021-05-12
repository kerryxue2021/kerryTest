
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Set;

public class Permutation2Tests {

    @Test
    // inputString: null
    public void testWithNULL() {
        Set<String> set = Permutation2.getPermutation(null);
        Assertions.assertEquals(null, set);
    }


    @Test
    // inputString: ""
    public void testWithBlank() {
        Set<String> set = Permutation2.getPermutation("");
        Assertions.assertEquals("[]", set.toString());
    }

    @Test
    // inputString:  "d"
    public void testWithOneChar() {
        Set<String> set = Permutation2.getPermutation("d");
        Assertions.assertEquals("[d]", set.toString());
    }

    @Test
    // inputString: dog
    public void testWithThreeChars() {
        Set<String> set = Permutation2.getPermutation("dog");
        Assertions.assertEquals("[odg, gdo, dog, ogd, dgo, god]", set.toString());
    }

    @Test
    // inputString: "doo"
    public void testWithDupChar() {
        Set<String> set = Permutation2.getPermutation("doo");
        Assertions.assertEquals("[doo, ood, odo]", set.toString());
    }

    @Test
    // inputString: big len string, check if get out of memory
    public void testWithMaxLen() {
        Set<String> set = Permutation2.getPermutation("1234567890");
        Assertions.assertEquals("", set.toString());
    }

}
