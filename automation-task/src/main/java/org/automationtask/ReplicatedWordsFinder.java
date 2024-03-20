package org.automationtask;

import java.util.LinkedHashMap;
import java.util.Map;

public class ReplicatedWordsFinder {

    public static void main(String[] args) {
        String text = "The enormous room on the ground floor faced towards the north. Cold for all the summer beyond the panes, for all the tropical heat of the room itself, a harsh thin light glared through the windows, hungrily seeking some draped lay figure, some pallid shape of academic gooseflesh, but finding only the glass and nickel and bleakly shining porcelain of a laboratory. Wintriness responded to wintriness. The overalls of the workers were white, their hands gloved with a pale corpse-colored rubber. The light was frozen, dead, a ghost. Only from the yellow barrels of the microscopes did it borrow a certain rich and living substance, lying along the polished tubes like butter, streak after luscious streak in long recession down the worktables.";

        // Splitting text into sentences using '.'
        String[] sentences = text.split("\\.");

        // LinkedHashMap to store word counts while preserving insertion order
        Map<String, Integer> wordCounts = new LinkedHashMap<>();

        // Iterating over sentences starting from the second sentence
        for (int i = 1; i < sentences.length; i++) {
            // Splitting sentence into lowcase words using any non-alphanumeric character as delimiters
            String[] words = sentences[i].trim().toLowerCase().split("[^a-zA-Z0-9]+");

            // Iterating over words using for-each
            for (String word : words) {
                // Ignoring empty strings
                if (!word.isEmpty()) {
                    // Counting word occurrences after converting to lowercase
                    wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
                }
            }
        }

        // Iterate over the list
        boolean hasDuplicates = false;
        for (Map.Entry<String, Integer> entry : wordCounts.entrySet()) {
            String word = entry.getKey();
            int count = entry.getValue();
            if (count > 1) {
                // Printing duplicate words and their counts
                System.out.println(word + ": " + count);
                hasDuplicates = true;
            }
        }

        // If no duplicates found, throw exception
        if (!hasDuplicates) {
            throw new RuntimeException("No repeated words");
        }
    }
}