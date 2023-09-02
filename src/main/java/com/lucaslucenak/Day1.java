package com.lucaslucenak;

import com.lucaslucenak.enums.Difficulty;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * This problem was recently asked by Google.
 *
 * Given a list of numbers and a number k, return whether any two numbers from the list add up to k.
 *
 * For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.
 */
public class Day1 {

    private Difficulty difficulty = Difficulty.EASY;

    public Day1() {
    }

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(List.of(10, 15, 3, 7));
        Integer k = 17;

        System.out.println("Worst result: " + isUpToKWorst(numbers, k));
        System.out.println("Best result: " + isUpToKBest(numbers, k));
    }

    // O(n²)
    public static Boolean isUpToKWorst(List<Integer> numbers, Integer k) {
        for (Integer i : numbers) {
            for (Integer j : numbers) {
                if (i + j == k) {
                    return true;
                }
            }
        }
        return false;
    }

    // O(n)
    public static Boolean isUpToKBest(List<Integer> numbers, Integer k) {

        // This HashSet is used to store all seen numbers;
        Set<Integer> seenNumbers = new HashSet<>();

        // As the "k" number is one number plus his complement, we can conclude that if the complement of "k" is present
        // On the HashSet, the sum is possible.

        for (Integer i : numbers) {
            Integer complement = k - i;
            if (seenNumbers.contains(complement)) {
                return true;
            }
            seenNumbers.add(i);
        }
        return false;
    }
}
