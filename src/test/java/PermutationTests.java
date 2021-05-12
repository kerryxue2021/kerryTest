

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class PermutationTests {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    // inputString: null
    public void testWithNULL() {
        Permutation.getPermutation(null);
        Assertions.assertEquals("", outputStreamCaptor.toString().trim());
    }


    @Test
    // inputString: ""
    public void testWithBlank() {
        Permutation.getPermutation("");
        Assertions.assertEquals("", outputStreamCaptor.toString().trim());
    }


    @Test
    // inputString:  "d"
    public void testWithOneChar() {
        Permutation.getPermutation("d");
        Assertions.assertEquals("d", outputStreamCaptor.toString().trim());
    }

    @Test
    // inputString: dog
    public void testWithThreeChars() {
        Permutation.getPermutation("dog");
         Assertions.assertEquals("dog\ndgo\nodg\nogd\ngod\ngdo", outputStreamCaptor.toString().trim());

    }

    @Test
    // inputString: "doo"
    public void testWithDupChar() {
        Permutation.getPermutation("doo");
        Assertions.assertEquals("doo\ndoo\nodo\nood\nood\nodo", outputStreamCaptor.toString().trim());
    }

    @Test
    // inputString:"1234567890" check if get out of memory
    public void testWithMaxLen() {
        Permutation.getPermutation("1234567890");
        Assertions.assertEquals("", outputStreamCaptor.toString().trim());
    }


    @AfterEach
    public void restoreInitialStreams() {
        System.setOut(standardOut);
    }
}
