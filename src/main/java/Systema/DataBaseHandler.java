package Systema;
import Service.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
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
}
