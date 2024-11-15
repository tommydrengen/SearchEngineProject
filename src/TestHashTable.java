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
        System.out.println("this.start fra constructor: " + this.start);
        System.out.println("this.startReturnItem fra constructor: " + this.startReturnItem);
        HashTable ht = new HashTable();
        this.ht = new HashTable();
        ht.insert(this.startReturnItem);
        ht.insert(this.startReturnItem);
        //***Row htr = new Row(null,null);
        System.out.println("ht: " + ht );
        System.out.println("ht.rows: " + ht.rows );
        System.out.println("ht.rows[0]: " + ht.rows[0] );
        System.out.println("ht.rows[1]: " + ht.rows[1] );
        //System.out.println("ht.rows[0] key : " + ht.rows[0].key );
        tmpReturnItem = startReturnItem;
        while (tmpReturnItem != null){
            System.out.println("ht.rows[0] key : " + ht.rows[ht.hash(tmpReturnItem.searchstr)].key + "   value: " + ht.rows[ht.hash(System.out.println("ht.rows[0] key : " + ht.rows[ht.hash(this.startReturnItem.searchstr)].key + "   value: " + ht.rows[ht.hash(this.startReturnItem.searchstr)].value );
            System.out.println("ht.rows[0] key : " + ht.rows[ht.hash(this.startReturnItem.searchstr)].key + "   value.searchstr: " + ht.rows[ht.hash(this.startReturnItem.searchstr)].value.searchstr );
            System.out.println(" value.searchstr: " + ht.rows[ht.hash(this.startReturnItem.searchstr)].value.searchstr + "   ht.rows.value: " + ht.rows[currentReturnItem.searchstr].value;
            System.out.println("ht.rows[0] key : " + ht.rows[ht.hash(this.startReturnItem.searchstr)].key + "   value: " + ht.rows[ht.hash(this.startReturnItem.searchstr)].value );
            System.out.println("ht.rows[0] key : " + ht.rows[ht.hash(this.startReturnItem.searchstr)].key + "   value.searchstr: " + ht.rows[ht.hash(this.startReturnItem.searchstr)].value.searchstr );
            System.out.println(" value.searchstr: " + ht.rows[ht.hash(this.startReturnItem.searchstr)].value.searchstr + "   ht.rows.value.next: " + ht.rows[ht.hash(this.startReturnItem.searchstr)].value.next );
            ReturnItem tmpReturnItem = ht.get(this.startReturnItem.searchstr);
            System.out.println(tmpReturnItem);
            ReturnItem tmpReturnItem = ht.get(this.tmpReturnItem.searchstr);
            System.out.println(ht.get(tmpReturnItem.searchstr) );
            System.out.println("ht.rows[0] key : " + ht.rows[ht.hash(tmpReturnItem.searchstr)].key + "   value.searchstr: " + ht.rows[ht.hash(this.tmpReturnItem.searchstr)].value.searchstr );
            System.out.println(" value.searchstr: " + ht.rows[ht.hash(tmpReturnItem.searchstr)].value.searchstr + "   ht.rows.value.next: " + ht.rows[ht.hash(this.tmpReturnItem.searchstr)].value.next );
            ReturnItem tmpReturnItem = ht.get(this.tmpReturnItem.searchstr);
            System.out.println(tmpReturnItem);
        }

        System.out.println("slut fra constructor! "+ "\n" );
       /* System.out.println("fra ht.get(this.startReturnItem.searchstr);");
        System.out.println(ht.get(this.startReturnItem.searchstr));
        System.out.println("ht.get(this.startReturnItem.startDoc");
        System.out.println(ht.get(this.startReturnItem.startDoc.str));
        System.out.println("ht.get(this.startReturnItem.next.searchstr)");
        System.out.println(ht.get(this.startReturnItem.next.searchstr));
*/

        //System.out.println("ReturnItem fra get: tmpReturnItem.searchstr " + tmpReturnItem.searchstr  + "tmpReturnItem.startDoc" + tmpReturnItem.startDoc + "" + "tmpReturnItem.next" + tmpReturnItem.next);
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

        HashTable(){
            rows = new Row[TABLE_SIZE];
            //**for(int i=1;i<10;i++){rows[i].key= i;}
            System.out.println("rows :" + rows );
        }


        void insert(ReturnItem rit){
            int index = hash(rit.searchstr);
            System.out.println("fra insert ");
            if(rows[index] == null){  // hash(rit)
                rows[index] = new Row(index, rit);
            }
            else{
                tmpReturnItem = rows[index].value;
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
        Row currentRow = rows[index];
        System.out.println( "fra get: " + searchstr + " hash value: " + hash(searchstr));
        ReturnItem row = rows[index].value;
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
        System.out.println("tht.start fra main :" + tht.start );
        System.out.println("tht.ht :" + tht.ht );
        //tht.start = new WikiItem("streng" , null);
        //tht.ht.insert(new ReturnItem("a",new WikiItem("A Anarchism", null),null));
//        tht.ht.insert(tht.startReturnItem);
        //tht.ht.displayHashTable();

    }
}
