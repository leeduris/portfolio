package csv;

import ejd.HtmlUtil;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CsvResult")
public class CsvResult extends HttpServlet 
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        doPost(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
       // get request attribs
        int parsedCount = (Integer)request.getAttribute("parsedCount");
        int addedCount = (Integer)request.getAttribute("addedCount");
        ArrayList<Person> addedPersons = 
                (ArrayList<Person>)request.getAttribute("addedPersons");
        
        PrintWriter out = response.getWriter();
        out.println("<h1>CSV Upload Result</h1></br>");
        out.println("<p>Parsed Persons Count: " + parsedCount + "</p>"
                + "<p>Added Persons Count: " + addedCount + "</p></br></br>");
                
        if(addedPersons == null || addedPersons.isEmpty())
            response.getWriter().println("<p>No Added Persons</p>");
        
        // add link to  main
        out.println("<a href=\"csv2database.html\">Go To Main Page</a></br></br>\n");
        
        // generate body of html
        String body = "<table>\n<tr>\n" + 
                      "<th>#</th><th>First Name</th><th>Last Name</th>" +  
                      "<th>Company Name</th><th>Address</th><th>City</th>"+ 
                      "<th>Province</th><th>Postal</th><th>Phone1</th>" + 
                      "<th>Phone2</th><th>Email</th><th>Web</th>\n" +
                      "</tr>\n";
                     
        for(int i = 0; i < addedPersons.size(); i++)
        {
            // print each row
            Person person = addedPersons.get(i);   
            body += "<tr>\n" + 
                    "<td>" + (i+1) + "</td>" +
                    "<td>" + person.getFirstName() + "</td>" +
                    "<td>" + person.getLastName() + "</td>" +
                    "<td>" + person.getCompanyName() + "</td>" +
                    "<td>" + person.getAddress() + "</td>" +
                    "<td>" + person.getCity() + "</td>" +
                    "<td>" + person.getProvince() + "</td>" +
                    "<td>" + person.getPostal() + "</td>" +
                    "<td>" + person.getPhone1() + "</td>" +
                    "<td>" + person.getPhone2() + "</td>" +
                    "<td>" + person.getEmail() + "</td>" +
                    "<td>" + person.getWeb() + "</td>" +
                    "</tr>";
        }
        
        // close <table>
        body += "</table></br></br></br>";     
        
        
        // css
        String css = "<style>\n" +
                     "body { background-color: antiquewhite; }\n" +
                     "h1 { color: orange; text-align: left; }\n" +
                     "p { font-family: verdana; font-size: 20px; " +
                          "color: red; text-align: left; }\n" +
                     "table, td, th { " +
                                      "border: 1px solid lime;" +
                                      "text-align: left; }\n" +
                     "table { border-collapse: collapse;" +
                             "width: 100%; }\n" +
                     "th, td { padding: 5px; color:DarkMagenta ;}\n" +        
                     "th, td { padding: 5px; color:Navy;}\n" +
                     "tr:hover { background-color:#f5f5f5; }\n" +
                     "a { color:Gold ; font-size:20px;}\n" +
                     "</style>\n" ;
        
        // print all authors to <table>
        response.setContentType("text/html");        
        HtmlUtil.printHeader(out, "Added Persons List", css);
        out.println(body);
        HtmlUtil.printFooter(out);
        
    }


}
