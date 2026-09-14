
/**
 * Unit5Project
 *
 * This program demonstrates how searching algorithms can be used
 * in a student score lookup tool. The program allows a teacher or
 * administrator to search for a specific student score using either
 * linear search or binary search.
 *
 * Concepts Demonstrated:
 * - Linear Search
 * - Binary Search
 * - Arrays
 * - Algorithm Efficiency
 *
 * Author: DAVID WOODS

 */
public class Unit5Project {

    public int linearSearch(int[] scores, int targetScore) {
        // Linear search has, funnily enough, a linear efficiency O(N)
        // Loop through each score in the scores array
        for (int s = 0; s < scores.length; s++) {
        // Check whether the current score matches targetScore
            if (scores[s] == targetScore){
        // Return the index where the score is found
                return s;
            }
        }
        // Return -1 if the target score is not found
        return -1;
    }

    public int binarySearch(int[] scores, int targetScore) {
        // Binary search has, a base 2 (binary) logarithmic efficiency O(log2(N))
        // Implement binary search for a sorted scores array
        int high = scores.length -1; // establish low and high indices
        int low = 0;

        while (low <= high){ // loop until the list is complete or a match is found
            int mid = (high + low) / 2;
            if (scores[mid] == targetScore){ // match is found
                return mid;
            } else if (targetScore < scores[mid]) { // reassign indices
                high = mid - 1;
            }else if (targetScore > scores[mid]) { // reassign indices
                low = mid + 1;
            }
        }

        return -1; // match not found
    }

    public void printConceptualAnalysis() {
        System.out.println("Conceptual Analysis:");
        System.out.println("- Linear search checks each student score one at a time.");
        System.out.println("- Binary search requires a sorted list of student scores.");
        System.out.println("- Binary search is more efficient for large sorted datasets.");
    }

    public static void main(String[] args) {

        // Create the application object
        Unit5Project app = new Unit5Project();

        // Create a sorted array of student scores
        int[] studentScores = {55, 67, 72, 81, 90, 95};

        // Target score to search for
        int targetScore = 81;

        // Run linear search
        int linearResult = app.linearSearch(studentScores, targetScore);

        // Display linear search results
        if (linearResult != -1) {
            System.out.println("Linear Search:");
            System.out.println("Score " + targetScore
                    + " found at index " + linearResult);
        } else {
            System.out.println("Linear Search:");
            System.out.println("Score not found.");
        }

        System.out.println();

        // Run binary search
        int binaryResult = app.binarySearch(studentScores, targetScore);

        // Display binary search results
        if (binaryResult != -1) {
            System.out.println("Binary Search:");
            System.out.println("Score " + targetScore
                    + " found at index " + binaryResult);
        } else {
            System.out.println("Binary Search:");
            System.out.println("Score not found.");
        }

        System.out.println();

        // Print conceptual analysis
        app.printConceptualAnalysis();
    }
}