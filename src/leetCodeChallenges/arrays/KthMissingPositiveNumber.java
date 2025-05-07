package leetCodeChallenges.arrays;

/*
Link: https://leetcode.com/problems/kth-missing-positive-number/description/?envType=problem-list-v2&envId=array

Problem: Kth Missing Positive Number

Problem Description: Given a strictly increasing array of positive integers arr and an integer k, find the kth positive integer that is missing from the array.

Approach: Iterative (O(n) Time Complexity)

The core idea of this solution is to efficiently count how many positive integers are missing as we iterate through the given sorted array. Since the array is sorted, we can leverage the relationship between an element's value and its index to determine the count of missing numbers up to that point.

Core Idea / Key Observation:

For any element arr[i] at index i (0-based) in a sorted array of positive integers, the number of positive integers missing before or at the value arr[i] can be calculated as:

Number of missing positives <= arr[i] = arr[i] - (i + 1)

Why? If there were no missing positive integers, the array would look like [1, 2, 3, 4, ...]. In this ideal case, the element at index i would be i + 1. The difference between the actual value arr[i] and the expected value (i + 1) tells you how many numbers were "skipped" or are missing up to that point.
Step-by-Step Logic:

Initialize a loop to iterate through the array arr from index i = 0 to arr.length - 1.
Inside the loop, for each element arr[i], calculate the count of missing positive integers up to the value arr[i] using the formula: current_missing_count = arr[i] - (i + 1).
Check the stopping condition:
If current_missing_count < k: This means we haven't found the kth missing number yet. The kth missing number must be a value larger than arr[i]. Continue the loop to check the next element arr[i+1].
If current_missing_count >= k: This means we have found at least k missing positive integers by the time we reached the value arr[i]. The kth missing number must be a value less than or equal to arr[i]. We have found the segment where the kth missing number is located, so we can stop the loop here.
Calculate the result when stopping inside the loop:
When the condition arr[i] - (i + 1) >= k is met, we stop at index i.
We need the kth missing number overall.
First, find how many missing numbers occurred before the current element arr[i]. This count is the number of missing values up to arr[i-1], calculated as missing_count_before_i = arr[i-1] - ((i-1) + 1) (for i > 0). If i is 0, there are 0 missing numbers before arr[0].
The number of additional missing numbers we still need to find, starting from the value arr[i-1] + 1, is k - missing_count_before_i.
The kth missing number is the (k - missing_count_before_i)-th positive integer that comes after arr[i-1].
Its value is arr[i-1] + (k - missing_count_before_i).
An edge case is when i is 0 and arr[0] - (0+1) >= k. This means the missing numbers are 1, 2, ..., arr[0]-1. If k is less than or equal to this count (arr[0]-1), the kth missing number is simply k.
Handling the Edge Case (Answer After the Array):

If the loop finishes completely without the stopping condition (arr[i] - (i + 1) >= k) ever being met, it means that even after checking the last element arr[arr.length - 1], the total number of missing positive integers up to that value was still less than k.
This implies that the kth missing positive integer is a value greater than the last element arr[arr.length - 1].
The total number of missing positive integers within the array (up to the value of arr[arr.length - 1]) is arr[arr.length - 1] - (arr.length - 1 + 1), which simplifies to arr[arr.length - 1] - arr.length.
You need the kth missing number. You've found arr[arr.length - 1] - arr.length missing numbers within the array.
You still need k - (arr[arr.length - 1] - arr.length) more missing numbers. These come sequentially after arr[arr.length - 1].
The mth positive integer after arr[arr.length - 1] is arr[arr.length - 1] + m.
So, the kth missing number (which is the k - (arr[arr.length - 1] - arr.length)-th positive integer after the last element) is arr[arr.length - 1] + (k - (arr[arr.length - 1] - arr.length)).
This simplifies neatly to k + arr.length.
Time Complexity: O(n) because in the worst case, we iterate through the entire array once.
Space Complexity: O(1) because we only use a few extra variables regardless of the input size.
 */
public class KthMissingPositiveNumber {
    public static int findMissingPositiveNumber(int[] arr, int k) {
        for (int i = 0; i < arr.length; i++) {
            int current_missing_number = arr[i] - (i + 1);
            if (current_missing_number >= k) {
                if (i == 0) {
                    return k;
                } else {
                    int missing_before_count = arr[i - 1] - ((i - 1) + 1);
                    return arr[i - 1] + (k - missing_before_count);
                }
            }
        }

        return arr[arr.length - 1] + (k - (arr[arr.length - 1] - ((arr.length - 1) + 1)));
    }
}
