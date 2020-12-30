import java.io.*;
import java.net.*;

class Client
{
    public static void main(String arg[]) throws Exception
    {
        System.out.println("CLIENT APPLICATION...");
    
        
        
        Socket s = new Socket("localhost",2408);
        System.out.println("CLIENT is Running...");
        
        BufferedReader brk = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader brs =new BufferedReader(new InputStreamReader(s.getInputStream()));
        PrintStream ps = new PrintStream(s.getOutputStream());

            System.out.println("enter name of the file with full path");
            String filename = brk.readLine();
        String str1,str2;
        DataOutputStream out = new DataOutputStream(s.getOutputStream());
        out.writeBytes(filename);

        
        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        while(true)
        {
            System.out.println("Enter Message for Server: ");
            str1 = brk.readLine();
            if(str1.equals("Exit"))
            {
                break;
            }
            ps.println(str1);
           
            str2 = brs.readLine();
            System.out.println("Message from Server: "+ str2);
        }
        
        ps.close();
        brs.close();
        brk.close();
        s.close();
        String str;
        while((str = in.readLine())!=null)
        System.out.println(str);
    }
}