package com.example.sorting;

public class SortingUtility {

    /**
     * Generic Comparable object for testing sorting algorithms.
     */
    public class TestComparable implements Comparable<TestComparable> {

        private final int value;

        public TestComparable(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        /**
         * Compare two TestComparable objects based on their integer value.
         */
        @Override
        public int compareTo(TestComparable other) {
            return Integer.compare(this.value, other.value);
        }

        @Override
        public String toString() {
            return Integer.toString(value);
        }
    }

    public static <T extends Comparable<T>> void gnomeSort(T[] a) {
        // Initialize position to start of array
        int pos = 0;

        // Iterate through array until end
        while (pos < a.length) {
            // If at start or current element >= previous element, move forward
            if (pos == 0 || a[pos].compareTo(a[pos - 1]) >= 0) {
                pos++;
            } else {
                // Otherwise, swap with previous element and move back
                swap(a, pos, pos - 1);
                pos--;
            }
        }
    }


    public static <T extends Comparable<T>> void cocktailShakerSort(T[] a) {
        boolean swapped;

        do {
            swapped = false;

            // Forward pass
            for (int i = 0; i < a.length - 1; i++) {
                if (a[i].compareTo(a[i + 1]) > 0) {
                    swap(a, i, i + 1);
                    swapped = true;
                }
            }

            // If no swaps occurred, array is sorted
            if (!swapped) {
                break;
            }

            swapped = false;

            // Backward pass
            for (int i = a.length - 2; i >= 0; i--) {
                if (a[i].compareTo(a[i + 1]) > 0) {
                    swap(a, i, i + 1);
                    swapped = true;
                }
            }

        } while (swapped);
    }

    public static <T extends Comparable<T>> void shellSort(T[] a) {
        int[] gaps = {701, 301, 132, 57, 23, 10, 4, 1};  // Ciura gap sequence
        int n = a.length;

        // Iterate over each gap
        for (int gap : gaps) {
            // Perform gapped insertion sort for this gap
            for (int i = gap; i < n; i++) {
                T temp = a[i];  // Save current element
                int j = i;

                // Shift elements up until the correct location for temp is found
                while (j >= gap && a[j - gap].compareTo(temp) > 0) {
                    a[j] = a[j - gap];
                    j -= gap;
                }

                // Place temp in its correct position
                a[j] = temp;
            }
        }
    }


    private static <T extends Comparable<T>> void swap(T[] data, int index1, int index2) {

        T temp = data[index1];
        data[index1] = data[index2];
        data[index2] = temp;

    }
}





