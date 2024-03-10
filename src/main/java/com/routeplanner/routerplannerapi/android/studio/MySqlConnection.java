package com.routeplanner.routerplannerapi.android.studio;

import java.sql.*;


public class MySqlConnection {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://LocalHost:3306/root";

    static final String USER = "root";
    static final String PASS = "password";
    static final String QUERY = "SELECT count(*) FROM user_info";
    static final String QUERY2 = "INSERT INTO user_info VALUES ('Del_Del', 'password', 'email')";

    Integer c = 0;
    public String count() {
        try {

            String url = "jdbc:mysql://localhost:3306/route_planner";
            String username = "root";
            String password = "password";
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement stmt = connection.createStatement();

            int i = stmt.executeUpdate(QUERY2);
            {
                // Extract data from result set
                if (i > 0) {
                    System.out.println("ROW INSERTED");
                } else {
                    System.out.println("ROW NOT INSERTED");
                }

                ResultSet rs = stmt.executeQuery(QUERY); {
                // Extract data from result set
                while (rs.next()) {
                    System.out.print("count: " + rs.getInt("count(*)"));
                    c =  rs.getInt("count(*)");
                }}



                //  Close the connection

                connection.close();
            }
        }
        catch (SQLException e) {
            System.out.println("Error connecting to the database!");
            e.printStackTrace();
        } finally {
                return "There are " + c.toString() + " rows in the db";
        }
    }
}