package cn.zjlg.onlineexam.student.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtils {
	// 加载配置文件
	private static Properties props = null;

	// 只在JdbcUtils类被加载时执行一次！
	static {
		// 给props进行初始化，即加载dbconfig.properties文件到props对象中
		try {
			InputStream in = JdbcUtils.class.getClassLoader()
					.getResourceAsStream("dbconfig.properties");
			props = new Properties();
			props.load(in);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		// 加载驱动类
		try {
			Class.forName(props.getProperty("driverClassName"));
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	// 获取连接!
	public static Connection getConnection() throws SQLException {
		// 得到Connection
		return DriverManager.getConnection(props.getProperty("url"),
				props.getProperty("username"), props.getProperty("password"));
	}

}
