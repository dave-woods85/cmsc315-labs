import java.util.Arrays;

/**
 * Unit7Project
 *
 * Price sorter tool that demonstrates bubble sort and selection sort.
 *
 * You will practice:
 * - Sorting arrays of product prices
 * - Comparing sorting algorithms
 * - Swapping array values
 * - Testing sorted output with JUnit
 * Author: DAVID WOODS
 */

public class Unit7Project {

    public void bubbleSort(int[] prices) {

        // TODO 1: Store the length of the prices array

       int listLength = prices.length; // not sure why the 'to do' wanted this, but here it is
       boolean swap = true; // variable for stopping the search early
        // TODO 2: Use nested loops to compare neighboring prices
        // Iteration for looping through each index a number of times equal to the number of indices
        for (int i = 0; i < listLength; i++) {
            for (int j = 0; j < listLength - i - 1; j++) {
        // TODO 3: Swap prices when the left value is greater than the right value
                // Compare and swap
                if (prices[j] > prices[j + 1]) {
                    int tempItem = prices[j];
                    prices[j] = prices[j + 1];
                    prices[j + 1] = tempItem;
                    swap = true; // determine that a swap occurred during this sweep
                }
        // TODO 4: Stop early if no swaps occur during a full pass

                else{
                    swap = false; // trigger the early termination if no swaps happened on this sweep
                }
            }
            if (!swap){ // exit the loop if no swaps occurred during a full sweep
                break;
            }
        }

    }

    public void selectionSort(int[] prices) {

        // TODO 5: Use selection sort to find the lowest remaining price
        // and move it into the correct position
        if(prices != null && prices.length != 0) {

            int sortedEndIndex = 0;
            int lowValueIndex = 0;
            boolean swap = false;
            for (int i = 0; i < prices.length - 1; i++) { // Iterate through the whole array length - 1 time
                int lowValue = prices[sortedEndIndex]; // initiate first unsorted index as the low value
                // Find the next lowest value
                for (int j = prices.length - 1; j > sortedEndIndex + 1; j--) {
                    if (prices[j] < lowValue) {
                        lowValue = prices[j];
                        lowValueIndex = j;
                        swap = true; // boolean to perform swap
                    }
                }
                if (swap) { // swap next lowest value with the value that is being evaluated
                    int tempItem = prices[sortedEndIndex]; // current value at the index to put the lowest value
                    prices[sortedEndIndex] = lowValue; // swap the low value into that index
                    prices[lowValueIndex] = tempItem; // swap the value from the old index to where to low value came from
                    swap = false; // reset the swap
                }
                sortedEndIndex++; // move the end index up one

            }
        }
    }

    public int findLowestPrice(int[] prices) {

        // TODO 6: Return the lowest price in the array
        // If the array is empty, return -1
        if (prices == null || prices.length == 0) { // null/empty check
            return -1;
        }
        int lowestValue = prices[0]; // set variable to track the low value, starting with first element
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] < lowestValue) { // compare elements and track low value
                lowestValue = prices[i];
            }
        }
        return lowestValue; // return low value

    }

    public int findHighestPrice(int[] prices) {

        // TODO 7: Return the highest price in the array
        // If the array is empty, return -1
        if (prices == null || prices.length == 0) { // null/empty check
            return -1;
        }
        int highestValue = prices[0]; // set variable to track the high value, starting with first element
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] > highestValue) { // compare elements and track high value
                highestValue = prices[i];
            }
        }
        return highestValue; // return high value
    }

    public static void main(String[] args) {

        Unit7Project app = new Unit7Project();

        int[] prices = {42, 19, 88, 7, 31};
        app.bubbleSort(prices);
        System.out.println("Bubble sorted prices: " + Arrays.toString(prices));

        int[] morePrices = {42, 19, 88, 7, 31};
        app.selectionSort(morePrices);
        System.out.println("Selection sorted prices: " + Arrays.toString(morePrices));
    }
}