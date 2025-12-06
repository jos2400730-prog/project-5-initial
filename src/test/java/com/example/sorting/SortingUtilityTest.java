package com.example.sorting;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SortingUtilityTest {

    // -------------------------------
    // Helper methods
    // -------------------------------

    private <T extends Comparable<T>> boolean isSorted(T[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i].compareTo(arr[i + 1]) > 0) return false;
        }
        return true;
    }

    private SortingUtility.TestComparable[] toTestComparableArray(int[] values) {
        SortingUtility util = new SortingUtility();
        SortingUtility.TestComparable[] arr = new SortingUtility.TestComparable[values.length];
        for (int i = 0; i < values.length; i++) {
            arr[i] = util.new TestComparable(values[i]);
        }
        return arr;
    }

    private String[] copyStringArray(String[] arr) {
        return arr.clone();
    }

    // -------------------------------
    // Generic test runner for integer arrays
    // -------------------------------

    private void runIntegerTestsForGnome(int[] values, String testName) {
        SortingUtility.TestComparable[] arr = toTestComparableArray(values);
        SortingUtility.gnomeSort(arr);
        assertTrue(isSorted(arr), "GnomeSort failed on: " + testName);
    }

    private void runIntegerTestsForCocktail(int[] values, String testName) {
        SortingUtility.TestComparable[] arr = toTestComparableArray(values);
        SortingUtility.cocktailShakerSort(arr);
        assertTrue(isSorted(arr), "CocktailShakerSort failed on: " + testName);
    }

    private void runIntegerTestsForShell(int[] values, String testName) {
        SortingUtility.TestComparable[] arr = toTestComparableArray(values);
        SortingUtility.shellSort(arr);
        assertTrue(isSorted(arr), "ShellSort failed on: " + testName);
    }

    // -------------------------------
    // Generic test runner for string arrays
    // -------------------------------

    private void runStringTestsForGnome(String[] values, String testName) {
        String[] arr = copyStringArray(values);
        SortingUtility.gnomeSort(arr);
        assertTrue(isSorted(arr), "GnomeSort failed on string array: " + testName);
    }

    private void runStringTestsForCocktail(String[] values, String testName) {
        String[] arr = copyStringArray(values);
        SortingUtility.cocktailShakerSort(arr);
        assertTrue(isSorted(arr), "CocktailShakerSort failed on string array: " + testName);
    }

    private void runStringTestsForShell(String[] values, String testName) {
        String[] arr = copyStringArray(values);
        SortingUtility.shellSort(arr);
        assertTrue(isSorted(arr), "ShellSort failed on string array: " + testName);
    }

    // -------------------------------
    // Test cases
    // -------------------------------

    @Test
    void testAllIntegerCases() {
        // Empty
        int[] empty = {};
        runIntegerTestsForGnome(empty, "Empty");
        runIntegerTestsForCocktail(empty, "Empty");
        runIntegerTestsForShell(empty, "Empty");

        // Single element
        int[] single = {5};
        runIntegerTestsForGnome(single, "Single element");
        runIntegerTestsForCocktail(single, "Single element");
        runIntegerTestsForShell(single, "Single element");

        // Already sorted
        int[] sorted = {1, 2, 3, 4, 5};
        runIntegerTestsForGnome(sorted, "Already sorted");
        runIntegerTestsForCocktail(sorted, "Already sorted");
        runIntegerTestsForShell(sorted, "Already sorted");

        // Reverse sorted
        int[] reverse = {5, 4, 3, 2, 1};
        runIntegerTestsForGnome(reverse, "Reverse sorted");
        runIntegerTestsForCocktail(reverse, "Reverse sorted");
        runIntegerTestsForShell(reverse, "Reverse sorted");

        // Duplicates
        int[] duplicates = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3};
        runIntegerTestsForGnome(duplicates, "Duplicates");
        runIntegerTestsForCocktail(duplicates, "Duplicates");
        runIntegerTestsForShell(duplicates, "Duplicates");

        // All same elements
        int[] same = {5, 5, 5, 5, 5};
        runIntegerTestsForGnome(same, "All same elements");
        runIntegerTestsForCocktail(same, "All same elements");
        runIntegerTestsForShell(same, "All same elements");

        // Two elements swapped
        int[] twoSwapped = {2, 1};
        runIntegerTestsForGnome(twoSwapped, "Two elements swapped");
        runIntegerTestsForCocktail(twoSwapped, "Two elements swapped");
        runIntegerTestsForShell(twoSwapped, "Two elements swapped");

        // Two elements sorted
        int[] twoSorted = {1, 2};
        runIntegerTestsForGnome(twoSorted, "Two elements sorted");
        runIntegerTestsForCocktail(twoSorted, "Two elements sorted");
        runIntegerTestsForShell(twoSorted, "Two elements sorted");

        // Random order
        int[] random = {64, 34, 25, 12, 22, 11, 90};
        runIntegerTestsForGnome(random, "Random order");
        runIntegerTestsForCocktail(random, "Random order");
        runIntegerTestsForShell(random, "Random order");
    }

    @Test
    void testAllStringCases() {
        // Random string array
        String[] strings = {"zebra", "apple", "mango", "banana"};
        runStringTestsForGnome(strings, "Random strings");
        runStringTestsForCocktail(strings, "Random strings");
        runStringTestsForShell(strings, "Random strings");

        // Already sorted
        String[] sortedStrings = {"apple", "banana", "mango", "zebra"};
        runStringTestsForGnome(sortedStrings, "Already sorted strings");
        runStringTestsForCocktail(sortedStrings, "Already sorted strings");
        runStringTestsForShell(sortedStrings, "Already sorted strings");

        // Reverse sorted
        String[] reverseStrings = {"zebra", "mango", "banana", "apple"};
        runStringTestsForGnome(reverseStrings, "Reverse sorted strings");
        runStringTestsForCocktail(reverseStrings, "Reverse sorted strings");
        runStringTestsForShell(reverseStrings, "Reverse sorted strings");

        // Duplicates
        String[] duplicatesStrings = {"apple", "banana", "apple", "mango", "banana"};
        runStringTestsForGnome(duplicatesStrings, "Duplicates strings");
        runStringTestsForCocktail(duplicatesStrings, "Duplicates strings");
        runStringTestsForShell(duplicatesStrings, "Duplicates strings");

        // Single element
        String[] single = {"apple"};
        runStringTestsForGnome(single, "Single string element");
        runStringTestsForCocktail(single, "Single string element");
        runStringTestsForShell(single, "Single string element");

        // Empty
        String[] empty = {};
        runStringTestsForGnome(empty, "Empty string array");
        runStringTestsForCocktail(empty, "Empty string array");
        runStringTestsForShell(empty, "Empty string array");
    }
}
