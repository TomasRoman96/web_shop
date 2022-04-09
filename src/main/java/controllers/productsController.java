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

@WebServlet(name = "productsController", urlPatterns = {"/productsController"})

public class productsController extends HttpServlet{
    productsQueries PQ = new productsQueries();

    public ArrayList<Products> getProductsFromDB(){
        ArrayList<Products> AR = PQ.getProductsFromBD();
        return AR;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        switch(req.getParameter("action")){
            case "getListProducts":
            ArrayList<Products> ArrayQuery = getProductsFromDB();
            PrintWriter out = resp.getWriter();
            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
            out.print(new Gson().toJson(ArrayQuery));
            out.flush();
            break;
        }
        
    }
}
