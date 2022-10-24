package com.example.supplychainmanagementproject;

import java.sql.*;

public class DataBaseConnection {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/supply_chain";
    private static final String USER = "root";
    private static final String PASS = "Polash@@0305";

    public Statement getStatement(){
        Statement statement = null;
        Connection conn;
        try{
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            statement = conn.createStatement();
        }catch (Exception e){
            e.printStackTrace();
        }
        return statement;
    }

    public ResultSet getQueryTable(String query) throws SQLException {
        Statement statement = getStatement();
        return statement.executeQuery(query);
    }
    public static void main(String[] args){
        DataBaseConnection dbConn = new DataBaseConnection();

        try {
            String query = "select * from product";
            ResultSet rs = dbConn.getQueryTable(query);
            while (rs.next()){
                System.out.println(rs.getInt("pid") + " " +
                        rs.getString("name") + " " +
                        rs.getDouble("price"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }


    }

}
