import java.io.*;
import java.net.*;

class Server
{
    public static void main(String arg[]) throws Exception
    {
        System.out.println("SERVER APPLICATION...");
        
        //CREATE OBJECT OF ServerSocket ->
        
        ServerSocket ss = new ServerSocket(2408);
        System.out.println("Server is Waiting for connection from client...");

        Socket s = ss.accept();
        System.out.println("Connection successfull");

        //BufferedReader brk = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader brs =new BufferedReader(new InputStreamReader(s.getInputStream()));
        //PrintStream ps = new PrintStream(s.getOutputStream());

        //String str1,str2;
        String filename = brs.readLine();
        File f = new File(filename);
        DataOutputStream out = new DataOutputStream(s.getOutputStream());
        /*while(true)
        {
            str1 = brs.readLine();
            if(str1 == null)
            {
                break;
            }
            System.out.println("MESSAGE FROM CLIENT: " +str1);
            System.out.println("Enter Message For CLIENT: ");

            str2 = brk.readLine();
            ps.println(str2);
        }*/
        
        if(f.exists())
        {
            FileReader fr= new FileReader(filename);
            
        BufferedReader brsfile = new BufferedReader(fr);
        String str;
        while((str=brsfile.readLine())!= null)
        {
            out.writeBytes(str);
        }
    }
        /*ps.close();
        brs.close();
        brk.close();
        s.close();
        ss.close();*/
    }
}