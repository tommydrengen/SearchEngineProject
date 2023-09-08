import java.io.*;
import java.util.Scanner;

class Index2 {

    int occurences = 0;  // Obs!!
    public final String [] fileNames = {
            "../files/testFile1.txt", "../files/testFile2.txt"
            /*"../files/WestburyLab.wikicorp.201004.txt",
            "../files/WestburyLab.wikicorp.201004_1MB.txt",
            "../files/WestburyLab.wikicorp.201004_2MB.txt",
            "../files/WestburyLab.wikicorp.201004_5MB.txt",
            "../files/WestburyLab.wikicorp.201004_10MB.txt",
            "../files/WestburyLab.wikicorp.201004_20MB.txt",
            "../files/WestburyLab.wikicorp.201004_50MB.txt",
            "../files/WestburyLab.wikicorp.201004_100KB.txt",
            "../files/WestburyLab.wikicorp.201004_100MB.txt",
            "../files/WestburyLab.wikicorp.201004_200MB.txt",
            "../files/WestburyLab.wikicorp.201004_400MB.txt",
            "../files/WestburyLab.wikicorp.201004_800MB.txt"*/
    };

    WikiItem start;

    private class WikiItem {
        String str;
        WikiItem next;

        WikiItem(String s, WikiItem n) {
            str = s;
            next = n;
        }
    }

    public Index2(String filename) {
        String word;
        WikiItem current, tmp;
        try {
            Scanner input = new Scanner(new File(filename), "UTF-8");
            word = input.next();
            start = new WikiItem(word, null);
            current = start;
            while (input.hasNext()) {   // Read all words in input
                word = input.next();
                System.out.println(word);
                tmp = new WikiItem(word, null);
                current.next = tmp;
                current = tmp;
            }
            input.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error reading file " + filename);
        }
    }

    public boolean search(String searchstr) {
        WikiItem current = start;
        while (current != null) {
            if (current.str.equals(searchstr)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

 //   public String searchFiles(String searchstr){
    //  }

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        for (;;) {
            System.out.println("Input search string or type exit to stop");
            String searchstr = console.nextLine();
            if (searchstr.equals("exit")) {
                break;
            }
            Index2 i = new Index2("");
            for(int j = 0; j < i.fileNames.length; j++){
                System.out.println("Preprocessing " + i.fileNames[j]);
                i = new Index2(i.fileNames[j]);



                if (i.search(searchstr)) {
                    System.out.println(searchstr + " exists in " + i.fileNames[j]);
                } else {
                    System.out.println(searchstr + " does not exist in " + i.fileNames[j]);
                }

            }

        }
        console.close();
    }
}