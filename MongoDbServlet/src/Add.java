
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import java.io.IOException;
import java.io.PrintWriter;
 
import com.mongodb.DB;
import com.mongodb.DBObject;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;  
import com.mongodb.client.MongoCollection;  
import com.mongodb.client.MongoDatabase;  
import org.bson.types.ObjectId;
public class Add extends HttpServlet{
public void doGet(HttpServletRequest req,HttpServletResponse res)
throws ServletException,IOException
{

PrintWriter out=res.getWriter();
String getValue=req.getParameter("uname");
if(!getValue.equals(null))
{
	
String str=req.getParameter("uname");
String str2=req.getParameter("mob");
String str1=req.getParameter("pass");
String str3=req.getParameter("email");
try
{
	 MongoCollection collection = ConnectionDb.getConnection();
	        DBObject document1 = new BasicDBObject();
        document1.put("name", str);
        document1.put("pass", str1);
        document1.put("mobile Number",str2);
        document1.put("email",str3);
        collection.insertOne(document1);
         res.sendRedirect("login");
     }
catch(Exception e)
{

}
}
}}
