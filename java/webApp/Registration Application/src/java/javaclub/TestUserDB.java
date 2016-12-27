/*
 * Document   : Unit-test module to test if UserDatabase and User classes are 
 *              working correctly or not
 * Created on : July 27, 2016
 * Updated on : July 27, 2016
 * Author     : Sung Woo Lee (leeduris@gmail.com)
 */

package javaclub;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TestUserDB")
public class TestUserDB extends HttpServlet
{
    ///////////////////////////////////////////////////////////////////////////
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        // create an instance of Model component
        UserDatabase db = new UserDatabase();
        
        // prepare THE output
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");    // MIME

        // test addUser() 
        int result = db.addUser("test",
                                "password",
                                "First",
                                "Last",
                                "email.com");
        
        out.println("addUser(): " + result);
        
        // test getUser()
        User user = db.getUser("test");
        out.println("<p>" + "getUser(): " + user + "</p>");
        
        // test isUnique()
        boolean unique = db.isUnique("test");
        out.println("<p>" + "isUnique(): " + unique + "</p>");
        
        // test isValid()
        boolean valid = db.isValid("test", "password");
        out.println("<p>" + "isValid(): " + valid + "</p>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        doGet(request, response);
    }
}
