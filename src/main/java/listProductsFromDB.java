import java.io.IOException;
import java.util.ArrayList;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import controllers.productsController;
import models.objects.*;

@WebServlet("/shop")

public class listProductsFromDB extends HttpServlet {
    productsController PC = new productsController();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<Products> AR = PC.getProductsFromBD();
        String Body = "";
        for (Products products : AR) {
            Body += "<p>"+products.getID()+"</p><p>"+products.getName()+"</p><p>"+products.getPrice()+"</p>";
        }
        req.setAttribute("Arreglo", Body);
        RequestDispatcher respuesta = req.getRequestDispatcher("/index.jsp");
        respuesta.forward(req, resp);
    }
}
