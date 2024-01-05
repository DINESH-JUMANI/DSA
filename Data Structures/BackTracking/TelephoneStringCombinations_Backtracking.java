package BackTracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TelephoneStringCombinations_Backtracking {
    private static void generateCombinations(String digits, int currentIndex, StringBuilder currentCombination, List<String> resultList, Map<Character, String> digitToLetters) {
        if (currentIndex == digits.length()) {
            resultList.add(currentCombination.toString());
            return;
        }

        char currentDigit = digits.charAt(currentIndex);
        String letterOptions = digitToLetters.get(currentDigit);

        if (letterOptions != null) {
            for (int i = 0; i < letterOptions.length(); i++) {
                char letter = letterOptions.charAt(i);
                currentCombination.append(letter);
                generateCombinations(digits, currentIndex + 1, currentCombination,resultList,digitToLetters);
                currentCombination.deleteCharAt(currentCombination.length() - 1);
            }
        }
    }
    public static void main(String[] args)
    {
        Map<Character, String> digitToLetters = new HashMap<>();
        List<String> resultList = new ArrayList<>();
        String digits = "23";

        digitToLetters.put('2', "abc");
        digitToLetters.put('3', "def");
        digitToLetters.put('4', "ghi");
        digitToLetters.put('5', "jkl");
        digitToLetters.put('6', "mno");
        digitToLetters.put('7', "pqrs");
        digitToLetters.put('8', "tuv");
        digitToLetters.put('9', "wxyz");

        generateCombinations(digits, 0, new StringBuilder(),resultList,digitToLetters);
        System.out.println(resultList);
    }

}
