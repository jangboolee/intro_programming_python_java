package arrayandarraylist;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

/**
 * Class with methods for working with and manipulating Arrays and ArrayLists. 
 */
public class ArrayAndArrayList {

	/**
	 * Counts the number of occurrences of the given element in the given array.
	 * 
	 * Example(s):
     * - For a defined array: int[] array = {1, 3, 5, 7, 9, 1, 2, 3, 4, 5};
     * - Calling howMany(array, 1) would return 2
     * - Calling howMany(array, 10) would return 0
     * 
     * - For a defined array: int[] array = new int[0];
     * - Calling howMany(array, 1) would return 0
     * 
	 * @param array to search
	 * @param element to search for
	 * @return number of times element is in array
	 */
	public int howMany(int[] array, int element) {
		
		// Create a counter
		int count = 0;
		
		// Loop through each element in the array
		for (int i : array) {
			// Increment counter if the element equals the provided elemnet
			if (i == element) {
				count += 1;
			}
		}
		return count;
	}
	
	/**
	 * Finds the max number in the given array.
	 * If the array is empty, returns -1.
	 * 
	 * Example(s):
     * - For a defined array: int[] array = {1, 3, 5, 7, 9, 1, 2, 3, 4, 5};
     * - Calling findMax(array) would return 9
	 * 
	 * - For a defined array: int[] array = {2, 4, 8, 12, 12, 4};
     * - Calling findMax(array) would return 12
     * 
     * - For a defined array: int[] array = new int[0];
     * - Calling findMax(array) would return -1
     * 
	 * @param array to search
	 * @return max number in array
	 */
	public int findMax(int[] array) {
		
		if (array.length == 0) {
			return -1;
		}
		else {
			// Temporarily set maxVal as the first value of the array
			int maxVal = array[0];
			
			// Loop through array and set maxVal as the largest value in the array
			for (int i : array) {
				if (i > maxVal) {
					maxVal = i;
				}
			}
			return maxVal;
		}
	}
	
	/**
	 * Keeps track of every occurrence of the max number in the given array.
	 * Returns an ArrayList that contains every occurrence of the max number.
	 * Uses the findMax(int[] array) method.
	 * If the array is empty, returns null.
	 * 
	 * Example(s):
     * - For a defined array: int[] array = {1, 3, 5, 7, 9, 1, 2, 3, 4, 5};
     * - Calling maxArray(array) would return an ArrayList containing 9
     * 
     * - For a defined array: int[] array = {2, 4, 8, 12, 12, 4};
     * - Calling maxArray(array) would return an ArrayList containing 12 and 12
     * 
     * - For a defined array: int[] array = new int[0];
     * - Calling maxArray(array) would return null
     * 
	 * @param array to search
	 * @return ArrayList containing every instance of the max
	 */
	public ArrayList<Integer> maxArray(int[] array) {
		
		if (array.length == 0) {
			return null;
		}
		else {
			// Find maximum value with findMax method
			int maxVal = this.findMax(array);
			// Initialize ArrayList
			ArrayList<Integer> maxValues = new ArrayList<>();
			// Loop through array and add instances of maxVal to the ArrayList maxValues
			for (int i : array) {
				if (i == maxVal) {
					maxValues.add(i);
				}
			}
			return maxValues;
		}
	}
	
	/**
	 * Puts all of the zeros in the given array, at the end of the given array.
	 * Updates the array itself.
	 * Maintains the order of the non-zeros.
	 * 
	 * Example(s):
     * - For a defined array: int[] array = {0, 1, 0, 2, 0, 3, 0, 5};
     * - Calling swapZero(array) would change the array to be: {1, 2, 3, 5, 0, 0, 0, 0};
     * 
     * - For a defined array: int[] array = {1, 3, 5, 7, 9, 10};
     * - Calling swapZero(array) wouldn't change the array, it would still be: {1, 3, 5, 7, 9, 10};
     * 
     * - For a defined array: int[] array = new int[0];
     * - Calling swapZero(array) wouldn't change the array, it would still be empty
     * 
	 * @param array to search for zeros
	 */
	public void swapZero(int[] array) {
		
		// Count instances of zero to remove
		int zeroCount = this.howMany(array, 0);
		
		// If zero is in the array
		if (zeroCount> 0) {
			// Create another array with the same length
			int[] tempArray = new int[array.length];
			// Copy the elements except the index of the 0
			// Loop through elements in array using indices
			for (int i=0, j=0; i < array.length; i++) {
				// If the index is for 0
				if (array[i] == 0) {
					// Don't add to the temp list
					continue;
				}
				// Add non zero items to the temporary array
				tempArray[j++] = array[i];
			}
		// Update the original array with the temporary array
		for (int i=0; i < array.length; i++) {
			array[i] = tempArray[i];
		}
		}
	}
}
