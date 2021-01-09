package sample.DB;

import java.sql.*;

public class DBHandler extends Config{
    Connection dbConnection;
    public Connection getDbConnection() throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://" + dbHost + ":"
                + dbPort + "/" + dbName;
        Class.forName("com.mysql.cj.jdbc.Driver");


        dbConnection = DriverManager.getConnection(connectionString,
                dbUser, dbPass);
        return dbConnection;


    }
    public void Insert(String firstname, String secondname, String login, String password, String gender, String age){
        String insert = "INSERT INTO " + Const.USERS_TABLE + "(" + Const.USERS_FIRST_NAME +"," + Const.USERS_SECOND_NAME + "," +
                Const.USERS_LOGIN + "," + Const.USERS_PASSWORD + "," + Const.USERS_GEMDER + "," + Const.USERS_AGE + "," +
                Const.USERS_LEVEL + ") VALUES(?,?,?,?,?,?,3)";
            try{
            PreparedStatement prST= getDbConnection().prepareStatement(insert);
            prST.setString(1, firstname);
            prST.setString(2, secondname);
            prST.setString(3, login);
            prST.setString(4, password);
            prST.setString(5, gender);
            prST.setString(6, age);

            prST.executeUpdate();}
            catch (Exception e){
                System.out.println("Error: " + e);
            }






    }
}
