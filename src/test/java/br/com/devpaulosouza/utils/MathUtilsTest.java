package br.com.devpaulosouza.utils;

import junit.framework.TestCase;

public class MathUtilsTest extends TestCase {

    public void testRound(){
        assertEquals(0, MathUtils.round(0.3f));
        assertEquals(0, MathUtils.round(0f));
        assertEquals(1, MathUtils.round(0.5f));
        assertEquals(1, MathUtils.round(0.99f));
        assertEquals(-1, MathUtils.round(-0.8f));
    }

}