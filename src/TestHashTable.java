public class TestHashTable {

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

    public TestHashTable(){
    this.start = new WikiItem("strng" , null);
    this.startReturnItem = new ReturnItem("en mere streng",this.start , null);
    System.out.println("start fra constructori! " );
    System.out.println("this.start fra constructor: " + this.start.str);
    System.out.println("this.startReturnItem fra constructor: " + this.startReturnItem.searchstr);
    HashTable ht = new HashTable();
        this.ht = new HashTable();
    ht.insert(this.startReturnItem);
    //***Row htr = new Row(null,null);
    System.out.println("ht: " + ht );
    System.out.println("ht.rows: " + ht.rows );
    System.out.println("ht.rows[0]: " + ht.rows[0] );
    System.out.println("slut fra constructori! "+ "\n" );
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
    private static final int TABLE_SIZE = 100;
    private class Row{
        int key;
        ReturnItem value;

        public Row(int key, ReturnItem value){
            this.key = key;
            this.value = value;
        }
    }
    Row[] rows;

    HashTable(){
        rows = new Row[TABLE_SIZE];
    //**for(int i=1;i<10;i++){rows[i].key= i;}
        System.out.println("rows :" + rows );
    }

    void insert(ReturnItem rit){
        if(rows[0] == null){
            rows[0] = new Row(0, rit);
            }
        else{
            tmpReturnItem = rows[0].value;
            while (tmpReturnItem.next != null){
                tmpReturnItem = tmpReturnItem.next;
            }
            tmpReturnItem.next = rit;
        }
    } 
 
    /*void insert(ReturnItem returnItem){
        int index = hash(returnItem.searchstr);
        if(rows[index] == null){
            rows[index] = returnItem;
        }
        else {
            tmpReturnItem = rows[index];
            while (tmpReturnItem.next != null){
                tmpReturnItem = tmpReturnItem.next;
            }
            tmpReturnItem.next = returnItem;
            tmpReturnItem = tmpReturnItem.next;
        }
    } */

    ReturnItem get(String searchstr){
        int index = hash(searchstr);
        ReturnItem row = rows[hash(searchstr)].value;
        while (row.searchstr != searchstr){
            row = row.next;
        }
        return row;
    }

    int hash(String str){
        int hashcode = 0;
        for( int j = 0; j < str.length(); j++){
            hashcode += (int) str.charAt(j); // ASCII-value of the char
        }
        int index = hashcode % TABLE_SIZE;
        return index;
    }
}
    public static void main(String[] args) {
        TestHashTable tht = new TestHashTable();
        System.out.println("tht fra main :" + tht);
        System.out.println("tht.start fra main :" + tht.start.str );
        System.out.println("tht.ht :" + tht.ht );
        System.out.println("ht.rows[0] key : " + ht.rows[0].key + "   value: " + ht.rows[0].value );
        /*for (int j = 0; j<tht.ht.rows.length;j++){
            //System.out.println("tht.ht.rows[j].key: " + tht.ht.rows[j].key);
            //System.out.println("tht.ht.rows[j].value: " + tht.ht.rows[j].value);
        }*/
        //tht.start = new WikiItem("streng" , null);
        //tht.ht.insert(new ReturnItem("a",new WikiItem("A Anarchism", null),null));
//        tht.ht.insert(tht.startReturnItem);
        //tht.ht.displayHashTable();

    }
}
