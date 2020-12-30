import java.sql.*;
class crud
{
    //static final String USER="root";
    //static final String PASS="";
    public static void main(String arg[]) throws Exception
    {
        Connection con=null;
        Statement stmt=null;
        //ResultSet rs=null;

       
       try
       {
           Class.forName("com.mysql.jdbc.Driver");
           System.out.println("class loaded successfully");

           System.out.println("connecting to TABLE");

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/marvellous?serverTimezone=UTC","root","");
           
               
           
           System.out.println("connection established");
           System.out.println("creating TABLE");

           stmt = con.createStatement();
           System.out.println("Statement object created successfully");

           String sq1 ="CREATE TABLE EMPLOYEE(eid int,name varchar(255))";
            stmt.executeUpdate(sq1);
            System.out.println("TABLE created successfully");S

            System.out.println("INSERTING RECORDS INTO TABLE EMPLOYEE");
            String sq1="INSERT INTO EMPLOYEE(eid,name)" + "VALUES(101,'John')";
            stmt.executeUpdate(sq1);
            System.out.println("Records Inserted in EMPLOYEE Table");

           System.out.println("Query executed successfully");
           

           System.out.println("Data from EMPLOYEE table"); 
           while(rs.next())
           {
            System.out.println(rs.getInt(1));
            System.out.println(rs.getString(2));
            System.out.println(rs.getString(3));
           } 
        }
       catch(Exception e)
       {
             System.out.println("Exception occurred");
               System.out.println(e);
                // System.out.println(e.printlnStackTrace());
              
       }
       finally
       {
          // rs.close();
           stmt.close();
           con.close();
           System.out.println("Finally block executed");
       }
    }
}