
package Servlets;

import Services.AccountService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Models.User;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        
        if(request.getAttribute("logout") != null){
            session.invalidate();
            request.setAttribute("message", "You have been logged out");
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);

        }else if(session.getAttribute("username") != null){
           response.sendRedirect("home");
        }else{
             getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }
    }

 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        String message;
        
        if(username.equals("") || password.equals("")){
            message = "Please enter a username and password to login";
            request.setAttribute("message", message);
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }else{
             AccountService accountService = new AccountService();
             User user = accountService.login(username, password);
             
             if(user != null){
                 HttpSession session = request.getSession();
                 
                 session.setAttribute("username",username);
                 response.sendRedirect("home");
                 
             }else{
                 message = "username or password is incorrect";;
                 request.setAttribute("username", username);
                 request.setAttribute("password", password);
                 request.setAttribute("message", message);
                 
                getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
             }
        }
    }

}