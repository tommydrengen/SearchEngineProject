public class HT {

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

    /*public HashTable(){
    this.start = new WikiItem("strng" , null);
    this.startReturnItem = new ReturnItem("en mere streng",this.start , null);
    System.out.println("this.start fra constructor: " + this.start.str);
    System.out.println("this.startReturnItem fra constructor startDoc: " + this.startReturnItem.startDoc);
    System.out.println("hej fra constructori! " );
    }*/

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

    private class HashTable{
        ReturnItem[] table;
        int TABLE_SIZE = 10;

        int hash(String s) {
            int hash = 7;
            for (int i = 0; i < s.length(); i++) {
                hash = hash * 31 + s.charAt(i);
            }
            return Math.abs(hash) % TABLE_SIZE;
        }


        HashTable(){
            this.table = new ReturnItem[TABLE_SIZE];
        /*ReturnItem currentReturnItem = startReturnItem;
        while (currentReturnItem != null){
            this.insert(currentReturnItem);
            currentReturnItem = currentReturnItem.next;
        }
        System.out.println("This table " + this.table);
        for ( int i = 0; i<TABLE_SIZE; i++){
            System.out.println("Table index " + i + ": " + table[i]);
        }*/
        }
        void insert(ReturnItem returnItem){
            int hashValue = hash(returnItem.searchstr);
            if(table[hashValue] == null){
                table[hashValue] = returnItem;
            }
            else { // collision
                tmpReturnItem = table[hashValue];
                while (tmpReturnItem.next != null){
                    tmpReturnItem = tmpReturnItem.next;
                }
                tmpReturnItem.next = returnItem;
            }
        }
        ReturnItem get(String searchstr){
            int hashValue = hash(searchstr);
            currentReturnItem = this.table[hashValue];
            while (currentReturnItem != null){
                if (currentReturnItem.searchstr.equals(searchstr)){
                    return currentReturnItem;
                }
                currentReturnItem = currentReturnItem.next;
            }
            return null;
        }
        void displayHashTable(){
            for (int i = 0; i<TABLE_SIZE; i++) {
                // currentReturnItem = startReturnItem;
                currentReturnItem = table[i];
                while (currentReturnItem != null){
                    System.out.println("Hashtable table[ " + i + " ] : " + get(currentReturnItem.searchstr)); //this.table[i].searchstr);
                    currentReturnItem = currentReturnItem.next;
                }
            }
        }
    }


    public static void main(String[] args) {
        TestHashTable tht = new HashTable();
        System.out.println("Hash table: " + tht);
        System.out.println("Hash table start: " + tht.start );
        //tht.start = new WikiItem("streng" , null);
        //tht.ht.insert(new ReturnItem("a",new WikiItem("A Anarchism", null),null));
        //tht.ht.displayHashTable();

    }
}
