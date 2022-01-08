package utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringUtilsTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void estEntier() {
        assertFalse(StringUtils.estEntier(null));
        assertFalse(StringUtils.estEntier("test"));
        assertTrue(StringUtils.estEntier("-4"));
        assertFalse(StringUtils.estEntier("3.2"));
        assertFalse(StringUtils.estEntier("3,2"));
    }

    @Test
    void nbOccurrence() {
        assertEquals(0, StringUtils.nbOccurrence("",'a'));
        assertEquals(2, StringUtils.nbOccurrence("abcabc", 'a'));
        
        //StringUtils.nbOccurrence(null, 'a');
    }
}