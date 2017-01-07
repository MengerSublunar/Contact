package com.menger.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * 数据库访问类的工具类
 * 0. 加载驱动 
 * 1. 得到数据库的连接 
 * 2. 关闭所有打开的资源
 */
public class JdbcUtil {

	private static ComboPooledDataSource ds = new ComboPooledDataSource();

	/**
	 * 类的驱动只需加载1次
	 */
/*	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}*/

	/**
	 * 得到数据库的连接
	 */
	public static Connection getConnection() {
		Connection conn = null;
		try {
			conn = ds.getConnection();
			return conn;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	/**
	 * 释放所有的资源
	 */
	public static void close(Connection conn,Statement stmt,ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			} finally {
				if (stmt != null) {
					try {
						stmt.close();
					} catch (SQLException e) {
						e.printStackTrace();
						throw new RuntimeException(e);
					} finally {
						try {
							if (conn != null) {
								conn.close();
							}
						} catch (SQLException e) {
							e.printStackTrace();
							throw new RuntimeException(e);
						}
					}
				}
			}
		}
	}
	
	/**
	 * 释放资源
	 * @param conn
	 * @param stmt
	 */
	public static  void close(Connection conn, Statement stmt) {
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			} finally {
				try {
					if (conn != null) {
						conn.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
					throw new RuntimeException(e);
				}
			}
		}
	}

}