import java.io.File;

// https://www.geeksforgeeks.org/java-program-to-traverse-in-a-directory/
// Main class
class FileTraverser {
 
    // Method 1
    // To display files
    public static void displayFiles(File[] files)
    {
        // Traversing through the files array
        for (File filename : files) {
            // If a sub directory is found,
            // print the name of the sub directory
            if (filename.isDirectory()) {
                System.out.println("Directory: "
                                   + filename.getName());
 
                // and call the displayFiles function
                // recursively to list files present
                // in sub directory
                displayFiles(filename.listFiles());
            }
 
            // Printing the file name present in given path
            else {
                // Getting the file name
                System.out.println("File: "
                                   + filename.getName());
            }
        }
    }
 
    // Method 2
    // Main driver method
    public static void main(String[] args)
    {
        // Storing the name of files and directories
        // in an array of File type
        File[] files = new File("../files").listFiles();

	File tmp_file = files[1];
	String file_str = tmp_file.getAbsolutePath();
	System.out.println("files[1] " + file_str);
	//System.out.println("files[1] " + files[1].to_string);

	//Index2 i2 = new Index2(file_str, "anarchy");
	//i2.main(String[file_str,"anarchy"]) ;
 
        // Calling method 1 to
        // display files
        displayFiles(files);

	for(File tmp_fil:files){
	   System.out.println(tmp_fil);	
	   String[]  args1 = {tmp_file.getAbsolutePath(),"anarchy"};
	   Index2 i2 = new Index2(args1[0], args1[1] ); //new Index2(tmp_file.getAbsolutePath(), "anarchy");
	   //i2.main(tmp_file.getAbsolutePath()," in ");
	}
    }
}
