public class ReturnObject {
    String searchString;
    FileItem matchFileItem;
    ReturnObject next;

    public ReturnObject(String searchString,  FileItem matchFileItem, ReturnObject next){
        this.searchString = searchString;
        this.FileItem = matchFileItem;
        this.next = next;

    }
    add(){}
}