package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Person;

/**
 *
 * @author awarsyle
 */
public class HelloWorldServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/helloWorldJSP.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
       
        
        if (firstname == null || firstname.equals("") ||
                lastname == null || lastname.equals("")) {
            request.setAttribute("fname", firstname);
            request.setAttribute("lname", lastname);
            request.setAttribute("error", "both");
            getServletContext().getRequestDispatcher("/WEB-INF/helloWorldJSP.jsp").forward(request, response);
            return;
        }

        // construct person object
        Person person = new Person(firstname, lastname);
        
        // pass person object to the JSP
        request.setAttribute("person", person);
        
        getServletContext().getRequestDispatcher("/WEB-INF/sayHello.jsp").forward(request, response);   
    }
}
