package com.example.cldart;




import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.Query.Filter;
import com.google.appengine.api.datastore.Query.FilterPredicate;
import com.google.appengine.api.datastore.Query.FilterOperator;
import com.google.appengine.api.datastore.Query.CompositeFilter;
import com.google.appengine.api.datastore.Query.CompositeFilterOperator;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Entity;




import java.io.*;
import java.util.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Properties;

public class Myapp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
   /* public Myapp() {
        super();
        // TODO Auto-generated constructor stub
    }
*/
    
    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
	 // Set response content type
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();

DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		Entity details = new Entity("student_details");
	String name=request.getParameter("name");
	String rollno=request.getParameter("rollno");
	String dob=request.getParameter("DOB");


			details.setProperty("name",name);
			details.setProperty("rollno",rollno);
			details.setProperty("DOB",dob);
		

		    datastore.put(details);
   
 }



    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request,response);

	      // Set response content type
	      response.setContentType("text/html");
	      PrintWriter out = response.getWriter();

DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		Query q = new Query("student_details");

		PreparedQuery pq = datastore.prepare(q);
 out.println("<!DOCTYPE html>");
	   out.println("<html>");
	  out.println("<head>Student Details</head>");
	  out.println("<body>");
	  out.println("<div style='margin-left:150px'>");
	 out.println("<p>");
	 out.println("<table style='background-color:beige'>");
	 out.println("<th>Name</th>");out.println("<th></th><th>RollNo</th>");out.println("<th></th><th>DOB</th>");
	


for (Entity result : pq.asIterable()) {
		 
    		 String name = (String) result.getProperty("name");
		 String rollno = (String) result.getProperty("rollno");
		 String dob = (String) result.getProperty("DOB");

	   	 out.println("<tr>");
	         out.print("<td>"+name+"</td>");
	   	 out.println("<td/>");
		 out.print("<td>"+rollno+"</td>");
		 out.println("<td/>");
	         out.print("<td>"+dob+"</td>");
	         out.println("<td/>");
	         out.println("</tr>");	
	     }   



out.println("</table>");
	out.println("</p>");
	
	out.println("</div>");
	out.println("<div style='margin-left:160px'><a href='index.jsp'>Add More</a></div>");
	out.println("</body>");
	out.println("</html>");

         }
	} 
