import java.io.*;
import java.util.Scanner;

class Index2 {

    int occurences = 0;  // Obs!!
    public final String [] fileNames = {
            "../files/testFile1.txt", "../files/testFile2.txt", "../files/testFile2.txt"
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
    // WikiItem startFile;
    WikiItem startMatchFile, tmpMatchFile;
    ReturnItem startReturnItem, tmpReturnItem;
    //    WikiItem matchFileStart;

    private class WikiItem {
        String str;
        WikiItem next;

        WikiItem(String s, WikiItem n) {
            str = s;
            next = n;
        }
    }

    private class ReturnItem{
        String searchstr;
        WikiItem startMatch;
        ReturnItem next;

        ReturnItem(String str, WikiItem match, ReturnItem nextItem){
            searchstr = str;
            startMatch = match;
            next = nextItem;
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
                // System.out.println(word);
                tmp = new WikiItem(word, null);
                current.next = tmp;
                current = tmp;
            }
            input.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error reading file " + filename);
            // e.printStackTrace();
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
    public void addMatchFileItem(String newFileName){
        WikiItem currentMatchFile = startMatchFile;
        if (this.startMatchFile == null) {
            this.startMatchFile = new WikiItem(newFileName, null);
        }
        else {
            tmpMatchFile = startMatchFile;

            while (tmpMatchFile.next != null) {   // Read all words in input
                tmpMatchFile = tmpMatchFile.next;
                tmpMatchFile = new WikiItem(newFileName, null);
                currentMatchFile.next = tmpMatchFile;
                currentMatchFile = tmpMatchFile;
            }
            tmpMatchFile.next = new WikiItem(newFileName, null);
        }
    }

    public void addReturnItem(String searchstr, WikiItem startMatchFile, ReturnItem next){
            ReturnItem currentReturnItem = startReturnItem;
            if (this.startReturnItem == null) {
                this.startReturnItem = new ReturnItem(searchstr, startMatchFile, null);
            }
            else {
                tmpReturnItem = new ReturnItem(searchstr, startMatchFile, null);
                while (currentReturnItem != null){
                    tmpReturnItem = tmpReturnItem.next;
                    currentReturnItem = tmpReturnItem;
                }
                //currentReturnItem = new ReturnItem(searchstr, startMatchFile, null);
                currentReturnItem = currentReturnItem;

            }
        }

    void displayWikiItemList(WikiItem startObj){
        WikiItem tmpWikiItem = startObj;
        while (tmpWikiItem != null){
            tmpWikiItem = tmpWikiItem.next;
            System.out.println("fra display metode : " + tmpWikiItem + "   streng:  " + tmpWikiItem.str );
        }
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
            Index2 i = new Index2("../files/testFile1.txt");
            for(int j = 0; j < i.fileNames.length; j++){
                // System.out.println("Preprocessing " + i.fileNames[j]);
                i = new Index2(i.fileNames[j]);

                if (i.search(searchstr)) {
                    System.out.println(searchstr + " exists in " + i.fileNames[j]);
                    // lav nyt WikiItem for fil med ordet

                    i.addMatchFileItem(i.fileNames[j]);
                    System.out.println("fra str+ " + i.startMatchFile);
                    System.out.println("fra next+ " + i.startMatchFile.next);
                    for (String f: i.fileNames) {
                        System.out.println(f);

                    }
                } else {
                    System.out.println(searchstr + " does not exist in " + i.fileNames[j]);
                }

            }
            //lav nyt ReturnItem
            i.addReturnItem(searchstr, i.startMatchFile, null);
            System.out.println("sogestreng " + i.startReturnItem.searchstr + " er i fil " +  i.startReturnItem.startMatch +" " + i.startReturnItem.next);

            //i.displayWikiItemList(i.startMatchFile.next);
            //i.displayWikiItemList(i.start);
        }
        console.close();
    }
}