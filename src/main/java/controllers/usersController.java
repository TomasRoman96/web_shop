package controllers;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.queries.*;
import models.objects.*;

@WebServlet(name = "usersController", urlPatterns = {"/usersController"})

public class usersController extends HttpServlet{
    usersQueries UQ = new usersQueries();

    public String insertUser(User U){
        String respQuery = UQ.insertNewUser(U);
        return respQuery;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        switch(req.getParameter("action")){
            case "login":
            User U = new User();
            U.setName(req.getParameter("name").toUpperCase());
            U.setUserName(req.getParameter("username").toUpperCase());
            U.setPassword(req.getParameter("password").toUpperCase());
            String respQuery = insertUser(U);
            PrintWriter out = resp.getWriter();
            out.print(respQuery);
            out.flush();
            break;
        }
        
    }
}
