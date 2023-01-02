package org.geeksforgeeks.findOverlappingSumOfTwoArrays;
// Java program to find overlapping sum
/*
  Source from @see https://www.geeksforgeeks.org/find-the-overlapping-sum-of-two-arrays/
 */

import java.util.*;
public class GFG
{

    /**
     * Function for calculating
     * overlapping sum of two array
     * @param A first array
     * @param B secound array
     * @param n length of one sum - not longer used
     * @return sum of overlapped entries
     */
//
    //
    public static int findSum(int[] A, int[] B, @Deprecated int n)
    {

        // unordered map to store count of 
        // elements
        HashMap<Integer, Integer> hash = new HashMap<>();

        // insert elements of A[] into
        // unordered_map
        for (int j : A) {
            if (!hash.containsKey(j)) {
                hash.put(j, 1);
            } else {
                hash.put(j, hash.get(j) + 1);
            }
        }

        // insert elements of B[] into
        // unordered_map
        for (int j : B) {
            if (!hash.containsKey(j)) {
                hash.put(j, 1);
            } else {
                hash.put(j, hash.get(j) + 1);
            }
        }

        // calculate overlapped sum
        int sum = 0;
        for(int itr: hash.keySet())
        {
            if(hash.get(itr) == 2)
            {
                sum += itr * 2;
            }
        }
        return sum;
    }

    // Driver code
    public static void main (String[] args)
    {
        int[] A = { 5, 4, 9, 2, 3 };
        int[] B = { 2, 8, 7, 6, 3 };

        // size of array
        int n = A.length;
        System.out.println(findSum(A, B, n));
    }
}

// This code is contributed by rag2127