package controllers;
import java.util.ArrayList;
import models.queries.*;
import models.objects.*;

public class productsController {
    productsQueries PQ = new productsQueries();

    public ArrayList<Products> getProductsFromBD() {
        ArrayList<Products> AR = PQ.getProductsFromBD();
        return AR;
    }
}
