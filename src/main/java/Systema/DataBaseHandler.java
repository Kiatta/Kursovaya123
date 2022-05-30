package Systema;
import Service.Client;
import Service.Product;
import Service.User;

import java.sql.*;

public class DataBaseHandler extends Data {
    Connection dbConnection;
    public Connection getDbConnection()
            throws ClassNotFoundException,SQLException {
        String connectionString = "jdbc:mysql://" + dbHost + ":"
                + dbPort + "/" + dbName;
        Class.forName("com.mysql.cj.jdbc.Driver");
        dbConnection=DriverManager.getConnection(connectionString,dbUser,dbPass);
        return dbConnection;
    }
    public void signUpUser(User user){
        String insert = "INSERT INTO "+Const.USER_TABLE+"("+Const.USERS_LOGIN+"," +Const.USERS_PASSWORD+"," +Const.USERS_FIRSTNAME+"," +Const.USERS_SECONDNAME+")" +"VALUES(?,?,?,?)";

        try{
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setString(1,user.getLogin());
            prSt.setString(2,user.getPassword());
            prSt.setString(3,user.getFirstname());
            prSt.setString(4,user.getSecondname());
            prSt.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
    public ResultSet getUser(User user){
        ResultSet resultSet=null;
        String select="SELECT * FROM " + Const.USER_TABLE +" WHERE "+ Const.USERS_LOGIN+"=? AND "+Const.USERS_PASSWORD+"=?";
        try{
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            prSt.setString(1,user.getLogin());
            prSt.setString(2,user.getPassword());
           resultSet = prSt.executeQuery();
        }catch(SQLException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resultSet;
    }
    public void signUpClient(Client client){
        String insert = "INSERT INTO "+Const.CLIENT_TABLE+"("+Const.CLIENT_FIO+"," +Const.CLIENT_MOBILE+"," +Const.CLIENT_DATA+"," +Const.CLIENT_TIME+")" +"VALUES(?,?,?,?)";

        try{
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setString(1,client.getFIO());
            prSt.setString(2,client.getMobile());
            prSt.setDate(3,client.getData());
            prSt.setString(4,client.getTime());
            prSt.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
    public void addProduct(Product product){
        String insert = "INSERT INTO "+Const.PRODUCT_TABLE+"("+Const.PRODUCT_NAME+"," +Const.PRODUCT_PRICE+")" +"VALUES(?,?)";

        try{
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setString(1,product.getNameProduct());
            prSt.setInt(2,product.getPrice());
            prSt.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
    public ResultSet getClient(Client client){
        ResultSet resultSet=null;
        String select="SELECT * FROM " + Const.CLIENT_TABLE +" WHERE "+ Const.CLIENT_FIO+"=? AND "+Const.CLIENT_DATA+"=?";
        try{
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            prSt.setString(1,client.getFIO());
            prSt.setDate(2,client.getData());

        }catch(SQLException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resultSet;
    }
    public void deleteDetail(String name) {
        String sql = "delete from Order WHERE Name='" + name + "'";


        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(sql);
            prSt.executeUpdate(sql);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
