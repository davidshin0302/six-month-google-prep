package leetCodeChallenges.arrays;

import java.util.HashMap;
import java.util.Map;

public class FormableWordsFinder {
    public static int formableWordFinder(String[] words, String characters) {
        Map<Character, Integer> countWord = new HashMap<>();
        int output = 0;

        for (char c : characters.toCharArray()) {
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
