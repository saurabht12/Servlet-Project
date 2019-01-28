/**
* The LoginServlet class here we show all records related to user  
*  .
*@author  knight Learning Solutions
* @version 1.0
* @since   2019-1-17 
*/


import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import java.io.IOException;
import java.io.PrintWriter;

import com.mongodb.DB;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;  
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.client.MongoCollection;  
import com.mongodb.client.MongoDatabase;  
import org.bson.types.ObjectId;
import java.io.File;

import org.apache.log4j.Logger;

public class LoginServlet extends HttpServlet
{
public void doGet(HttpServletRequest req,HttpServletResponse res)
throws ServletException,IOException
{
res.setContentType("text/html");
PrintWriter out=res.getWriter();


try
{
	 MongoCollection collection = ConnectionDb.getConnection();
            DBCursor dbo = (DBCursor) collection.find();



            out.println("<html><body style='background-color: darkorange';> ");
        out.println("<head><h1 align='center'><u>User Management</u></h1></head>");
 out.print("<table width=80% border=1>");  
 out.println("<form action='averify'><input type='submit' value='Add New'></form>");
 out.print("<caption><h3>User Data:</h3></caption>");
 out.println("<form action='check'><input type='submit' value='Logout'></form>");

  out.println("<th>Name</th>");
  out.println("<th>Password</th>");
     out.println("<th>Email</th>"); 
     out.println("<th>Mobile</th>");
     out.println("<th>ID</th>");
     out.println("<th>Options</th>");
          out.println("</tr>");




 while(dbo.hasNext())
    {
       DBObject dbq=dbo.next();
       ObjectId id = (ObjectId) dbq.get( "_id" );
          String name=(String) dbq.get("name");
      String pass=(String) dbq.get("pass");
      String mob=(String) dbq.get("mobile Number");
      String email=(String) dbq.get("email");
       out.println("<tr>");
        out.println("<td>"+name+"</td>");
     out.println("<td>"+pass+"</td>");
         out.println("<td>"+email+"</td>");
     out.println("<td>"+mob+"</td>");
     out.println("<td>"+id+"</td>");
     out.println("<td><a href='delete?uname="+id+"'>Delete</a></td> ");
      out.println("<td><a href='update?uname="+id+"'>Edit</a></td></form>");

  }
  
}


catch(Exception e)
{

}
}
}
