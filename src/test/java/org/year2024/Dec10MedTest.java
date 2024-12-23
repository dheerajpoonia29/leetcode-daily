package org.year2024;

import junit.framework.TestCase;
import org.junit.Test;


public class Dec10MedTest extends TestCase {

    Dec10Med dec10Med = new Dec10Med();

    @Test
    public void testMaximumLength() {
        assertEquals(dec10Med.maximumLength("abcaba"), 1);
        assertEquals(dec10Med.maximumLength("aaaa"), 2);
        assertEquals(dec10Med.maximumLength("abcdef"), -1);
        assertEquals(dec10Med.maximumLength("cccerrrecdcdccedecdcccddeeeddcdcddedccdceeedccecde"), 2);
    }

    @Test
    public void testIsSpecial() {
        // Test case 1: All characters are the same
        assertTrue(dec10Med.isSpecial("aaa"));

        // Test case 2: All characters are the same
        assertTrue(dec10Med.isSpecial("ccc"));

        // Test case 3: Characters are different
        assertFalse(dec10Med.isSpecial("abc"));

        // Test case 4: Single character should be special
        assertTrue(dec10Med.isSpecial("a"));

        // Test case 5: Multiple characters but not the same
        assertFalse(dec10Med.isSpecial("ab"));

        // Test case 6: Empty string is not considered special
        assertFalse(dec10Med.isSpecial(""));

        assertFalse(dec10Med.isSpecial("cce"));
    }

}