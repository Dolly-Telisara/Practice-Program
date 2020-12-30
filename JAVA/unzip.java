import java.io.*;
import java.util.zip.*;

public class unzip {
    public static void main(String args[]) throws Exception
    {
        FileInputStream fis = new FileInputStream("Newzip"); // Attach compressed file(file2) to FileInputStream for reading data. 

        FileOutputStream fos = new FileOutputStream("NewUnzip"); // Attach original file(file2Unzip) to FileOutputStream. 

        InflaterInputStream iis = new InflaterInputStream(fis); //  Attach FileInputStream to InflaterInputStream. 

        // read data from InflaterInputStream and write it into FileOutputStream

        int data;

        while((data = iis.read()) != -1) 
            fos.write(data);
        
        //close the files
        fos.close();
        iis.close();
    }
}
