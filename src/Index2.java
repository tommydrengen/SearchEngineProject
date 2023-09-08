import java.io.*;
import java.util.Scanner;

class Index2 {

    WikiItem start;
    WikiItem startFile;


    private class WikiItem {
        String str;
        WikiItem next;

        WikiItem(String s, WikiItem n) {
            str = s;
            next = n;
        }
    }

    // ReturnObject returnObject;
    int occurences = 0;  // Obs!!
    public String [] fileNames = {
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

    public Index2(String filename) {

        // make file list
        String file;
        WikiItem currentFile, tmpFile;
        int j = 0;
        file = filename;
        startFile = new WikiItem(file, null);
        currentFile = startFile;
        while ( fileNames[j] != null){
            currentFile = new WikiItem(fileNames[j],null);
            tmpFile = currentFile;
            j++;
        }
        System.out.println(startFile.str + startFile.next);


        String word;
        WikiItem current, tmp;
        try {
            Scanner input = new Scanner(new File(filename), "UTF-8");
            word = input.next();
            start = new WikiItem(word, null);
            current = start;
            while (input.hasNext()) {   // Read all words in input
                word = input.next();
//   Obs!!
              //  System.out.println(word);   //Obs!!
 //  Obs!!
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


//////////////////////////////////////////

    public int searchNCount(String searchstr) {
        WikiItem current = start;
        while (current != null) {
            if (current.str.equals(searchstr)) {
                occurences = occurences+1;    //her !
            }
            current = current.next;
        }
        return occurences;
    }

    public static void main(String[] args) {


        for (String tmpFile : fileNames) {
            currentFile = tmpFile;
            System.out.println("Preprocessing " + currentFile);
            Index2 i = new Index2(currentFile);
            String searchstr = "one"; //console.nextLine(); // = args[0]; =  "this"; // "anarchy"; //console.nextLine();   Obs!!
            if (i.search(searchstr)) {
                System.out.println("filnavn: " + currentFile + "  tekststreng: "
                        + searchstr + " exists  " + "   antal_forekomster: "+
                        i.searchNCount(searchstr) + " i " + currentFile);
                //System.out.println(searchstr + " exists  " );
                } else {
                System.out.println(searchstr + " does not exist");
                }

            }
        }







//        Index2 i = new Index2();
//        System.out.println("Preprocessing " + fileNames[1]);
//        //Index2 i2 = new Index2();
//        String searchstr = "anarchy";// args[1]; // "this"; // "anarchy"; //console.nextLine();   Obs!!
//        System.out.println("Startfile " + i.startFile.fileName + i.startFile.next);

            }