package com.example.vremenskaprognoza;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCPrimer1 {

	public static void main(String[] args) {
		JDBCPrimer1 primer = new JDBCPrimer1();
		primer.prikaziPredmete();
	}

	private void prikaziPredmete() {
		Connection c = null;
		Statement s = null;
		ResultSet rs = null;
		try {
			c = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/vremenskaprognoza", "root", "sifrazamysql");
			s = c.createStatement();
			rs = s.executeQuery("select * from temperatura");

			while (rs.next())
				System.out.println(rs.getString(1));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if (s != null)
				try {
					s.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if (c != null)
				try {
					c.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}

}

