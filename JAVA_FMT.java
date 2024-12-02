import java.io.*;
import java.util.*;

public class Projet1 {

        private static void ListFiles(){
            // Scanner object to read input from user
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter Directory Path: ");
            // Store the input directory path
            String DP=sc.nextLine();
            try{
                // Create a File object using the directory path
                File dir=new File(DP);
                // Check if the directory exists and is indeed a directory
                if(dir.exists()&&dir.isDirectory()){
                     // List all files in the directory
                    File[] files=dir.listFiles();
                    // Check if the directory is not empty
                    if(files!=null){
                        int i=0;
                        // Iterate over the files and print details
                        for(File file:files){
                            System.out.println("["+i+"] "+file.getName()+" ( Size: "+file.length()+" bytes )");
                            i++;
                        }
                    }
                    else{
                        // Inform the user that no files were found
                        System.out.println("No files found!!");
                    }
                }
                else{
                    // Inform the user that the directory path is invalid
                    System.out.println("Invalid directory path!!!");
                }
            }
            // Catch any security exceptions and print the error message
            catch(SecurityException e){
                System.out.println("Security exception occurred: "+e.getMessage());
            }
        }

        private static void ListFilesRecursively(){
            // Scanner object to read input from user
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter Directory Path: ");
            // Store the input directory path
            String DP=sc.nextLine();
            try{
                // Create a File object using the directory path
                File dir=new File(DP);
                //call ListFilesRecursivelyMain
                ListFilesRecursivelyMain(dir);
            }
            // Catch any security exceptions and print the error message
            catch(SecurityException e){
                System.out.println("Security exception occurred: "+e.getMessage());
            }
        }

        private static void ListFilesRecursivelyMain(File dir) {
            // Scanner object to read input from user
            Scanner sc = new Scanner(System.in);
            try{
                // Check if the directory exists and is indeed a directory
                if(dir.exists() && dir.isDirectory()){                   
                    // List all files in the directory
                    File[] files = dir.listFiles();
                    // Check if the directory is not empty               
                    if(files != null) {                   
                        // Iterate over the files and print their details
                        for(File file : files) {          
                            // Check it is a directory               
                            if(file.isDirectory()){
                                // Calls ListFilesRecursivelyMain function
                                ListFilesRecursivelyMain(file);
                            }
                            else{
                                System.out.println(file.getAbsolutePath());       
                            }
                        }
                    }
                    else{
                        // Inform the user that no files were found
                        System.out.println("No files found!!");
                    }                   
                } 
                else{
                    // Inform the user that the directory path is invalid
                    System.out.println("Invalid directory path!!!");
                }
            } 
            // Catch any security exceptions and print the error message
            catch(SecurityException e){
                System.out.println("Security exception occurred: " + e.getMessage());
            }
        }

        private static void ListFilesByAlphabetically(){
            // Scanner object to read input from user
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter Directory Path: ");
            // Store the input directory path
            String DP=sc.nextLine();
            try{
                // Create a File object using the directory path
                File dir=new File(DP);
                // Check if the directory exists and is indeed a directory
                if(dir.exists() && dir.isDirectory()){
                    // List all files in the directory
                    File[] files=dir.listFiles();
                    // Check files is not empty
                    if(files!=null){
                        // Sort Files
                        Arrays.sort(files);
                        int i=1;
                            // Iterate over the files and print their details
                            for(File file:files){
                                System.out.println("["+i+"]"+file.getName()+" ( Size: "+file.length()+" bytes )");
                                i++;
                            }
                    }
                    else{
                        // Inform the user that no files were found
                        System.out.println("No files found!!");
                    }
                }
                else{
                    // Inform the user that the directory path is invalid
                    System.out.println("Invalid Directory Path!!!");
                }
            }
            // Catch any security exceptions and print the error message
            catch(SecurityException e){
                System.out.println("Security exception occured: "+e.getMessage());            
            }
        }

