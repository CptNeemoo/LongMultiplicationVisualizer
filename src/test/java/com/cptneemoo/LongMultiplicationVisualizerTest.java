package com.cptneemoo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongMultiplicationVisualizerTest {

    @Test
    void toStringTest1() {
        String expected =
                "      1234352\n" +
                "      3453422\n" +
                "      _______\n" +
                "      2468704\n" +
                "     2468704 \n" +
                "    4937408  \n" +
                "   3703056   \n" +
                "  6171760    \n" +
                " 4937408     \n" +
                "3703056      \n" +
                "_____________\n" +
                "4262738352544";
        String actual = new LongMultiplicationVisualizer(1234352, 3453422).toString();
        assertEquals(expected,actual);

    }

    @Test
    void toStringTest2() {
        String expected =
                        "  111\n" +
                        "  111\n" +
                        "  ___\n" +
                        "  111\n" +
                        " 111 \n" +
                        "111  \n" +
                        "_____\n" +
                        "12321";
        String actual = new LongMultiplicationVisualizer(111, 111).toString();
        assertEquals(expected,actual);
    }
}