package com.lucaslucenak;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class Day2Test {

     @Test
     void Day2_AllNumbersProductExceptI_Return_2_3_6() {
          List<Integer> numbers = List.of(3, 2, 1);
          Assertions.assertEquals(Day2.allNumbersProductExceptI(numbers), List.of(2, 3, 6));
     }

     @Test
     void Day2_AllNumbersProductExceptI_Return_120_60_40_30_24() {
          List<Integer> numbers = List.of(1, 2, 3, 4, 5);
          Assertions.assertEquals(Day2.allNumbersProductExceptI(numbers), List.of(120, 60, 40, 30, 24));
     }
}
