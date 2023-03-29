package br.com.demo.camelcase;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CamelCaseConverterTest {

    private static CamelCaseConverter camelCaseconverter;

    @BeforeAll
    public static void setUp() {
        camelCaseconverter = new CamelCaseConverter();
    }

    @Test
    public void shouldBeApplyCamelCaseInOneWord() {
        String result = camelCaseconverter.convert("lionel");
        assertEquals("Lionel", result);
    }

    @Test
    public void shouldBeApplyCamelCaseInWordWithLowerAndUpperCase() {
        String result = camelCaseconverter.convert("LiOnEL");
        assertEquals("Lionel", result);
    }
}