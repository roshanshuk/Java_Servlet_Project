import javax.servlet.*;
import java.io.*;
import java.sql.*;
public class servlet implements Servlet{
	public void init(ServletConfig h){ }
	public void service(ServletRequest req, ServletResponse res)throws ServletException, IOException
          {
	res.setContentType("text/html");
	PrintWriter pw = res.getWriter();
	String name = req.getParameter("username");
	String pass = req.getParameter("password");
	String email = req.getParameter("useremail");
	String contact = req.getParameter("contactnumber");
try{
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
	PreparedStatement ps = con.prepareStatement("insert into employee values(?,?,?,?)");
	ps.setString(1,name);
	ps.setString(2,pass);
	ps.setString(3,email);
	ps.setString(4,contact);
	ps.executeUpdate();
	RequestDispatcher dispatcher = req.getRequestDispatcher("index.html");
	dispatcher.include(req,res);
	pw.println("<br>Hey " +name+" you are registered successfully");
   }catch(Exception e){ }
   pw.close();
 }
	public void destroy(){ }
	public String getServletInfo()
	{
	   return (null);
	}
	public ServletConfig getServletConfig()
	{
	  return (null);
	}
}