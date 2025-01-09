package lc_daily.year2025;

import junit.framework.TestCase;

public class Jan2MedTest extends TestCase {
    Jan2Med obj = new Jan2Med();

    public void testVowelStrings() {
        assertEquals(true, obj.isVowel('a'));
        assertEquals(true, obj.isVowel('e'));
        assertEquals(true, obj.isVowel('i'));
        assertEquals(true, obj.isVowel('o'));
        assertEquals(true, obj.isVowel('u'));
        assertEquals(false, obj.isVowel('b'));
        assertEquals(false, obj.isVowel('z'));
    }
}