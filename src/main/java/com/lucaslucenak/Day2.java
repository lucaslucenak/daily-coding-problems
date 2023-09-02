package com.lucaslucenak;

import com.lucaslucenak.enums.Difficulty;

import java.util.ArrayList;
import java.util.List;

/**
 * This problem was asked by Uber.
 *
 * Given an array of integers, return a new array such that each element at index i of the new array is the product of all the numbers in the original array except the one at i.
 *
 * For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30, 24]. If our input was [3, 2, 1], the expected output would be [2, 3, 6].
 *
 * Follow-up: what if you can't use division?
 */
public class Day2 {

    private Difficulty difficulty = Difficulty.HARD;

    public Day2() {
    }

    public static void main(String[] args) {
        System.out.println(allNumbersProductExceptI(List.of(1, 2, 3, 4, 5)));
        System.out.println(allNumbersProductExceptI(List.of(3, 2, 1)));
    }

    public static List<Integer> allNumbersProductExceptI(List<Integer> numbers) {
        List<Integer> output = new ArrayList<>();

        for (Integer i : numbers) {
            List<Integer> numbersWithOutI = new ArrayList<>(numbers);
            numbersWithOutI.remove(i);
            output.add(numbersWithOutI.stream().reduce(1, (a, b) -> a * b));
        }
        return output;
    }
}
