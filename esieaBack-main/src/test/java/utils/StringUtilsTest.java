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
        assertFalse(esiea.utils.StringUtils.estEntier(null));
        assertFalse(esiea.utils.StringUtils.estEntier("test"));
        assertTrue(esiea.utils.StringUtils.estEntier("-4"));
        assertFalse(esiea.utils.StringUtils.estEntier("3.2"));
        assertFalse(esiea.utils.StringUtils.estEntier("3,2"));
    }

    @Test
    void nbOccurrence() {
        assertEquals(0, esiea.utils.StringUtils.nbOccurrence("",'a'));
        assertEquals(2, esiea.utils.StringUtils.nbOccurrence("abcabc", 'a'));

        //StringUtils.nbOccurrence(null, 'a');
    }
}
