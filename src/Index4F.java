import java.io.*;
import java.util.Scanner;

class Index4F {

    WikiItem start, startDoc, tmpDoc, currentDoc;
    WikiItem startDistinct, currentDistinct, tmpDistinct;
    ReturnItem startReturnItem, currentReturnItem, tmpReturnItem;
    HashTable ht;


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

    public class HashTable{
        private static final int TABLE_SIZE = 10;
        private class Row{
            int key;
            ReturnItem value;

            public Row(int key, ReturnItem value){
                this.key = key;
                this.value = value;
            }
        }
        Row[] rows;

        public void initHashTable(){
            rows = new Row[TABLE_SIZE];
            tmpReturnItem = startReturnItem;
            // System.out.println("fra initHashTable() startReturnItem:  " + this.startReturnItem);
            int tael_1 = 0;
            while (tmpReturnItem.next != null){   // tmpReturnItem.next ??
                // **while  (tmpReturnItem != null &&  tael_1 < 55){
                tael_1 = tael_1 + 1;
                tmpReturnItem = tmpReturnItem.next;
                this.insert(tmpReturnItem);
                System.out.println("fra initHashTable() tmpReturnItem:  " + tmpReturnItem  );
            }
            //**for(int i=1;i<10;i++){rows[i].key= i;}
            //System.out.println("rows :" + rows );
        }


        public void displayHashTable(HashTable ht){
            for(int i=0; i<10;i++) {
                System.out.println("ht.rows("+ i + ")  " + ht.rows[i] + "   length of linked list: " + returnItemListSize(ht.rows[i].value))  ;
            }
// System.out.println("ht.rows("+ 3 + ")  " + ht.rows[3] + "  value.searchstr: " + ht.rows[3].value.searchstr  + "  value.next: " + ht.rows[3].value.next  );
        }


        void insert(ReturnItem returnItem){
            int index = hash(returnItem.searchstr);
            System.out.println("fra insert, rows["+index+ "]: " + rows[index] + "  index: " + index   );
            ReturnItem currentRI = returnItem;

            //while (currentRI != null){
            if(rows[index] == null){  // rows[hash(rit)] i stedet for rows[8]
                System.out.println("hello fra insert if , rows["+index+ "]: " + rows[index] );
                rows[index] = new Row(index, returnItem);
                System.out.println("hello fra insert efter indsæt , rows["+index+ "].value: " + rows[index].value );
            }
            else{
                System.out.println("hello fra insert else, index er nu: " + index );
                System.out.println("hello fra insert else, value i rows["+index+"] er: " + rows[index].value );
                // find sidste item i listen under rows[index].value
/*            ReturnItem item, crItm ; item = rows[index].value; crItm = item;
            while(item.next != null){crItm = item.next;
              item = item.next;
            crItm = item;} */
                //System.out.println("fra else: crItm: " + crItm + "   crItm.next: " + crItm.next  );
                //System.out.println("rows["+index+ "]: " + rows[index] + "  crItm: " + crItm );
                //while (currentRI.next != null){
//            System.out.println("hello fra insert else ,crItm: " + crItm + "  index: " +index);
//                crItm.next = returnItem;
            }
        }




        ReturnItem get(String searchstr){
            int index = hash(searchstr);
            System.out.println( "fra get: " + searchstr + " hash value: " + index);
            ReturnItem row = rows[hash(searchstr)].value;
            while (row.searchstr != searchstr){
                row = row.next;
            }
            return row;
        }

        int hash(String s) {
            int hash = 7;
            for (int i = 0; i < s.length(); i++) {
                hash = hash * 31 + s.charAt(i);
            }
            hash =  Math.abs(hash) % TABLE_SIZE;
            int index = hash % TABLE_SIZE;
            return index;
        }
    }



    public Index4F(String filename) {
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
                System.out.println(word);
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
        this.ht = new HashTable();
//**        this.ht.initHashTable();
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
        //System.out.println("ReturnString:  \n" + returnString);

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
        returnString ="";
        return startReturnItem;
    }

