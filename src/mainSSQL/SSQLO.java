package mainSSQL;

import java.sql.Connection;
/*  5:   */
import java.sql.DriverManager;
/*  6:   */
import java.sql.SQLException;
/*  7:   */
import java.sql.Statement;
/*  8:   */
import java.util.HashMap;

import mainSSQL.types.SQLTable;
import mainSSQL.types.SQLType;

public class SSQLO {
	Connection con;
	private Statement stmt;

	public SSQLO(String url, String port, String db, String user, String passwd)
			throws SQLException, ClassNotFoundException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Treiber werden geladen");
		} catch (ClassNotFoundException e) {
			throw e;
		}
		try {
			this.con = DriverManager.getConnection("jdbc:mysql://" + url + ":"
					+ port + "/" + db + "?" + "user=" + user + "&"
					+ "password=" + passwd);
			System.out.println("Verbindung wird aufgebaut");
			this.stmt = this.con.createStatement();
		} catch (SQLException e) {
			throw e;
		}
	}

	public void close() throws SQLException {
		try {
			this.con.close();
		} catch (SQLException e) {
			throw e;
		}
	}

	public SQLTable CreateTable(HashMap<String, SQLType> Spalten, String name)
			throws SQLException {
		SQLTable table = new SQLTable(this, Spalten, name);
		return table;
	}

	public Connection getConnection() {
		return con;
	}
}
