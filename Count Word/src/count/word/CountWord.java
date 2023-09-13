package count.word;

import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

public class CountWord {

    HashMap<String, Integer> word = new HashMap<>();
    HashMap<Character, Integer> word1 = new HashMap<>();

    public String enterString() {
        Scanner sc = new Scanner(System.in);
        String input = null;
        while (input == null) {
            System.out.println("Enter String");
            input = sc.nextLine();
            if (!input.matches("[a-zA-Z ]+")) {
                System.out.println("Invalid input. Please enter a valid string.");
                input = null;
            }
        }
        return input;
    }

    public void countWords(String s) {
        StringTokenizer text = new StringTokenizer(s);
        while (text.hasMoreTokens()) {
            String words = text.nextToken().toLowerCase();
            if (word.containsKey(words)) {
                int count = word.get(words);
                word.put(words, count + 1);
            } else {
                word.put(words, 1);
            }
        }

        String result = s.replace(" ", "");
        for (int i = 0; i < result.length(); i++) {
            char character = result.charAt(i);
            if (word1.containsKey(character)) {
                int count = word1.get(character);
                word1.put(character, count + 1);
            } else {
                word1.put(character, 1);
            }
        }
    }

    public void disPlay() {
        System.out.println("Word Counter");
        for (String s : word.keySet()) {
            int count = word.get(s);
            System.out.println("[ " + s + " ]" + " = " + count);
        }
        System.out.println("Character Counter");
        for (Character a : word1.keySet()) {
            int count = word1.get(a);
            System.out.println("[ " + a + " ]" + " = " + count);
        }
    }

    public static void main(String[] args) {
        CountWord d = new CountWord();
        d.countWords(d.enterString());
        d.disPlay();
    }
}
