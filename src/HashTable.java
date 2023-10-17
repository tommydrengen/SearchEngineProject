public class HashTable {

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

    public HashTable(){
    this.start = new WikiItem("strng" , null);
    this.startReturnItem = new ReturnItem("en mere streng",this.start , null);
    System.out.println("this.start fra constructor: " + this.start.str);
    System.out.println("this.startReturnItem fra constructor startDoc: " + this.startReturnItem.startDoc);
    System.out.println("hej fra constructori! " );
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
        ReturnItem[] ht;

        int hash(String s){
            return (int) s.charAt(0)%10;
        }

        HashTable(){

            this.ht = new ReturnItem[10];
            ReturnItem currentReturnItem = startReturnItem;
            while (currentReturnItem != null){
                this.insert(currentReturnItem);
                currentReturnItem = currentReturnItem.next;
            }
            System.out.println("This table " + this.ht);
            for ( int i = 0; i<10; i++){
                System.out.println("Table index " + i + ": " + this.ht[i].searchstr);
            }
            this.insert(new ReturnItem("Anarchism",new WikiItem("Anarchism",null), null));
            this.displayHashTable();
        }
        void insert(ReturnItem returnItem){
            int hashValue = hash(returnItem.searchstr);
            if(ht[hashValue] == null){
                ht[hashValue] = returnItem;
            }
            else {
                tmpReturnItem = ht[hashValue];
                while (tmpReturnItem.next != null){
                    tmpReturnItem = tmpReturnItem.next;
                }
                tmpReturnItem.next = returnItem;
            }
        }
        ReturnItem get(String searchstr){
            int hashValue = hash(searchstr);
            currentReturnItem = this.ht[hashValue];
            while (currentReturnItem != null){
                if (currentReturnItem.searchstr.equals(searchstr)){
                    return currentReturnItem;
                }
                currentReturnItem = currentReturnItem.next;
            }
            return null;
        }
        void displayHashTable(){
            for (int i = 0; i<10; i++) {
                // currentReturnItem = startReturnItem;
                currentReturnItem = ht[i];
                while (currentReturnItem != null){
                    System.out.println("Hashtable h[ " + i + " ] : " + get(currentReturnItem.searchstr)); //this.ht[i].searchstr);
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
