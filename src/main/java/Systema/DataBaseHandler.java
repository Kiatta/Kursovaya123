package Systema;
import Service.Client;
import Service.EndClient;
import Service.Product;
import Service.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.time.LocalDate;

public class DataBaseHandler extends Data {
    private static final ObservableList<Client> Clients = FXCollections.observableArrayList();
    private static final ObservableList<Product> Products = FXCollections.observableArrayList();
    private static final ObservableList<EndClient> EndClients = FXCollections.observableArrayList();
    private static final ObservableList<String> Fios = FXCollections.observableArrayList();
    private static final ObservableList<String> Cl = FXCollections.observableArrayList();
    private static final ObservableList<String> name = FXCollections.observableArrayList();
    private static final ObservableList<String> fio = FXCollections.observableArrayList();
    private static final ObservableList<Integer> ClId = FXCollections.observableArrayList();
    private static final ObservableList<Integer> PrId = FXCollections.observableArrayList();

    private static Connection dbConnection;

    public static Connection getDbConnection()
            throws ClassNotFoundException, SQLException {
        String dbPass = "14092001Ks.";
        String dbUser = "root";
        String connectionString = "jdbc:mysql://localhost:3306/4Clients";
        Class.forName("com.mysql.cj.jdbc.Driver");

        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);
        return dbConnection;
    }

    public void signUpUser(User user) {
        String insert = "INSERT INTO " + Const.USER_TABLE + "(" + Const.USERS_LOGIN + "," + Const.USERS_PASSWORD + "," + Const.USERS_FIRSTNAME + "," + Const.USERS_SECONDNAME + ")" + "VALUES(?,?,?,?)";

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setString(1, user.getLogin());
            prSt.setString(2, user.getPassword());
            prSt.setString(3, user.getFirstname());
            prSt.setString(4, user.getSecondname());
            prSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static ResultSet getUser(User user) {
        ResultSet resultSet = null;
        String select = "SELECT * FROM " + Const.USER_TABLE + " WHERE " + Const.USERS_LOGIN + "=? AND " + Const.USERS_PASSWORD + "=?";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            prSt.setString(1, user.getLogin());
            prSt.setString(2, user.getPassword());
            resultSet = prSt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public void signUpClient(Client client) {
        String insert = "INSERT INTO " + Const.CLIENT_TABLE + "(" + Const.CLIENT_FIO + "," + Const.CLIENT_MOBILE + "," + Const.CLIENT_DATA + "," + Const.CLIENT_TIME + ")" + "VALUES(?,?,?,?)";

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setString(1, client.getFIO());
            prSt.setString(2, client.getMobile());
            prSt.setDate(3, client.getData());
            prSt.setString(4, client.getTime());
            prSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
    public static ObservableList readClient() {
        String sql = "SELECT * FROM client";
        Clients.clear();

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(sql);
            ResultSet resultSet = prSt.executeQuery(sql);

            while (resultSet.next()) {
                String FIO = resultSet.getString("FIO");
                String Mobile = resultSet.getString("Mobile");
                Date data = resultSet.getDate("data");
                String time = resultSet.getString("time");
                Clients.add(new Client(FIO,Mobile,data,time));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        return Clients;
    }
    public static void delClient(String FIO) {

        String sql = "delete from client where FIO='" + FIO + "'";
        Clients.clear();

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(sql);
            prSt.executeUpdate(sql);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public static void addProduct(Product product) {
        String insert = "INSERT INTO " + Const.PRODUCT_TABLE + "(" + Const.PRODUCT_NAME + "," + Const.PRODUCT_PRICE + ")" + "VALUES(?,?)";

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setString(1, product.getNameProduct());
            prSt.setInt(2, product.getPrice());
            prSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }


    public static ObservableList readProduct() {
        String sql = "SELECT * FROM product";
        Products.clear();

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(sql);
            ResultSet resultSet = prSt.executeQuery(sql);

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                int price = resultSet.getInt("price");
                Products.add(new Product(name, price));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        return Products;
    }

    public static void delProduct(String name) {

        String sql = "delete from product where name='" + name + "'";
        Products.clear();

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(sql);
            prSt.executeUpdate(sql);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public static ObservableList readEndClient()
    {
        String sql = "SELECT * FROM clientprod";
        EndClients.clear();
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(sql);
            ResultSet resultSet = prSt.executeQuery(sql);
            while (resultSet.next()) {
                int idClientpr = resultSet.getInt("idClientpr");
                int idPrclient = resultSet.getInt("idPrclient");
                EndClients.add(new EndClient(idClientpr, idPrclient));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return EndClients;
    }
    public static void  addEndClient(int idClientpr, int idPrclient)
    {
        String sql = "insert clientprod (idClientpr, idPrclient) values('" + idClientpr + "', '"+ idPrclient + "')";
        System.out.println(sql);
        try
        {
            PreparedStatement prSt = getDbConnection().prepareStatement(sql);
            prSt.executeUpdate(sql);

        }
        catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void delEndClient(int idClientpr, int idPrclient) {
        String sql = "delete from clientprod WHERE idClientpr='" + idClientpr + "' AND idPrclient = '" + idPrclient + "'";
        EndClients.clear();

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(sql);
            prSt.executeUpdate(sql);

        } catch (Exception e) {
            e.printStackTrace();

        }
    }
    public static ObservableList getPr() {
        String sql = "select * from product";
        Fios.clear();

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(sql);
            ResultSet resultSet = prSt.executeQuery(sql);
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                Fios.add(name);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Fios;
    }
    public static ObservableList getCl() {
        String sql = "select * from client";
        Cl.clear();

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(sql);
            ResultSet resultSet = prSt.executeQuery(sql);
            while (resultSet.next()) {
                String name = resultSet.getString("FIO");
                Cl.add(name);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Cl;
    }
    public static int getId(String a) {
        String sql = "select * from client where FIO='"+a+"'";

        int ids=0;
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(sql);
            ResultSet resultSet = prSt.executeQuery(sql);

            while (resultSet.next()) {
                 ids = resultSet.getInt("idClient");

            }
        }  catch (Exception e) {
            e.printStackTrace();
        }


        return ids;
    }
    public static int getPrId(String b) {
        String sql = "select * from product where name='"+b+"'";
        int ids=0;
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(sql);
            ResultSet resultSet = prSt.executeQuery(sql);
            while (resultSet.next()) {
                 ids = resultSet.getInt("idproduct");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ids;
    }
    public static ObservableList getClId() {
        String sql = "select * from clientprod ";
        ClId.clear();

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(sql);
            ResultSet resultSet = prSt.executeQuery(sql);
            while (resultSet.next()) {
                Integer Clidd = resultSet.getInt("idClientpr");
                ClId.add(Clidd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ClId;
    }
    public static ObservableList getPrId() {
        String sql = "select * from clientprod";
        PrId.clear();

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(sql);
            ResultSet resultSet = prSt.executeQuery(sql);
            while (resultSet.next()) {
                Integer Cliddd = resultSet.getInt("idPrclient");
                PrId.add(Cliddd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return PrId;
    }
    public static ObservableList readName()
    {
        String sql = "SELECT product.name FROM product,clientprod WHERE idPrclient = idproduct";
        name.clear();
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(sql);
            ResultSet resultSet = prSt.executeQuery(sql);
            while (resultSet.next()) {
                String names = resultSet.getString("FIO");
                name.add(names);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return name;
    }
    public static ObservableList readFIO()
    {
        String sql = "SELECT client.FIO FROM client,clientprod WHERE idClientpr = idClient";
        fio.clear();
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(sql);
            ResultSet resultSet = prSt.executeQuery(sql);
            while (resultSet.next()) {
                String names = resultSet.getString("FIO");
                fio.add(names);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fio;
    }
    public static int Totals(int Id)
    {
        int total=0;
        String sql = "call 4clients.Total("+Id+")";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(sql);
            ResultSet resultSet = prSt.executeQuery(sql);
            while (resultSet.next()) {
                total = resultSet.getInt("Price");
            }
        } catch (Exception e) {
            total = 0;
            e.printStackTrace();
        }
        return total;
    }
    public static int getId4total() {
        String sql = "select * from clientprod";

        int ids=0;
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(sql);
            ResultSet resultSet = prSt.executeQuery(sql);

            while (resultSet.next()) {
                ids = resultSet.getInt("idClientpr");

            }
        }  catch (Exception e) {
            e.printStackTrace();
        }


        return ids;
    }
    public static void delAll() {
        String sql = "delete from clientprod";
        EndClients.clear();

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(sql);
            prSt.executeUpdate(sql);

        } catch (Exception e) {
            e.printStackTrace();

        }
    }
    public static void updClient(String f,String m, Date d,String t, int Id)
    {
        String sql = "update client set FIO = '" + f + "', Mobile = '" + m + "', data = '" + d + "', time = '" + t +"'" + " WHERE idClient='"+ Id + "'";
        Clients.clear();
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(sql);
            prSt.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static String  getMob(int id4upd) {
        String sql = "SELECT * FROM client WHERE idClient ='"+id4upd+"'";
        String Mobile = null;
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(sql);
            ResultSet resultSet = prSt.executeQuery(sql);

            while (resultSet.next()) {
                Mobile = resultSet.getString("Mobile");


            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Mobile;
    }
    public static Date getDate(int id4upd) {
        String sql = "SELECT * FROM client WHERE idClient ='"+id4upd+"'";
        Date data=null;
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(sql);
            ResultSet resultSet = prSt.executeQuery(sql);

            while (resultSet.next()) {
                 data = resultSet.getDate("data");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }
    public static String getTime(int id4upd) {
        String sql = "SELECT * FROM client WHERE idClient ='"+id4upd+"'";
        String time=null;
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(sql);
            ResultSet resultSet = prSt.executeQuery(sql);

            while (resultSet.next()) {
                time = resultSet.getString("time");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return time;
    }

}
