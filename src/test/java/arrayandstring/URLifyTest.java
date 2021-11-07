package arrayandstring;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class URLifyTest {

    private URLify urLify;

    @BeforeEach
    public void setup() {
        urLify = new URLify();
    }

    @Test
    public void urlify() {
        assertEquals("Mr%20John%20Smith", String.valueOf(urLify.doUrlify("Mr John Smith      ".toCharArray(), 13)));
        assertEquals("Mr John Smith ", String.valueOf(urLify.doUrlify("Mr John Smith ".toCharArray(), 13)));
    }
}