        private static void ListFilesByExtension(){
            // Scanner object to read input from user
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter Directory Path: ");
            // Store the input directory path
            String DP = sc.nextLine();
            System.out.print("Enter File Extension like (txt,png,...): ");
            // Store the input extension name Ex:png,txt,ipynb etc.....
            String exten = sc.nextLine();
            try{
                // Create a File object using the directory path
                File dir = new File(DP);
                // Check if the directory exists and is indeed a directory
                if(dir.exists() && dir.isDirectory()){
                // List all files with specified extension in the directory 
                File[] files = dir.listFiles((directory, name) -> name.toLowerCase().endsWith("." + exten.toLowerCase()));
                // Check file is not empty
                if(files != null&&files.length>0){
                    int i=1;
                    // Iterate over the files and print their details
                    for(File file : files){
                        System.out.println("["+i+"] "+file.getName()+" (Size:"+file.length()+" bytes)");
                        i++;
                    }
                    System.out.println("Total files with "+exten+" are "+(i-1));
                }
                else{
                    // Inform the user that no files were found with specified extension
                    System.out.println("No files found with the specified extension "+exten+".");
                }
            }
            else{
                // Inform the user that the directory path is invalid
                System.out.println("Invalid directory path.");
            }
        }
        // Catch any security exceptions and print the error message
        catch(SecurityException e){
            System.out.println("Security exception occurred: " + e.getMessage());
        }
    }

