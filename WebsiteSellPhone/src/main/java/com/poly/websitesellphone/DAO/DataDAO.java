package com.poly.websitesellphone.DAO;

import java.sql.*;

public class DataDAO {
    private static String jdbcUrl = "jdbc:sqlserver://localhost:1433;databaseName=Java3;encrypt=true;trustServerCertificate=true;";
    private static String username = "sa";
    private static String password = "quangthucdz@0310";

    public static Connection getConnection(){
        Connection connection = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(jdbcUrl, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    };

    public static PreparedStatement getStmt(String sql, Object... args) throws SQLException {
        PreparedStatement pstmt = null;
        if (sql.trim().startsWith("{")) {
            pstmt = getConnection().prepareCall(sql);
        } else {
            pstmt = getConnection().prepareStatement(sql);
        }
        for (int i = 0; i < args.length; i++) {
            pstmt.setObject(i + 1, args[i]);
        }
        return pstmt;
    }

    public static void update(String sql, Object... args) {
        try {
            PreparedStatement stmt = DataDAO.getStmt(sql, args);
            try {
                stmt.executeUpdate();
            } finally {
                stmt.getConnection().close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static ResultSet query(String sql, Object... args) {
        try {
            PreparedStatement stmt = DataDAO.getStmt(sql, args);
            return stmt.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Object value(String sql, Object... args) {
        try {
            ResultSet rs = DataDAO.query(sql, args);
            if (rs.next()) {
                return rs.getObject(0);
            }
            rs.getStatement().getConnection().close();
            return null;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
