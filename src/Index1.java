import java.io.*;
import java.util.Scanner;

class Index1 {

    WikiItem start, startDoc, tmpDoc, currentDoc;
    ReturnItem startReturnItem, currentReturnItem, tmpReturnItem;


    private class WikiItem {
        String str;
        WikiItem next;

        WikiItem(String s, WikiItem n) {
            str = s;
            next = n;
        }
    }

    // klasse til at holde 3 felter
    private class ReturnItem{
        String      searchstr;
        WikiItem    startfile;
        ReturnItem  next;

        ReturnItem(String str, WikiItem ff, ReturnItem n) {
            searchstr  = str;
            startfile = ff;
            next = n;
        }
    }

    public Index1(String filename) {
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
        boolean exists = false;
        int occurences = 0;
        String documentName = start.str;
        String returnString = "";
        WikiItem current = start;
        // ReturnItem startReturnItem, currentReturnItem, tmpReturnItem;

        //documentName = current.str; // first document
        startDoc = null; // delete last search
        // startReturnItem = null;

        while (current != null) {
            if (current.str.equals(searchstr)) {
                occurences++;
                exists = true;
            }
            if (current.str.equals("---END.OF.DOCUMENT---")){
                if(occurences > 0){
                    returnString += documentName + ": " + occurences +"\n";
                    if (startDoc == null){
                        startDoc = new WikiItem(documentName,null);
                    }
                    else {
                        currentDoc = startDoc;
                        while (currentDoc.next != null){
                            currentDoc = currentDoc.next;
                        }
                        currentDoc.next = new WikiItem(documentName, null);
                        currentDoc = currentDoc.next;
                    }
                }
                if (current.next != null) {
                    documentName = "";
                    while (!current.str.endsWith(".")){
                        documentName += current.next.str + " "; // next document
                        current = current.next;
                    }
                }
                occurences = 0;
            }

            current = current.next;
        }
        System.out.println("ReturnString:  \n" + returnString);

        if (startReturnItem == null){
            startReturnItem = new ReturnItem(searchstr, startDoc, null);
        }
        else {
            currentReturnItem = startReturnItem;
            while (currentReturnItem.next != null){
                currentReturnItem = currentReturnItem.next;
            }
            currentReturnItem.next = new ReturnItem(searchstr, startDoc, null);
            currentReturnItem = currentReturnItem.next;
        }

        skrivTilFil(startDoc);
        skrivReturnItemTilFil(startReturnItem);
        //displayWikiList(startDoc);
        returnString ="";
        return exists;
    }

    public static void main(String[] args) {
        System.out.println("Preprocessing " + args[0]);
        Index1 i = new Index1(args[0]);
        //i.displayWikiList(i.start);
        //i.skrivTilFil(i.start);
        //for each word in start, call search

        Scanner console = new Scanner(System.in);
        for (;;) {
            System.out.println("Input search string or type exit to stop");
            String searchstr = console.nextLine();
            if (searchstr.equals("exit")) {
                break;
            }
            if (i.search(searchstr)) {
                System.out.println(searchstr + " exists");
            } else {
                System.out.println(searchstr + " does not exist");
            }
        }
        console.close();
    }


    public void displayWikiList(WikiItem head){
        int tal = 0;
        WikiItem current = head;
        while (current != null){
            tal = tal +1; if(tal > 2889){break;}
            System.out.println("   " + tal + "  ->" + current.str + "<-");
            current = current.next;}

    }

    public void skrivTilFil(WikiItem head){
        try{
            PrintWriter writer = new PrintWriter("../files/output.txt");
            WikiItem current = head;
            while (current != null) {
                writer.println("current object'et: " +
                        String.format("%25s", current)  +
                        "  current.str: " + String.format("%40s", current.str) +
                        " current.next:  " + current.next );current= current.next;
            }
            writer.close();
        } catch (FileNotFoundException e){System.out.println("fil ikke fundet");}
    }

    public void skrivReturnItemTilFil(ReturnItem head){
        try{
            PrintWriter writer = new PrintWriter("../files/ReturnItem.txt");
            ReturnItem current = head;
            String printStr = "";
            while (current != null) {
                printStr += "current object'et: " +
                        String.format("%25s", current)  +
                        "  current.str: " + String.format("%40s", current.searchstr) +
                        "  current.startFile: " + String.format("%40s", current.startfile.str) +
                        " current.next:  " + current.next;
                current= current.next;
            }
            writer.println(printStr);
            writer.close();
        } catch (FileNotFoundException e){System.out.println("fil ikke fundet");}
    }
}