package leetCodeChallenges.arrays;

/*
Link: https://leetcode.com/problems/find-greatest-common-divisor-of-array/submissions/1628683891/?envType=problem-list-v2&envId=array

 */

public class GreatestCommonDivisor {
    public static int findGCD(int[] nums) {
        int smallest = nums[0];
        int largest = nums[nums.length - 1];

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < smallest) {
                smallest = nums[i];
            }
            if (nums[i] > largest) {
                largest = nums[i];
            }
        }

        int gcd = largest;

        while(gcd > 1) {
            if(smallest % gcd == 0 && largest % gcd == 0){
                break;
            }
            gcd--;
        }
        return gcd;
    }
}
