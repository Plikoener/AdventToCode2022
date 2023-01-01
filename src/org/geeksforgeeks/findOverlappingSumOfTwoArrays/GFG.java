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
     * @param n sum of overlapped entries
     * @return
     */
//
    //
    public static int findSum(int A[], int B[], int n)
    {

        // unordered map to store count of 
        // elements
        HashMap<Integer, Integer> hash = new HashMap<>();

        // insert elements of A[] into
        // unordered_map
        for(int i = 0; i < n; i++)
        {
            if(!hash.containsKey(A[i]))
            {
                hash.put(A[i], 1);
            }
            else
            {
                hash.put(A[i], hash.get(A[i]) + 1);
            }
        }

        // insert elements of B[] into
        // unordered_map
        for(int i = 0; i < n; i++)
        {
            if(!hash.containsKey(B[i]))
            {
                hash.put(B[i], 1);
            }
            else
            {
                hash.put(B[i], hash.get(B[i]) + 1);
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
        int A[] = { 5, 4, 9, 2, 3 };
        int B[] = { 2, 8, 7, 6, 3 };

        // size of array
        int n = A.length;
        System.out.println(findSum(A, B, n));
    }
}

// This code is contributed by rag2127