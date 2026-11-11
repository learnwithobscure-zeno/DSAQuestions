/**
 * Binary Search implementation in Java.
 *
 * Binary Search works on a sorted array. It repeatedly checks the middle
 * element and discards the half of the search range that cannot contain
 * the target.
 *
 * Time Complexity:  O(log n)
 * Space Complexity: O(1) - iterative implementation
 */
public class BinarySearch {

    /**
     * Searches for a target value in a sorted array using Binary Search.
     *
     * @param numbers sorted array of integers (ascending order)
     * @param target  value to search for
     * @return index of the target if found; otherwise, -1
     */
    public static int binarySearch(int[] numbers, int target) {

        // 'low' is the first index in the current search range.
        int low = 0;

        // 'high' is the last index in the current search range.
        int high = numbers.length - 1;

        // Continue while there are still elements left to search.
        while (low <= high) {

            // Find the middle index of the current search range.
            // This form avoids possible integer overflow from (low + high) / 2.
            int mid = low + (high - low) / 2;

            // If the middle element is the target, we have found it.
            if (numbers[mid] == target) {
                return mid;
            }

            // If the middle element is smaller than the target,
            // the target (if present) must be in the right half.
            if (numbers[mid] < target) {
                low = mid + 1;
            }

            // If the middle element is greater than the target,
            // the target (if present) must be in the left half.
            else {
                high = mid - 1;
            }
        }

        // The search range is empty, so the target is not in the array.
        return -1;
    }

    /**
     * Demonstrates the Binary Search implementation.
     */
    public static void main(String[] args) {

        // Binary Search requires the input array to be sorted.
        int[] numbers = { 3, 7, 12, 18, 24, 31, 39, 45, 52, 60 };

        int target = 31;

        // Run Binary Search and store the returned index.
        int result = binarySearch(numbers, target);

        // Display whether the target was found.
        if (result != -1) {
            System.out.println("Target " + target + " found at index: " + result);
        } else {
            System.out.println("Target " + target + " was not found in the array.");
        }

        // Try a value that is not present in the array.
        int missingTarget = 20;
        int missingResult = binarySearch(numbers, missingTarget);

        if (missingResult != -1) {
            System.out.println("Target " + missingTarget + " found at index: " + missingResult);
        } else {
            System.out.println("Target " + missingTarget + " was not found in the array.");
        }
    }
}