        private static String repeat(char c, int count) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < count; i++) {
                sb.append(c);
            }
            return sb.toString();
        }

        private static void CopyFile(){
            // Scanner object to read input from user
            Scanner sc=new Scanner(System.in);
            System.out.print("Enter Source File Path: ");
            // Store the input Source File path
            String SPath = sc.nextLine();
            System.out.print("Enter Destination File Path: ");
            // Store the input Destination File path
            String DPath = sc.nextLine();

            // Check if the source file path is provided
            if(SPath.isEmpty()){
                System.out.println("Source file path not provided!");
                return;
            }
            
            // Check if the destination file path is provided
            if(DPath.isEmpty()){
                System.out.println("Destination file path not provided!");
                return;
            }
            
            try{
                // Create a File object for the source
                File SFile = new File(SPath);
                // Create a File object for the destination
                File DFile = new File(DPath);
    
                // Check if the source file exists and is a file
                if(!SFile.exists()||!SFile.isFile()){
                    // Inform the user that no files were found
                    System.out.println("Source file not found!!");
                    return;
                }
                
                try(
                    // Stream to read from the source file
                    FileInputStream FIS = new FileInputStream(SFile);
                    // Stream to write to the destination file
                    FileOutputStream FOS = new FileOutputStream(DFile);
                )
                {
                    // Buffer to hold file data
                    byte[] buffer = new byte[1024];
                    // Size of the source file
                    long fileSize = SFile.length();
                    // Number of bytes copied
                    long copiedBytes = 0;
                    // Number of bytes read
                    int length;
                    while((length = FIS.read(buffer)) > 0){
                        FOS.write(buffer, 0, length);
                        // Update the copied bytes count
                        copiedBytes += length;

                    //Calculate progress percentage
                    int progress = (int) ((copiedBytes * 100) / fileSize);
                    //Progress bar
                    System.out.print("\r[" + repeat('#', progress / 5) + repeat(' ', 20 - progress / 5) + "] " + progress + "% ("+copiedBytes+"/"+fileSize);
                    }
                    System.out.println();
                    // Display the size of the copied
                    System.out.println("Size of file copied: "+copiedBytes);
                    
                    System.out.println("File copied successfully!!!");
                }
                // Catch any Input Output exceptions and print the error message
                catch(IOException e){
                    System.out.println("Error while copying file: " + e.getMessage());
                }
            }
            // Catch any security exceptions and print the error message
            catch (SecurityException e){
                System.out.println("Security exception occurred: " + e.getMessage());
            }
        }

        private static void DeleteFile(){
            // Scanner object to read input from user
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter file path to delete: ");
            // Store the input file path
            String Df=sc.nextLine();
            try{
                // Create a File object using the file path
                File file=new File(Df);
                // Check if the file exists and is indeed a file
                if(file.isFile()&&file.exists()){    
                    // delete file                                                                                                                                                                                
                    if(file.delete()){
                        System.out.println("File Deleted Succesfully!!!");
                    }
                    else{
                        // Inform the user that the file failed to delete
                        System.out.println("Failed to delete file!!!");
                    }
                }
                else{
                    // Inform the user file does not exist
                    System.out.println("File does not exist!!!");
                }
            }
            // Catch any security exceptions and print the error message
            catch(SecurityException e){
                System.out.println("Security exception occurred: " + e.getMessage());
            }
        }

        private static void ConcatenateFiles(){
            // Scanner object to read input from user
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter path of 1st file: ");
            // Store the input 1st File path
            String firstfilepath=sc.nextLine();
            System.out.print("Enter path of 2nd file: ");
            // Store the input 2nd File path
            String secondfilepath=sc.nextLine();
            System.out.print("Enter path of Output file: ");
            // Store the Output File  path
            String outputfilepath=sc.nextLine();
            try{
                // Create a File object using the 1st source file path
                File sourcefile1=new File(firstfilepath);
                // Create a File object using the 2nd source file path
                File sourcefile2=new File(secondfilepath);
                // Create a File object using the output file path
                File outputfile=new File(outputfilepath);

                // Check if the source files exists 
                if(!sourcefile1.exists()||!sourcefile2.exists()){
                    System.out.println("Input Files not found!!");
                    return;
                }
                

                try(
                    // Create BufferedReader to read from the first source file
                    BufferedReader firstreader=new BufferedReader(new FileReader(sourcefile1));
                    // Create BufferedReader to read from the second source file
                    BufferedReader secondreader=new BufferedReader(new FileReader(sourcefile2));
                    // Create BufferedWriter to write to the output file
                    BufferedWriter writer=new BufferedWriter(new FileWriter(outputfile));){
                    String line;
                    // Read each line from the first source file
                    while((line=firstreader.readLine())!=null){
                        // Write the line to the output file
                        writer.write(line);
                        // Add a new line in the output file
                        writer.newLine();
                    }
                    // Read each line from the second source file
                    while((line=secondreader.readLine())!=null){
                        // Write the line to the output file
                        writer.write(line);
                        // Add a new line in the output file
                        writer.newLine();
                    }
                    System.out.println("Files Concatenated Sucessfully!!!!");
                }
                // Catch any Input Output exceptions and print the error message
                catch(IOException e){
                    System.out.println("Error Concatenating Files: "+e.getMessage());
                }
            }
            // Catch any security exceptions and print the error message
            catch(SecurityException e){
                    System.out.println("Security Exception Occurred: "+e.getMessage());
                }
        }

        private static void FindHiddenFiles(){
            // Scanner object to read input from user
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter path of directory: ");
            // Store the input directory path
            String directorypath=sc.nextLine();
            try{
                // Creates a File object using the directory path
                File dire=new File(directorypath);
                // Check if the directory exists and is indeed a directory
                if(dire.exists()&&dire.isDirectory()){
                    // List all files in the directory
                    File[] files=dire.listFiles();
                    // Check if the directory is not empty
                    if(files!=null){
                        int i=0;
                        // Iterate over the files and print their details
                        for(File file:files){
                            if(file.isHidden()){
                                System.out.println("["+i+"] "+file.getName()+" ( Size: "+file.length()+" bytes)");
                                i++;
                            }
                        }
                    }
                    else{
                        // Inform the user that no files were found in Directory 
                        System.out.println("No files found in the directory!!!");
                    }
                }
                else{
                    // Inform the user that no Directory were found
                    System.out.println("Directory does not exist!!!");
                }
            }
            // Catch any security exceptions and print the error message
            catch (SecurityException e) {
                System.out.println("Security exception occurred: "+e.getMessage());
            }
        }

        private static void filedetails(File file){
            // Gets the last modified time of the file in milliseconds
            long lastModifiedTimeMilliseconds = file.lastModified();
            // Converts the last modified time into a Date object
            Date lastModifiedDate = new Date(lastModifiedTimeMilliseconds);
            System.out.println("\n File Name: " + file.getName() +                                   //File Name
                                   "\n Can Execute: " + file.canExecute() +                          //Execution Permision
                                   "\n Read: " + file.canRead() +                                    //Reading Permision
                                   "\n Write: " + file.canWrite() +                                  //Writing Permision
                                   "\n Free Space: " + file.getFreeSpace() +" bytes"+                //Available Free Space
                                   "\n File Total Space: " + file.getTotalSpace() +" bytes"+         //Total Space
                                   "\n File Size: " + file.length() +" bytes"+                       //Length of file
                                   "\n File Last Modified on: " + lastModifiedDate+                  //Last Modified Details
                                   "\n File is Hidden: " + file.isHidden()+                          //File Hidden Details
                                   "\n");
        }

        private static void DetailsOfFile() {
            // Scanner object to read input from user
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter path: ");
            // Store the input File or Directory path
            String path = sc.nextLine();
            // Create a File object using the directory path
            File file = new File(path);
            
            try{
                // Check if the file exists and is indeed a file
                if(file.exists()&&file.isFile()){
                // calls filedetails function
                filedetails(file);
                }
                // Check if the directory exists and is indeed a directory
                else if(file.isDirectory()&&file.exists()){
                    // List all files in the directory
                    File[] files = file.listFiles();
                    // Check if the directory is not empty
                    if(files != null){
                        // Iterate over the files and print their details
                        for(File i : files){
                            // calls filedetails function
                            filedetails(i);
                        }
                    }
                    else{
                        // Inform the user that no files were found
                        System.out.println("No files found in the directory!!!");
                    }
                }
                else{
                    // Inform the user that the file path is invalid
                    System.out.println("Specified file does not exist!!!");
                }
            }
            // Catch any security exceptions and print the error message
            catch(SecurityException e){
                System.out.println("Security exception occurred: " + e.getMessage());
            }
            // Catch any exceptions and print the error message
            catch(Exception e){
                System.out.println("An error occurred: " + e.getMessage());
            }
        }
        

        public static void main(String[] args){
            // Scanner object to read input from user
            Scanner sc = new Scanner(System.in);
            System.out.println("                                        _______________________________________________________\n"+
            "                                        **************___**************____****____________****\n"+
            "                                        **************___**************____*******_____********\n"+
            "                                        ______***________****______________****__***__***__****\n"+
            "                                        ______***________****______________****____****____****\n"+
            "                                        ______***________**************____****____****____****\n"+
            "                                        ***___***________**************____****____________****\n"+
            "                                        ***___***________****______________****____________****\n"+
            "                                        *********________****______________****____________****\n"+
            "                                        *********________****______________****____________****\n"+
            "                                        _______________________________________________________\n");
        //Label for outerloop to jump back to main
        OuterLoop:
        while(true){
            //Main Menu Options
            System.out.println("File Manipulation Tool Menu: ");
            System.out.println("1) List Files\n2) Copy Files\n3) Delete Files\n4) Concatenate Files\n5) HiddenFiles\n6) Exit\n");
            System.out.print("Enter your choice: ");
            int choice=sc.nextInt();
            System.out.println();
            //Switch statement to handle main menu
            switch(choice){
                case 1:
                    System.out.println("List Files Menu: ");
                    System.out.println("1) List all files in a directory\n2) List all files in a directory recursively\n3) List all files in a directory sorted by alphabetically\n4) List files in a directory filtered by an extension\n5) Details of files\n6) Back\n");
                    System.out.print("Enter your choice: ");
                    int choice1 = sc.nextInt();
                    sc.nextLine();//consume new line
                    //Switch statement to handle submenu list file
                    switch(choice1){
                        case 1:
                            ListFiles();
                            break;
                        case 2:
                            ListFilesRecursively();
                            break;
                        case 3:
                            ListFilesByAlphabetically();
                            break;
                        case 4:
                            ListFilesByExtension();
                            break;
                        case 5:
                            DetailsOfFile();
                            break;
                        case 6:
                            //Jump back to main loop
                            continue OuterLoop;
                        default:
                            System.out.println("Invalid Choice!!! Please try again.");
                            System.out.println();
                            break;
                    }
                
                    break;
                case 2:
                    CopyFile();
                    break;
                case 3:
                    DeleteFile();
                    break;
                case 4:
                    ConcatenateFiles();
                    break;
                case 5:
                    FindHiddenFiles();
                    break;
                case 6:
                    System.out.println("\n--------------------------------------------------------------------"+
                        "\n------------------Program----Exited----Successfully-----------------"+
                        "\n--------------------------------------------------------------------");
                    // Close the scanner
                    sc.close();
                    // Exit the program
                    return;
                default:
                    System.out.println("Invalid choice!!! Please try again.");
                    System.out.println();
                    break;
                    
                    
            }
            System.out.println("\n1) Do you want to continue?\n2) exit");
            System.out.print("Enter your selection: ");
            int choice2 = sc.nextInt();
            if(choice2 == 1){
                continue;
            }
            else if(choice2 == 2){
                System.out.println("\n--------------------------------------------------------------------"+
                "\n------------------Program----Exited----Successfully-----------------"+
                "\n--------------------------------------------------------------------");
                // Close the scanner
                sc.close();
                // Exit the program
                return;
            }
            else{
                System.out.println("\nChoice invalid!!\n");
                System.out.println("Program Terminated!!!");
                // Exit the program
                return;
            }
        }
      
    }
}


