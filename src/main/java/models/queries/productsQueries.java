package models.queries;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import config.*;
import models.objects.*;

public class productsQueries extends DBConnect {

    public ArrayList<Products> getProductsFromBD() {
        ArrayList<Products> data = new ArrayList<Products>();
        try {
            String sql = "call getAllProducts()";
            PreparedStatement statement = getConnect().prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Products P = new Products();
                P.setID(resultSet.getInt("ID"));
                P.setName(resultSet.getString("NAME"));
                P.setPrice(resultSet.getInt("PRICE"));
                data.add(P);
            }
            statement.close();
            resultSet.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                getConnect().close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return data;
    }
}
