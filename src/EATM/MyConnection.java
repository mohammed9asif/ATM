package EATM;

import java.sql.*;

public class MyConnection {

    Connection con;
    Statement st;
    public MyConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/project","root","root");
            st = con.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }


    }
}
