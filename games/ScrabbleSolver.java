package games;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ScrabbleSolver {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Please enter the pool of letters:");
            String letters = scanner.nextLine().toUpperCase();
            Map<Character, Integer> lettersCountMap = getCharacterCountMap(letters);

            try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\kshitijsingh\\Downloads\\dict.txt"))) {
                System.out.println("All possible words you can make are:");
                String currentWord;
                while ((currentWord = reader.readLine()) != null) {
                    if (canFormWord(currentWord.toUpperCase(), lettersCountMap)) {
                        System.out.println(currentWord);
                    }
                }
            } catch (IOException e) {
                System.err.println("Error reading the dictionary file: " + e.getMessage());
            }
        }
    }

    private static boolean canFormWord(String currentWord, Map<Character, Integer> lettersCountMap) {
        Map<Character, Integer> currentWordMap = getCharacterCountMap(currentWord);
        for (Character ch : currentWordMap.keySet()) {
            int currentWordCharCount = currentWordMap.get(ch);
            int lettersCharCount = lettersCountMap.containsKey(ch) ? lettersCountMap.get(ch) : 0;
            if (currentWordCharCount > lettersCharCount) {
                return false;
            }
        }
        return true;
    }

    private static Map<Character, Integer> getCharacterCountMap(String letters) {
        Map<Character, Integer> countMap = new HashMap<>();
        for (int i = 0; i < letters.length(); i++) {
            char ch = letters.charAt(i);
            int count = countMap.containsKey(ch) ? countMap.get(ch) : 0;
            countMap.put(ch, count + 1);
        }
        return countMap;
    }
}
