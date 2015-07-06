package mainSSQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;

import mainSSQL.types.SQLType;

/**
 * Dies ist die Klasse der SimpleSQLApi, von der als erstes eine Instanz erzeugt
 * werden muss, damit auf Datenbanken zugegriffen werden kann! Die gesamte API
 * ist für MySQL ausgelegt und befindet sich noch in der Beta Phase!
 **/
public class SSQLO {
	Connection con;

	/**
	 * @param url
	 *            Die URL des MySQL Server
	 * @param port
	 *            Port des MySQL Servers
	 * @param db
	 *            Name der Datenbank auf die Zugegriffen werden soll
	 * @param user
	 *            Nutzer, mit dem sich in die Datenbank eingeloggt werden soll
	 * @param passwd
	 *            Passwort für "user"
	 * @throws SQLException
	 *             sollte einer der Argumente nicht richtig sein, oder eine
	 *             Verbindung zum Server nicht möglich sein
	 * @throws ClassNotFoundException
	 *             Sollten die JDBC Driver nicht geladen werden können
	 */
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

		} catch (SQLException e) {
			throw e;
		}
	}

	/**
	 * Schließt die Verbindung. Alle Weiteren Versuche in irgendeiner Art und
	 * Weise auf die Datenbank zuzugreifen wird mit einer SQLException
	 * fehlschlagen
	 * 
	 * @throws SQLException
	 */
	public void close() throws SQLException {
		try {
			this.con.close();
		} catch (SQLException e) {
			throw e;
		}
	}

	/**
	 * Erzeugt ein TabellenObjekt mit dessen Hilfe auf die Daten dieser
	 * MySQLDatenbank zugegriffen werden kann
	 * 
	 * @param Spalten Eine Hashmap mit den Namen der einzelnen Spalten und des Types
	 * @param name Name der Tabelle
	 * @return SQLTable 
	 * @throws SQLException
	 */
	public SQLTable CreateTable(HashMap<String, SQLType> Spalten, String name)
			throws SQLException {
		SQLTable table = new SQLTable(this, Spalten, name);
		return table;
	}

	public Connection getConnection() {
		return con;
	}
}
