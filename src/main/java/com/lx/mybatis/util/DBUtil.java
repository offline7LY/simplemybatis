package com.lx.mybatis.util;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * 数据库连接工具类
 */
public class DBUtil {
    private static final String jdbcUrl;
    private static final String driverClass;
    private static final String username;
    private static final String password;

    /**
     * 读取数据库配置文件信息
     */
    static {
        // 使用properties读取配置文件
        Properties prop = new Properties();
        try {
            InputStream genentity = DBUtil.class.getResourceAsStream(
                    "/jdbc.properties");
            prop.load(genentity);

            if (genentity != null) {
                genentity.close();
            }
        } catch (Exception e) {
            System.out.println("file " + "jdbc.properties"
                    + " not found!\n" + e);
        }
        jdbcUrl = prop.getProperty("jdbcUrl");
        driverClass = prop.getProperty("driverClass");
        username = prop.getProperty("username");
        password = prop.getProperty("password");
    }

    /**
     * 加载数据库驱动
     */
    static {
        try {
            Class.forName(driverClass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 拿到数据库连接
     *
     * @return
     */
    public static Connection getConn() {
        Connection conn = null;
        try {
//            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/?user=root&password=root");
            conn = DriverManager.getConnection(jdbcUrl, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * @param conn
     * @return
     */
    public static Statement getStmt(Connection conn) {
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return stmt;
    }

    /**
     * @param conn
     * @param sql
     * @return
     */
    public static PreparedStatement getPStmt(Connection conn, String sql) {
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pstmt;
    }

    /**
     * @param stmt
     * @param sql
     * @return
     */
    public static ResultSet getRs(Statement stmt, String sql) {
        try {
            stmt.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @param stmt
     * @param sql
     */
    private static void executeUpdate(Statement stmt, String sql) {
        try {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param conn
     * @param sql
     */
    public static void executeUpdate(Connection conn, String sql) {
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        executeUpdate(stmt, sql);
    }

    /**
     * @param conn
     * @param sql
     * @return
     */
    public static ResultSet executeQuery(Connection conn, String sql) {
        ResultSet rs = null;
        try {
            rs = conn.prepareStatement(sql).executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    /**
     * @param conn
     */
    public static void close(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * @param stmt
     */
    public static void close(Statement stmt) {
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * @param rs
     */
    private static void close(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * @param rs
     * @return
     */
    public static int getTotalRecord(ResultSet rs) {
        int totalRecord = 0;
        try {
            while (rs.next()) {
                totalRecord = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(rs);
        }
        return totalRecord;
    }
}
