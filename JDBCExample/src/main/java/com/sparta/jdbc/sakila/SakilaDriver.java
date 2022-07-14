package com.sparta.jdbc.sakila;

import java.sql.*;

public class SakilaDriver {
    public static void main(String[] args) {
        try (Connection conn =
                     DriverManager.getConnection(
                     "jdbc:mysql://localhost:3306/sakila",
                     "root",
                     "password")){
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("select * from actor");
            while(rs.next()){
                System.out.println(rs.getString(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
