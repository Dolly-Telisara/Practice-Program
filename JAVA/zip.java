import java.io.*;
import java.util.zip.*;

public class zip {
    public static void main(String args[]) throws Exception
    {
        FileInputStream fis = new FileInputStream("New"); // Attach original file(file1) to FileInputStream for reading data. 

        FileOutputStream fos = new FileOutputStream("Newzip"); // Attach compressed file(file2) to FileOutputStream. 

        DeflaterOutputStream dos = new DeflaterOutputStream(fos); //  Attach FileOutputStream to DeflaterOutputStream. 

        // read data from FileInputStream and write it into DeflaterOutputSream

        int data;

        while((data = fis.read()) != -1) 
            dos.write(data);
        
        //close the files
        fis.close();
        dos.close();
    }
}
