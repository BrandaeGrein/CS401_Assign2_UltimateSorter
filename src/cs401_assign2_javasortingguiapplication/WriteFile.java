package cs401_assign2_javasortingguiapplication;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class WriteFile {
    private static String FOLDERPATH = System.getProperty("user.dir");
    
    
    private String fileName;
    
    public WriteFile( String _fileName){
        
        fileName = _fileName;
    }
    
   
    
    public void writeToFile(String text) throws IOException{
        String filePath = FOLDERPATH + fileName; 
        
        FileWriter write = new FileWriter(filePath, true);
        
        PrintWriter print_line = new PrintWriter(write);
        
        print_line.printf("%s"+ " ", text);
        print_line.close();
    }
    
    public void clearFile() throws FileNotFoundException{
        String filePath = FOLDERPATH + fileName; 
        PrintWriter writer = new PrintWriter(filePath);
        writer.print("");
        writer.close();
    }
}
