/*
 * Document   : Servlet (Controller) to render the member’s main page
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

@WebServlet("/MainPage")
public class MainPage extends HttpServlet 
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        // get session object first
        HttpSession session = request.getSession(false);
                
        if(session == null)
        {
            // not login yet, redirest to login page
            response.sendRedirect("Login"); 
        }
        else
        {
            // login success, disable browser cache first
            response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
            response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
            response.setHeader("Expires", "0"); // Proxies.
            
            // forward to mainPage.jsp
            RequestDispatcher rd = request.getRequestDispatcher("mainPage.jsp");
            rd.forward(request, response);            
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        doGet(request, response);       
    }
}
