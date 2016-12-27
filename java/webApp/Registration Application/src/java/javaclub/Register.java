/*
 * Document   : Servlet (Controller) for the registration form page. 
 * Created on : July 27, 2016
 * Updated on : July 27, 2016
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

@WebServlet("/Register")
public class Register extends HttpServlet 
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
        // get 6 input parameters from request
        String userId = request.getParameter("user");
        String password = request.getParameter("pass");
        String passwordRe = request.getParameter("pass2");
        String firstName = request.getParameter("fname");
        String lastName = request.getParameter("lname");
        String email = request.getParameter("email");
        
        // if all inputs are null, there is no error message
        if(userId == null && password == null && passwordRe == null &&
                firstName == null && lastName == null && email == null)
        {
            // forward to register.jsp and exit this method
            RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
            rd.forward(request, response);
        }
        
        // instance of UserDatabase to access DB 
        UserDatabase db = new UserDatabase();
        
        // local var to store the current status(error/result)
        String signupMessage = null;
        
        // subsequent request, validate all input parameters
        if(userId == null || userId.isEmpty())
            signupMessage = "User ID cannot be empty";
        else if(!db.isUnique(userId))
            signupMessage = "User ID, " + userId + " already exists.";
        else if(password == null || password.isEmpty())
            signupMessage = "Password cannot be empty";
        else if(!password.equals(passwordRe))
            signupMessage = "Enter the same password with the prevoius";
        else if(firstName == null || firstName.isEmpty())
            signupMessage = "First Name cannot be empty";
        else if(lastName == null || lastName.isEmpty())
            signupMessage = "Last Name cannot be empty";
        else if(email == null || email.isEmpty())
            signupMessage = "Email cannot be empty";
        
        // passed validation, forward to registerResult.jsp
        if(signupMessage == null)
        {
            // add the user to DB and check it is successful
            int result = db.addUser(userId, password, firstName, lastName, email);
            if(result == 1)
            {
                // update signupMessage and set as request attribute
                signupMessage = "Sign up successfully, Thank you for joining Java Club!";
                request.setAttribute("signupMessage", signupMessage); 
                
                // forward to login.jsp to show registerResult.jsp form
                RequestDispatcher rd = request.getRequestDispatcher("registerResult.jsp");
                rd.forward(request, response);                  
            }
            else if(result == -1)
            {
                // if addUser() may fail, update signupMessage and set attribute
                signupMessage = "Try again...";
                request.setAttribute("signupMessage", signupMessage);
                
                // forward to login.jsp to show register.jsp form again
                RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
                rd.forward(request, response);                
            }
        }   
        // failed validation, forward to register.jsp
        else
        {            
            // forward to login.jsp to show register.jsp form again
            request.setAttribute("signupMessage", signupMessage);
            RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
            rd.forward(request, response);
        }
        
    }
}
