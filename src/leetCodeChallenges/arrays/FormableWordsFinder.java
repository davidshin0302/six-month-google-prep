package leetCodeChallenges.arrays;

import java.util.HashMap;
import java.util.Map;

/*
Link: https://leetcode.com/problems/find-words-that-can-be-formed-by-characters/?envType=problem-list-v2&envId=array

The key constraint is that each character from chars can be used at most once per word. This means we need to check
if the count of each specific character required by a word is less than or equal to the count of that same character available
in the chars string. Frequency counting is an efficient way to track character availability and requirements.

Time Complexity: O(L1 + L2), where L1 is the total number of characters across all words in words,
and L2 is the total number of characters in chars. (More precisely, O(Sum of lengths of all words + length of chars)).
 We iterate through chars once, and then for each word, we iterate through its characters and perform constant-time operations
 (array/map lookups).

Space Complexity: O(1), because the space used for frequency counting
(an array of size 26 or a HashMap with at most 26 entries) is constant, regardless of the input string lengths.



 */
public class FormableWordsFinder {
    public static int formableWordFinder(String[] words, String chars) {
        Map<Character, Integer> countWord = new HashMap<>();
        int output = 0;

        for (char c : chars.toCharArray()) {
            int count = countWord.getOrDefault(c, 0);
            countWord.put(c, count + 1);
        }

        for (String word : words) {
            Map<Character, Integer> map = new HashMap<>(countWord);
            if (countFrequency(word, map)) {
                output = output + word.length();
            }
        }
        return output;
    }

    public static boolean countFrequency(String word, Map<Character, Integer> map) {
        boolean isFormable = false;

        for (char c : word.toCharArray()) {
            if (map.get(c) != null && map.get(c) > 0) {
                int count = map.get(c);
                count--;

                map.put(c, count);
                isFormable = true;
            } else {
                isFormable = false;
                break;
            }
        }
        return isFormable;
    }
}
