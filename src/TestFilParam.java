import java.io.File;


class TestFilParam {

    public static void displayFiles(File[] files)
    {
	Index2 i2 =new Index2("fil.txt");

        // Traversing through the files array
        for (File filename : files) {
            // If a sub directory is found,
            // print the name of the sub directory
            if (filename.isDirectory()) {
                System.out.println("Directory: "
                                   + filename.getAbsolutePath());
 
                // and call the displayFiles function
                // recursively to list files present
                // in sub directory
                displayFiles(filename.listFiles());
            }
 
            // Printing the file name present in given path
            else {
                // Getting the file name
                System.out.println("File: "
                                   + filename.getAbsolutePath());
		i2.testMetode(filename.getAbsolutePath(),"anarchy");
            }
        }
    }


   /* public static void main(String[] args)
    {
     File soegeFil = new File( "C:\\Users\\F\\java_kode\\data_filer\\WestburyLab.wikicorp.201004_5MB.txt");
     System.out.println(soegeFil);
     String file_str = soegeFil.getAbsolutePath();
     Index2 i2 =new Index2("this_fil.txt");
     i2.testMetode(file_str,"anarchy");
    } */

    // test ny main herfra:
    public static void main(String[] args)
    {
	    File[] files = new File("/Users/thomasnicolajsen/IdeaProjects/SearchEngineProject/files").listFiles();

	    displayFiles(files);
    
    }

}
