package models.queries;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import config.*;
import models.objects.*;

public class usersQueries extends DBConnect{
    public String insertNewUser(User U){
        String respQuery = "error";
        try {
            String sql = "call insertUser(?,?,?)";
            PreparedStatement statement = getConnect().prepareStatement(sql);
            statement.setString(1, U.getName());
            statement.setString(2, U.getUserName());
            statement.setString(3, U.getPassword());
            if(statement.executeUpdate() > 0){respQuery = "success";}
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                getConnect().close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return respQuery;
    }
}
