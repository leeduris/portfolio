/*
 * Document   : Servlet (Controller) to allow user to login. 
 * Created on : July 27, 2016
 * Updated on : July 28, 2016
 * Author     : Sung Woo Lee (leeduris@gmail.com)
 */
package javaclub;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Login")
public class Login extends HttpServlet 
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
        // get parameters
        String user = request.getParameter("user");
        String pass = request.getParameter("pass");        
                
        // if valid, set a session attribute and store the user obj
        UserDatabase db = new UserDatabase();
        
        if(db.isValid(user, pass))
        {
            // create session at this moment
            HttpSession session = request.getSession(true);
            
            // set session timeout in sec
            session.setMaxInactiveInterval(300);        
           
            // get the user from DB and set as session attribute
            session.setAttribute("user", db.getUser(user));
              
            // redirect to MainPage
            RequestDispatcher rd = request.getRequestDispatcher("/MainPage");
            rd.forward(request, response);
        }
        else
        {
            // set a request attribute, "loginMessage"
            String loginMessage = "You enterd wrong user ID or password";
            request.setAttribute("loginMessage", loginMessage);
            
            // forward to login.jsp to show login form again
            RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
            rd.forward(request, response);
            
        }
    }
}