    public ReturnItem search3(){ // make all ReturnItems
        currentDistinct = startDistinct;
        while (currentDistinct != null){
            search2(currentDistinct.str);
            currentDistinct = currentDistinct.next;
        }
        //skrivTilFil(start,"WikiItemLstEjDistinct");
        skrivTilFil(startDistinct,"Words.txt");
        if(startReturnItem != null){
            if(startReturnItem.startDoc != null){
                skrivReturnItemTilFil(startReturnItem);
            }
        }
        this.startReturnItem = startReturnItem;
        return startReturnItem;
    }

    public ReturnItem search4(String searchstr){
        String word;
        currentReturnItem = startReturnItem;
        while (currentReturnItem != null){
            if(currentReturnItem.searchstr.equals(searchstr)){
                System.out.println("Documents containing the search string \" " + currentReturnItem.searchstr + "\": ");
                System.out.println();
                currentDoc = currentReturnItem.startDoc;
                while (currentDoc!=null){
                    currentDoc = currentDoc.next;
                }
                return currentReturnItem;
            }
            currentReturnItem = currentReturnItem.next;
        }
        return new ReturnItem("",new WikiItem("",null),null);
    }

    public static void main(String[] args) {
        System.out.println("Preprocessing " + args[0]);
        Index4F i = new Index4F(args[0]);
        i.search3(); //make all ReturnItems
        i.ht.initHashTable();
        System.out.println(" size af i.ht.rows[3] :  " + i.returnItemListSize(i.ht.rows[3].value));
//**        i.ht.insert(i.startReturnItem);
        i.ht.displayHashTable(i.ht);
        System.out.println("fra main() startReturnItem:  " + i.startReturnItem);
//**        i.displayReturnItemList(i.ht.rows[3].value);


        Scanner console = new Scanner(System.in);
        for (;;) {
            System.out.println("Input search string or type exit to stop");
            String searchstr = console.nextLine();
            if (searchstr.equals("exit")) {
                break;
            }
            if (i.search(searchstr)) {
                //System.out.println(searchstr + " exists in startDoc: ");
                ReturnItem returnItem = i.search4(searchstr);
//*                ReturnItem returnItem2 = i.ht.get(searchstr); //nyt hashtable
//*                System.out.println(returnItem2.searchstr);
                //*               i.displayWikiList(returnItem2.startDoc);
            } else {
                System.out.println(searchstr + " does not exist");
            }
        }
        console.close();
    }


    public void displayReturnItemList(ReturnItem head){
        int tal = 0;
        ReturnItem current = head;
        while (current != null){
            tal = tal +1; if(tal > 2889){break;}
//**            System.out.println("   " + tal + " : " + current.searchstr);
            System.out.println("   " + tal + " : " + current + "  searchstr: " + current.searchstr + "  startDoc" + current.startDoc + "   next: " + current.next);
            current = current.next;}

    }


    public int returnItemListSize(ReturnItem head){
        int tal = 0;
        ReturnItem current = head;
        while (current != null){
            tal = tal +1;
            current = current.next;}
        return tal;
    }


    public void displayWikiList(WikiItem head){
        int tal = 0;
        WikiItem current = head;
        while (current != null){
            tal = tal +1; if(tal > 2889){break;}
            System.out.println("   " + tal + " : " + current.str);
            current = current.next;}

    }

    public void skrivTilFil(WikiItem head, String filnavn){
        try{
            PrintWriter writer = new PrintWriter(filnavn);
            //PrintWriter writer = new PrintWriter("ReturnItem.txt");
            WikiItem current = head;
            while (current != null) {
                writer.println("current object'et: " +
                        String.format("%25s", current)  +
                        "  current.str: " + String.format("%40s", current.str) +
                        " current.next:  " + current.next );
                current= current.next;
            }
            writer.close();
        } catch (FileNotFoundException e){System.out.println("file not found");}
    }

    public void skrivReturnItemTilFil(ReturnItem head){
        try {
            PrintWriter writer = new PrintWriter("ReturnItem.txt");
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
