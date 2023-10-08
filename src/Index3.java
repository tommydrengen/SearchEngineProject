import java.io.*;
import java.util.Scanner;

class Index3 {

    WikiItem start, startDoc, tmpDoc, currentDoc;
    WikiItem startDistinct, currentDistinct, tmpDistinct;
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
        WikiItem startDoc;
        ReturnItem  next;

        ReturnItem(String str, WikiItem startDocument, ReturnItem n) {
            searchstr  = str;
            startDoc = startDocument;
            next = n;
        }
    }

    public Index3(String filename) {
        String word , wordDistinct;
        WikiItem current, tmp;
        try {
            Scanner input = new Scanner(new File(filename), "UTF-8");
            word = input.next();
            start = new WikiItem(word, null);
            this.start = start;
            current = start;
            while (input.hasNext()) {   // Read all words in input
                word = input.next();
//***                System.out.println(word);
                tmp = new WikiItem(word, null);
                current.next = tmp;
                current = tmp;
            }
            input.close();

        } catch (FileNotFoundException e) {
            System.out.println("Error reading file " + filename);
        }

        try {
            Scanner input = new Scanner(new File(filename), "UTF-8");
            wordDistinct = input.next();
            startDistinct = new WikiItem(wordDistinct, null);
            this.startDistinct = startDistinct;
            currentDistinct = startDistinct;
            while (input.hasNext()) {   // Read all words in input
                wordDistinct= input.next();
                if (!search1(wordDistinct)){
                    tmpDistinct = new WikiItem(wordDistinct, null);
                    currentDistinct.next = tmpDistinct;
                    currentDistinct = tmpDistinct;
                }
            }
            input.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error reading file " + filename);
        }
        // proeve kald search2 med alle ord i startDistinct
        startReturnItem = search3(startDistinct.str);




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


    public boolean search1(String searchstr) {
        WikiItem current = this.startDistinct;
        while (current != null) {
            if (current.str.equals(searchstr)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }



    public ReturnItem search2(String searchstr) {
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



        //displayWikiList(startDoc);
        returnString ="";
        //return exists;
        return startReturnItem;
    }

    public ReturnItem search3(String searchstr){
        currentDistinct = startDistinct;
        while (currentDistinct != null){
            search2(currentDistinct.str);
            currentDistinct = currentDistinct.next;
        }
        skrivTilFil(start,"WikiItemLstEjDistinct");
        skrivTilFil(startDistinct,"../files/Words.txt");
        if(startReturnItem != null){
            if(startReturnItem.startDoc != null){
                skrivReturnItemTilFil(startReturnItem);
            }
        }
        return startReturnItem;
    }

    public ReturnItem search4(String searchstr){
        String word;
        currentReturnItem = startReturnItem;
        while (currentReturnItem != null){
            if(currentReturnItem.searchstr.equals(searchstr)){
                System.out.println(currentReturnItem.searchstr);
                System.out.println(currentReturnItem.startDoc);

                return currentReturnItem;
            }
            currentReturnItem = currentReturnItem.next;
        }
        return new ReturnItem("",new WikiItem("",null),null);
    }

    public static void main(String[] args) {
        System.out.println("Preprocessing " + args[0]);
        Index3 i = new Index3(args[0]);
        //i.displayWikiList(i.start);
        //for each word in start, call search

        Scanner console = new Scanner(System.in);
        for (;;) {
            System.out.println("Input search string or type exit to stop");
            String searchstr = console.nextLine();
            if (searchstr.equals("exit")) {
                break;
            }
            if (i.search(searchstr)) {
                System.out.println(searchstr + " exists in startDoc: ");
                ReturnItem returnItem = i.search4(searchstr);
                System.out.println(returnItem.searchstr);
                i.displayWikiList(returnItem.startDoc);
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

    public void skrivTilFil(WikiItem head, String filnavn){
        try{
            PrintWriter writer = new PrintWriter(filnavn);
            //PrintWriter writer = new PrintWriter("../files/ReturnItem.txt");
            WikiItem current = head;
            while (current != null) {
                writer.println("current object'et: " +
                        String.format("%25s", current)  +
                        "  current.str: " + String.format("%40s", current.str) +
                        " current.next:  " + current.next );current= current.next;
            }
            writer.close();
        } catch (FileNotFoundException e){System.out.println("file not found");}
    }

    public void skrivReturnItemTilFil(ReturnItem head){
        try {
            PrintWriter writer = new PrintWriter("../files/ReturnItem.txt");
            ReturnItem current = head;
            String printStr = "";
            while (current != null) {
                printStr += "current object'et: " +
                        String.format("%25s", current) +
                        "  current.searchstr: " + String.format("%40s", current.searchstr);

                // Check if startDoc is not null before accessing its str property
                if (current.startDoc != null) {
                    printStr += "  current.startDoc: " + String.format("%40s", current.startDoc.str);
                } else {
                    printStr += "  current.startDoc: <null>"; // Handle null case
                }

                printStr += " current.next:  " + current.next + "\n";
                current = current.next;
            }
            writer.print(printStr);
            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }
}