import java.util.Arrays;
import java.util.Scanner;

/**
* The Binary Search program will populate an array of 10 random numbers.
* Then it will sort it from smallest to largest.
* Then it will ask the user for a number to search for.
* If the number is found, it will display the index of the number.
* It will keep asking the user for a number to search for,
* until the user enters "q".
* If the user enters "q", the program will display a goodbye message.
*
* @version 1.0
* @since 2025-03-27
*/

final class BinarySearch {

    /**
     * This is the array length.
     */
    public static final int ARRAY_LENGTH = 10;

    /**
     * This is the minimum number.
     */
    public static final int MAX_NUM = 100;

    /**
     * This is a private constructor used to satisfy the
     * style checker.
     *
     * @exception IllegalStateException Utility class.
     * @see IllegalStateException
    */
    private BinarySearch() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * This is the populating arrays method.
     *
     * @return array of random numbers
     */

    public static int[] populatingArrays() {

        // Create an array of numbers
        int[] arrayNum = new int[ARRAY_LENGTH];

        // Write a random number to the array of numbers
        // until 10 numbers have been added
        for (int counter = 0; counter < ARRAY_LENGTH; counter += 1) {

            // Add a random integer to the array, cast as an integer
            // The random integer is between 0 and 100
            arrayNum[counter] = (int) (Math.random() * (MAX_NUM + 1));
        }

        // Sort the array of numbers
        Arrays.sort(arrayNum);

        // return the sorted array of numbers
        return arrayNum;
    }

    /**
     * This is the binary search method.
     *
     * @param arrayInt array of integers
     * @param userNumInt the number that the user is searching for
     * @return index as an int
     */

    public static int binarySearch(final int[] arrayInt, final int userNumInt) {

        // Initialize low and high outside of the loop
        int low = 0;
        int high = arrayInt.length - 1;

        // Perform a binary search on the sorted array to find the user's number
        // loop until index is returned or the low is greater than the high
        while (low <= high) {

            // calculate the mid
            int mid = low + (high - low) / 2;

            // Check if user's number is equal to the mid
            if (arrayInt[mid] == userNumInt) {

                // return the index
                return mid;

            // If the user number is greater, ignore left half of array
            }  else if (arrayInt[mid] < userNumInt) {
                // reset the low
                low = mid + 1;

            // If the user's number is smaller, ignore right half of array
            }  else {
                // reset the high
                high = mid - 1;
            }
        }

        // If we reach here, then the user's number is not found in the array
        return -1;
    }

    /**
     * This is the main method.
     *
     * @param args Unused.
     */

    public static void main(final String[] args) throws Exception {

        // Using Scanner for getting input from user
        Scanner scanner = new Scanner(System.in);

        // Greeting
        System.out.println("Welcome to the linear search program!");

        // initialize userNum outside the loop
        String userNum = "";

        // Initialize userNumInt
        int userNumInt = 0;

        // Keep looping until the user enters "q"
        do {

            // Get the sorted array by calling the populating arrays function
            int[] arrayNumber = populatingArrays();

            // Instructions
            System.out.print(
                "What number are you searching for in the list below? "
                );
            System.out.println("Enter 'q' to quit.");

            // Display the array
            for (int num : arrayNumber) {
                // Display each number, separated by a space
                System.out.print(num + " ");
            }

            // Ask the user what number they are searching for
            System.out.print("Number: ");

            // Get the user's number as a string
            userNum = scanner.nextLine();

            // If the user enters q
            if (userNum.equals("q")) {
                // Display goodbye message
                System.out.println("Thank you for playing!");
            } else {
                try {
                    // Convert the user's number to an integer
                    userNumInt = Integer.parseInt(userNum);

                    // Get the index of the user's number from function
                    int index = binarySearch(arrayNumber, userNumInt);

                    // if number is not found in array
                    if (index == -1) {
                        System.out.println(
                                userNumInt
                                + " is not in the array."
                        );
                    } else {
                        System.out.println(
                                userNumInt
                                + " is found at index "
                                + index + "."
                            );
                    }

                } catch (Exception Exception) {
                   // If the user does not enter a number
                    System.out.println(userNum + " is not an integer.");
                    System.out.println("Try again.");
                }
            }

        // Keep looping until the user enters "q"
        } while (!userNum.equals("q"));

        // Closing Scanner
        scanner.close();
    }
}
