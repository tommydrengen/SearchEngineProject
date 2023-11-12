import java.util.Scanner;
import java.io.*;

public class LongestWord {
    //https://stackoverflow.com/questions/28752858/how-to-find-longest-words-from-a-text-file-with-any-characters
    public static void main(String [ ] args) throws FileNotFoundException {
        new LongestWord().getLongestWords();
    }

    public String getLongestWords() throws FileNotFoundException {

        String longestWord = "";
        String current;
        Scanner scan = new Scanner(new File("../files/WestburyLab.wikicorp.201004_100kb.txt"));


        while (scan.hasNext()) {
            current = scan.next();
            if ((current.length() > longestWord.length()) && (!current.matches(".*\\d.*"))) {
                longestWord = current;
            }

        }
        System.out.println(longestWord + "length: " + longestWord.length());
        longestWord.replaceAll("[^a-zA-Z ]", "").split("\\s+");
        return longestWord;
    }

}