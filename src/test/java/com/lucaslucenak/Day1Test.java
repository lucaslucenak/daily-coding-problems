package com.lucaslucenak;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class Day1Test {

    List<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new ArrayList<>(List.of(10, 15, 3, 7));
    }

    @Test
    void Day1_IsUpToK_ReturnTrue() {
        Assertions.assertTrue(Day1.isUpToKBest(numbers, 17));
    }

    @Test
    void Day1_IsUpToK_ReturnFalse() {
        Assertions.assertFalse(Day1.isUpToKBest(numbers, 20));
    }

    @Test
    void Day1_IsUpToK_EmptyNumbersList_ReturnFalse() {
        numbers.clear();
        Assertions.assertFalse(Day1.isUpToKBest(numbers, 10));
    }

    @Test
    void Day1_IsUpToK_NumbersListWithOneElement_ReturnFalse() {
        numbers.clear();
        numbers.add(10);
        Assertions.assertFalse(Day1.isUpToKBest(numbers, 10));
    }

    @Test
    void Day1_IsUpToK_NumbersListWithNegativeNumbers_ReturnTrue() {
        numbers.clear();
        numbers.addAll(List.of(-2, -3, -4, -5));
        Assertions.assertTrue(Day1.isUpToKBest(numbers, -5));
    }

    @Test
    void Day1_IsUpToK_NumbersListWithNegativeNumbers_ReturnFalse() {
        numbers.clear();
        numbers.addAll(List.of(-2, -3, -4, -5));
        Assertions.assertFalse(Day1.isUpToKBest(numbers, -10));
    }
}
