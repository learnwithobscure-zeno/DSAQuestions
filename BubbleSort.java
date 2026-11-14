import java.util.Arrays;

/**
 * Bubble Sort implementation in Java (ascending order).
 *
 * Bubble Sort compares adjacent elements and swaps them when they are
 * out of order. After each pass, the largest remaining element reaches
 * its correct position at the end of the unsorted portion.
 *
 * This implementation uses an early-exit optimization: if a full pass
 * performs no swaps, the array is already sorted and we stop.
 *
 * Time complexity:
 *   Best case:    O(n)   - already sorted (early exit)
 *   Average case: O(n^2)
 *   Worst case:   O(n^2)
 * Space complexity: O(1) extra space (sorting happens in place)
 */
public class BubbleSort {

    /**
     * Sorts the given array in ascending order, in place.
     *
     * @param numbers the array to sort
     */
    public static void bubbleSort(int[] numbers) {
        int n = numbers.length;

        // Each pass places one more element at its final position.
        for (int i = 0; i < n - 1; i++) {
            // Reset at the start of EACH pass.
            boolean swapped = false;

            // The last i elements are already in their sorted positions.
            for (int j = 0; j < n - i - 1; j++) {
                // Swap adjacent elements if they are in the wrong order.
                if (numbers[j] > numbers[j + 1]) {
                    int temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                    swapped = true;
                }
            }

            // No swaps in this pass means the whole array is sorted.
            if (!swapped) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] numbers = {5, 1, 4, 2, 8};

        System.out.println("Before sorting: " + Arrays.toString(numbers));
        bubbleSort(numbers);
        System.out.println("After sorting:  " + Arrays.toString(numbers));

        // Also works for arrays that are already sorted.
        int[] alreadySorted = {1, 2, 3, 4, 5};
        bubbleSort(alreadySorted);
        System.out.println("Already sorted: " + Arrays.toString(alreadySorted));
    }
}
