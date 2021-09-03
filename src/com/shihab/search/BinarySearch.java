package com.shihab.search;

public class BinarySearch {

    // Returns index of x if it is present in arr[],
    // else return -1
    public int binarySearch(int arr[], int desiredValue) {
        int leftPosition = 0, rightPosition = arr.length - 1, midPosition;
        while (leftPosition <= rightPosition) {
            midPosition = (leftPosition + rightPosition) / 2;

            // Check if x is present at mid
            if (arr[midPosition] == desiredValue)
                return midPosition;

            // If x greater, ignore left half

            if (arr[midPosition] < desiredValue)
                leftPosition = midPosition + 1;

                // If x is smaller, ignore right half
            else
                rightPosition = midPosition - 1;
        }

        // if we reach here, then element was
        // not present
        return -1;
    }

    public static void main(String[] args) {
        BinarySearch search= new BinarySearch();
        int arr[] = { 2, 3, 4, 10, 40 };
        int x = 40;
        int result = search.binarySearch(arr, x);
        if (result == -1)
            System.out.println("Element not present");
        else
            System.out.println("Element found at "
                    + "index " + result);
    }
}
