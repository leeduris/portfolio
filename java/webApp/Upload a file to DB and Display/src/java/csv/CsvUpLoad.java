package csv;

import ejd.JdbcHelper;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/CsvUpLoad")
@MultipartConfig
public class CsvUpLoad extends HttpServlet 
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        // handle GET in doPost()
        doPost(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        // local vars
        ArrayList<String> lines = null;
        String body = null;
        ArrayList<Person> parsedPersons = new ArrayList<>();
        ArrayList<Person> addedPersons = new ArrayList<>();  
        JdbcHelper jdbc = new JdbcHelper();
                
        // get servlet context for connection to database
        ServletContext ctx = getServletContext();
        String dbUrl = ctx.getInitParameter("dbUrl");
        String dbUser = ctx.getInitParameter("dbUser");
        String dbPass = ctx.getInitParameter("dbPass");         
        Csv2Database db = new Csv2Database(dbUrl, dbUser, dbPass);
        
        // get the file from request and convert it to FileStream
        Part filePart = request.getPart("file");
        InputStream fileStream = filePart.getInputStream();
        
        // parse a CSV file.        
        parsedPersons = db.readCsv(fileStream);
        
        // close streamimg
        fileStream.close();
            
        // add the parsed records to database
        addedPersons = db.addPersons(parsedPersons);
        
        // clean up
        jdbc.disconnect();

        // set 3 request attribs            
        int parsedCount = parsedPersons.size();
        int addedCount = addedPersons.size();             
        request.setAttribute("parsedCount", parsedCount);
        request.setAttribute("addedCount", addedCount);
        request.setAttribute("addedPersons", addedPersons);
                      
        // forward to CsvResult servlet
        RequestDispatcher rd = request.getRequestDispatcher("CsvResult");
        rd.forward(request, response);

    }
}



